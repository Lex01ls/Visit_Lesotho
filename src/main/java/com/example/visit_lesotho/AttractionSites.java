package com.example.visit_lesotho;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import model.Sites;

public class AttractionSites {

    @FXML
    private ImageView img;

    @FXML
    private Label name;

    @FXML
    private Text description;

    @FXML
    private Label price;


    public void setData(Sites sites){

        var imgSrc = getClass().getResource(sites.getImage_src());
        if(imgSrc != null){
            String ext = imgSrc.toExternalForm();
            Image image =  new Image(ext);
            img.setImage(image);
            img.setPreserveRatio(true);
        }
        else{
            System.out.println("This is null");

        }
        name.setText(sites.getName());
        price.setText("M"+sites.getPrice());
        description.setText(sites.getDescription());
    }

}
