
package com.example.frs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable {

    @FXML
    private TableView<Flight> tableFlight;

    @FXML
    private TableColumn<Flight, String> arDate;

    @FXML
    private Button bookFlightBtn;

    @FXML
    private DatePicker datapicker;

    @FXML
    private TableColumn<Flight, String> depDate;

    @FXML
    private TextField flightidtf;

    @FXML
    private TableColumn<Flight, String> fromFlightColumn;

    @FXML
    public TextField from_field;

    @FXML
    private TableColumn<Flight, String> flightId;

    @FXML
    private TableColumn<Flight, Integer> price;

    @FXML
    private TableColumn<Flight, String> toFlightColumn;

    @FXML
     TextField to_field;

    ObservableList<Flight> flightObservableList = FXCollections.observableArrayList();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection c = sqlDB.getConnection();
        String query = "SELECT Dep_City,Ar_City,DepartureDate,ArrivalDate,ticket_price,flightId from flightinformation";



        try {
            Statement statement = c.createStatement();
            ResultSet set = statement.executeQuery(query);
            DataSingleton data=DataSingleton.getInstance();
            from_field.setText(data.getFrom_city());
            to_field.setText(data.getTo_city());

            while (set.next()) {
                String flight_id = set.getString("flightId");
                String from = set.getString("Dep_City");
                String to = set.getString("Ar_City");
                String DepDate = set.getString("DepartureDate");
                String ArDate = set.getString("ArrivalDate");
                Integer ticketPrice = set.getInt("ticket_price");

                flightObservableList.add(new Flight(from, to, flight_id, DepDate, ArDate, ticketPrice));
            }
            fromFlightColumn.setCellValueFactory(new PropertyValueFactory<>("from"));
            toFlightColumn.setCellValueFactory(new PropertyValueFactory<>("to"));
            depDate.setCellValueFactory(new PropertyValueFactory<>("DepartureDate"));
            arDate.setCellValueFactory(new PropertyValueFactory<>("ArrivalDate"));
            price.setCellValueFactory(new PropertyValueFactory<>("price"));
            flightId.setCellValueFactory(new PropertyValueFactory<>("flightId"));

            tableFlight.setItems(flightObservableList);

            FilteredList<Flight> filteredData = new FilteredList<>(flightObservableList, b -> true);
            from_field.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(flight -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    String lowerCaseFilter = newValue.toLowerCase();
                    return flight.getFrom().toLowerCase().contains(lowerCaseFilter);
                });
                tableFlight.setItems(filteredData);
            });

            to_field.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(flight -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    String lowerCaseFilter = newValue.toLowerCase();
                    return flight.getTo().toLowerCase().contains(lowerCaseFilter);
                });
                tableFlight.setItems(filteredData);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bookFlight(ActionEvent event) throws IOException {
        SceneChanger sc=new SceneChanger();
        sc.changeScene(event,"booking.fxml","Book Flight");
        DataSingleton data=DataSingleton.getInstance();
        data.setFlightid(flightidtf.getText());

    }
}
