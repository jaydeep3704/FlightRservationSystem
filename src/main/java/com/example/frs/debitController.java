package com.example.frs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import com.example.frs.animations.Shake;

public class debitController implements Initializable {
    @FXML
    private ChoiceBox<String> bankName;

    @FXML
    private Label amount;

    @FXML
    private TextField chn;

    @FXML
    private TextField cno;

    @FXML
    private TextField expdate;
    @FXML
    private Button pay;

    private String [] banks={"State Bank Of India","Axis Bank ","HDFC Bank","Bank of Baroda","Bank Of Maharashtra"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        bankName.getItems().addAll(banks);

    }


    public void paybtn(ActionEvent event) throws IOException {


       // if(chn.getText().equals("")  )
       // {
        //    Shake shake=new Shake(chn);
        //    shake.playAnim();
       // }
       // else if ( cno.getText().equals("")) {
       //     Shake shake=new Shake(chn);
       //     shake.playAnim();
       // }
       // else if ( expdate.getText().equals("")) {
       //     Shake shake=new Shake(chn);
       //     shake.playAnim();
       // }

            SceneChanger sc=new SceneChanger();
            sc.changeScene(event,"processed.fxml","Thank You");
    }
}
