package com.example.visit_lesotho;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML
    private Button btnPlay;

    @FXML
    private MediaView mediaView;

    @FXML
    private Label lbl_profile_name;

    String username;

    @FXML
    private Text txtReview;

    private Media media;
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = true;

    @FXML
    void handleClicks(ActionEvent event) {
        if(event.getSource()==btnPlay){


            MediaPlayer.Status status = mediaPlayer.getStatus();
            if(status == MediaPlayer.Status.PLAYING){
                mediaPlayer.pause();
                btnPlay.setText("Play");
                btnPlay.setOpacity(100);
            }
            else if(status == MediaPlayer.Status.PAUSED){
                mediaPlayer.play();
                btnPlay.setText("Pause");
                btnPlay.setOpacity(0.01);
            }
            else if(status == MediaPlayer.Status.STOPPED || status == MediaPlayer.Status.UNKNOWN){
                mediaPlayer.stop();
                mediaPlayer.seek(Duration.ZERO);
                mediaPlayer.play();
                btnPlay.setText("Replay");
            }

            if (btnPlay.getText().equals("Replay")){
                mediaPlayer.play();
                btnPlay.setText("Pause");
                btnPlay.setOpacity(0.01);
            }

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String srcPath = "/Top 15 Places To Visit In Lesotho.mp4";
        String uriString = getClass().getResource(srcPath).toExternalForm();
        media = new Media(uriString);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        btnPlay.setText("Pause");
        btnPlay.setOpacity(0.01);

        mediaPlayer.setOnEndOfMedia(()->{
            mediaPlayer.stop();
            mediaPlayer.seek(Duration.ZERO);
            btnPlay.setOpacity(100);
            btnPlay.setText("Replay");

        });

        readFromFile();
        readFile();
        lbl_profile_name.setText(username);
    }

    public void readFromFile(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Reviews.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }
            txtReview.setText(stringBuilder.toString());

            reader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void readFile(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("username.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }
            username = stringBuilder.toString();

            reader.close();


        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void muteAudio(){
        mediaPlayer.setMute(true);
    }

}
