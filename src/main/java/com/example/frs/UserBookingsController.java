package com.example.frs;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class UserBookingsController implements Initializable {

    @FXML
    private TableView<MyBookings>passengerInfo;


    @FXML
    private TableColumn<MyBookings,Integer> bookingId;

    @FXML
    private TableColumn<MyBookings, String> departureDate;

    @FXML
    private TableColumn<MyBookings, String> departureTime;

    @FXML
    private TableColumn<MyBookings, String> flightId;

    @FXML
    private TableColumn<MyBookings, String> from;

    @FXML
    private TableColumn<MyBookings, String> passengerName;

    @FXML
    private TableColumn<MyBookings, String> to;

    @FXML
    private Button back_btn;

    ObservableList<MyBookings> bookingsObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Connection c=sqlDB.getConnection();
        DataSingleton d=DataSingleton.getInstance();
        String query="SELECT bookinginfo.flightid,bookingid,Dep_City,Ar_City,name,DepartureDate,CONVERT(DepartureTime,CHAR) as time FROM flightinformation\n "+
                "JOIN bookinginfo ON bookinginfo.flightid=flightinformation.flightId\n" +
                "JOIN userinfo ON bookinginfo.userid=userinfo.userId where username='"+d.getUsername()+"';";
        try {
            Statement statement = c.createStatement();
            ResultSet set = statement.executeQuery(query);

            while (set.next()) {
                String flight_id = set.getString("flightid");
                Integer booking_id = set.getInt("bookingid");
                String from = set.getString("Dep_City");
                String to = set.getString("Ar_City");
                String pName = set.getString("name");
                String DepDate = set.getString("DepartureDate");
                String time = set.getString("time");

                bookingsObservableList.add(new MyBookings(booking_id, flight_id, from, to, pName, DepDate, time));
            }
            flightId.setCellValueFactory(new PropertyValueFactory<>("flightId"));
            bookingId.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
            from.setCellValueFactory(new PropertyValueFactory<>("from"));
            to.setCellValueFactory(new PropertyValueFactory<>("to"));
            passengerName.setCellValueFactory(new PropertyValueFactory<>("passengerName"));
            departureDate.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
            departureTime.setCellValueFactory(new PropertyValueFactory<>("time"));

            passengerInfo.setItems(bookingsObservableList);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }




    public void back(ActionEvent event)
    {
        try{
            SceneChanger sc=new SceneChanger();
            sc.changeScene(event,"flightSearch.fxml","Search Flights");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void cancelFlight(ActionEvent event) throws IOException {
        SceneChanger sc=new SceneChanger();
        sc.changeScene(event,"cancelFlight.fxml","Cancel Flight");
    }

}