package package_modele;
import java.sql.*;

public class GroupeDAO extends DAO<Groupe> {

    public GroupeDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Groupe obj) {
        return false;
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
        Groupe groupe = new Groupe();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery(
                    "SELECT * FROM groupe "
                    + "LEFT JOIN promotion ON ID_Promotion = groupe.ID_Promotion "
                    + "AND ID_Promotion = " + id
            );
            if (result.first()) {
                groupe = new Groupe(id, result.getString("Nom"));
                result.beforeFirst();
                PromotionDAO matDao = new PromotionDAO(this.connect);

                while (result.next()) {
                    groupe.addPromotion(matDao.find(result.getInt("ID_Promotion")));
                }
            }
        } catch (SQLException e) {
        }
        return groupe;
    }

    @Override
    public Groupe find(String Email, String Password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
