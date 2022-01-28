package com.example.euclidcalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EuclidCalculatorController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}