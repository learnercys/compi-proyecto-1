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
    private int cfg = 1;
    private int cdg = 1;

    @FXML ImageView bgImage;
    @FXML Label bgName;
    @FXML Label fgName;
    @FXML Label dgName;

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
        if ( tmp >= 0 && tmp < this.bgs.size() && this.bgs.size() > 0) {
            cbg += change;
            GenericElement bg = this.bgs.get(cbg);
            bgName.setText((String)bg.getAttr("name").getValue());
            // todo validate if the picture already exist
            //bgImage.setImage(new Image((String)bg.getAttr("picture").getValue()));
        }
    }

    private void setFg(int change) {
        int tmp = cfg + change;
        if(tmp >= 0 && tmp < this.figures.size() && this.figures.size() > 0) {
            cfg += change;
            GenericElement fg = this.figures.get(cfg);
            fgName.setText((String)fg.getAttr("name").getValue());
            // todo validate if the picture already exist
        }
    }

    private void setDg(int change) {
        int tmp = cdg + change;
        if(tmp >= 0 && tmp < this.designs.size() && this.designs.size() > 0){
            cdg += change;
            GenericElement dg = this.designs.get(cdg);
            dgName.setText((String)dg.getAttr("name").getValue());
        }
    }

    public void setBgs(ArrayList<GenericElement> bgs) {
        this.bgs = bgs;
        // show bgs
        setBg(-1); // initial index, zero.
    }

    public void setFigures(ArrayList<GenericElement> figures) {
        this.figures = figures;
        // show figures
        setFg(-1);
    }

    public void setDesigns(ArrayList<GenericElement> designs) {
        this.designs = designs;
        // show designs
        setDg(-1);
    }

    public void setStr(ArrayList<GenericElement> bgs, ArrayList<GenericElement> figures, ArrayList<GenericElement> designs) {
        setBgs(bgs);
        setFigures(figures);
        setDesigns(designs);
    }
}
