package package_modele;
import java.sql.*;

public class EnseignantDAO extends DAO<Enseignant> {
      
    public EnseignantDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Enseignant obj) {
        return false;
    }

    @Override
    public boolean delete(Enseignant obj) {
        return false;
    }

    @Override
    public boolean update(Enseignant obj) {
        return false;
    }
   
    @Override
  public Enseignant find(int id) {
    Enseignant enseignant = new Enseignant();            
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery(
        "SELECT * FROM enseignant "+
        "LEFT JOIN utilisateur ON ID_Utilisateur = enseignant.ID_Utilisateur " + 
        "AND ID_Utilisateur = "+ id 
      );
      if(result.first()){
        enseignant = new Enseignant(id, result.getString("ID_Cours"));
        result.beforeFirst();
        UtilisateurDAO matDao = new UtilisateurDAO(this.connect);
            
        while(result.next())
          enseignant.addUtilisateur(matDao.find(result.getInt("ID_Utilisateur")));
      }
    } catch (SQLException e) {
    }
    return enseignant;
  }

    @Override
    public Enseignant find(String Email, String Password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
