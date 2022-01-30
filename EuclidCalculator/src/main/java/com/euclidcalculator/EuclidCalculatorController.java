package com.euclidcalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class EuclidCalculatorController implements Initializable {

    @FXML
    private RadioButton radioGCD;

    @FXML
    private RadioButton radioRSA;

    private final ToggleGroup calculationOptions = new ToggleGroup();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.radioGCD.setToggleGroup(calculationOptions);
        this.radioRSA.setToggleGroup(calculationOptions);
    }

    @FXML
    private void onConfirmSelection(ActionEvent event) {

    }

}
