package package_modele;
import java.sql.*;
import java.util.ArrayList;

public class PromotionDAO extends DAO<Promotion> {

    public PromotionDAO(Connection conn) {
    super(conn);
    }
    
    @Override
    public boolean create(Promotion obj) {
        return false;
    }

    @Override
    public boolean delete(Promotion obj) {
        return false;
    }

    @Override
    public boolean update(Promotion obj) {
        return false;
    }
   
    @Override
    public Promotion find(int id) {
        Promotion cours = new Promotion();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM promotion WHERE ID_Promotion= "+id);
            if (result.first()) {
                cours = new Promotion(
                        id,
                        result.getString("Nom"));
            }
        } catch (SQLException e) {
        }
        return cours;
    }

    @Override
    public Promotion find(String Email, String Passwd) {
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
        ArrayList<Integer> Array = new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `promotion`");
            while (result.next()) {
//                System.out.println(result.getInt("ID_Utilisateur"));
                Array.add(result.getInt("ID_Promotion"));
            }
        } catch (SQLException e) {
        }
        return Array;
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
  
