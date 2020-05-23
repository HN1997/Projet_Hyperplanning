package package_modele;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConnexionSQL 
{
    private Connection conn = null; //gerer la connection a la bdd
    private PreparedStatement pst = null; //executer les requetes (=query)
    private ResultSet rs = null;

    //Constructeur qui nous connecte a la BDD

    /**
     *
     */
    public ConnexionSQL() 
    {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erreur connection a la base de donnee");
        }

        try 
        {
            //création d'une connexion JDBC à la base
            conn = DriverManager.getConnection("jdbc:mysql://localhost/planning", "root", "");
            //JOptionPane.showMessageDialog(null, "Connection a la bdd reussie!");
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erreur connection a la base de donnee");
        }
    }
    
    
    private static Connection connc;
    
    /**
     *
     * @return
     * @throws SQLException
     */
    public static Connection getInstance() throws SQLException {
        if (connc == null) {
            connc = DriverManager.getConnection("jdbc:mysql://localhost/planning", "root", "");
        }
        return connc;
    }
}


   


