package com.example.frs;

import com.example.frs.animations.LabelDisappear;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import com.example.frs.animations.Shake;
import javafx.util.Duration;


import java.io.IOException;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;



public class LoginController {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField usernametf;
    @FXML
    private PasswordField passwordpf;
    @FXML
    private Button loginbtn;
    @FXML
    private Label errorLabel;
    @FXML
    private Button signup_btn;

    private volatile boolean stop=false;





    public void signUp(ActionEvent event) throws IOException {
       SceneChanger sc= new SceneChanger();
       sc.changeScene(event,"signup.fxml","SignUp");
    }

    public void setLoginbtn(ActionEvent event) {
        try {
            Connection c = sqlDB.getConnection();
            String password = passwordpf.getText();
            String username = usernametf.getText();
            AdminPassword admin = new AdminPassword();
            if (password.equals(admin.getAdmin_password()) && username.equals(admin.getAdmin_username())) {
                SceneChanger sce = new SceneChanger();
                sce.changeScene(event, "adminPanel.fxml", "Admin Panel");
            }


            String query = "Select * from userinfo";
            Statement checkCredentials = c.createStatement();
            ResultSet set = checkCredentials.executeQuery(query);
            while (set.next()) {
                int userid=set.getInt(1);
                String name = set.getString(2);
                String pass = set.getString(3);
                if (Objects.equals(username, name) && Objects.equals(password, pass)) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("flightSearch.fxml"));
                    root = loader.load();
                    FlightSearchController flightSearchController = loader.getController();
                    flightSearchController.displayName(username);
                    DataSingleton data=DataSingleton.getInstance();
                    data.setUserid(userid);
                    data.setUsername(name);
                    //Parent root= FXMLLoader.load(getClass().getResource("Scene2.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
                errorLabel.setText("Invalid Credentials");
                LabelDisappear ld = new LabelDisappear();
                ld.disappear(errorLabel);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



}
