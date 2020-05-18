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
  public Utilisateur find(int id) {
    Utilisateur utilisateur = new Utilisateur();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE ID_Utilisateur = " + id);
      if(result.first())
        utilisateur = new Utilisateur(
          id,
          result.getString("Email"),
          result.getString("Passwd"),
          result.getString("Nom"),
          result.getString("Prenom"),
          result.getInt("Droit"
        ));         
    } catch (SQLException e) {
    }
    return utilisateur;
  }
}

