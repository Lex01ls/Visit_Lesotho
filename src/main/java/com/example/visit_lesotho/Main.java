package com.example.visit_lesotho;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

public class Main implements Initializable {
    @FXML
    private BorderPane mainPane;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnExplore;

    @FXML
    private Button btnMap;

    @FXML
    private Button btnGallery;

    @FXML
    private Button btnInformation;

    @FXML
    private Label lblName;

    private Pane view;
    private String getUserName;

    Home home = new Home();

    @FXML
    void handleClicks(ActionEvent event) {
        if(event.getSource() == btnHome){
            view = changeScene("Home.fxml");
            mainPane.setCenter(view);
        }
        if(event.getSource()== btnExplore){
            view = changeScene("Explore.fxml");
            mainPane.setCenter(view);
        }
        if(event.getSource()== btnMap){
            view = changeScene("Map.fxml");
            mainPane.setCenter(view);
        }
        if(event.getSource()==btnGallery){
            view = changeScene("Gallery.fxml");
            mainPane.setCenter(view);
        }
        if(event.getSource()==btnInformation){
            view = changeScene("Information.fxml");
            mainPane.setCenter(view);
        }
    }

    private Pane changeScene(String file_name){
        try {
            URL file_URl = Visit_Lesotho.class.getResource(file_name);
            if(file_URl == null){
                throw new java.io.FileNotFoundException("FXML does not exist");
            }
            new FXMLLoader();
            view = FXMLLoader.load(file_URl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        view = changeScene("Home.fxml");
        mainPane.setCenter(view);
        readFromFile();
        lblName.setText(getUserName);

    }
    public void readFromFile(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("username.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }
            getUserName = stringBuilder.toString();

            reader.close();


        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
