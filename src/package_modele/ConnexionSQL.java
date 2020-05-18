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
    ArrayList<Object> Utilisateurs;
    ArrayList<Object> Type_Cours;
    ArrayList<Object> Sites;
    ArrayList<Object> Sceance_Salles;
    ArrayList<Object> Sceance_Groupes;
    ArrayList<Object> Sceance_Enseignant;
    ArrayList<Object> Sceance;
    ArrayList<Object> Salle;
    ArrayList<Object> Promotion;
    ArrayList<Object> Groupe;
    ArrayList<Object> Enseignant;
    ArrayList<Object> Cours;
    

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
    
    public ArrayList<Object> Utilisateur (String email, String password)
    {
        String sql = "SELECT * FROM utilisateur WHERE Email='email' AND Passwd='password' ";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Utilisateurs.add(rs.next()); // renverra true si il y a un resultat, false sinon
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Utilisateurs;
    }
    
    public ArrayList<Object> Type_Cours ()
    {
        String sql = "SELECT * FROM type_cours ";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Type_Cours.add(rs.next()); // renverra true si il y a un resultat, false sinon
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Type_Cours;
    }
    
    public ArrayList<Object> Site ()
    {
        String sql = "SELECT * FROM site ";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Sites.add(rs.next()); // renverra true si il y a un resultat, false sinon
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Sites;
    }
    
    public ArrayList<Object> Salle ()
    {
        String sql = "SELECT * FROM salle ";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Salle.add(rs.next()); // renverra true si il y a un resultat, false sinon
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Salle;
    }
    
    public ArrayList<Object> Seance_Salle ()
    {
        String sql = "SELECT * FROM sceance_salles ";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Sceance_Salles.add(rs.next()); // renverra true si il y a un resultat, false sinon
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Sceance_Salles;
    }
    
    
}


   


