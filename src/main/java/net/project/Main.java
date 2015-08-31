package net.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author learnercys on 30/08/15.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("fxml/mainctrl.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
