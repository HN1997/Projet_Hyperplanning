
package package_controleur;
import java.sql.SQLException;
import package_modele.*;
import java.util.Calendar;


public class Rechercheinformations {
    


    // Début des variables
    ConnexionSQL connSQL;
    // Fin des variables
    
    
     //Constructeur
    public Rechercheinformations() 
    {
        this.connSQL = new ConnexionSQL();
    }
    
    
    //Fonction pour se connecter, renvoie un tableau de 2 case, indice 0 = true si la connexion a ete etablie, indice 1 = un int pour le type de droit (de 1 a 4, 0 par defaut)
    public Object[] GetDroit(String email, String password)
    {
        Object[] result = {false,0};
        
        if(this.connSQL != null) //Si la connecion a la BDD a bien ete initialise
        {
            result[0] = connSQL.CheckConnection(email, password); //Regarde si on s'est bien connecté (email/password OK)
            if((boolean)result[0])
            {
                result[1] = connSQL.CheckDroit(email, password); //On recuperer le droit de l'utilisateur
            }
        }
        
        return (Object[]) result[1];
    }
    
    
    //Cette méthode renvoie la semaine actuelle à laquelle on est
    public int GetSemaine(){
            return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        }
    
    
    public String GetPrenomNom(String Email, String Passwd) throws SQLException
    {
        
        DAO<Utilisateur> Utilisateurd= new UtilisateurDAO(ConnexionSQL.getInstance()); 
        Utilisateur user= Utilisateurd.find(Email,Passwd);
        
        return("user.getNom()" + "user.getPrenom()");
        
    }
    
    public String GetPromotion(String Email, String Passwd) throws SQLException
    {
    
        DAO<Promotion> Promotiond= new PromotionDAO(ConnexionSQL.getInstance()); 
        Promotion user= Promotiond.find(Email,Passwd);
        
        return("user.getNom()");//la promo s'appelle "nom" dans PromotionDAO
        
    }
}


//dans le constructeur, methode que cree anand pr que qd je lui envooi id et mdp je puis recup id 