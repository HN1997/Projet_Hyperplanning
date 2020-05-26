package package_modele;
import java.sql.*;
import java.util.ArrayList;

public class EnseignantDAO extends DAO<Enseignant> {

    public EnseignantDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Enseignant obj) {
        return false;
    }

    @Override
    public boolean delete(Enseignant obj) {
        return false;
    }

    @Override
    public boolean update(Enseignant obj) {
        return false;
    }
    
    @Override
    public Enseignant find(int id) {
        Enseignant cours = new Enseignant();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM enseignant WHERE ID_Utilisateur= "+id);
            if (result.first()) {
                cours = new Enseignant(
                        id,
                        result.getInt("ID_Cours"));
            }
        } catch (SQLException e) {
        }
        return cours;
    }

    @Override
    public Enseignant find(String Email, String Passwd) {
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
}
  
