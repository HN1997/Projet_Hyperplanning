package package_modele;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeanceDAO extends DAO<Seance> {
    
    public SeanceDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Seance obj) {
        return false;
    }

    @Override
    public boolean delete(Seance obj) {
        return false;
    }

    @Override
    public boolean update(Seance obj) {
        return false;
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
    
}
