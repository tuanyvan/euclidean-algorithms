module com.example.euclidcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.euclidcalculator to javafx.fxml;
    exports com.example.euclidcalculator;
}