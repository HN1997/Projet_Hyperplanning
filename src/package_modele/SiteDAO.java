package package_modele;
import java.sql.*;
import java.util.ArrayList;


public class SiteDAO extends DAO<Site> {
    
    public SiteDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Site obj) {
        return false;
    }

    @Override
    public boolean delete(Site obj) {
        return false;
    }

    @Override
    public boolean update(Site obj) {
        return false;
    }

    @Override
    public Site find(int id) {
        Site site = new Site();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM site WHERE ID_Site= " + id);
            if (result.first()) {
                site = new Site(
                        id,
                        result.getString("Nom"
                        ));
            }
        } catch (SQLException e) {
        }
        return site;
    }

    @Override
    public Site find(String Email, String Password) {
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
        ArrayList<Integer> Array = new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `site`");
            while (result.next()) {
//                System.out.println(result.getInt("ID_Utilisateur"));
                Array.add(result.getInt("ID_Site"));
            }
        } catch (SQLException e) {
        }
        return Array;
    }

   @Override
    public ArrayList<String> FindEmailPasswd(String Nom, String Prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
