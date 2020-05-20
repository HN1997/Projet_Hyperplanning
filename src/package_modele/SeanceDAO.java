/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ShadowZeus
 */
public class SeanceDAO extends DAO<Seance> {
        
    public SeanceDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Seance obj) {
        return false;
    }

    @Override
    public boolean delete(Seance obj) {
        return false;
    }

    @Override
    public boolean update(Seance obj) {
        return false;
    }

    @Override
    public Seance find(int id) {
        Seance seance = new Seance();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery(
                    "SELECT * FROM seance "
                    + "LEFT JOIN type_cours ON ID_Type = seance.ID_Type "
                    + "AND ID_Type = " + id
            );
            if (result.first()) {
                seance = new Seance(id, result.getInt("Semaine"), result.getInt("Date"), result.getInt("Heure_Debut"), result.getInt("Heure_Fin"), result.getString("Status"), result.getInt("R"), result.getInt("V"), result.getInt("B"));
                result.beforeFirst();
                Type_CoursDAO matDao = new Type_CoursDAO(this.connect);

                while (result.next()) {
                    seance.addType_Cours(matDao.find(result.getInt("ID_Type")));
                }
            }
        } catch (SQLException e) {
        }
        return seance;
    }

    @Override
    public Seance find(String Email, String Password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
