package net.project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import net.project.components.CustomCodeArea;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author learnercys on 30/08/15.
 */
public class MainCtrl implements Initializable {

    @FXML BorderPane ccAreaContainer;

    private CustomCodeArea ccArea;

    public void closeApplication() {

    }

    public void executeGame() {

    }

    public void showAboutUs() {

    }

    public void showErrors() {

    }

    public void showSymbolsTable() {

    }

    public void showTechnicalManual() {

    }

    public void showUserManual() {

    }

    public void newFile() {

    }

    public void onCompileStructure() {

    }

    public void onCompileScenarios() {

    }

    public void onCompileSecuences() {

    }

    public void openFile () {

    }

    public void saveFile() {

    }

    public void saveFileAs() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // injecting the code area.
        ccArea = new CustomCodeArea();
        ccAreaContainer.setCenter(ccArea);
    }
}
