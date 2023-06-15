package com.example.visit_lesotho;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.Photos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Album {
    @FXML
    private Label Location;

    @FXML
    private ImageView site_image;

    @FXML
    private Button btnPrevious;

    @FXML
    private Button btnNext;


    private List<Image> images;
    private int currentIndex;
    private FadeTransition fadeTransition;

    public void initialize(Photos photos) {

        Location.setText(photos.getName());


        String folderName = photos.getFolderName();
        loadImagesFromFolder(folderName);
        fadeTransition = new FadeTransition(Duration.seconds(1), site_image);
        showImage(currentIndex);

    }

    //do not touch
    private void loadImagesFromFolder(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg"));
        images = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                Image image = new Image(file.toURI().toString());
                images.add(image);
            }
        }
    }

    @FXML
    private void showNextImage() {
        currentIndex++;
        if (currentIndex >= images.size()) {
            currentIndex = 0;
        }
        showImage(currentIndex);
    }

    @FXML
    private void showPreviousImage() {
        currentIndex--;
        if (currentIndex < 0) {
            currentIndex = images.size() - 1;
        }
        showImage(currentIndex);
    }

    private void showImage(int index) {
        if (index < 0 || index >= images.size()) {
            return;
        }

        Image image = images.get(index);
        site_image.setImage(image);

        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }
    @FXML
    void handleClicks(ActionEvent event) {
        if(event.getSource() == btnPrevious){
            showPreviousImage();
        }
        if(event.getSource() == btnNext){
            showNextImage();
        }
    }
}
