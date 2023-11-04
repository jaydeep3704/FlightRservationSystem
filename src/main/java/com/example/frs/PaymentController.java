package com.example.frs;
import com.example.frs.animations.LabelDisappear;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;


public class PaymentController {
    @FXML
    private RadioButton PayPal;

    @FXML
    private Button Proceed;

    @FXML
    private RadioButton UPI;

    @FXML
    private Button back;


    @FXML
    private RadioButton creditCard;

    @FXML
    private RadioButton debitCard;

    @FXML
    private ToggleGroup payment;





    public void setBack_btn(ActionEvent event) throws IOException {
        SceneChanger sc=new SceneChanger();
        sc.changeScene(event,"booking.fxml","Book Flight");
    }

    public void proceed_btn(ActionEvent event) throws IOException {
        SceneChanger sc=new SceneChanger();
        if(debitCard.isSelected())
        {
            sc.changeScene(event,"debitCard.fxml","Payment - Debit Card");
        }
        else if(UPI.isSelected())
        {
            sc.changeScene(event,"gpay.fxml","Payment - Debit Card");
        }
    }

}
