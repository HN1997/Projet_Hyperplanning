package package_modele;
import java.sql.*;

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
    Etudiant etudiant = new Etudiant();            
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery(
        "SELECT * FROM etudiant "+
        "LEFT JOIN utilisateur ON ID_Utilisateur = etudiant.ID_Utilisateur " + 
        "AND ID_Utilisateur = "+ id 
      );
      if(result.first()){
        etudiant = new Etudiant(id, result.getString("Numero"), result.getString("ID_Groupe"));
        result.beforeFirst();
        UtilisateurDAO matDao = new UtilisateurDAO(this.connect);
            
        while(result.next())
          etudiant.addUtilisateur(matDao.find(result.getInt("ID_Utilisateur")));
      }
    } catch (SQLException e) {
    }
    return etudiant;
  }

    @Override
    public Etudiant find(String Email, String Password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
