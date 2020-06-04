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
public class Seance_GroupeDAO extends DAO<Seance_Groupe> {
    
    /**
     *
     * @param conn
     */
    public Seance_GroupeDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void create(Seance_Groupe obj) {
       PreparedStatement st;
       try {
           st = connect.prepareStatement("INSERT INTO `seance_groupes`(`ID_Groupe`, `ID_Seance`) VALUES (?,?)");
           st.setInt(1, obj.getId_groupe());
           st.setInt(2, obj.getId_seance());
           
           System.out.print(obj.getId_groupe()+"-"+obj.getId_seance());
           st.executeUpdate();
       } catch (SQLException e) {
       }
    }

    @Override
    public void delete(Seance_Groupe obj) {
           PreparedStatement st = null;
       try {
           st = connect.prepareStatement("DELETE FROM `seance_groupes` WHERE `ID_Seance`=?");
           st.setInt(1,obj.getId_seance());
           
           st.execute();
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }        
    }

    @Override
    public void update(Seance_Groupe obj) {
       PreparedStatement st;
       try {
           st = connect.prepareStatement("UPDATE `seance_groupes` SET `ID_Groupe`=? WHERE `ID_Seance`=?");
           st.setInt(1, obj.getId_groupe());
           st.setInt(2, obj.getId_seance());
           
           System.out.print(obj.getId_groupe()+"-"+obj.getId_seance());
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `seance_groupes` WHERE `ID_Groupe`=" + id );
            while (result.next()) {
                Array.add(result.getInt("ID_Seance"));
            }
        } catch (SQLException e) {
        }
        return Array;
    }
    
        @Override
    public ArrayList<Integer> ComposerFindGroupe(int id) {
        ArrayList<Integer> Array = new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `seance_groupes` WHERE `ID_Seance`=" + id );
            while (result.next()) {
                Array.add(result.getInt("ID_Groupe"));
            }
        } catch (SQLException e) {
        }
        return Array;
    }


    @Override
    public Seance_Groupe find(String Email, String Passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance_Groupe find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> ComposerFindEnseignant(int id) {
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
