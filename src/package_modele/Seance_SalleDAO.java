package package_modele;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public boolean create(Seance_Salle obj) {
        return false;
    }

    @Override
    public boolean delete(Seance_Salle obj) {
        return false;
    }

    @Override
    public boolean update(Seance_Salle obj) {
        return false;
    }

    @Override
    public Seance_Salle find(int id) {
        Seance_Salle cours = new Seance_Salle();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `seance_salles` WHERE `ID_Salle`=" + id );
            if (result.first()) {
                cours = new Seance_Salle(
                        id,
                        result.getInt("ID_Seance"));
            }
        } catch (SQLException e) {
        }
        return cours;
    }

    @Override
    public Seance_Salle find(String Email, String Passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
