package net.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author learnercys on 30/08/15.
 */
public class Main extends Application {
    public static String ROOT_PATH;
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = FXMLLoader.load(getClass().getResource("fxml/mainctrl.fxml"));
        ROOT_PATH = getClass().getResource("").getPath();
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String [] args) {
        launch(args);
    }
}
