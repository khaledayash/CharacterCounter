package com.mycompany.showcharwithhighestoccurrence.javafxFrontend;

import com.mycompany.showcharwithhighestoccurrence.javafxBusinessLogic.BusinessLogic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {


    @FXML
    private TextField textField;

    @FXML
    private Label outputLabel;


    private BusinessLogic businessLogic = new BusinessLogic();


    @FXML
    private void showCharWithHighestOccurence(KeyEvent event) {

        String input = "";
        String output = "";


        if (textField.getText() != null) {
            input = textField.getText();
            if (businessLogic.giveFinalResult(input) != null) {
                output = businessLogic.giveFinalResult(input);
                if (output != null) {
                    outputLabel.setText(output);
                }
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
