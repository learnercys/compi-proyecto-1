package net.project.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import net.project.utils.GenericElement;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author learnercys on 5/10/15.
 */
public class StructuresContainer extends BorderPane {
    private ArrayList<GenericElement> bgs = new ArrayList<>();
    private ArrayList<GenericElement> figures = new ArrayList<>();
    private ArrayList<GenericElement> designs = new ArrayList<>();

    public StructuresContainer() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("structurescontainer.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setBg(ArrayList<GenericElement> bgs) {
        this.bgs = bgs;
        // todo show bgs
    }

    public void setFigures(ArrayList<GenericElement> figures) {
        this.figures = figures;
        // todo show figures
    }

    public void setDesigns(ArrayList<GenericElement> designs) {
        this.designs = designs;
        // todo show designs
    }

    public void setStr(ArrayList<GenericElement> bgs, ArrayList<GenericElement> figures, ArrayList<GenericElement> designs) {
        setBg(bgs);
        setFigures(figures);
        setDesigns(designs);
    }
}
