package package_modele;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        Utilisateur cours = new Utilisateur();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM `utilisateur` WHERE `ID_Utilisateur`= " + id);
            if (result.first()) {
                cours = new Utilisateur(
                        id,
                        result.getString("Nom"),result.getString("Prenom"),result.getString("Email"),result.getString("Passwd"),result.getInt("Droit"));
            }
        } catch (SQLException e) {
        }
        return cours;
    }

    
}
