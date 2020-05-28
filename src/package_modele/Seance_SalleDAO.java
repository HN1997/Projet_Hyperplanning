package package_modele;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ShadowZeus
 */
public class Seance_SalleDAO extends DAO<Seance_Salle> {
    
    /**
     *
     * @param conn
     */
    public Seance_SalleDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Seance_Salle obj) {
        return false;
    }

    @Override
    public boolean delete(Seance_Salle obj) {
        return false;
    }

    @Override
    public boolean update(Seance_Salle obj) {
        return false;
    }

    @Override
    public ArrayList<Integer> ComposerFindSeance(int id) {
        ArrayList<Integer> Array = new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `seance_salles` WHERE `ID_Salle`=" + id );
            while (result.next()) {
                Array.add(result.getInt("ID_Seance"));
            }
        } catch (SQLException e) {
        }
        return Array;
    }
    
    @Override
    public Seance_Salle find(String Email, String Passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    public Seance_Salle find(int id) {
        Seance_Salle cours = new Seance_Salle();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance_salles WHERE ID_Seance= "+id);
            if (result.first()) {
                cours = new Seance_Salle(
                        id,
                        result.getInt("ID_Salle"));
            }
        } catch (SQLException e) {
        }
        return cours;
    }

    @Override
    public ArrayList<Integer> ComposerFindEnseignant(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> ComposerFindGroupe(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> FindEtudiant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> FindEnseignant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> FindPromotion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> FindSite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> FindEmailPasswd(String Nom, String Prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
