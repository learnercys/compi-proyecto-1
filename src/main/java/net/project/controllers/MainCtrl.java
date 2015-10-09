package net.project.controllers;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.project.components.CustomCodeArea;
import net.project.components.ScenariosContainer;
import net.project.components.SequencesContainer;
import net.project.components.StructuresContainer;
import net.project.parser.scenarios.ScenariosParser;
import net.project.parser.sequences.SequencesParser;
import net.project.parser.structures.StructuresParser;
import net.project.scanner.scenarios.ScenariosScanner;
import net.project.scanner.sequences.SequencesScanner;
import net.project.scanner.structures.StructuresScanner;
import net.project.utils.CFile;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * @author learnercys on 30/08/15.
 */
public class MainCtrl implements Initializable {


    @FXML BorderPane root;
    @FXML BorderPane ccAreaContainer;
    @FXML StructuresContainer stc;
    @FXML ScenariosContainer scc;
    @FXML SequencesContainer sqc;
    @FXML Tab tabStructures;
    @FXML Tab tabScenarios;
    @FXML Tab tabSequences;

    private CustomCodeArea ccArea;
    private boolean structuresErrors = false;
    private boolean scenariosErrors = false;
    private boolean sequencesErrors = false;
    public ArrayList<HashMap<String, String>> lErrors = new ArrayList<>();
    public ArrayList<HashMap<String, String>> sErrors = new ArrayList<>();

    public void closeApplication() {
        ((Stage)root.getScene().getWindow()).close();
    }

    /**
     * execute the game
     */
    public void executeGame() {
        try {
            Stage game = new Stage(StageStyle.DECORATED);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gamectrl.fxml"));
            game.setScene(new Scene(loader.load()));
            GameCtrl gameCtrl = loader.getController();
            gameCtrl.initData();
            game.show();
        } catch (IOException ioe) {
            //
        }
    }

    /**
     * how the about us modal
     */
    public void showAboutUs() {
        try {
            Stage about = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("aboutctrl.fxml"));
            about.setScene(new Scene(loader.load()));
            about.show();
        } catch (IOException ioe) {
            //
        }
    }

    /**
     * Show the current errors
     */
    public void showErrors() {

        if(this.lErrors.size() == 0 && this.sErrors.size() == 0) {
            // todo: cannot show the error list, not errors to show
            return;
        }

        try {
            MustacheFactory mustacheFactory = new DefaultMustacheFactory();
            Mustache mustache = mustacheFactory.compile(new InputStreamReader(getClass().getResourceAsStream("errors.mustache")),"errors.mustache");
            File tmpFile = new File("/tmp/project-errors.html");
            Errors e = new Errors();
            e.lErrors.addAll(this.lErrors);
            e.sErrors.addAll(this.sErrors);
            mustache.execute(new PrintWriter( tmpFile ), e).flush();

            Stage table = new Stage(StageStyle.DECORATED);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("htmlctrl.fxml"));

            table.setScene(new Scene(loader.load()));
            HTMLCtrl tableCtrl = loader.getController();
            tableCtrl.initData(CFile.read(tmpFile), "Errores");
            System.out.println("temp" + CFile.read(tmpFile));
            table.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * TODO Show the symbols table
     */
    public void showSymbolsTable() {
        if(this.lErrors.size() > 0 || this.sErrors.size() > 0) {
            // todo: cannot show symbols table, errors found.
            return;
        }

        try {
            MustacheFactory mustacheFactory = new DefaultMustacheFactory();
            Mustache mustache = mustacheFactory.compile(new InputStreamReader(getClass().getResourceAsStream("symbols.mustache")), "symbols.mustache");
            File tmpFile = new File("/tmp/project-symbols.html");
            SymbolsTable symbolsTable = new SymbolsTable();
            mustache.execute(new PrintWriter(tmpFile), symbolsTable).flush();

            Stage table = new Stage(StageStyle.DECORATED);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("htmlctrl.fxml"));

            table.setScene(new Scene(loader.load()));
            HTMLCtrl tableCtrl = loader.getController();
            tableCtrl.initData(CFile.read(tmpFile), "Simbolos");
            table.show();

        } catch (Exception e) {
            // todo  cannot read file
        }
    }

    /**
     * Show the technical manual
     */
    public void showTechnicalManual() {
        try {
            Stage tech = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("htmlctrl.fxml"));
            tech.setScene(new Scene(loader.load()));
            HTMLCtrl techCtrl = loader.getController();
            techCtrl.initData("", "Manual técnico");
            tech.show();
        } catch (Exception e) {
            // todo a lot of exceptions
        }
    }

    /**
     * show the user manual
     */
    public void showUserManual() {
        try {
            Stage userManual = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("htmlctrl.fxml"));
            userManual.setScene(new Scene(loader.load()));
            HTMLCtrl userManualCtrl = loader.getController();
            userManualCtrl.initData("", "Manual de usuario");
            userManual.show();
        } catch (Exception e) {
            // todo file errors
        }
    }

    /**
     * create a new File
     */
    public void newFile() {
        ccArea.setFile(null);
    }

    /**
     * Compile structure
     */
    public void onCompileStructure() {

        if ( ccArea.getText().trim().length() == 0) {
            // TODO show error, cannot compile empty files
            return;
        }

        // TODO verify if the current text is saved

        StringReader stringReader = new StringReader(ccArea.getText());
        StructuresScanner structuresScanner = new StructuresScanner(stringReader);
        StructuresParser structuresParser = new StructuresParser(structuresScanner);

        try {
            structuresParser.parse();
            this.lErrors.clear();
            this.lErrors.addAll(structuresScanner.errors);
            this.sErrors.clear();
            this.sErrors.addAll(structuresParser.errors);

            if ( !lErrors.isEmpty() || !sErrors.isEmpty()) {
                tabScenarios.setDisable(true);
                tabStructures.setDisable(true);
                tabSequences.setDisable(true);
                this.showErrors();
                this.structuresErrors = true;
            } else {
                stc.setStr(structuresParser.bgs, structuresParser.figures, structuresParser.designs);
                tabStructures.setDisable(false);
                this.structuresErrors = false;
                compilationSuccess();
            }

        } catch (Exception e ) {
            // TODO the world is unfair.
        }
    }

    /**
     * Compile scenarios
     */
    public void onCompileScenarios() {
        if(ccArea.getText().trim().length() ==0) {
            // TODO show error list, cannot compile empty files
            return;
        }
        // TODO verify if the current text is saved

        if( this.structuresErrors ) {
            // TODO send a warning, cannot compile if the structures has errors
            showErrors();
            return;
        }

        StringReader stringReader = new StringReader(ccArea.getText());
        ScenariosScanner scenariosScanner = new ScenariosScanner(stringReader);
        ScenariosParser scenariosParser = new ScenariosParser(scenariosScanner);

        try {
            scenariosParser.parse();
            this.lErrors.clear();
            this.lErrors.addAll(scenariosScanner.errors);
            this.sErrors.clear();
            this.sErrors.addAll(scenariosParser.errors);

            if(!lErrors.isEmpty() || !sErrors.isEmpty()) {
                tabScenarios.setDisable(true);
                tabSequences.setDisable(true);
                this.showErrors();
                this.scenariosErrors = true;
            } else {
                tabScenarios.setDisable(false);
                this.scc.setScenarios(scenariosParser.scenarios);
                this.scenariosErrors = false;
                compilationSuccess();
            }
        } catch (Exception e) {
            // todo: reading error or something
        }

    }

    /**
     * compile the sequences
     */
    public void onCompileSequences() {
        if(ccArea.getText().trim().length() == 0) {
            // todo show error, cannot compile empty files
            return;
        }
        if(this.scenariosErrors) {
            // todo send a warning, cannot compile if the scenarios has errors
            showErrors();
            return;
        }

        // TODO verify structures and scenarios

        StringReader stringReader = new StringReader(ccArea.getText());
        SequencesScanner sequencesScanner = new SequencesScanner(stringReader);
        SequencesParser sequencesParser = new SequencesParser(sequencesScanner);

        try {
            sequencesParser.parse();
            this.lErrors.clear();
            this.lErrors.addAll(sequencesScanner.errors);
            this.sErrors.clear();
            this.sErrors.addAll(sequencesParser.errors);

            if ( !lErrors.isEmpty() || !sErrors.isEmpty()) {
                tabSequences.setDisable(true);
                this.showErrors();
                this.sequencesErrors = true;
            } else {
                tabSequences.setDisable(false);
                sqc.setSequences(sequencesParser.sequences);
                this.sequencesErrors = false;
                compilationSuccess();
            }
        } catch (Exception e) {
            // TODO the world is null
        }
    }

    /**
     * open a new file
     */
    public void openFile () {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("conf files", "*.conf")
        );

        try {
            CFile cFile = new CFile(fileChooser.showOpenDialog(root.getScene().getWindow()));

            if(cFile.canRead()) {
                ccArea.setFile(cFile);
            }

        } catch ( NullPointerException e ) {
            // something horrible happen, is not my fault.
        }
    }

    /**
     *  save the current file
     */
    public void saveFile() {
        if ( ccArea.getFile() == null) {
            saveFileAs();
        } else {
            // save the current file located in the ccArea.
            ccArea.getFile().saveFile(ccArea.getText());
        }
    }

    /**
     * save the current file as
     */
    public void saveFileAs() {
        FileChooser fileS = new FileChooser();

        fileS.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("xconf files", "*.conf")
        );

        File file = fileS.showSaveDialog(root.getScene().getWindow());

        // if the file is null the user put the cancel button or close the window.
        if( file != null ) {
            // NullPointerException is really bad, sorry. I thing it is easy to fix it, but I haven't time to do it.
            if( CFile.getExtension(file) == null || !CFile.getExtension(file).equals("conf")  ) {
                // in case the file does not have extension or the extension is not correct
                // wee add the correct extension to the current file.
                file = new File(file.getAbsolutePath() + ".conf");  // just in case
            }
            CFile cFile = new CFile(file);
            cFile.saveFile(ccArea.getText());
            ccArea.setFile(cFile);
        }
    }

    public void compilationSuccess() {
        Alert errorModal = new Alert(Alert.AlertType.INFORMATION);
        errorModal.setTitle("Compilación Finalizada");
        errorModal.setHeaderText("Compilación");
        errorModal.setContentText("La compilación se ha finalizado con éxito");
        errorModal.show();
    }

    public void Success(String title, String text, String contentText) {
        Alert s = new Alert(Alert.AlertType.CONFIRMATION);
        s.setTitle(title);
        s.setHeaderText(text);
        s.setContentText(contentText);
        s.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // injecting the code area.
        ccArea = new CustomCodeArea();
        ccAreaContainer.setCenter(ccArea);
    }

    public class Errors {
        public ArrayList<HashMap<String,String>> lErrors = new ArrayList<>();
        public ArrayList<HashMap<String,String>> sErrors = new ArrayList<>();
    }

    private class SymbolsTable {
        public ArrayList<HashMap<String,String>> symbols = new ArrayList<>();
    }
}
