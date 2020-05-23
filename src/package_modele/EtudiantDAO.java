package package_modele;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EtudiantDAO extends DAO<Etudiant> {

    public EtudiantDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Etudiant obj) {
        return false;
    }

    @Override
    public boolean delete(Etudiant obj) {
        return false;
    }

    @Override
    public boolean update(Etudiant obj) {
        return false;
    }
   
    @Override
    public Etudiant find(int id) {
        Etudiant cours = new Etudiant();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM etudiant WHERE ID_Utilisateur= "+id);
            if (result.first()) {
                cours = new Etudiant(
                        id,
                        result.getInt("ID_Promotion"),result.getInt("Numero"),result.getInt("ID_Groupe"));
            }
        } catch (SQLException e) {
        }
        return cours;
    }

    @Override
    public Etudiant find(String Email, String Passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
  