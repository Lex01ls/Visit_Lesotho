package com.example.visit_lesotho;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Visit_Lesotho extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Visit_Lesotho.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        String css =  Objects.requireNonNull(this.getClass().getResource("/application.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        Image icon = new Image("icon_pic.png");
        stage.getIcons().add(icon);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}