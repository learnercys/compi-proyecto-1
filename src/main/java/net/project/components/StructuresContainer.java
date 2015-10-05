package net.project.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    // Current Background
    private int cbg = 1;

    @FXML ImageView bgImage;
    @FXML Label bgName;

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

    private void setBg(int change) {
        int tmp = cbg + change;
        if ( tmp >= 0 && tmp < this.bgs.size()) {
            cbg += change;
            GenericElement bg = this.bgs.get(cbg);
            bgName.setText((String)bg.getAttr("name").getValue());
            // todo validate if the picture already exist
            //bgImage.setImage(new Image((String)bg.getAttr("picture").getValue()));
        }
    }

    public void setBgs(ArrayList<GenericElement> bgs) {
        this.bgs = bgs;
        // todo show bgs
        setBg(-1); // initial index, zero.
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
        setBgs(bgs);
        setFigures(figures);
        setDesigns(designs);
    }
}
