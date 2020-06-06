package package_modele;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ShadowZeus
 */
public class Seance_SalleDAO extends DAO<Seance_Salle> {
    
    /**
     *
     * @param conn
     */
    public Seance_SalleDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void create(Seance_Salle obj) {
       PreparedStatement st;
       try {
           st = connect.prepareStatement("INSERT INTO `seance_salles`(`ID_Seance`, `ID_Salle`) VALUES (?,?)");
           st.setInt(1, obj.getId_salle());
           st.setInt(2, obj.getId_seance());
           
//           System.out.print(obj.getId_salle()+"-"+obj.getId_seance());
           st.executeUpdate();
       } catch (SQLException e) {
       }
    }

    @Override
    public void delete(Seance_Salle obj) {
           PreparedStatement st = null;
       try {
           st = connect.prepareStatement("DELETE FROM `seance_salles` WHERE `ID_Seance`=?");
           st.setInt(1,obj.getId_seance());
           
           st.execute();
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }        
    }

    @Override
    public void update(Seance_Salle obj) {
       PreparedStatement st;
       try {
           st = connect.prepareStatement("UPDATE `seance_salles` SET `ID_Salle`=[value-2] WHERE `ID_Seance`=");
           st.setInt(1, obj.getId_salle());
           st.setInt(2, obj.getId_seance());
           
           System.out.print(obj.getId_salle()+"-"+obj.getId_seance());
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `seance_salles` WHERE `ID_Salle`=" + id );
            while (result.next()) {
                Array.add(result.getInt("ID_Seance"));
            }
        } catch (SQLException e) {
        }
        return Array;
    }
    
    @Override
    public Seance_Salle find(String Email, String Passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    public Seance_Salle find(int id) {
        Seance_Salle cours = new Seance_Salle();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance_salles WHERE ID_Seance= "+id);
            if (result.first()) {
                cours = new Seance_Salle(
                        id,
                        result.getInt("ID_Salle"));
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

    @Override
    public Seance_Salle find(int id, int id2, int id3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance_Salle find(int id, int id2) {
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
