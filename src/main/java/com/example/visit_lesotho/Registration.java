package com.example.visit_lesotho;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Registration {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtConfirm;

    @FXML
    private Button btnRegister;
    String username;
    String password;
    String Confirm;
    @FXML
    void handleClicks(ActionEvent event) throws IOException {
        if(event.getSource()==btnRegister){
            goToLogin(event);
        }
    }
    private void goToLogin(ActionEvent event) throws IOException {
        validate(event);
        FXMLLoader fxmlLoader = new FXMLLoader(Visit_Lesotho.class.getResource("login.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void validate(ActionEvent event) {
        Confirm = txtConfirm.getText();
        password = txtPassword.getText();

        if(password.equals(Confirm)){
            saveToFile();
        }
    }
    public void saveToFile(){
        username = txtUsername.getText();
        password = txtPassword.getText();
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("username.txt"));
            writer.write(username);

            writer.close();

            BufferedWriter writer2 = new BufferedWriter(new FileWriter("password.txt"));
            writer2.write(password);
            writer2.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
