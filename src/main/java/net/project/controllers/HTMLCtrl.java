package net.project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author learnercys on 5/10/15.
 */
public class HTMLCtrl implements Initializable {
    @FXML
    Label title;
    @FXML
    WebView webView;

    public void initData ( String html, String title ) {
        this.title.setText(title);
        webView.getEngine().loadContent(html);
    }

    @Override
    public void initialize( URL location, ResourceBundle resource ) {

    }
}
