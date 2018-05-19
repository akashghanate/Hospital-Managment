package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class signin {
    public JFXTextField usernameTF;
    public JFXPasswordField passwordTF;
    public JFXTextField docname;
    public JFXPasswordField docpass;
    public JFXButton docin;
    public JFXButton sigin;
    @FXML
    public Pane userpane;
    public Pane docpane;
    @FXML
    private Label lbl;
    public Label lbl1;

    public JFXToggleButton toggle;

    private LoginModel lm = new LoginModel();


   public static String User;
   public static String Pass;
   public static Stage registe=new Stage();

    Connection conn;

    public signin()
    {
        conn = sqliteConnection.Connector();
        if(conn == null) System.exit(1);
    }
    public void sigin() throws Exception {
        sigin.setOnAction(ae->{
        try {
            if ((!usernameTF.getText().equals("")) && (!passwordTF.getText().equals(""))) {
                if (lm.isLogin(usernameTF.getText(), passwordTF.getText())) {
                    ((Node) ae.getSource()).getScene().getWindow().hide();
                     Stage RegisterStage=new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("patientdetails.fxml"));
                    RegisterStage.setTitle("Patient_details");
                    RegisterStage.setScene(new Scene(root));
                    RegisterStage.getIcons().add(new Image(getClass().getResourceAsStream("/sample/logo.png")));
                    RegisterStage.show();
                    User = usernameTF.getText();
                    Pass = passwordTF.getText();
                } else {
                    lbl.setText("Status : Invalid ID");
                }
            } else {
                lbl.setText("Status : empty");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        });
    }

    public void sigup(ActionEvent event) throws Exception{

        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));

        registe.setTitle("Register_Window");
        registe.setScene(new Scene(root));
        registe.getIcons().add(new Image(getClass().getResourceAsStream("/sample/logo.png")));
        registe.show();
    }
    public void toggleaction(ActionEvent event) {
        if (toggle.isDisabled()){
          userpane.setVisible(true);
            docpane.setVisible(false);
        }
        if(toggle.isFocused()){
                userpane.setVisible(false);
                docpane.setVisible(true);
            }

    }

    public void sigindoc() throws Exception {
        docin.setOnAction(ae -> {
            try {
                if ((!docname.getText().equals("")) && (!docpass.getText().equals(""))) {
                    if (lm.doclogin(docname.getText(), docpass.getText())) {
                        lbl1.setText("Successful");
                        ((Node) ae.getSource()).getScene().getWindow().hide();
                        Parent root = FXMLLoader.load(getClass().getResource("doctorgroup.fxml"));

                        registe.setTitle("Details_Window");
                        registe.setScene(new Scene(root));
                        registe.getIcons().add(new Image(getClass().getResourceAsStream("/sample/logo.png")));
                        registe.show();
//                        User = docname.getText();
  //                      Pass = docpass.getText();
                    } else {
                        lbl1.setText("Status : Invalid ID");
                    }
                } else {
                    lbl1.setText("Status : empty");
                }
            } catch (SQLException e) {
                System.out.println(e);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
    public void sigupdoc(ActionEvent event)throws Exception{

    }
}