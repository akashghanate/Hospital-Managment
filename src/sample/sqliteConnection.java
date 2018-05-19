package sample;
import java.sql.*;
public class sqliteConnection {
    public static Connection Connector()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:E:Login.sqlite");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}