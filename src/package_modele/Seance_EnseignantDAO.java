package package_modele;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public ArrayList<Integer> ComposerFindSeance(int id) {
        ArrayList<Integer> Array = new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `seance_enseignants` WHERE `ID_Utilisateur`=" + id );
            while (result.next()) {
//                System.out.println(result.getInt("ID_Seance"));
                Array.add(result.getInt("ID_Seance"));
            }
        } catch (SQLException e) {
        }
        return Array;
    }
    
    @Override
    public ArrayList<Integer> ComposerFindEnseignant(int id) {
        ArrayList<Integer> Array = new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `seance_enseignants` WHERE `ID_Seance`=" + id );
            while (result.next()) {
//                System.out.println(result.getInt("ID_Utilisateur"));
                Array.add(result.getInt("ID_Utilisateur"));
            }
        } catch (SQLException e) {
        }
        return Array;
    }

    @Override
    public Seance_Enseignant find(String Email, String Passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance_Enseignant find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> ComposerFindGroupe(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
