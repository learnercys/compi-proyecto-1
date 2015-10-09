package net.project.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import java.util.ArrayList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import net.project.utils.GenericElement;

import java.io.IOException;

/**
 * @author learnercys on 7/10/15.
 */
public class SequencesContainer extends BorderPane{

    public ArrayList<GenericElement> sequences = new ArrayList<>();

    @FXML VBox sequencesContainer;

    public SequencesContainer() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sequencescontainer.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public void setSequences(ArrayList<GenericElement> sequences) {
        this.sequences = sequences;
        showSequences();
    }

    private void showSequences() {
        sequencesContainer.getChildren().removeAll();

        for(GenericElement sequence: this.sequences){
            HBox sContainer = new HBox();
            sContainer.setAlignment(Pos.CENTER);
            sContainer.getChildren().addAll(new Label("Nombre:" + sequence.getAttr("name").getValue()), new Label(", Orden: " + sequence.getAttr("order").getValue().toString()));
            sequencesContainer.getChildren().add(sContainer);
        }
    }
}
