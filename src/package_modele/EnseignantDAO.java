package package_modele;
import java.sql.*;
import java.util.ArrayList;

public class EnseignantDAO extends DAO<Enseignant> {

    public EnseignantDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void create(Enseignant obj) {
    }

    @Override
    public void delete(Enseignant obj) {}

    @Override
    public void update(Enseignant obj) {}

////////////////////////////////////////////////// METHODE PERMETTANT DE RECHERCHER UN ENSEIGANT EN FONCTION DE SON ID DANS LA TABLE ENSEIGNANT ///////////////////////////////////////
    
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

    @Override
    public ArrayList<Integer> FindEtudiant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
////////////////////////////////////////////////// METHODE PERMETTANT DE RECHERCHER TOUS ENSEIGNANT DANS LA TABLE ENSEIGNANT /////////////////////////////////////
    
    @Override
    public ArrayList<Integer> FindEnseignant() {
        ArrayList<Integer> Array = new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `enseignant`");
            while (result.next()) {
//                System.out.println(result.getInt("ID_Seance"));
                Array.add(result.getInt("ID_Utilisateur"));
            }
        } catch (SQLException e) {
        }
        return Array;
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
  
