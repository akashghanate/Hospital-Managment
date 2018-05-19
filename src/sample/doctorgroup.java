package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.ResourceBundle;


public class doctorgroup implements Initializable {
    Connection con = sqliteConnection.Connector();

         public TableView<modeltable> table;
         public TableColumn<modeltable,String> user;
         public TableColumn<modeltable,String> pass;
         public TableColumn<modeltable,String> firstname;
         public TableColumn<modeltable,String> lastname;
         public TableColumn<modeltable,String> date;
         public TableColumn<modeltable,Integer> age;
         public TableColumn<modeltable,String> blood;
         public TableColumn<modeltable,String> disease;
         public JFXTextField search;
         public TableColumn<modeltable,Integer> phno;
         public Label label;
         public ChoiceBox<String> checkbox;
         HashMap<String,String> map=new HashMap<String, String>();


         ObservableList<modeltable> oblist = FXCollections.observableArrayList();


    public void backact(ActionEvent event) throws Exception{
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage backtosignin=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
        backtosignin.setTitle("Hospital Managment");
        backtosignin.setScene(new Scene(root));
        backtosignin.getIcons().add(new Image(getClass().getResourceAsStream("/sample/logo.png")));
        backtosignin.show();
    }




public void createHashpatient()throws SQLException {
        String query = "select * from Users";
        String S,a;

    PreparedStatement ps= null;
    ResultSet rs=null;
    try{
        ps=con.prepareStatement(query);
        rs=ps.executeQuery();
        while(rs.next()){
            S=rs.getString("firstname");
            a=rs.getString("disease");
            map.put(S,a);
        }
    }catch (Exception e){
        e.printStackTrace();;
    }finally {
        ps.close();
        rs.close();
    }
}
 public void searchin(ActionEvent event)throws SQLException{
        createHashpatient();
        String s= search.getText();
        String a= map.get(s);
        label.setText(a);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {



        String query = "select * from Users";

        try{
            ResultSet rs = con.createStatement().executeQuery(query);
            while(rs.next()){
                oblist.add(new modeltable(rs.getString("Username"),rs.getString("Password"),rs.getString("firstname"),rs.getString("lastname"),rs.getInt("age"),rs.getString("birth"),rs.getString("bloodgrp"),rs.getString("disease"),rs.getInt("phoneno")));
            }
        }catch(Exception e){
            System.out.println("error "+e);
        }

        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        date.setCellValueFactory(new PropertyValueFactory<>("dob"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        blood.setCellValueFactory(new PropertyValueFactory<>("blood"));
        disease.setCellValueFactory(new PropertyValueFactory<>("disease"));
        phno.setCellValueFactory(new PropertyValueFactory<>("phone"));
        lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        pass.setCellValueFactory(new PropertyValueFactory<>("pass"));
        table.setItems(oblist);
    }
}
