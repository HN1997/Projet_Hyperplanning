package package_modele;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ShadowZeus
 */
public class GroupeDAO extends DAO<Groupe> {

    public GroupeDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Groupe obj) {
        return false;
    }

    @Override
    public boolean delete(Groupe obj) {
        return false;
    }

    @Override
    public boolean update(Groupe obj) {
        return false;
    }
   
    @Override
    public Groupe find(int id) {
        Groupe cours = new Groupe();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM groupe WHERE ID_Groupe= "+id);
            if (result.first()) {
                cours = new Groupe(
                        id,
                        result.getString("Nom"),result.getInt("ID_Promotion"));
            }
        } catch (SQLException e) {
        }
        return cours;
    }

    @Override
    public Groupe find(String Email, String Passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> ComposerFindSeance(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    
}
  
