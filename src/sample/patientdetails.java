package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class patientdetails {
    public Label username;
    public Label password;
    public Label firstname;
    public Label lastname;
    public Label date;
    public Label agel;
    public Label blood;
    public Label phno;
   public Label disease;
   public AnchorPane display;
   public AnchorPane anchor;

   public String user;
   public String pass;
   public String fname;
    Connection conn;

    public patientdetails()
    {
        conn = sqliteConnection.Connector();
        if(conn == null) System.exit(1);
    }

    public void backaction(ActionEvent event )throws  Exception {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage RegisterStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
        RegisterStage.setTitle("Hospital Managment");
        RegisterStage.setScene(new Scene(root));
        RegisterStage.getIcons().add(new Image(getClass().getResourceAsStream("/sample/logo.png")));
        RegisterStage.show();
       }

    public void Disact(ActionEvent event) {
        display.setVisible(true);
        try {
            loginDetails();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void loginDetails() throws SQLException
    {
        user=signin.User;
        pass=signin.Pass;
        username.setText(user);
        password.setText(pass);
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from Users where Username = ? and Password = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();

                //System.out.println(rs.);
                if(rs.next())
                {
                    fname = rs.getString("firstname");
                    lastname.setText(rs.getString("lastname"));
                    agel.setText(rs.getString("age"));
                    date.setText(rs.getString("birth"));
                    blood.setText(rs.getString("bloodgrp"));
                    disease.setText(rs.getString("disease"));
                    phno.setText(rs.getString("phoneno"));
                    if(fname != null) firstname.setText(fname);
                }

            }
            catch(Exception e)
            {
                System.out.println("Hello"+e);
            }
            finally
            {
                ps.close();
                rs.close();
            }

        }
    }


