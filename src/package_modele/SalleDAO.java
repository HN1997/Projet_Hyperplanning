package package_modele;
import java.sql.*;

public class SalleDAO extends DAO<Salle>{
    
        public SalleDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Salle obj) {
        return false;
    }

    @Override
    public boolean delete(Salle obj) {
        return false;
    }

    @Override
    public boolean update(Salle obj) {
        return false;
    }
   
    @Override
  public Salle find(int id) {
    Salle salle = new Salle();            
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery(
        "SELECT * FROM salle "+
        "LEFT JOIN site ON ID_Site = salle.ID_Site " + 
        "AND ID_Site = "+ id 
      );
      if(result.first()){
        salle = new Salle(id, result.getString("Nom"), result.getInt("Capacite"));
        result.beforeFirst();
        SiteDAO matDao = new SiteDAO(this.connect);
            
        while(result.next())
          salle.addSite(matDao.find(result.getInt("ID_Site")));
      }
    } catch (SQLException e) {
    }
    return salle;
  }

    @Override
    public Salle find(String Email, String Password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
