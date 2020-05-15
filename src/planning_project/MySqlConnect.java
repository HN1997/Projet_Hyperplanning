package planning_project;
import java.sql.*;
import javax.swing.*;

public class MySqlConnect 
{
    private static Connection conn = null;
    
    public static Connection ConnectDB()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/planning", "root", "");
            //JOptionPane.showMessageDialog(null, "Connected to database.");
            return conn;
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
