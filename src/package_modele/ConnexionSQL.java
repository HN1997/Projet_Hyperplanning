/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_modele;
import java.sql.*;
import java.lang.*;
import java.util.*;

/**
 *
 * @author ShadowZeus
 */


public class ConnexionSQL {

    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    private final Connection conn;
    private final Statement stmt;
    private final ResultSet rset;
    private final ResultSetMetaData rsetMeta;

    

    /**
     * Constructeur avec 3 paramètres : nom, login et password de la BDD locale
     *
     * @param email
     * @param Password
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public ConnexionSQL(String email, String Password) throws SQLException, ClassNotFoundException{
        // chargement driver "com.mysql.jdbc.Driver"
        ArrayList Array = new ArrayList();
        Class.forName("com.mysql.jdbc.Driver");

       
       // String urlDatabase = "jdbc:mysql://localhost:3308/jps?characterEncoding=latin1";

        //création d'une connexion JDBC à la base 
        conn = DriverManager.getConnection("jdbc:mysql://localhost/planning", "root", "");

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
        rset = stmt.executeQuery("SELECT Droit FROM utilisateur WHERE Passwd='Password' AND Email='email'");
        rsetMeta = rset.getMetaData();
        
        if (rset.next()) {
            Array.add(rset);
            Array.add(true);
            
        }
        else {
            Array.add(null);
            Array.add(false);
        }
            }
    }


   


