package com.example.frs;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import com.example.frs.animations.*;
import java.io.IOException;
import java.sql.*;

public class AdminPanelController {
    @FXML
    private TextField flightIdtf;
    @FXML
    private TextField fromtf;
    @FXML
    private TextField totf;
    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;
    @FXML
    private Button addFlightbtn;
    @FXML
    private Label labelUpdate;
    @FXML
    private Button clearBtn;
    @FXML
    private Button logoutBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private TextField ticketPrice;

    public void addFlight(ActionEvent event) throws SQLException {
        Connection c=sqlDB.getConnection();

        String query="insert into flightinformation(flightId,Dep_City,Ar_City,DepartureDate,ArrivalDate,DepartureTime,ticket_price )values(ucase(?),ucase(?),ucase(?),?,?,current_time,?)";
        PreparedStatement pst=c.prepareStatement(query);
        pst.setString(1,flightIdtf.getText());
        pst.setString(2,fromtf.getText());
        pst.setString(3,totf.getText());
        pst.setString(4,((TextField)fromDate.getEditor()).getText());
        pst.setString(5,((TextField)toDate.getEditor()).getText());
        pst.setString(6,ticketPrice.getText());
        pst.executeUpdate();
        labelUpdate.setText("Success:flight information has been recorded");
        LabelDisappear ld=new LabelDisappear();
        ld.disappear(labelUpdate);


    }
    public void updateFlight(ActionEvent event) throws SQLException {
        Connection c=sqlDB.getConnection();
        String query="update flightinformation set Dep_City=?,Ar_City=?,DepartureDate=?,ArrivalDate=? where flightId='"+flightIdtf.getText()+"'";
        PreparedStatement pst=c.prepareStatement(query);

        pst.setString(1,fromtf.getText());
        pst.setString(2,totf.getText());
        pst.setString(3,((TextField)fromDate.getEditor()).getText());
        pst.setString(4,((TextField)toDate.getEditor()).getText());
        pst.executeUpdate();
        labelUpdate.setText("Success:flight details updated");
        LabelDisappear ld=new LabelDisappear();
        ld.disappear(labelUpdate);
    }



    public void logout(ActionEvent event) throws IOException {
        FlightSearchController fs=new FlightSearchController();
        fs.logout(event);
    }

    public void clearbtn(ActionEvent event)
    {
        flightIdtf.clear();
        fromtf.clear();
        totf.clear();
    }

}
