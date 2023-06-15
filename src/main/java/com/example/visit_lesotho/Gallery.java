package com.example.visit_lesotho;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.Photos;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Gallery implements Initializable {

    @FXML
    private GridPane photo_grid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<Photos> photoList = getPhotos();

        int column = 0;
        int row = 1;


        try {
            for (Photos photo : photoList){

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Album.fxml"));
                Pane pane = loader.load();
                Album albumController = loader.getController();
                albumController.initialize(photo);

                if(column == 2){
                    column = 0;
                    ++row;
                }
                    photo_grid.add(pane, column++, row);
                    GridPane.setMargin(pane, new Insets(20));

            }
        }catch (IOException e){
                e.printStackTrace();
        }
    }

    private ArrayList<Photos> getPhotos() {
        ArrayList<Photos> list = new ArrayList<>();

        Photos photos = new Photos();
        photos.setFolderName("src/main/resources/Images/Gallery/Afriski");
        photos.setName("Afriski Mountain Resort");
        list.add(photos);

        photos = new Photos();
        photos.setFolderName("src/main/resources/Images/Gallery/katse");
        photos.setName("Katse Dam");
        list.add(photos);

        photos = new Photos();
        photos.setFolderName("src/main/resources/Images/Gallery/liphofung");
        photos.setName("Liphofung Nature Reserve");
        list.add(photos);

        photos = new Photos();
        photos.setFolderName("src/main/resources/Images/Gallery/maletsunyane");
        photos.setName("Maletsunyane Falls");
        list.add(photos);

        photos = new Photos();
        photos.setFolderName("src/main/resources/Images/Gallery/morija");
        photos.setName("Morija Museum and Archives");
        list.add(photos);

        photos = new Photos();
        photos.setFolderName("src/main/resources/Images/Gallery/Thaba_bosiu");
        photos.setName("Thaba Bosiu Cultural Village");
        list.add(photos);

        return list;
    }
}
