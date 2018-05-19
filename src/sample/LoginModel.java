package sample;
import java.sql.*;

public class LoginModel {
    Connection conn;

    public LoginModel()
    {
        conn = sqliteConnection.Connector();
        if(conn == null) System.exit(1);
    }
//patient login
    public boolean isLogin(String user, String pass) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from Users where Username = ? and Password = ?";
        try
        {
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
            rs = ps.executeQuery();
            //System.out.println(rs.next());
            if(rs.next())
            {
                return true;
            }
            else
                return false;
        }
        catch(Exception e)
        {
            return false;
        }
        finally
        {
            ps.close();
            rs.close();
        }
    }

//Doctor login
    public boolean doclogin(String user, String pass) throws SQLException{
        PreparedStatement ps1 = null;
        ResultSet rs1 = null;
        String query = "select * from Doctor where Docname = ? and Docpass = ?";
        try
        {
            ps1 = conn.prepareStatement(query);
            ps1.setString(1,user);
            ps1.setString(2,pass);
            rs1 = ps1.executeQuery();
            if(rs1.next())
            {
                return true;
            }
            else
                return false;
        }
        catch(Exception e)
        {
            return false;
        }
        finally
        {
            ps1.close();
            rs1.close();
        }
    }
}
