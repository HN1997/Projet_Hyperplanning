package package_modele;
import java.sql.*;


public class PromotionDAO extends DAO<Promotion> {
      
    public PromotionDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Promotion obj) {
    return false;
  }

  @Override
  public boolean delete(Promotion obj) {
    return false;
  }
   
  @Override
  public boolean update(Promotion obj) {
    return false;
  }
   
    @Override
  public Promotion find(int id) {
    Promotion promotion = new Promotion();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM promotion WHERE ID_Promotion = " + id);
      if(result.first())
        promotion = new Promotion(
          id,
          result.getString("Nom"
        ));         
    } catch (SQLException e) {
    }
    return promotion;
  }

    @Override
    public Promotion find(String Email, String Password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
