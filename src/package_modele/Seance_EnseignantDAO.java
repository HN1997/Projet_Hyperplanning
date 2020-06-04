package package_modele;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public void create(Seance_Enseignant obj) {
       PreparedStatement st ;
       try {
           st = connect.prepareStatement("INSERT INTO `seance_enseignants`(`ID_Seance`, `ID_Utilisateur`, `ID_Cours`) VALUES (?,?,?)");
           st.setInt(1, obj.getId_seance());
           st.setInt(2, obj.getId_enseignant());
           st.setInt(3, obj.getId_cours());
           st.executeUpdate();
       } catch (SQLException e) {
       }
    }

    @Override
    public void delete(Seance_Enseignant obj) {}

    @Override
    public void update(Seance_Enseignant obj) {
       PreparedStatement st ;
       try {
           st = connect.prepareStatement("UPDATE `seance_enseignants` SET `ID_Utilisateur`=?,`ID_Cours`=? WHERE `ID_Seance`=?");
           st.setInt(1, obj.getId_seance());
           st.setInt(2, obj.getId_enseignant());
           st.setInt(3, obj.getId_cours());
           st.executeUpdate();
       } catch (SQLException e) {
       }
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

    @Override
    public int ID(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> ListInfo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int GetUniqID(int id, String Nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
