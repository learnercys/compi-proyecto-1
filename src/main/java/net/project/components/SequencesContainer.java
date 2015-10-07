package net.project.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import java.util.ArrayList;
import net.project.utils.GenericElement;

import java.io.IOException;

/**
 * @author learnercys on 7/10/15.
 */
public class SequencesContainer extends BorderPane{
    public ArrayList<GenericElement> sequences = new ArrayList<>();

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

        // todo show the sequences
    }
}
