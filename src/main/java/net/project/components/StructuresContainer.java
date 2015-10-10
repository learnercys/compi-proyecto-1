package net.project.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import net.project.utils.GenericElement;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author learnercys on 5/10/15.
 */
public class StructuresContainer extends BorderPane implements Initializable{
    final Canvas bgCanvas = new Canvas(200,200);
    final Canvas fgCanvas = new Canvas(200,200);
    final Canvas dgCanvas = new Canvas(200,200);

    private ArrayList<GenericElement> bgs = new ArrayList<>();
    private ArrayList<GenericElement> figures = new ArrayList<>();
    private ArrayList<GenericElement> designs = new ArrayList<>();

    // Current Background
    private int cbg = 1;
    private int cfg = 1;
    private int cdg = 1;

    private GraphicsContext bgGC;
    private GraphicsContext fgGC;
    private GraphicsContext dgGC;

    @FXML Label bgName;
    @FXML Label fgName;
    @FXML Label fgLive;
    @FXML Label fgType;
    @FXML Label fgDestroy;
    @FXML Label fgDescription;
    @FXML Label dgName;
    @FXML Label dgType;
    @FXML Label dgCredits;
    @FXML Label dgDestroy;
    @FXML Button nextBGButton;
    @FXML Button prevBGButton;
    @FXML Button nextFGButton;
    @FXML Button prevFGButton;
    @FXML Button nextDGButton;
    @FXML Button prevDGButton;
    @FXML FlowPane bgCanvasContainer;
    @FXML FlowPane fgCanvasContainer;
    @FXML FlowPane dgCanvasContainer;

    public StructuresContainer() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("structurescontainer.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
            // button events

            nextBGButton.setOnMouseClicked(event -> setBg(1));

            prevBGButton.setOnMouseClicked(event -> setBg(-1));

            nextFGButton.setOnMouseClicked(event -> setFg(1));

            prevFGButton.setOnMouseClicked(event -> setFg(-1));

            nextDGButton.setOnMouseClicked(event -> setDg(1));

            prevDGButton.setOnMouseClicked(event -> setDg(-1));
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void setBg(int change) {
        int tmp = cbg + change;
        if ( tmp >= 0 && tmp < this.bgs.size() && this.bgs.size() > 0) {
            cbg += change;
            GenericElement bg = this.bgs.get(cbg);
            bgName.setText((String) bg.getAttr("name").getValue());
            // validate if the picture already exist
            try {
                bgGC.setFill(Color.WHITE);
                bgGC.fillRect(0, 0, 200, 200);
                bgGC.drawImage(new Image(new File((String)bg.getAttr("picture").getValue()).toURI().toString()), 0, 0, 200, 200);
            } catch (Exception npe) {
                npe.printStackTrace();
            }
        }
    }

    private void setFg(int change) {
        int tmp = cfg + change;
        if(tmp >= 0 && tmp < this.figures.size() && this.figures.size() > 0) {
            cfg += change;
            GenericElement fg = this.figures.get(cfg);
            fgName.setText((String)fg.getAttr("name").getValue());
            fgLive.setText(fg.getAttr("live").getValue().toString());
            fgType.setText((String)fg.getAttr("type").getValue());
            fgDestroy.setText(fg.getAttr("destroy").getValue().toString());
            fgDescription.setText((String)fg.getAttr("description").getValue());
            // validate if the picture already exist
            try {
                fgGC.setFill(Color.WHITE);
                fgGC.fillRect(0, 0, 200, 200);
                fgGC.drawImage(new Image(new File((String)fg.getAttr("picture").getValue()).toURI().toString()), 0, 0, 200, 200);
            } catch (Exception npe) {
                npe.printStackTrace();
            }
        }
    }

    private void setDg(int change) {
        int tmp = cdg + change;
        if(tmp >= 0 && tmp < this.designs.size() && this.designs.size() > 0){
            cdg += change;
            GenericElement dg = this.designs.get(cdg);
            dgName.setText((String)dg.getAttr("name").getValue());
            dgType.setText((String)dg.getAttr("type").getValue());
            if( dg.getAttr("destroy") != null) {
                dgCredits.setText(dg.getAttr("destroy").getValue().toString());
            } else {
                dgCredits.setText("");
            }
            if(dg.getAttr("credits") != null) {
                dgDestroy.setText(dg.getAttr("credits").getValue().toString());
            } else {
                dgDestroy.setText("");
            }
            try {
                dgGC.setFill(Color.WHITE);
                dgGC.fillRect(0, 0, 200, 200);
                dgGC.drawImage(new Image(new File((String)dg.getAttr("picture").getValue()).toURI().toString()), 0, 0, 200, 200);
            } catch (Exception npe) {
                npe.printStackTrace();
            }
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

    public ArrayList<GenericElement> getBgs() {
        return bgs;
    }

    public ArrayList<GenericElement> getFigures() {
        return figures;
    }

    public ArrayList<GenericElement> getDesigns() {
        return designs;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // canvas background
        bgGC = bgCanvas.getGraphicsContext2D();
        bgCanvasContainer.getChildren().add(bgCanvas);

        // canvas figure
        fgGC = fgCanvas.getGraphicsContext2D();
        fgCanvasContainer.getChildren().add(fgCanvas);

        // canvas design
        dgGC = dgCanvas.getGraphicsContext2D();
        dgCanvasContainer.getChildren().add(dgCanvas);


    }
}
