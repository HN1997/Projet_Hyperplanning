package package_controleur;

import static java.lang.Thread.sleep;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import package_modele.ConnexionSQL;
import package_modele.DAO;
import package_modele.Utilisateur;
import package_modele.UtilisateurDAO;

public class RechercheInformationsHugo 
{
    // Début des variables
    ConnexionSQL connSQL;
    // Fin des variables
    
    ////////////////////////////////////////////////// CONSTRUCTEUR ///////////////////////////////////////
    public RechercheInformationsHugo() 
    {
        this.connSQL = new ConnexionSQL();
    }
    
    ////////////////////////////////////////////////// PARTIE LIEE AU TEMPS ///////////////////////////////////////
    
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
    
    //Cette méthode renvoie la semaine actuelle à laquelle on est
    public static int GetSemaine()
    {
        return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
    }
    
    public static int[] getSemaineNumbers(int numeroSemaine) //En fonction du numero de semaine, renvoie le numero du lundi mardi mercredi jeudi vendredi
    {
        int[] semNumb = new int[5];
        Calendar calendar = Calendar.getInstance();
        
        
        int annee = Calendar.getInstance().get(Calendar.YEAR); //L'année actuelle a laquelle on est
        
        semNumb[0] = annee;
        semNumb[1] = annee;
        semNumb[2] = annee;
        semNumb[3] = annee;
        semNumb[4] = annee;
        
        return semNumb;
    }
    
    public String[] getMoisString(int numeroSemaine) //en fonction du numero de semaine, envoie le mois associé au lundi mardi mercredi jeudi vendredi
    {
        String[] mois = new String[5];
        
        return mois;
    }
    
    ////////////////////////////////////////////////// PARTIE LIEE A L USER ///////////////////////////////////////
    
    //Fonction pour récupérer le nom et prenom de l'utilisateur
    public String GetPrenomNom(String Email, String Passwd) 
    {
        try {
            DAO<Utilisateur> Utilisateurd ;
            Utilisateurd = new UtilisateurDAO(ConnexionSQL.getInstance());
            Utilisateur user = Utilisateurd.find(Email,Passwd);
            return (user.getPrenom()+" "+user.getNom());
        } catch (SQLException ex) {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
    
    public String GetDroit(String Email, String Passwd) 
    {
        String droit = "";
        int droitint = connSQL.CheckDroit(Email, Passwd);
        switch(droitint)
        {
            case 1:
                droit = "Administrateur";
                break;
            case 2:
                droit = "Référent Pédagogique";
                break;
            case 3:
                droit = "Enseignant";
                break;
            case 4:
                droit = "Etudiant";
                break;
        }
        return droit;
    }
    
    //A CHANGER
    public String getPromotion(String email, String pass)
    {
        return connSQL.CheckPromotion(email, pass);
    }
    
    //A CHANGER
    public String getTD(String email, String pass)
    {
        return connSQL.CheckTD(email, pass);
    }
    
}
