package com.example.visit_lesotho;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Map implements Initializable {


    @FXML
    private WebView mapWebView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        WebEngine webEngine = mapWebView.getEngine();

        String searchEngineURL = "https://goo.gl/maps/4EXmZsBGMH6VbSkQ7";

        webEngine.load(searchEngineURL);

    }
}
