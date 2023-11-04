package com.example.frs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Processed {

    @FXML
    private Button backToSearch;


    public void setBackToSearch(ActionEvent event) throws IOException {
        SceneChanger sc=new SceneChanger();
        sc.changeScene(event,"flightSearch.fxml","search Flights");
    }
}
