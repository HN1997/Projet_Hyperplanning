/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_controleur;

import java.sql.SQLException;

/**
 *
 * @author ShadowZeus
 */
public class MainTest {

    public static void main(String[] args) throws SQLException {
       System.out.println(Rechercheinformations.GetPrenomNom("anand_maisuria@yahoo.fr", "159"));
    }

}