module com.example.euclidcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.euclidcalculator to javafx.fxml;
    exports com.euclidcalculator;
}