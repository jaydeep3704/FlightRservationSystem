package com.example.frs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class FlightSearchController {

    @FXML
    private Label welcome_label;

    @FXML
    private Button btn_logout;


    @FXML
    private Button clearBtn;

    @FXML
    private Button contactsBtn;

    @FXML
    private DatePicker dateOfFly_picker;

    @FXML
    private TextField from_field;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField where_field;

    @FXML
    private Button flightsbtn;

    @FXML

    public void logout(ActionEvent event) throws IOException {

        SceneChanger sChanger=new SceneChanger();
        sChanger.changeScene(event,"login.fxml");

    }

    public void displayName(String username)
    {
        welcome_label.setText("Hello "+username);
    }



    public void clear(ActionEvent event)
    {
        from_field.clear();         //clear text fields
        where_field.clear();
    }


}


