package sample;
import java.sql.*;


public class registerModel {
    Connection conn;
    public  registerModel(){
        conn=sqliteConnection.Connector();
        if(conn ==null) System.exit(1);
    }
    public void insertinfo(String Username,String Password,String firstn,String lastn,String age,String birth,String disease,String blood,String phno) throws SQLException{
        PreparedStatement ps = null;

        String Query = "INSERT INTO Users (Username,Password,firstname,lastname,age,birth,bloodgrp,disease,phoneno) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
         ps=conn.prepareStatement(Query);
         ps.setString(1,Username);
         ps.setString(2,Password);
         ps.setString(3,firstn);
         ps.setString(4,lastn);
         ps.setString(5,age);
         ps.setString(6,birth);
         ps.setString(7,blood);
         ps.setString(8,disease);
         ps.setString(9,phno);


         }
         catch (Exception e){
             System.out.println("Hello "+e);
         }
         finally {
            ps.execute();
            ps.close();
        }


    }
}
