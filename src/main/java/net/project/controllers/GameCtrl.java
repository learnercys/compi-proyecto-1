package net.project.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

/**
 * @author learnercys on 8/10/15.
 */
public class GameCtrl {

    @FXML GridPane gameContainer;

    private int scenario = -1;

    public void initData() {
        setNextScene();
    }

    private void setNextScene() {
        scenario++;

    }
}
