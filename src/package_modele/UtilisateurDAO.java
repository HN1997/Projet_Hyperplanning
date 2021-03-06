package package_modele;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ShadowZeus
 */
public class UtilisateurDAO extends DAO<Utilisateur> {
    
    /**
     *
     * @param conn
     */
    public UtilisateurDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void create(Utilisateur obj) {
    }

    @Override
    public void delete(Utilisateur obj) {}

    @Override
    public void update(Utilisateur obj) {}

    @Override
    public Utilisateur find(String Email, String Passwd) {
        Utilisateur cours = new Utilisateur();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE Email='" + Email + "' and Passwd='" + Passwd + "'");
            if (result.first()) {
                cours = new Utilisateur(
                        result.getInt("ID_Utilisateur"),
                        result.getString("Nom"),result.getString("Prenom"),result.getString("Email"),result.getString("Passwd"),result.getInt("Droit"));
            }
        } catch (SQLException e) {
        }
        return cours;
    }

    @Override
    public Utilisateur find(int id) {
        Utilisateur cours = new Utilisateur();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE ID_Utilisateur= "+id);
            if (result.first()) {
                cours = new Utilisateur(
                        result.getInt("ID_Utilisateur"),
                        result.getString("Nom"),result.getString("Prenom"),result.getString("Email"),result.getString("Passwd"),result.getInt("Droit"));
            }
        } catch (SQLException e) {
        }
        return cours;
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
        ArrayList<String> Array = new ArrayList<>();
        Utilisateur cours = new Utilisateur();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE Nom='" + Nom + "' and Prenom='" + Prenom + "'");
            if (result.first()) {
                Array.add(result.getString("Email"));
                Array.add(result.getString("Passwd"));
            }
        } catch (SQLException e) {
        }
        return Array;
    }

    @Override
    public int ID(String nom) {
        int i = 0;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `utilisateur` WHERE `Nom`= " +"'" + nom+ "'");
            if (result.first()) {
//                System.out.print(result.getInt("ID_Promotion"));
                i=result.getInt("ID_Utilisateur");
            }
        } catch (SQLException e) {
        }
        return i;
    }

    @Override
    public ArrayList<String> ListInfo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int GetUniqID(int id, String Nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur find(int id, int id2, int id3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur find(int id, int id2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> FindAllSeance(int id, int id2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance GetSeanceInfo(int id, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
