package com.example.visit_lesotho;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Reviews {

    @FXML
    private TextArea txtComment;

    @FXML
    private Button btnSubmit;

    @FXML
    void handleClicks(ActionEvent event) {
        if(event.getSource()==btnSubmit){
            check();
        }
    }

   public void saveToFile(){
        try{

            BufferedWriter writer = new BufferedWriter(new FileWriter("Reviews.txt"));
            writer.write(txtComment.getText());
            System.out.println("file saved");
            writer.close();


        } catch (IOException e){
            e.printStackTrace();
        }
   }

    public void reset(){
        txtComment.setText(null);
    }

    public void check(){
        if(txtComment.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Cannot leave a text area empty if you want to leave a comment");
            alert.showAndWait();
        }else{
            saveToFile();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Thank you for you Review");
            alert.showAndWait();
            reset();
        }
    }

}
