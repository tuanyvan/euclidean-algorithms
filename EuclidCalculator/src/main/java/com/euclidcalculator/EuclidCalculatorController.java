package com.euclidcalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EuclidCalculatorController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onConfirmSelection() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}