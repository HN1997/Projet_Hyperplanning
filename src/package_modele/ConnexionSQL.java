package package_modele;
import java.sql.*;
import java.lang.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConnexionSQL 
{
    private Connection conn = null;
    

    //Constructeur qui nous connecte a la BDD
    public ConnexionSQL() 
    {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erreur connection a la base de donnee");
        }

       
        try 
        {
            //création d'une connexion JDBC à la base
            conn = DriverManager.getConnection("jdbc:mysql://localhost/planning", "root", "");
            JOptionPane.showMessageDialog(null, "Connection a la bdd reussie!");
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erreur connection a la base de donnee");
        }
    }
    
    public boolean CheckConnection(String email, String password)
    {
        return false;
    }
    
    public int CheckDroit(String email, String password)
    {
        return 0;
    }
    
}


   


