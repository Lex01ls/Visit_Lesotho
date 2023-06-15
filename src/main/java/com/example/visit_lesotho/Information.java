package com.example.visit_lesotho;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

public class Information implements Initializable {


    @FXML
    private Text textInfo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        readFromFile();
    }
    public void readFromFile(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("information.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }
            textInfo.setText(stringBuilder.toString());

            reader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
