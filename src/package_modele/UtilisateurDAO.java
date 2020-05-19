package package_modele;
import java.sql.*;

public class UtilisateurDAO extends DAO<Utilisateur> {
    
  public UtilisateurDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Utilisateur obj) {
    return false;
  }

  @Override
  public boolean delete(Utilisateur obj) {
    return false;
  }
   
  @Override
  public boolean update(Utilisateur obj) {
    return false;
  }
   
  @Override
  public Utilisateur find(String Email, String Password ) {
    Utilisateur utilisateur = new Utilisateur();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE Email='" + Email + "' and Passwd='" + Password + "'");
      if(result.first())
        utilisateur = new Utilisateur(
          Email,
          Password,      
          result.getInt("id"),
          result.getString("Nom"),
          result.getString("Prenom"),
          result.getInt("Droit"
        ));         
    } catch (SQLException e) {
    }
    return utilisateur;
  }

    @Override
    public Utilisateur find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

