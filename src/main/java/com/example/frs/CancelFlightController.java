package com.example.frs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CancelFlightController {
    @FXML
    private Button back;

    @FXML
    private TextField bookingId;

    @FXML
    private Button cancelFlightBtn;


    public void setBack(ActionEvent event) throws IOException {
        SceneChanger sc=new SceneChanger();
        sc.changeScene(event,"userBookings.fxml","user bookings");
    }

    public void setCancelFlightBtn(ActionEvent event) {
        try {
            int booking_id=Integer.parseInt(bookingId.getText());
            Connection c=sqlDB.getConnection();
            String query="delete from bookinginfo where bookingid="+booking_id;
            Statement statement = c.createStatement();
            statement.executeUpdate(query);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
