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
    public void create(Groupe obj) {
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM groupe WHERE ID_Groupe= " + id);
            if (result.first()) {
                cours = new Groupe(
                        id,
                        result.getString("Nom"), result.getInt("ID_Promotion"));
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `groupe` WHERE `ID_Promotion`=" + id);
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM groupe WHERE Nom='" + Nom + "' and ID_Promotion='" + id + "'");
            while (result.next()) {
//                System.out.println(result.getInt("ID_Seance"));
                i = result.getInt("ID_Groupe");
            }
        } catch (SQLException e) {
        }
        return i;
    }

}
