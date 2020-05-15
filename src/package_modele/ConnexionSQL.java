/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_modele;
import java.sql.*;
import java.lang.*;

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

     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public ConnexionSQL() throws SQLException, ClassNotFoundException{
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

       
       // String urlDatabase = "jdbc:mysql://localhost:3308/jps?characterEncoding=latin1";

        //création d'une connexion JDBC à la base 
        conn = DriverManager.getConnection("jdbc:mysql://localhost/planning", "root", "");

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
        rset = stmt.executeQuery("SELECT * FROM utilisateur");
        rsetMeta = rset.getMetaData();
        
        for (int i = 1; i <= rsetMeta.getColumnCount(); i++) {
                    System.out.print(rsetMeta.getColumnName(i) + " | ");
                }

                System.out.println("\n"); 

                while (rset.next()) {
                    
                    for (int i = 1; i <= rsetMeta.getColumnCount(); i++) {
                        System.out.print(rset.getObject(i).toString() + " | ");
                    }
                    
                    System.out.println();
                    
                }
                
            }
    }


   


