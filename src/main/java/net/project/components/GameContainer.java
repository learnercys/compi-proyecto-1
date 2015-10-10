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
import net.project.utils.Point2D;
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

    private double wElement = 0, hElement = 0;

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
        wElement = WIDTH / this.scenario.getWidth();
        hElement = HEIGHT / this.scenario.getHeight();
        showWalls();
        showVillains();
        showHero();
        showWeapons();
        showBonus();
        showFinish();
        showFloors();
    }

    private void drawImage(double x, double y, double w, double h, String path) {
        //System.out.println(x + " " + y + " " + w + " " + h + " " + path);
        try {
            gc.drawImage(new Image(path), x, y, w, h);
        } catch (Exception e){
            //
        }
    }

    private void showFinish(){
        GenericElement finish = this.scenario.getFinish();
        String hName = finish.getAttr("name").getValue().toString();
        System.out.println(hName);
        Integer x = ((Integer) finish.getAttr("x").getValue());
        Integer y = ((Integer) finish.getAttr("y").getValue());
        String path = "";
        for(GenericElement dg: this.dgs){
            if(hName.equals(dg.getAttr("name").getValue())){
                path = new File((String)dg.getAttr("picture").getValue()).toURI().toString();
            }
        }
        drawImage(x * wElement, y * hElement, wElement, hElement, path);
    }

    private void showBonus(){
        for(GenericElement bonus: this.scenario.getBonus()){
            String wName = bonus.getAttr("name").getValue().toString();
            Integer x = ((Integer) bonus.getAttr("x").getValue());
            Integer y = ((Integer) bonus.getAttr("y").getValue());

            String path = "";
            for(GenericElement dg: this.dgs){
                if(wName.equals(dg.getAttr("name").getValue())){
                    path = new File(((String) dg.getAttr("picture").getValue())).toURI().toString();
                }
            }

            drawImage(x * wElement, y * hElement, wElement, hElement, path);
        }
    }

    private void showWeapons(){
        for(GenericElement weapon: this.scenario.getWeapons()){
            String wName = weapon.getAttr("name").getValue().toString();
            Integer x = ((Integer) weapon.getAttr("x").getValue());
            Integer y = ((Integer) weapon.getAttr("y").getValue());

            String path = "";
            for(GenericElement dg: this.dgs){
                if(wName.equals(dg.getAttr("name").getValue())){
                    path = new File(((String) dg.getAttr("picture").getValue())).toURI().toString();
                }
            }

            drawImage(x * wElement, y * hElement, wElement, hElement, path);
        }
    }

    private void showHero(){
        GenericElement hero = this.scenario.getHero();
        String hName = hero.getAttr("name").getValue().toString();
        Integer x = ((Integer) hero.getAttr("x").getValue());
        Integer y = ((Integer) hero.getAttr("y").getValue());
        String path = "";
        for(GenericElement fg: this.fgs){
            if(hName.equals(fg.getAttr("name").getValue())){
                path = new File((String)fg.getAttr("picture").getValue()).toURI().toString();
            }
        }
        drawImage(x * wElement, y * hElement, wElement, hElement, path);
    }

    private void showVillains(){
        for(GenericElement villain: this.scenario.getVillains()){
            String vName = villain.getAttr("name").getValue().toString();
            Integer x = ((Integer) villain.getAttr("x").getValue());
            Integer y = ((Integer) villain.getAttr("y").getValue());

            String path = "";
            for(GenericElement fg: this.fgs){
                if(vName.equals(fg.getAttr("name").getValue())){
                    path = new File(((String) fg.getAttr("picture").getValue())).toURI().toString();
                }
            }

            drawImage(x * wElement, y * hElement, wElement, hElement, path);

        }
    }
    public void showFloors() {
        for(GenericElement floor: this.scenario.getFloors()){
            String wName = floor.getAttr("name").getValue().toString();
            Point2D point = ((Point2D) floor.getAttr("range").getValue());

            String path = "";
            for(GenericElement dg: this.dgs){
                if(wName.equals(dg.getAttr("name").getValue())){
                    path = new File((String)dg.getAttr("picture").getValue()).toURI().toString();
                }
            }
            System.out.println(path);

            if(point.getX1().equals(point.getX2())  && point.getY1().equals(point.getY2())) {
                // just one point
                drawImage(point.getX1() * wElement, point.getY1() * hElement, wElement, hElement, path);
                //gc.drawImage(new Image(path), point.getX1()*wElement,point.getY1()*hElement,wElement,hElement);
            } else if(!point.getX1().equals(point.getX2())){
                // diff x points
                for(int h= point.getX1(); h <= point.getX2(); h++){
                    drawImage(h * wElement, point.getY1() * hElement, wElement, hElement, path);
                    //gc.drawImage(new Image(path), h * wElement, point.getY1()*hElement, wElement,hElement);
                }

            } else {
                // diff y points
                for(int v = point.getY1(); v <= point.getY2(); v++){
                    drawImage(point.getX1() * wElement, v * hElement, wElement, hElement, path);
                    //gc.drawImage(new Image(path), point.getX1()*wElement, v*hElement, wElement, hElement);
                }
            }
        }
    }

    public void showWalls() {
        for(GenericElement wall: this.scenario.getWalls()){
            String wName = wall.getAttr("name").getValue().toString();
            Point2D point = ((Point2D) wall.getAttr("range").getValue());

            String path = "";
            for(GenericElement dg: this.dgs){
                if(wName.equals(dg.getAttr("name").getValue())){
                    path = new File((String)dg.getAttr("picture").getValue()).toURI().toString();
                }
            }
            System.out.println(path);

            if(point.getX1().equals(point.getX2())  && point.getY1().equals(point.getY2())) {
                // just one point
                drawImage(point.getX1() * wElement, point.getY1() * hElement, wElement, hElement, path);
                //gc.drawImage(new Image(path), point.getX1()*wElement,point.getY1()*hElement,wElement,hElement);
            } else if(!point.getX1().equals(point.getX2())){
                // diff x points
                for(int h= point.getX1(); h <= point.getX2(); h++){
                    drawImage(h * wElement, point.getY1() * hElement, wElement, hElement, path);
                    //gc.drawImage(new Image(path), h * wElement, point.getY1()*hElement, wElement,hElement);
                }

            } else {
                // diff y points
                for(int v = point.getY1(); v <= point.getY2(); v++){
                    drawImage(point.getX1() * wElement, v * hElement, wElement, hElement, path);
                    //gc.drawImage(new Image(path), point.getX1()*wElement, v*hElement, wElement, hElement);
                }
            }
        }
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
