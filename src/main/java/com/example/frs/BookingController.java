package com.example.frs;

import com.example.frs.animations.LabelDisappear;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import static java.lang.Integer.parseInt;

public class BookingController {
    @FXML
    private TextField name_tf,age_tf,address_tf,emailid_tf,dob,phoneno_tf,nationality_tf,passportno_tf;
    @FXML
    private RadioButton Male,Female;
    @FXML
    private Button back_btn,proceed_btn;
    @FXML
    private Label phoneLabel;
    String flightId;
    public void Proceed(ActionEvent event)
    {

        try {
            Connection con = sqlDB.getConnection();
            String query="insert into bookingInfo(name,age,address,email,dob,phoneno,nationality,passport,userid,gender,flightid) values(?,?,?,?,?,?,?,?,?,?,?)";
            DataSingleton data=DataSingleton.getInstance();
            if(phoneno_tf.getText().length()>10)
            {
                phoneLabel.setText("Invalid Phone No");
                LabelDisappear ld=new LabelDisappear();
                ld.disappear(phoneLabel);
            }
            else {
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, name_tf.getText());
                pstmt.setInt(2, parseInt(age_tf.getText()));
                pstmt.setString(3, address_tf.getText());
                pstmt.setString(4, emailid_tf.getText());
                pstmt.setString(5, dob.getText());
                pstmt.setString(6, phoneno_tf.getText());
                pstmt.setString(7, nationality_tf.getText());
                pstmt.setString(8, passportno_tf.getText());
                pstmt.setInt(9, data.getUserid());
                pstmt.setString(10, getGender(event));
                pstmt.setString(11, data.getFlightid());
                pstmt.executeUpdate();
                PaymentController p = new PaymentController();

                SceneChanger sc = new SceneChanger();
                sc.changeScene(event, "payment.fxml", "Payment");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



    public void getFlightId(String flightId)
    {
        this.flightId=flightId;
        System.out.println(this.flightId);
    }

    public String getGender(ActionEvent event)
    {
        String gender = "";
        if(Male.isSelected())
        {
             gender="Male";
        }
        else if (Female.isSelected())
        {
            gender="Female";
        }
        return gender;
    }

    public void setBack_btn(ActionEvent event) throws IOException {
        SceneChanger sc=new SceneChanger();
        sc.changeScene(event,"Search-view.fxml","search flights");
    }

}
