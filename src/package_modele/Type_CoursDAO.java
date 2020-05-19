package package_modele;
import java.sql.*;

public class Type_CoursDAO extends DAO<Type_Cours> {
    
    public Type_CoursDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Type_Cours obj) {
        return false;
    }

    @Override
    public boolean delete(Type_Cours obj) {
        return false;
    }

    @Override
    public boolean update(Type_Cours obj) {
        return false;
    }

    @Override
    public Type_Cours find(int id) {
        Type_Cours type_cours = new Type_Cours();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM type_cours WHERE ID_Type= " + id);
            if (result.first()) {
                type_cours = new Type_Cours(
                        id,
                        result.getString("Nom"
                        ));
            }
        } catch (SQLException e) {
        }
        return type_cours;
    }
    
}
