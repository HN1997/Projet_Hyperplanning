package package_modele;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ShadowZeus
 */
public class Seance_EnseignantDAO extends DAO<Seance_Enseignant> {
    
    /**
     *
     * @param conn
     */
    public Seance_EnseignantDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Seance_Enseignant obj) {
        return false;
    }

    @Override
    public boolean delete(Seance_Enseignant obj) {
        return false;
    }

    @Override
    public boolean update(Seance_Enseignant obj) {
        return false;
    }

    @Override
    public Seance_Enseignant find(int id) {
        Seance_Enseignant cours = new Seance_Enseignant();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `seance_enseignants` WHERE `ID_Utilisateur`=" + id );
            if (result.first()) {
                cours = new Seance_Enseignant(
                        result.getInt("ID_Utilisateur"),
                        result.getInt("ID_Seance"),result.getInt("ID_Cours"));
            }
        } catch (SQLException e) {
        }
        return cours;
    }

    @Override
    public Seance_Enseignant find(String Email, String Passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
