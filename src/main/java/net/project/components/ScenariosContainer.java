package net.project.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ArrayList;
import net.project.utils.Scenario;

/**
 * @author learnercys on 7/10/15.
 */
public class ScenariosContainer extends BorderPane{
    public ArrayList<Scenario> scenarios = new ArrayList<>();

    public ScenariosContainer() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scenarioscontainer.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public ArrayList<Scenario> getScenarios() {
        return scenarios;
    }

    public void setScenarios(ArrayList<Scenario> scenarios) {
        this.scenarios = scenarios;
    }
}
