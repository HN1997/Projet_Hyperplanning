/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_modele;
import java.sql.*;
import java.lang.*;
import java.util.*;


public class ConnexionSQL 
{
    private final Connection conn;
    private final Statement stmt;
    private final ResultSet rset;
    

    //Constructeur qui nous connecte a la BDD
    public ConnexionSQL() throws SQLException, ClassNotFoundException
    {
        
        Class.forName("com.mysql.jdbc.Driver");

       
       // String urlDatabase = "jdbc:mysql://localhost:3308/jps?characterEncoding=latin1";

        //création d'une connexion JDBC à la base 
        conn = DriverManager.getConnection("jdbc:mysql://localhost/planning", "root", "");

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
        rset = stmt.executeQuery("SELECT Droit FROM utilisateur WHERE Passwd='Password' AND Email='email'");
        
        
    }
}


   


