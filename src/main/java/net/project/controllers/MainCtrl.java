package net.project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.project.components.CustomCodeArea;
import net.project.utils.CFile;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author learnercys on 30/08/15.
 */
public class MainCtrl implements Initializable {

    @FXML BorderPane root;
    @FXML BorderPane ccAreaContainer;

    private CustomCodeArea ccArea;

    public void closeApplication() {
        ((Stage)root.getScene().getWindow()).close();
    }

    /**
     * TODO execute the game
     */
    public void executeGame() {

    }

    /**
     * TODO show the about us modal
     */
    public void showAboutUs() {

    }

    /**
     *  TODO Show the current errors
     */
    public void showErrors() {

    }

    /**
     * TODO Show the symbols table
     */
    public void showSymbolsTable() {

    }

    /**
     * TODO Show the technical manual
     */
    public void showTechnicalManual() {

    }

    /**
     * TODO show the user manual
     */
    public void showUserManual() {

    }

    /**
     * TODO create a new File
     */
    public void newFile() {
        ccArea.setFile(null);
    }

    /**
     * TODO Compile structure
     */
    public void onCompileStructure() {

    }

    /**
     * TODO Compile scenarios
     */
    public void onCompileScenarios() {

    }

    /**
     * compile the sequences
     */
    public void onCompileSequences() {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // injecting the code area.
        ccArea = new CustomCodeArea();
        ccAreaContainer.setCenter(ccArea);
    }
}
