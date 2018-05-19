package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.jnlp.ApiDialog;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLData;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.sun.javaws.ui.SplashScreen.hide;

public class register {
    public JFXTextField firstName;
    public JFXTextField lastName;
    public JFXTextField age;
    public JFXTextField birth;
    public JFXTextField bloodgrp;
    public JFXPasswordField password;
    public JFXTextField userName;
    public JFXTextField phno;
    public JFXTextField disease;
    public JFXButton register;
    public JFXButton cancel;
    public JFXButton close;
    public registerModel rg = new registerModel();
    public AnchorPane anchor;
    public AnchorPane con;

    Stage RegisterStage = new Stage();
    public void registerin(ActionEvent event) {

        add();
    }

    public void cancelAction(ActionEvent event) throws Exception {
        ((Node) event.getSource()).getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
        RegisterStage.setTitle("Hospital Managment");
        RegisterStage.setScene(new Scene(root));
        RegisterStage.getIcons().add(new Image(getClass().getResourceAsStream("/sample/logo.png")));
        RegisterStage.show();
    }

    public void add() {
        String first = firstName.getText();
        String last = lastName.getText();
        String ag = age.getText();
        String bir = birth.getText();
        String blood = bloodgrp.getText();
        String user = userName.getText();
        String pass = password.getText();
        String dise = disease.getText();
        String phone = phno.getText();


        try {
            rg.insertinfo(user, pass, first, last, ag, bir, dise, blood, phone);
        } catch (Exception e) {
            e.printStackTrace();

        }
        if (!first.isEmpty() && !last.isEmpty() && !ag.isEmpty() && !bir.isEmpty() && !blood.isEmpty() && !user.isEmpty()
                && !pass.isEmpty() && !dise.isEmpty() && !phone.isEmpty())
        {
                   Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("confirm.fxml"));
            } catch (Exception ex) {
            }


            RegisterStage.setTitle("Confirmation");
            RegisterStage.initModality(Modality.APPLICATION_MODAL);
            RegisterStage.setScene(new Scene(root, 270, 200));
            RegisterStage.getIcons().add(new Image(getClass().getResourceAsStream("/sample/logo.png")));
            RegisterStage.show();

        } else {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("error.fxml"));
            } catch (Exception ex) {
            }
            RegisterStage.setTitle("Error");
            RegisterStage.initModality(Modality.APPLICATION_MODAL);
            RegisterStage.setScene(new Scene(root, 270, 200));
            RegisterStage.getIcons().add(new Image(getClass().getResourceAsStream("/sample/logo.png")));
            RegisterStage.show();
        }
    }

    public void closeaction(ActionEvent event) throws Exception {


        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
        RegisterStage.setTitle("Hospital Managment");
        RegisterStage.setScene(new Scene(root));
        RegisterStage.getIcons().add(new Image(getClass().getResourceAsStream("/sample/logo.png")));
        RegisterStage.show();

    }
}
