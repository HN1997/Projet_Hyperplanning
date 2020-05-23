package package_modele;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ShadowZeus
 */
public class Seance_GroupeDAO extends DAO<Seance_Groupe> {
    
    /**
     *
     * @param conn
     */
    public Seance_GroupeDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Seance_Groupe obj) {
        return false;
    }

    @Override
    public boolean delete(Seance_Groupe obj) {
        return false;
    }

    @Override
    public boolean update(Seance_Groupe obj) {
        return false;
    }

    @Override
    public Seance_Groupe find(int id) {
        Seance_Groupe cours = new Seance_Groupe();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `seance_groupes` WHERE `ID_Groupe`=" + id );
            if (result.first()) {
                cours = new Seance_Groupe(
                        id,
                        result.getInt("ID_Seance"));
            }
        } catch (SQLException e) {
        }
        return cours;
    }

    @Override
    public Seance_Groupe find(String Email, String Passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
