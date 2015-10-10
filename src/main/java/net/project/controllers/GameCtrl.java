package net.project.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import net.project.components.GameContainer;
import net.project.utils.GenericElement;
import net.project.utils.NextGame;
import net.project.utils.Scenario;

import java.util.ArrayList;

/**
 * @author learnercys on 8/10/15.
 */
public class GameCtrl implements NextGame{

    @FXML GameContainer gameContainer;

    // structures

    public ArrayList<Scenario> scenarios = new ArrayList<>();
    public ArrayList<GenericElement> sequences = new ArrayList<>();

    @FXML
    BorderPane root;

    private int sequenceIndex = -1;

    public void initData(
            ArrayList<GenericElement> bgs,
            ArrayList<GenericElement> fgs,
            ArrayList<GenericElement> dgs,
            ArrayList<Scenario> scenarios,
            ArrayList<GenericElement> sequences
    ) {

        this.scenarios = scenarios;
        this.sequences = sequences;
        //gameContainer.setParent(this);
        gameContainer.setStrs(bgs, fgs, dgs);
        setNextScene();

    }

    public void keyPressed(String code) {
        gameContainer.keyPressed(code);
    }

    private void setNextScene() {
        sequenceIndex++;
        if ( sequenceIndex > -1 && sequenceIndex < sequences.size() && sequences.size() != 0) {
            String scenarioName = sequences.get(sequenceIndex).getAttr("name").getValue().toString();
            for(Scenario scenario: this.scenarios){
                if(scenario.getName().equals(scenarioName)){
                    gameContainer.setScenario(scenario);
                    break;
                }
            }
            //gameContainer.setScenario(scenarios.get(sequenceIndex));
        } else {
            sequenceIndex--;
        }
    }

    public void playGame() {
        //setNextScene();
        gameContainer.play();
    }

    @Override
    public void NextGame() {
        setNextScene();
    }
}
