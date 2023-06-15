module com.example.visit_lesotho {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.media;


    opens com.example.visit_lesotho to javafx.fxml;
    exports com.example.visit_lesotho;
}