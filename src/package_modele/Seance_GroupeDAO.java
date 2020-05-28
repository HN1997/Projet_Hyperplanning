package package_modele;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public ArrayList<Integer> ComposerFindSeance(int id) {
        ArrayList<Integer> Array = new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `seance_groupes` WHERE `ID_Groupe`=" + id );
            while (result.next()) {
                Array.add(result.getInt("ID_Seance"));
            }
        } catch (SQLException e) {
        }
        return Array;
    }
    
        @Override
    public ArrayList<Integer> ComposerFindGroupe(int id) {
        ArrayList<Integer> Array = new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `seance_groupes` WHERE `ID_Seance`=" + id );
            while (result.next()) {
                Array.add(result.getInt("ID_Groupe"));
            }
        } catch (SQLException e) {
        }
        return Array;
    }


    @Override
    public Seance_Groupe find(String Email, String Passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance_Groupe find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> ComposerFindEnseignant(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> FindEtudiant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
