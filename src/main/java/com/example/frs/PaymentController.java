package com.example.frs;
import com.example.frs.animations.LabelDisappear;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;


public class PaymentController {
    @FXML
    private Label paymentLabel;
    @FXML
    private Button back;

    public void setBack_btn(ActionEvent event) throws IOException {
        SceneChanger sc=new SceneChanger();
        sc.changeScene(event,"booking.fxml","Book Flight");
    }
}
