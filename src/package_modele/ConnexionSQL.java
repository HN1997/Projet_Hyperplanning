package package_modele;
import java.sql.*;
import java.lang.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConnexionSQL 
{
    private Connection conn = null; //gerer la connection a la bdd
    private PreparedStatement pst = null; //executer les requetes (=query)
    private ResultSet rs = null;

    

    //Constructeur qui nous connecte a la BDD
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
    
    public static Connection getInstance() throws SQLException {
        if (connc == null) {
            connc = DriverManager.getConnection("jdbc:mysql://localhost/planning", "root", "");
        }
        return connc;
    }
    
    //Lance une requete savoir si email et mot de passe se trouve bien dans notre bdd, renvoie vrai si c'est le cas
    public boolean CheckConnection(String email, String password)
    {
        //SELECT * FROM `utilisateur` WHERE Email="anand_maisuria@yahoo.fr" AND Passwd="159"
        String sql = "SELECT * FROM utilisateur WHERE Email='" + email + "' and Passwd='" + password + "'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs.next(); // renverra true si il y a un resultat, false sinon
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; //Ici le try n'a pas fonctionne, on renvoie false par defaut
    }
    
    public int CheckDroit(String email, String password)
    {
        String sql = "SELECT * FROM utilisateur WHERE Email='" + email + "' and Passwd='" + password + "'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()) // veut dire, s'il y a un resultat (on a trouve une ligne)
            {
                int droit = rs.getInt("Droit"); //On recupere ce qu'il y a dans la colonne droit, ATTENTION si Droit mal ecrit cela renverra une erreur dans la console

                if(droit >= 1 && droit <= 4) //On verifie que le droit est bien 1 2 3 ou 4
                    return droit;
                else //Sinon il y a une erreur, on revoie 0
                    return 0;
            }
            else //Si pas de resultat on est pas co
            {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0; // le try n'a pas fonctionne
    }
    
   ////////////////////////////////////////////////////////////// PARTIE EDT ////////////////////////////////////////////////
    
    
    public int CheckPromotion(String email, String password)
    {
        int droit = CheckDroit(email, password);
        
        if(droit == 4) //Si c'est un etudiant, on peut regarder sa promotion
        {
            String sql = "SELECT * FROM utilisateur WHERE Email='" + email + "' and Passwd='" + password + "'";
            try 
            {
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                rs.next(); // se place a la premiere ligne

            } catch (SQLException ex) 
            {
                Logger.getLogger(ConnexionSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return droit;
    }
}


   


