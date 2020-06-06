package package_modele;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeanceDAO extends DAO<Seance> {
    
    public SeanceDAO(Connection conn) {
        super(conn);
    }

    @Override
    public void create(Seance obj) {
       PreparedStatement st = null;
       try {
           st = connect.prepareStatement("INSERT INTO `seance`(`ID_Seance`, `Semaine`, `Date`, `Heure_Debut`, `Heure_Fin`, `Status`, `R`, `V`, `B`, `ID_Cours`, `ID_Type`) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
           st.setString(1,null);
           st.setInt(2, obj.getSemaine());
           st.setString(3, obj.getdate1());
           st.setString(4, obj.getHeure_Debut1());
           st.setString(5, obj.getHeure_Fin1());
           st.setString(6, obj.getStatus());
           st.setInt(7, obj.getR());
           st.setInt(8, obj.getV());
           st.setInt(9, obj.getB());
           st.setInt(10, obj.getId_cours());
           st.setInt(11, obj.getId_type());
           
           st.execute();
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
    }

    @Override
    public void delete(Seance obj) {
           PreparedStatement st = null;
       try {
           st = connect.prepareStatement("DELETE FROM `seance` WHERE `ID_Seance`=?");
           st.setInt(1,obj.getId());
           
           st.execute();
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }    
    }

    @Override
    public void update(Seance obj) {
           PreparedStatement st = null;
       try {
           st = connect.prepareStatement("UPDATE `seance` SET `Semaine`=?,`Date`=?,`Heure_Debut`=?,`Heure_Fin`=?,`Status`=?,`R`=?,`V`=?,`B`=?,`ID_Cours`=?,`ID_Type`=? WHERE `ID_Seance`=?");
           st.setString(1,null);
           st.setInt(2, obj.getSemaine());
           st.setString(3, obj.getdate1());
           st.setString(4, obj.getHeure_Debut1());
           st.setString(5, obj.getHeure_Fin1());
           st.setString(6, obj.getStatus());
           st.setInt(7, obj.getR());
           st.setInt(8, obj.getV());
           st.setInt(9, obj.getB());
           st.setInt(10, obj.getId_cours());
           st.setInt(11, obj.getId_type());
           
           st.execute();
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
    }

    @Override
    public Seance find(int id) {
        Seance cours = new Seance();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `seance` WHERE `ID_Seance`= "+id);
            if (result.first()) {
                cours = new Seance(
                        result.getInt("Semaine"),
                        result.getInt("ID_Seance"),result.getDate("Date"),result.getTime("Heure_Debut"),result.getTime("Heure_Fin"),result.getString("Status"),result.getInt("R"),result.getInt("V"),result.getInt("B"),result.getInt("ID_Cours"),result.getInt("ID_Type"));
            }
        } catch (SQLException e) {
        }
        return cours;
    }

    @Override
    public Seance find(String Email, String Passwd) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int GetUniqID(int id, String Nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance find(int id, int id2, int id3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance find(int id, int id2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> FindAllSeance(int id, int id2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance GetSeanceInfo(int id, String Nom) {
        Seance cours = new Seance();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE ID_Seance='" + id + "' and Date='" + Nom + "'");
            if (result.first()) {
                cours = new Seance(
                        result.getInt("Semaine"),
                        result.getInt("ID_Seance"),result.getDate("Date"),result.getTime("Heure_Debut"),result.getTime("Heure_Fin"),result.getString("Status"),result.getInt("R"),result.getInt("V"),result.getInt("B"),result.getInt("ID_Cours"),result.getInt("ID_Type"));
            }
        } catch (SQLException e) {
        }
        return cours;
    }
    
}
