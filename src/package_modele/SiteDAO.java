package package_modele;
import java.sql.*;

public class SiteDAO extends DAO<Site>{

    public SiteDAO(Connection conn) {
        super(conn);
    }
    

    @Override
    public boolean create(Site obj) {
        return false;
    }

    @Override
    public boolean delete(Site obj) {
        return false;
    }

    @Override
    public boolean update(Site obj) {
        return false;
    }

    @Override
    public Site find(int id) {
        Site site = new Site();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM site WHERE ID_Type= " + id);
            if (result.first()) {
                site = new Site(
                        id,
                        result.getString("Nom"
                        ));
            }
        } catch (SQLException e) {
        }
        return site;
    }
    
}
