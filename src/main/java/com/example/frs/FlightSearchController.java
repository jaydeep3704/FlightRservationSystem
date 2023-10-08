// FlightSearchController.java
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
    private DatePicker dateOfFly_picker;

    @FXML
    public TextField from_field,where_field;

    @FXML
    private Button searchbtn,myflightsBtn,flightsbtn;



    @FXML
    public void logout(ActionEvent event) throws IOException {
        SceneChanger sChanger = new SceneChanger();
        sChanger.changeScene(event, "login.fxml", "Login");
    }

    public void displayName(String username) {
        welcome_label.setText("Hello " + username);
    }

    public void clear(ActionEvent event) {
        from_field.clear();
        where_field.clear();
    }

    public void setFlightsbtn(ActionEvent event) throws IOException {
        SceneChanger sc = new SceneChanger();
        sc.changeScene(event, "Search-view.fxml", "search view");
    }

    public void search(ActionEvent event) throws IOException {


        SearchViewController sv=new SearchViewController();

      TextFieldUtils t=new TextFieldUtils();
        DataSingleton data=DataSingleton.getInstance();
        data.setFrom_city(from_field.getText());
        data.setTo_city(where_field.getText());
        SceneChanger sc = new SceneChanger();
        sc.changeScene(event, "Search-view.fxml", "search view");
    }
    public void setMyflightsBtn(ActionEvent event) throws IOException {
        SceneChanger sc=new SceneChanger();
        sc.changeScene(event,"userBookings.fxml","My Bookings");
    }
}
