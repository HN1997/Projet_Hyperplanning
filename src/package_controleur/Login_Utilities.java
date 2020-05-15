package package_controleur;
import package_modele.ConnexionSQL;

//Classe permettant de donner a la fenetre login les informations de la bdd
public class Login_Utilities 
{
    // Debut des variables
    private final ConnexionSQL connSQL;
    // Fin des variables

    //Constructeur
    public Login_Utilities() 
    {
        this.connSQL = new ConnexionSQL();
    }
    
    //Fonction pour se connecter, renvoie un tableau de 2 case, indice 0 = true si la connexion a ete etablie, indice 1 = un int pour le type de droit (de 1 a 4, 0 par defaut)
    public Object[] Connexion(String email, String password)
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
        
        return result;
    }
}
