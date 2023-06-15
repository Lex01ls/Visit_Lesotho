package com.example.visit_lesotho;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Login {

    @FXML
    private TextField txtUsername;

    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnRegister;

    String getUserName;
    String getPassword;

    String username;
    String Password;
    @FXML
    void validation(ActionEvent event) throws IOException {

        username = txtUsername.getText();
        Password  = txtUsername.getText();
        readFromFile();
        readFile();

        if(!Objects.equals(getUserName, username) && Objects.equals(getPassword, Password)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Incorrect Credentials");
            alert.showAndWait();

        }
        else {

            goToMain(event);

        }

    }

    private void goToMain(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Visit_Lesotho.class.getResource("main.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
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
    public void readFile(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("password.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }
            getPassword = stringBuilder.toString();

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleClicks(ActionEvent event) throws IOException {
        if(event.getSource()==btnLogIn){
            validation(event);
        }
        if(event.getSource()== btnRegister){
            goToRegister(event);
        }
    }

    private void goToRegister(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Visit_Lesotho.class.getResource("registration.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

}
