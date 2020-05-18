package package_modele;
import java.sql.*;


public class CoursDAO extends DAO<Cours> {
    
    public CoursDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Cours obj) {
        return false;
    }

    @Override
    public boolean delete(Cours obj) {
        return false;
    }

    @Override
    public boolean update(Cours obj) {
        return false;
    }

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
    
}
