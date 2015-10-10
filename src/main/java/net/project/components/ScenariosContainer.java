package net.project.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ArrayList;

import net.project.utils.GenericElement;
import net.project.utils.Scenario;

/**
 * @author learnercys on 7/10/15.
 */
public class ScenariosContainer extends BorderPane{
    public ArrayList<Scenario> scenarios = new ArrayList<>();
    private int scenarioIndex;
    @FXML GameContainer gameContainer;
    @FXML Button nextButton, prevButton;

    public ScenariosContainer() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scenarioscontainer.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
            nextButton.setOnMouseClicked(event -> setNextScene());
            prevButton.setOnMouseClicked(event -> setPrevScene());
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public void initData(
            ArrayList<GenericElement> bgs,
            ArrayList<GenericElement> fgs,
            ArrayList<GenericElement> dgs,
            ArrayList<Scenario> scenarios) {

        this.scenarios = scenarios;
        this.scenarioIndex = -1;
        //gameContainer.setParent(this);
        gameContainer.setStrs(bgs, fgs, dgs);
        setNextScene();

    }

    public void setNextScene(){
        scenarioIndex++;
        if ( scenarioIndex > -1 && scenarioIndex < scenarios.size() && scenarios.size() != 0) {
            gameContainer.setScenario(scenarios.get(scenarioIndex));
            System.out.println(scenarios.get(scenarioIndex).getName());
            System.out.println(scenarioIndex);
        } else {
            scenarioIndex--;
        }
    }

    public void setPrevScene(){
        scenarioIndex--;
        if ( scenarioIndex > -1 && scenarioIndex < scenarios.size() && scenarios.size() != 0) {
            gameContainer.setScenario(scenarios.get(scenarioIndex));
        } else {
            scenarioIndex++;
        }
    }

    public ArrayList<Scenario> getScenarios() {
        return scenarios;
    }

    public void setScenarios(ArrayList<Scenario> scenarios) {
        this.scenarios = scenarios;
    }
}
