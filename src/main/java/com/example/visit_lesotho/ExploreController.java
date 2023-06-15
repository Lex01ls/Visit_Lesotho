package com.example.visit_lesotho;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Sites;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ExploreController implements Initializable {
    @FXML
    private GridPane site_grid;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Sites> sites =  new ArrayList<>(getSites());
        int column = 0;
        int row = 1;
        try{
            for(Sites site : sites){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AttractionSites.fxml"));

                Pane pane = loader.load();
                AttractionSites attractionSites = loader.getController();
                attractionSites.setData(site);

                if(column == 1){
                    column = 0;
                    ++row;
                }
                site_grid.add(pane, column++, row);
                GridPane.setMargin(pane, new Insets(25));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private List<Sites> getSites() {
        List<Sites> list = new ArrayList<>();

        Sites mySites = new Sites();
        mySites.setName("Maletsunyane Falls");
        mySites.setImage_src("/lesotho_cascate_semokong.jpg");
        mySites.setPrice(300);
        mySites.setDescription("Maletsunyane Falls is a 192-metre-high waterfall in the Southern African country Lesotho." +
                " It is located near the town of Semonkong, which also is named after the falls." +
                " The waterfall is on the Maletsunyane River and it falls from a ledge of Triassic-Jurassic basalt");
        list.add(mySites);

        mySites = new Sites();
        mySites.setName("AfriSki Mountain Resort");
        mySites.setImage_src("/afriski-ski-mountain.jpg");
        mySites.setPrice(500);
        mySites.setDescription("Afriski is the only skiing resort in Lesotho, located 3050 m above sea-level in the Maluti Mountains, operating in Southern Africa near the northern border of Lesotho with South Africa." +
                " It is one of only two ski resorts in southern Africa.");
        list.add(mySites);

        mySites = new Sites();
        mySites.setName("Thaba Bosiu");
        mySites.setImage_src("/ThabaBosiu.jpg");
        mySites.setPrice(40);
        mySites.setDescription("Thaba Bosiu is a sandstone plateau with an area of approximately 2 km² and a height of 1,804 meters above sea level." +
                " It is located between the Orange and Caledon Rivers in the Maseru District of Lesotho, 24 km east of the country's capital Maseru.");
        list.add(mySites);

        mySites = new Sites();
        mySites.setName("Katse Dam");
        mySites.setImage_src("/KatseDam.jpg");
        mySites.setPrice(1200);
        mySites.setDescription("The Katse Dam, a concrete arch dam on the Malibamat'so River in Lesotho, is Africa's second largest double-curvature arch dam." +
                " (The Tekezé Dam, completed in early 2009, is now Africa's largest double curvature dam)." +
                " The dam is part of the Lesotho Highlands Water Project, which will eventually include five large dams in remote rural areas." +
                " The dam is just below the confluence of the Bokong River, which forms the western arm of the Katse reservoir.");
        list.add(mySites);

        mySites = new Sites();
        mySites.setName("Liphofung");
        mySites.setImage_src("/Liphofung.jpg");
        mySites.setPrice(1500);
        mySites.setDescription("The Liphofung (“place of the eland”) Historical Site includes a cave which occupies an important place in Lesotho history." +
                " It is the smallest of the Lesotho Highlands Development Authority (LHDA) reserves, at about 4.5 ha (11 acres), but has been intensively developed." +
                " The cave is a large overhang in the Clarens sandstone, which is a typical feature of the Lesotho lowlands region.");
        list.add(mySites);

        mySites = new Sites();
        mySites.setName("Morija Museum and Archives");
        mySites.setImage_src("/MorijaMuseum.jpg");
        mySites.setPrice(250);
        mySites.setDescription("Morija Museum & Archives, also known as Morija Museum, is located in Morija, a large village in the Maseru district of Lesotho." +
                " The museum was formally opened in 1956, and entered its present permanent facilities in 1989." +
                " The purpose of the museum is to carry on the tradition of Morija, as a centre of learning, innovation and excellence, in Lesotho." +
                " Morija Museum is home to many cultural treasures including, traditional Basotho artifacts as well as Lifaqane and Boer War memorabilia.");
        list.add(mySites);

        return list;
    }
    @FXML
    private Button btnComment;

    @FXML
    void handleClicks(ActionEvent event) throws IOException {
        if(event.getSource() == btnComment){
            goToLeaveComment(event);
        }
    }

    private void goToLeaveComment(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Visit_Lesotho.class.getResource("Reviews.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

}
