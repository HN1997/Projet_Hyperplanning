
package package_controleur;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import package_modele.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;


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
        
        return(user.getNom());
        
    }
    
    public String GetPromotion(String Email, String Passwd) throws SQLException
    {
    
        DAO<Promotion> Promotiond= new PromotionDAO(ConnexionSQL.getInstance()); 
        Promotion user= Promotiond.find(Email,Passwd);
        
        return("user.getNom()");//la promo s'appelle "nom" dans PromotionDAO
        
    }
    
    //Fonction qui permet de modifier le label date à la date actuelle, et le label heure à l'heure actuelle
    public static void Clock(JLabel date, JLabel heure) //Modifie le label date et heure en continu
    {
        Thread clock = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    for(;;)
                    {
                        Calendar cal = new GregorianCalendar();
        
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        int month = cal.get(Calendar.MONTH);
                        int year = cal.get(Calendar.YEAR);

                        int second = cal.get(Calendar.SECOND);
                        int minute = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR_OF_DAY);
                        
                        String mois = "";
                        switch(month)
                        {
                            case 0:
                                mois = "janvier";
                                break;
                            case 1:
                                mois = "février";
                                break;
                            case 2:
                                mois = "mars";
                                break;
                            case 3:
                                mois = "avril";
                                break;
                            case 4:
                                mois = "mai";
                                break;
                            case 5:
                                mois = "juin";
                                break;
                            case 6:
                                mois = "juillet";
                                break;
                            case 7:
                                mois = "août";
                                break;
                            case 8:
                                mois = "septembre";
                                break;
                            case 9:
                                mois = "octobre";
                                break;
                            case 10:
                                mois = "novembre";
                                break;
                            case 11:
                                mois = "décembre";
                                break;
                            default:
                                break;
                        }

                        date.setText(day + " " + mois + " " + year); //mois+1 car janvier = 0
                        heure.setText(hour + ":" + minute + ":" + second);
                        
                        sleep(1000);
                    }
                }catch(InterruptedException e){e.printStackTrace();}
            }
        };
        
        clock.start();
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


//dans le constructeur, methode que cree anand pr que qd je lui envooi id et mdp je puis recup id 