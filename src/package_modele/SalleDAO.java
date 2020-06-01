package package_modele;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalleDAO extends DAO<Salle> {
    
    public SalleDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void create(Salle obj) {
    }

    @Override
    public boolean delete(Salle obj) {
        return false;
    }

    @Override
    public boolean update(Salle obj) {
        return false;
    }

    @Override
    public Salle find(int id) {
        Salle cours = new Salle();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM salle WHERE ID_Salle= " + id);
            if (result.first()) {
                cours = new Salle(
                        id,
                        result.getString("Nom"),result.getInt("Capacite"),result.getInt("ID_Site"));
            }
        } catch (SQLException e) {
        }
        return cours;
    }

    @Override
    public Salle find(String Email, String Passwd) {
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
        ArrayList<String> Array = new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `salle` WHERE `ID_Site`=" + id );
            while (result.next()) {
//                System.out.println(result.getInt("ID_Seance"));
                Array.add(result.getString("Nom"));
            }
        } catch (SQLException e) {
        }
        return Array;
    }

    @Override
    public int GetUniqID(int id, String Nom) {
        int i = 0;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM salle WHERE Nom='" + Nom + "' and ID_Site='" + id + "'");
            while (result.next()) {
//                System.out.println(result.getInt("ID_Seance"));
                i = result.getInt("ID_Salle");
            }
        } catch (SQLException e) {
        }
        return i;
    }
}
