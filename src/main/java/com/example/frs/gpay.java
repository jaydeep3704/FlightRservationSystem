package com.example.frs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.example.frs.animations.*;

import java.io.IOException;

public class gpay {


    @FXML
    private Button back;

    @FXML
    private Button pay;

    @FXML
    private TextField upiId;


    public void  payBtn(ActionEvent event) throws IOException {
        if(upiId.getText().equals(""))
        {
            Shake s=new Shake(upiId);
            s.playAnim();
        }
        else{
            SceneChanger sc=new SceneChanger();
            sc.changeScene(event,"processed.fxml","Thank You");
        }
    }

    public void setBack(ActionEvent event) throws IOException {
        SceneChanger sc=new SceneChanger();
        sc.changeScene(event,"payment.fxml","Payment");
    }

}
