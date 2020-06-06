package package_modele;
import java.sql.*;
import java.util.ArrayList;


public class CoursDAO extends DAO<Cours> {
    
    public CoursDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void create(Cours cours) {}   
 
    @Override
    public void delete(Cours obj) {}

    @Override
    public void update(Cours obj) {}
    ////////////////////////////////////////////////// METHODE DE RECHERCHE AVEC EN PARAMETRE L'ID DU COURS RECUPERE ///////////////////////////////////////
    
    @Override
    public Cours find(int id) {
        Cours cours = new Cours();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cours WHERE ID_Cours= " + id);
            if (result.first()) {
                cours = new Cours(
                        id,
                        result.getString("Nom"
                        ));
            }
        } catch (SQLException e) {
        }
        return cours;
    }

    @Override
    public Cours find(String Email, String Password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> ComposerFindSeance(int id) {
        ArrayList cours = new ArrayList();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cours WHERE ID_Cours= " + id);
            if (result.first()) {
                cours.add(result.getInt("R"));
                cours.add(result.getInt("V"));
                cours.add(result.getInt("B"));
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
        ArrayList<Integer> Array = new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `cours`");
            while (result.next()) {
//                System.out.println(result.getInt("ID_Utilisateur"));
                Array.add(result.getInt("ID_Cours"));
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

    @Override
    public int ID(String nom) {
        int i = 0;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `cours` WHERE `Nom`= " +"'" + nom+ "'");
            if (result.first()) {
//                System.out.print(result.getInt("ID_Promotion"));
                i=result.getInt("ID_Cours");
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
    public Cours find(int id, int id2, int id3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cours find(int id, int id2) {
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
