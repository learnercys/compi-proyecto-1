package net.project.components;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import net.project.utils.GenericElement;
import net.project.utils.NextGame;
import net.project.utils.Scenario;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author learnercys on 10/9/15.
 */
public class GameContainer extends BorderPane implements Initializable{

    private boolean playing = false;
    
    private final double WIDTH = 800.0;
    private final double HEIGHT = 400.0;

    private Canvas canvas = new Canvas(WIDTH, HEIGHT);
    private GraphicsContext gc;

    private ArrayList<GenericElement> bgs = new ArrayList<>();
    private ArrayList<GenericElement> fgs = new ArrayList<>();
    private ArrayList<GenericElement> dgs = new ArrayList<>();
    private Scenario scenario;

    // background scenario
    private ImageView background;

    // to send the finish game event
    private NextGame nextGame;

    public GameContainer() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gamecontainer.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
            gc = canvas.getGraphicsContext2D();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
        showBG();
    }

    public void showBG(){
        String bgName = this.scenario.getBg();
        for(GenericElement bg: this.bgs){
            System.out.println(bg.getAttr("name").getValue());
            if(bgName.equals(bg.getAttr("name").getValue())){
                System.out.println(bg.getAttr("picture").getValue());
                try {
                    gc.setFill(Color.WHITE);
                    gc.fillRect(0, 0, WIDTH, HEIGHT);
                    gc.drawImage(new Image(new File((String)bg.getAttr("picture").getValue()).toURI().toString()),0,0,WIDTH,HEIGHT);
                } catch (Exception e){
                    ///
                }
            }
        }

    }

    public void play() {
        this.playing = true;
    }

    public void stop() {
        this.playing = false;
    }

    public void keyPressed(String code) {
        if(playing) {
            switch (code){
                case "UP":
                    break;
                case "DOWN":
                    break;
                case "LEFT":
                    break;
                case "RIGHT":
                    break;
            }
        }
    }

    public void setStrs(ArrayList<GenericElement> bgs,
                        ArrayList<GenericElement> fgs,
                        ArrayList<GenericElement> dgs) {
        this.bgs = bgs;
        this.fgs = fgs;
        this.dgs = dgs;
    }

    public void setParent(NextGame parent) {
        this.nextGame = parent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // canvas
        gc = canvas.getGraphicsContext2D();
        this.getChildren().add(canvas);
    }
}
