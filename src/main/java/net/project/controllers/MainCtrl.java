package net.project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.project.components.CustomCodeArea;
import net.project.utils.CFile;

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
     * TODO open a new file
     */
    public void openFile () {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("conf files", "*.conf")
        );

        try {
            CFile cFile = new CFile(fileChooser.showOpenDialog(root.getScene().getWindow()));


        } catch ( NullPointerException e ) {
            // something horrible happen, is not my fault.
        }
    }

    /**
     * TODO save the current file
     */
    public void saveFile() {
        if ( ccArea.getFile() == null) {
            saveFileAs();
        } else {
            // TODO save the current file located in the ccArea.
        }
    }

    /**
     * TODO save the current file as
     */
    public void saveFileAs() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // injecting the code area.
        ccArea = new CustomCodeArea();
        ccAreaContainer.setCenter(ccArea);
    }
}
