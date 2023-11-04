package com.example.frs;

import com.example.frs.animations.LabelDisappear;
import com.example.frs.animations.Shake;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class signupController {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label errorLabel;

    @FXML
    private Button login_back;

    @FXML
    private PasswordField passwordpf;

    @FXML
    private Button signup_btn;

    @FXML
    private Label time;

    @FXML
    private TextField usernametf;

    @FXML
    private TextField emailtf;

    @FXML
    public void backToLogin(ActionEvent event) throws IOException {
        SceneChanger sc=new SceneChanger();
        sc.changeScene(event,"login.fxml","Login Page");
    }

    @FXML
    public void signUp(ActionEvent event)
    {
        try{
            Connection c=sqlDB.getConnection();
            String passwordfield=passwordpf.getText();
            String usernamefield=usernametf.getText();
            String emailfield=emailtf.getText();
            String q="select * from userinfo where username='"+usernamefield+"'";
            Statement stmt=c.createStatement();
            ResultSet set=stmt.executeQuery(q);
            if(set.next())
            { errorLabel.setText("username already exists");
                LabelDisappear ld=new LabelDisappear();
                ld.disappear(errorLabel);
            }
            else{
                if(Objects.equals(usernamefield, "") || Objects.equals(passwordfield, ""))
                {
                    Shake shake=new Shake(usernametf);
                    shake.playAnim();
                    Shake shake1=new Shake(passwordpf);
                    shake1.playAnim();
                }
                else{
                    q="INSERT INTO userInfo(username,password,email) values (?,?,?)";
                    PreparedStatement pstmt= c.prepareStatement(q);
                    pstmt.setString(1,usernamefield);
                    pstmt.setString(2,passwordfield);
                    pstmt.setString(3,emailfield);
                    pstmt.executeUpdate();
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
