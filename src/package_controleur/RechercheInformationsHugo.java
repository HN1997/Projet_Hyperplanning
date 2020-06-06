package package_controleur;

import com.sun.glass.ui.Cursor;
import com.sun.glass.ui.Pixels;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.year;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import package_modele.*;
import java.lang.String;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

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
        try 
        {
            DAO<Utilisateur> Utilisateurd = new UtilisateurDAO(ConnexionSQL.getInstance());
            Utilisateur user = Utilisateurd.find(email,password);
            if(user.getDroit() != 0)
            {
                result[0] = true;
                result[1] = user.getDroit();
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    /** fonction qui prend en argument 3 string dans l'ordre : jour mois annee, retourne un int qui est le num de semaine */
    public int DateStringToNumSem(String jour, String mois, String annee)
    {
        int numSemaine = 0;
        
        int jourInt;
        int moisInt = 0;
        int anneeInt;
        
        try
        {
            jourInt = Integer.parseInt(jour);
            if(mois.equalsIgnoreCase("Janvier"))
            {
                moisInt = 0;
            }
            else if(mois.equalsIgnoreCase("Février"))
            {
                moisInt = 1;
            }
            else if(mois.equalsIgnoreCase("Mars"))
            {
                moisInt = 2;
            }
            else if(mois.equalsIgnoreCase("Avril"))
            {
                moisInt = 3;
            }
            else if(mois.equalsIgnoreCase("Mai"))
            {
                moisInt = 4;
            }
            else if(mois.equalsIgnoreCase("Juin"))
            {
                moisInt = 5;
            }
            else if(mois.equalsIgnoreCase("Juillet"))
            {
                moisInt = 6;
            }
            else if(mois.equalsIgnoreCase("Août"))
            {
                moisInt = 7;
            }
            else if(mois.equalsIgnoreCase("Septembre"))
            {
                moisInt = 8;
            }
            else if(mois.equalsIgnoreCase("Octobre"))
            {
                moisInt = 9;
            }
            else if(mois.equalsIgnoreCase("Novembre"))
            {
                moisInt = 10;
            }
            else if(mois.equalsIgnoreCase("Décembre"))
            {
                moisInt = 11;
            }
            anneeInt = Integer.parseInt(annee);
            
            java.util.Date date = new GregorianCalendar(anneeInt, moisInt, jourInt).getTime();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            numSemaine = cal.get(Calendar.WEEK_OF_YEAR);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Probleme conversion string en int : " + e.toString());
        }
        
        return numSemaine;
    }
    
    //Cette méthode renvoie la semaine actuelle à laquelle on est
    public static int GetSemaine()
    {
        return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
    }
    
    public static int[] getSemaineNumbers(int numeroSemaine) //En fonction du numero de semaine, renvoie le numero du lundi mardi mercredi jeudi vendredi
    {
        int[] semNumb = new int[5];
        Calendar cal = Calendar.getInstance( new Locale("fr","FR") ); //On instancie un calendrier francais
        cal.setFirstDayOfWeek(Calendar.MONDAY); //On dit que le premier mois d'une semaine est le lundi (aux US, le premier jour est un dimanche)
         
        int annee; //L'année actuelle a laquelle on est
        int mois = Calendar.getInstance().get(Calendar.MONTH); //Le mois actuelle, commence a 0 pour janvier
        
        if(mois < 6) //Si on est dans la période début d'année (avant juillet)
        {
            if(numeroSemaine>=31 && numeroSemaine<=52)
            {
                annee = Calendar.getInstance().get(Calendar.YEAR);
                annee--; //si on est en janvier 2020, cela correspond a l'annee 2019
            }
            else
            {
                annee = Calendar.getInstance().get(Calendar.YEAR);
            }
        }
        else //Si on est dans la période fin d'année
        {
            if(numeroSemaine >=1 && numeroSemaine <=30)
            {
                annee = Calendar.getInstance().get(Calendar.YEAR);
                annee++; //Si on est en decembre 2020, l'année d'apres affichera les cours de 2021
            }
            else
            {
                annee = Calendar.getInstance().get(Calendar.YEAR);
            }
        }
        
        cal.setWeekDate(annee, numeroSemaine, Calendar.MONDAY);
        semNumb[0] = cal.get(Calendar.DAY_OF_MONTH);
                
        cal.setWeekDate(annee, numeroSemaine, Calendar.TUESDAY);
        semNumb[1] = cal.get(Calendar.DAY_OF_MONTH);
                
        cal.setWeekDate(annee, numeroSemaine, Calendar.WEDNESDAY);
        semNumb[2] = cal.get(Calendar.DAY_OF_MONTH);
                
        cal.setWeekDate(annee, numeroSemaine, Calendar.THURSDAY);
        semNumb[3] = cal.get(Calendar.DAY_OF_MONTH);
                
        cal.setWeekDate(annee, numeroSemaine, Calendar.FRIDAY);
        semNumb[4] = cal.get(Calendar.DAY_OF_MONTH);
        
        return semNumb;
    }
    
    
    public String[] getMoisString(int numeroSemaine) //en fonction du numero de semaine, envoie le mois associé au lundi mardi mercredi jeudi vendredi
    {
        String[] moisString = new String[5];
        Calendar cal = Calendar.getInstance( new Locale("fr","FR") ); //On instancie un calendrier francais
        cal.setFirstDayOfWeek(Calendar.MONDAY); //On dit que le premier mois d'une semaine est le lundi (aux US, le premier jour est un dimanche)
        
        int annee; //L'année actuelle a laquelle on est
        int mois = Calendar.getInstance().get(Calendar.MONTH); //Le mois actuelle, commence a 0 pour janvier
        
        if(mois < 6) //Si on est dans la période début d'année (avant juillet)
        {
            if(numeroSemaine>=31 && numeroSemaine<=52)
            {
                annee = Calendar.getInstance().get(Calendar.YEAR);
                annee--; //si on est en janvier 2020, cela correspond a l'annee 2019
            }
            else
            {
                annee = Calendar.getInstance().get(Calendar.YEAR);
            }
        }
        else //Si on est dans la période fin d'année
        {
            if(numeroSemaine >=1 && numeroSemaine <=30)
            {
                annee = Calendar.getInstance().get(Calendar.YEAR);
                annee++; //Si on est en decembre 2020, l'année d'apres affichera les cours de 2021
            }
            else
            {
                annee = Calendar.getInstance().get(Calendar.YEAR);
            }
        }
        
        cal.setWeekDate(annee, numeroSemaine, Calendar.MONDAY);
        moisString[0] = monthIntToString(cal.get(Calendar.MONTH));
        
        cal.setWeekDate(annee, numeroSemaine, Calendar.TUESDAY);
        moisString[1] = monthIntToString(cal.get(Calendar.MONTH));
        
        cal.setWeekDate(annee, numeroSemaine, Calendar.WEDNESDAY);
        moisString[2] = monthIntToString(cal.get(Calendar.MONTH));
        
        cal.setWeekDate(annee, numeroSemaine, Calendar.THURSDAY);
        moisString[3] = monthIntToString(cal.get(Calendar.MONTH));
        
        cal.setWeekDate(annee, numeroSemaine, Calendar.FRIDAY);
        moisString[4] = monthIntToString(cal.get(Calendar.MONTH));
        return moisString;
    }
    
    //Fonction pour transformer un entier representant le mois en string ( 0 = janvier)
    public String monthIntToString(int month)
    {
        switch(month)
        {
            case 0:
                return "Janvier";
            case 1:
                return "Février";
            case 2:
                return "Mars";
            case 3:
                return "Avril";
            case 4:
                return "Mai";
            case 5:
                return "Juin";
            case 6:
                return "Juillet";
            case 7:
                return "Août";
            case 8:
                return "Septembre";
            case 9:
                return "Octobre";
            case 10:
                return "Novembre";
            case 11:
                return "Décembre";
            default:
                return "";
        }
    }
    
    //Fonction pour changer le label des 5 jours quand on clique sur l'un des 52 boutons en haut
    public void ChangeLabelJours(JLabel lundi, JLabel mardi, JLabel mercredi, JLabel jeudi, JLabel vendredi, int numeroSemaine)
    {
        int[] sem = getSemaineNumbers(numeroSemaine);
        String[] mois = getMoisString(numeroSemaine);
        lundi.setText("Lundi " + sem[0] + " " + mois[0]);
        mardi.setText("Mardi " + sem[1] + " " + mois[1]);
        mercredi.setText("Mercredi " + sem[2] + " " + mois[2]);
        jeudi.setText("Jeudi " + sem[3] + " " + mois[3]);
        vendredi.setText("Vendredi " + sem[4] + " " + mois[4]);
    }
    

    //Fonction pour changer le numéro de l'année
    public void ChangeAnneeProgramme(JLabel anneeLabel, int numeroSemaine)
    {
        int annee = Calendar.getInstance().get(Calendar.YEAR); //L'année actuelle a laquelle on est
        
        if(numeroSemaine >= 31 && numeroSemaine <= 52 )
        {
            annee-=1;
            anneeLabel.setText("Année " + annee);
        }
        else
        {
            anneeLabel.setText("Année " + annee);
        }
        
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
    
    //Fonction pour récupérer le droit de l'utilisateur
    public String GetDroit(String Email, String Passwd) 
    {
        String droitstring = "";
        
        try
        {
            DAO<Utilisateur> Utilisateurd = new UtilisateurDAO(ConnexionSQL.getInstance());
            Utilisateur user = Utilisateurd.find(Email,Passwd);
            
            int droit = user.getDroit();
            switch(droit)
            {
                case 1:
                    droitstring = "Administrateur";
                    break;
                case 2:
                    droitstring = "Référent Pédagogique";
                    break;
                case 3:
                    droitstring = "Enseignant";
                    break;
                case 4:
                    droitstring = "Etudiant";
                    break;
                default:
                    break;
            }
        }catch (SQLException ex) {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return droitstring;
    }
    
    //Fonction qui renvoie le droit de l'utilisateur sous forme d'int
    public int GetDroitInt(String Email, String Passwd)
    {
        int droit = 0;
        
        try
        {
            DAO<Utilisateur> Utilisateurd = new UtilisateurDAO(ConnexionSQL.getInstance());
            Utilisateur user = Utilisateurd.find(Email,Passwd);
            
            droit = user.getDroit();
            return droit;
        }catch (SQLException ex) {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return droit;
    }
    
    //Fonction pour récupérer la promotion de l'utilisateur, chaine vide si admin ou ref
    public String getPromotion(String email, String pass)
    {
        String prom = "";
        try {
            
            DAO<Utilisateur> Utilisateurd = new UtilisateurDAO(ConnexionSQL.getInstance());
            Utilisateur user = Utilisateurd.find(email,pass);
            
            if(user.getDroit() == 4) //Si c'est un etudiant
            {
                DAO<Etudiant> etudiantd = new EtudiantDAO(ConnexionSQL.getInstance());
                Etudiant etu = etudiantd.find(user.getId());
                
                DAO<Promotion> promod = new PromotionDAO(ConnexionSQL.getInstance());
                Promotion promo = promod.find(etu.getId_promotion());
                
                prom = promo.getNom();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prom;
    }
    
    //Fonction pour récupérer le td de l'utilisateur, chaine vide si admin ou ref ou enseignant
    public String getTD(String email, String pass)
    {
        String groupenom = "";
        try
        {
            DAO<Utilisateur> Utilisateurd = new UtilisateurDAO(ConnexionSQL.getInstance());
            Utilisateur user = Utilisateurd.find(email,pass);
            
            if(user.getDroit() == 4) //Si c'est un etudiant
            {
                DAO<Etudiant> etudiantd = new EtudiantDAO(ConnexionSQL.getInstance());
                Etudiant etu = etudiantd.find(user.getId());
                
                DAO<Groupe> grouped = new GroupeDAO(ConnexionSQL.getInstance());
                Groupe groupe = grouped.find(etu.getId_groupe());
                
                groupenom = groupe.getNom();
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return groupenom;
    }
    
    
     ////////////////////////////////////////////////// Affichage des cours sur l'edt ///////////////////////////////////////
    
    //Dessine sur l'edt les cours
    public void Draw(int numSemaine, JPanel lundiP, JPanel mardiP, JPanel mercrediP, JPanel jeudiP, JPanel vendrediP, String email, String password)
    {
        //On vide tous les panels
        Empty(lundiP);
        Empty(mardiP);
        Empty(mercrediP);
        Empty(jeudiP);
        Empty(vendrediP);
        
        //On ajoute 
        int droit = GetDroitInt(email, password);
        
        //Si c'est un etudiant
        if(droit == 4)
        {
            DrawPanelEtudiant(numSemaine, 1, lundiP, email, password);
            DrawPanelEtudiant(numSemaine, 2, mardiP, email, password);
            DrawPanelEtudiant(numSemaine, 3, mercrediP, email, password);
            DrawPanelEtudiant(numSemaine, 4, jeudiP, email, password);
            DrawPanelEtudiant(numSemaine, 5, vendrediP, email, password);
        }
        
        //Si c'est un professeur
        if(droit == 3)
        {
            DrawPanelProfesseur(numSemaine, 1, lundiP, email, password);
            DrawPanelProfesseur(numSemaine, 2, mardiP, email, password);
            DrawPanelProfesseur(numSemaine, 3, mercrediP, email, password);
            DrawPanelProfesseur(numSemaine, 4, jeudiP, email, password);
            DrawPanelProfesseur(numSemaine, 5, vendrediP, email, password);
        }
    }
    
    //Dessine sur l'edt les cours
    public void DrawSupprimer(int numSemaine, JPanel lundiP, JPanel mardiP, JPanel mercrediP, JPanel jeudiP, JPanel vendrediP, String email, String password, int droit2)
    {
        //On vide tous les panels
        Empty(lundiP);
        Empty(mardiP);
        Empty(mercrediP);
        Empty(jeudiP);
        Empty(vendrediP);
        
        //On ajoute 
        int droit = GetDroitInt(email, password);
        
        //Si c'est un etudiant
        if(droit == 4)
        {
            DrawPanelEtudiant(numSemaine, 1, lundiP, email, password);
            DrawPanelEtudiant(numSemaine, 2, mardiP, email, password);
            DrawPanelEtudiant(numSemaine, 3, mercrediP, email, password);
            DrawPanelEtudiant(numSemaine, 4, jeudiP, email, password);
            DrawPanelEtudiant(numSemaine, 5, vendrediP, email, password);
        }
        
        //Si c'est un professeur
        if(droit == 3)
        {
            if(droit2 == 1) //si admin
            {
                DrawPanelProfesseurSupprimer(numSemaine, 1, lundiP, email, password);
                DrawPanelProfesseurSupprimer(numSemaine, 2, mardiP, email, password);
                DrawPanelProfesseurSupprimer(numSemaine, 3, mercrediP, email, password);
                DrawPanelProfesseurSupprimer(numSemaine, 4, jeudiP, email, password);
                DrawPanelProfesseurSupprimer(numSemaine, 5, vendrediP, email, password);
            }
            else
            {
                DrawPanelProfesseur(numSemaine, 1, lundiP, email, password);
                DrawPanelProfesseur(numSemaine, 2, mardiP, email, password);
                DrawPanelProfesseur(numSemaine, 3, mercrediP, email, password);
                DrawPanelProfesseur(numSemaine, 4, jeudiP, email, password);
                DrawPanelProfesseur(numSemaine, 5, vendrediP, email, password);
            }
        }
    }
    
    public void DrawPanelProfesseur(int numSemaine, int jour, JPanel panel, String email, String password)
    {
        try 
        {
            //On recup l'utilisateur
            DAO<Utilisateur> Utilisateurd = new UtilisateurDAO(ConnexionSQL.getInstance());
            Utilisateur user = Utilisateurd.find(email,password);
            
            //On recup l'enseignant
            DAO<Enseignant> Enseignantd = new EnseignantDAO(ConnexionSQL.getInstance());
            Enseignant Enseignant = Enseignantd.find(user.getId());
            
            DAO<Seance_Enseignant> sed = new Seance_EnseignantDAO(ConnexionSQL.getInstance());
            ArrayList<Integer> list_id_seance = sed.ComposerFindSeance(Enseignant.getId());
            
            for(int i=0; i<list_id_seance.size(); i++)
            {
                DAO<Seance> seanced = new SeanceDAO(ConnexionSQL.getInstance());
                Seance seance = seanced.find(list_id_seance.get(i));
                
                Date d = seance.getdate();
                if(jour == d.getDay() && numSemaine == seance.getSemaine())
                {
                   //La panneau du cours et son layout
                   JPanel cours = new JPanel();
                   cours.setLayout(new GridBagLayout());
                   GridBagConstraints gbc = new GridBagConstraints();
                   gbc.weightx = 1;
                   
                   //On change la couleur
                   cours.setBackground(new Color(seance.getR(),seance.getV(), seance.getB()));
                   
                   //Font et couleur des textes
                   Font font = new Font("Cambria", Font.PLAIN, 12);
                   Font font2 = new Font("Cambria", Font.BOLD, 12);
                   Color c = new Color(0,0,0); //noir
                   Color ece = new Color(0,153,153); 
                   
                   //On ajoute l'etat
                   JLabel status = new JLabel();
                   String statusString = seance.getStatus();
                   if(statusString.equals("ANNULE"))
                   {
                       status.setText(statusString);
                       status.setFont(font);
                       status.setForeground(Color.RED);
                   }
                   else
                   {
                       statusString = "";
                   }
                   
                   //On ajoute le nom du cours
                   JLabel nomcours = new JLabel();
                   String nomTypeCours = "";
                   int idcours = seance.getId_cours();
                   DAO<Cours> coursd = new CoursDAO(ConnexionSQL.getInstance());
                   Cours coursName = coursd.find(idcours);
                   nomTypeCours += coursName.getNom();
                   nomTypeCours += " - ";
                   DAO<Type_Cours> type_coursd = new Type_CoursDAO(ConnexionSQL.getInstance());
                   Type_Cours type_cours = type_coursd.find(seance.getId_type());
                   nomTypeCours += type_cours.getNom();
                   nomcours.setText(nomTypeCours);
                   nomcours.setFont(font2);
                   nomcours.setForeground(c);
                   
                   //On ajoute la promotion et les groupes
                   JLabel promotionEtGroupe = new JLabel();
                   String promotionEtGroupeString = "";
                   int id_seance = seance.getId(); //l'id de la seance
                   int id_promotion = 0; //l'id de la promotion
                   DAO<Seance_Groupe> sgd = new Seance_GroupeDAO(ConnexionSQL.getInstance());
                   ArrayList<Integer> list_id_groupes = sgd.ComposerFindGroupe(id_seance); //la liste des id_groupe dans seance_groupe
                   for(int j=0;j<list_id_groupes.size();j++)
                   {
                       DAO<Groupe> grouped = new GroupeDAO(ConnexionSQL.getInstance());
                       Groupe groupe = grouped.find(list_id_groupes.get(j));
                       promotionEtGroupeString = promotionEtGroupeString + groupe.getNom() + " ";
                       id_promotion = groupe.getId_promotion();
                   }
                   DAO<Promotion> promotiond = new PromotionDAO(ConnexionSQL.getInstance());
                   Promotion prom = promotiond.find(id_promotion);
                   promotionEtGroupeString = promotionEtGroupeString + " - " + prom.getNom();
                   promotionEtGroupe.setText(promotionEtGroupeString);
                   promotionEtGroupe.setFont(font);
                   promotionEtGroupe.setForeground(c);
                   
                   //On ajoute la salle et le site
                   JLabel salleSiteCapacite = new JLabel();
                   String salleSiteCapaciteString = "";
                   String nomSalle = "";
                   String capaciteSalle = "";
                   String nomSite = "";
                   int id_seance2 = seance.getId(); //l'id de la seance
                   DAO<Seance_Salle> ssd = new Seance_SalleDAO(ConnexionSQL.getInstance());
                   Seance_Salle ss = ssd.find(id_seance2);
                   int id_salle = ss.getId_salle();
                   DAO<Salle> sd = new SalleDAO(ConnexionSQL.getInstance());
                   Salle s = sd.find(id_salle);
                   nomSalle += s.getNom();
                   capaciteSalle += s.getCapacite() + "";
                   int id_site = s.getId_site();
                   DAO<Site> sited = new SiteDAO(ConnexionSQL.getInstance());
                   Site site = sited.find(id_site);
                   nomSite = site.getNom();
                   salleSiteCapaciteString = nomSalle + " - " + nomSite + " (" + capaciteSalle + ")"; 
                   salleSiteCapacite.setText(salleSiteCapaciteString);
                   salleSiteCapacite.setFont(font);
                   salleSiteCapacite.setForeground(c);
                   
                   
                   //On recupere le nbr de minutes que dure le cours pour agrandir en height le panel
                   //Changement de la dimension et de la hauteur du rectangle
                   Time ti = seance.getHeure_Debut();
                   Time tf = seance.getHeure_Fin();
                   long diffInMinutes = ((tf.getTime() - ti.getTime())/1000)/60; //la difference de temps entre cours en minutes, une minute = 1.034 height
                   Dimension dim = new Dimension();
                   dim.setSize(198,  1.03472222222 * diffInMinutes);
                   cours.setSize(dim);
                   long beginTimeCours = (ti.getTime()/1000)/60;
                   long huitHeureTrente = 510-60;
                   cours.setLocation(0, (int)(1.03472222222*(beginTimeCours-huitHeureTrente)));
                   
                   //On ajoute l'heure de début et l'heure de fin
                   JLabel heureLabel = new JLabel();
                   String heure = "";
                   heure += ti + " ~ " + tf;
                   heureLabel.setText(heure);
                   heureLabel.setFont(font);
                   heureLabel.setForeground(c);
                   
                   //On ajoute tous les textes
                   gbc.gridx = 0;
                   gbc.gridy = 0;
                   cours.add(status, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 1;
                   cours.add(nomcours, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 2;
                   cours.add(promotionEtGroupe, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 3;
                   cours.add(salleSiteCapacite, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 4;
                   cours.add(heureLabel, gbc);
                   
                   //On ajoute au jour correspondant ce cours
                   panel.add(cours);
                }
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Dessine sur 1'EDT en fonction du numero de semaine et du jour, celui de l'étudiant
    public void DrawPanelEtudiant(int numSemaine, int jour, JPanel panel, String email, String password)
    {
        try 
        {
            //On recup l'utilisateur
            DAO<Utilisateur> Utilisateurd = new UtilisateurDAO(ConnexionSQL.getInstance());
            Utilisateur user = Utilisateurd.find(email,password);
            
            
            
            //On recup l'etudiant - son id_groupe
            DAO<Etudiant> Etudiantd = new EtudiantDAO(ConnexionSQL.getInstance());
            Etudiant etudiant = Etudiantd.find(user.getId());
            
            
            //On recupere la seance groupe - on recup un arraylist d'int qui est la liste id_seance
            DAO<Seance_Groupe> seance_grouped = new Seance_GroupeDAO(ConnexionSQL.getInstance());
            ArrayList<Integer> seance_groupe = seance_grouped.ComposerFindSeance(etudiant.getId_groupe()); //C'est la liste des id_seance
           
            
            //Pour chaque id seance qu'on trouve
            for(int i=0; i<seance_groupe.size();i++)
            {
                //on va dans seance et on recupere le status
                DAO<Seance> seanced = new SeanceDAO(ConnexionSQL.getInstance());
                Seance seance = seanced.find(seance_groupe.get(i));
                
                
               Date d = seance.getdate();
               if(jour == d.getDay() && numSemaine == seance.getSemaine()) //Si le jour passé en parametre est le meme que celui qu'on recupere
               {
                   
                   //La panneau du cours et son layout
                   JPanel cours = new JPanel();
                   cours.setLayout(new GridBagLayout());
                   GridBagConstraints gbc = new GridBagConstraints();
                   gbc.weightx = 1;
                   
                   //On change la couleur
                   cours.setBackground(new Color(seance.getR(),seance.getV(), seance.getB()));
                   
                   //Font et couleur des textes
                   Font font = new Font("Cambria", Font.PLAIN, 12);
                   Font font2 = new Font("Cambria", Font.BOLD, 12);
                   Color c = new Color(0,0,0); //noir
                   Color ece = new Color(0,153,153); 
                   
                   //On ajoute le label de l'etat
                   JLabel status = new JLabel();
                   String statusString = seance.getStatus();
                   if(statusString.equals("ANNULE"))
                   {
                       status.setText(statusString);
                       status.setFont(font);
                       status.setForeground(Color.RED);
                   }
                   else
                   {
                       statusString = "";
                   }
                   
                   
                   //On ajoute le nom du cours
                   JLabel nomcours = new JLabel();
                   String nomTypeCours = "";
                   int idcours = seance.getId_cours();
                   DAO<Cours> coursd = new CoursDAO(ConnexionSQL.getInstance());
                   Cours coursName = coursd.find(idcours);
                   nomTypeCours += coursName.getNom();
                   nomTypeCours += " - ";
                   DAO<Type_Cours> type_coursd = new Type_CoursDAO(ConnexionSQL.getInstance());
                   Type_Cours type_cours = type_coursd.find(seance.getId_type());
                   nomTypeCours += type_cours.getNom();
                   nomcours.setText(nomTypeCours);
                   nomcours.setFont(font2);
                   nomcours.setForeground(c);
                   
                   //On ajoute les noms des profs
                   JLabel nomProfs = new JLabel();
                   String nomProfsString = "";
                   int idseance = seance.getId();
                   DAO<Seance_Enseignant> seance_enseignantd = new Seance_EnseignantDAO(ConnexionSQL.getInstance());
                   ArrayList<Integer> id_utilisateurs = seance_enseignantd.ComposerFindEnseignant(idseance); //les ids utilisateurs sont des ids d enseignants
                   for(int j=0;j<id_utilisateurs.size();j++)
                   {
                       DAO<Utilisateur> Utilisateurdprof = new UtilisateurDAO(ConnexionSQL.getInstance());
                       Utilisateur userprof = Utilisateurdprof.find(id_utilisateurs.get(j));
                       nomProfsString += userprof.getNom();
                   }
                   nomProfs.setText(nomProfsString);
                   nomProfs.setFont(font);
                   nomProfs.setForeground(c);
                   
                   
                   
                   //On ajoute la promotion + le ou les groupes
                   JLabel promotionEtGroupe = new JLabel();
                   String promotionEtGroupeString = "";
                   int idgroupe = etudiant.getId_groupe(); //l'id du groupe de l'etudiant connecte
                   int idpromotion = etudiant.getId_promotion(); //l'id de la promotion de l etudiant connecte
                   DAO<Promotion> promd = new PromotionDAO(ConnexionSQL.getInstance());
                   Promotion prom = promd.find(idpromotion);
                   String nomPromotion = prom.getNom(); //Le nom de la promotion
                   promotionEtGroupeString += nomPromotion;
                   promotionEtGroupeString += ", ";
                   DAO<Groupe> grouped = new GroupeDAO(ConnexionSQL.getInstance());
                   Groupe g = grouped.find(idgroupe);
                   promotionEtGroupeString += g.getNom();
                   promotionEtGroupe.setText(promotionEtGroupeString);
                   promotionEtGroupe.setFont(font);
                   promotionEtGroupe.setForeground(c);
                   
                   //On ajoute la salle et le site
                   JLabel salleSiteCapacite = new JLabel();
                   String salleSiteCapaciteString = "";
                   String nomSalle = "";
                   String capaciteSalle = "";
                   String nomSite = "";
                   DAO<Seance_Salle> seance_salled = new Seance_SalleDAO(ConnexionSQL.getInstance());
                   Seance_Salle seance_salle = seance_salled.find(seance_groupe.get(i));
                   int id_salle = seance_salle.getId_salle();
                   DAO<Salle> salled = new SalleDAO(ConnexionSQL.getInstance());
                   Salle salle = salled.find(id_salle);
                   nomSalle = salle.getNom();
                   capaciteSalle = salle.getCapacite() + "";
                   int id_site = salle.getId_site();
                   DAO<Site> sited = new SiteDAO(ConnexionSQL.getInstance());
                   Site s = sited.find(id_site);
                   nomSite = s.getNom();
                   salleSiteCapaciteString = nomSalle + " - " + nomSite + " (" + capaciteSalle + ")"; 
                   salleSiteCapacite.setText(salleSiteCapaciteString);
                   salleSiteCapacite.setFont(font);
                   salleSiteCapacite.setForeground(c);
                   
                   //On recupere le nbr de minutes que dure le cours pour agrandir en height le panel
                   //Changement de la dimension et de la hauteur du rectangle
                   Time ti = seance.getHeure_Debut();
                   Time tf = seance.getHeure_Fin();
                   long diffInMinutes = ((tf.getTime() - ti.getTime())/1000)/60; //la difference de temps entre cours en minutes, une minute = 1.034 height
                   Dimension dim = new Dimension();
                   dim.setSize(198,  1.03472222222 * diffInMinutes);
                   cours.setSize(dim);
                   long beginTimeCours = (ti.getTime()/1000)/60;
                   long huitHeureTrente = 510-60;
                   cours.setLocation(0, (int)(1.03472222222*(beginTimeCours-huitHeureTrente)));
                   
                   //On ajoute l'heure de début et l'heure de fin
                   JLabel heureLabel = new JLabel();
                   String heure = "";
                   heure += ti + " ~ " + tf;
                   heureLabel.setText(heure);
                   heureLabel.setFont(font);
                   heureLabel.setForeground(c);
                   
                   //On ajoute les textes au panel cours
                   gbc.gridx = 0;
                   gbc.gridy = 0;
                   cours.add(status, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 1;
                   cours.add(nomcours, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 2;
                   cours.add(nomProfs, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 3;
                   cours.add(promotionEtGroupe, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 4;
                   cours.add(salleSiteCapacite, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 5;
                   cours.add(heureLabel, gbc);
                   
                   //On ajoute au jour correspondant ce cours
                   panel.add(cours);
                   
               }
                
            }
            
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void DrawPanelProfesseurSupprimer(int numSemaine, int jour, JPanel panel, String email, String password)
    {
        try 
        {
            //On recup l'utilisateur
            DAO<Utilisateur> Utilisateurd = new UtilisateurDAO(ConnexionSQL.getInstance());
            Utilisateur user = Utilisateurd.find(email,password);
            
            //On recup l'enseignant
            DAO<Enseignant> Enseignantd = new EnseignantDAO(ConnexionSQL.getInstance());
            Enseignant Enseignant = Enseignantd.find(user.getId());
            
            DAO<Seance_Enseignant> sed = new Seance_EnseignantDAO(ConnexionSQL.getInstance());
            ArrayList<Integer> list_id_seance = sed.ComposerFindSeance(Enseignant.getId());
            
            for(int i=0; i<list_id_seance.size(); i++)
            {
                DAO<Seance> seanced = new SeanceDAO(ConnexionSQL.getInstance());
                Seance seance = seanced.find(list_id_seance.get(i));
                
                Date d = seance.getdate();
                if(jour == d.getDay() && numSemaine == seance.getSemaine())
                {
                   //La panneau du cours et son layout
                   JPanel cours = new JPanel();
                   cours.setLayout(new GridBagLayout());
                   GridBagConstraints gbc = new GridBagConstraints();
                   gbc.weightx = 1;
                   
                   //On change la couleur
                   cours.setBackground(new Color(seance.getR(),seance.getV(), seance.getB()));
                   
                   //Font et couleur des textes
                   Font font = new Font("Cambria", Font.PLAIN, 12);
                   Font font2 = new Font("Cambria", Font.BOLD, 12);
                   Color c = new Color(0,0,0); //noir
                   Color ece = new Color(0,153,153); 
                   
                   //On ajoute l'etat
                   JLabel status = new JLabel();
                   String statusString = seance.getStatus();
                   if(statusString.equals("ANNULE"))
                   {
                       status.setText(statusString);
                       status.setFont(font);
                       status.setForeground(Color.RED);
                   }
                   else
                   {
                       statusString = "";
                   }
                   
                   //On ajoute le nom du cours
                   JLabel nomcours = new JLabel();
                   String nomTypeCours = "";
                   int idcours = seance.getId_cours();
                   DAO<Cours> coursd = new CoursDAO(ConnexionSQL.getInstance());
                   Cours coursName = coursd.find(idcours);
                   nomTypeCours += coursName.getNom();
                   nomTypeCours += " - ";
                   DAO<Type_Cours> type_coursd = new Type_CoursDAO(ConnexionSQL.getInstance());
                   Type_Cours type_cours = type_coursd.find(seance.getId_type());
                   nomTypeCours += type_cours.getNom();
                   nomcours.setText(nomTypeCours);
                   nomcours.setFont(font2);
                   nomcours.setForeground(c);
                   
                   //On ajoute la promotion et les groupes
                   JLabel promotionEtGroupe = new JLabel();
                   String promotionEtGroupeString = "";
                   int id_seance = seance.getId(); //l'id de la seance
                   int id_promotion = 0; //l'id de la promotion
                   DAO<Seance_Groupe> sgd = new Seance_GroupeDAO(ConnexionSQL.getInstance());
                   ArrayList<Integer> list_id_groupes = sgd.ComposerFindGroupe(id_seance); //la liste des id_groupe dans seance_groupe
                   for(int j=0;j<list_id_groupes.size();j++)
                   {
                       DAO<Groupe> grouped = new GroupeDAO(ConnexionSQL.getInstance());
                       Groupe groupe = grouped.find(list_id_groupes.get(j));
                       promotionEtGroupeString = promotionEtGroupeString + groupe.getNom() + " ";
                       id_promotion = groupe.getId_promotion();
                   }
                   DAO<Promotion> promotiond = new PromotionDAO(ConnexionSQL.getInstance());
                   Promotion prom = promotiond.find(id_promotion);
                   promotionEtGroupeString = promotionEtGroupeString + " - " + prom.getNom();
                   promotionEtGroupe.setText(promotionEtGroupeString);
                   promotionEtGroupe.setFont(font);
                   promotionEtGroupe.setForeground(c);
                   
                   //On ajoute la salle et le site
                   JLabel salleSiteCapacite = new JLabel();
                   String salleSiteCapaciteString = "";
                   String nomSalle = "";
                   String capaciteSalle = "";
                   String nomSite = "";
                   int id_seance2 = seance.getId(); //l'id de la seance
                   DAO<Seance_Salle> ssd = new Seance_SalleDAO(ConnexionSQL.getInstance());
                   Seance_Salle ss = ssd.find(id_seance2);
                   int id_salle = ss.getId_salle();
                   DAO<Salle> sd = new SalleDAO(ConnexionSQL.getInstance());
                   Salle s = sd.find(id_salle);
                   nomSalle += s.getNom();
                   capaciteSalle += s.getCapacite() + "";
                   int id_site = s.getId_site();
                   DAO<Site> sited = new SiteDAO(ConnexionSQL.getInstance());
                   Site site = sited.find(id_site);
                   nomSite = site.getNom();
                   salleSiteCapaciteString = nomSalle + " - " + nomSite + " (" + capaciteSalle + ")"; 
                   salleSiteCapacite.setText(salleSiteCapaciteString);
                   salleSiteCapacite.setFont(font);
                   salleSiteCapacite.setForeground(c);
                   
                   
                   //On recupere le nbr de minutes que dure le cours pour agrandir en height le panel
                   //Changement de la dimension et de la hauteur du rectangle
                   Time ti = seance.getHeure_Debut();
                   Time tf = seance.getHeure_Fin();
                   long diffInMinutes = ((tf.getTime() - ti.getTime())/1000)/60; //la difference de temps entre cours en minutes, une minute = 1.034 height
                   Dimension dim = new Dimension();
                   dim.setSize(198,  1.03472222222 * diffInMinutes);
                   cours.setSize(dim);
                   long beginTimeCours = (ti.getTime()/1000)/60;
                   long huitHeureTrente = 510-60;
                   cours.setLocation(0, (int)(1.03472222222*(beginTimeCours-huitHeureTrente)));
                   
                   //On ajoute l'heure de début et l'heure de fin
                   JLabel heureLabel = new JLabel();
                   String heure = "";
                   heure += ti + " ~ " + tf;
                   heureLabel.setText(heure);
                   heureLabel.setFont(font);
                   heureLabel.setForeground(c);
                   
                   //On ajoute tous les textes
                   gbc.gridx = 0;
                   gbc.gridy = 0;
                   cours.add(status, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 1;
                   cours.add(nomcours, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 2;
                   cours.add(promotionEtGroupe, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 3;
                   cours.add(salleSiteCapacite, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 4;
                   cours.add(heureLabel, gbc);
                   
                   //Boutton supprimer
                   JButton bouttonSupprimer = new JButton("Supprimer");
                   bouttonSupprimer.setBackground(ece);
                   bouttonSupprimer.addActionListener(new SupprimerBoutton(list_id_seance.get(i), user.getId(), idcours, numSemaine, jour, panel, email, password));
                   gbc.gridx = 0;
                   gbc.gridy = 6;
                   cours.add(bouttonSupprimer, gbc);
                   
                   //On ajoute au jour correspondant ce cours
                   panel.add(cours);
                }
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /** Listener pour supprimer un cours */
    public class SupprimerBoutton implements ActionListener
    {
        int idseance;
        int iduser;
        int idcours;
        
        int numSemaine;
        int jour;
        JPanel panel; 
        String email;
        String password;
        
        public SupprimerBoutton(int idseance, int iduser, int idcours, int numSemaine, int jour, JPanel panel, String email, String password)
        {
            this.idseance = idseance;
            this.iduser = iduser;
            this.idcours = idcours;
            this.numSemaine = numSemaine;
            this.jour = jour;
            this.panel = panel;
            this.email = email;
            this.password = password;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            try 
            {
                //seance_enseignant, senace_groupe, seance_salle
                
                DAO<Seance_Enseignant> sed = new Seance_EnseignantDAO(ConnexionSQL.getInstance());
                Seance_Enseignant se = sed.find(idseance, iduser, idcours);
                sed.delete(se);
                
                DAO<Seance_Salle> ssd = new Seance_SalleDAO(ConnexionSQL.getInstance());
                Seance_Salle ss = ssd.find(idseance);
                ssd.delete(ss);
                
                DAO<Seance_Groupe> sgd = new Seance_GroupeDAO(ConnexionSQL.getInstance());
                ArrayList<Integer> list_id_groupe = sgd.ComposerFindGroupe(idseance);
                for(int i=0; i<list_id_groupe.size();i++)
                {
                    Seance_Groupe sg = sgd.find(idseance, list_id_groupe.get(i));
                    sgd.delete(sg);
                }
                
                DAO<Seance> dao = new SeanceDAO(ConnexionSQL.getInstance());
                Seance t = dao.find(idseance);
                dao.delete(t);
                
            } catch (SQLException ex) {
                Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Empty(panel);
            DrawPanelProfesseurSupprimer(numSemaine, jour, panel, email, password);
        }
        
    }
            
    
    
    //Methode pour vider un JPanel de son contenu
    public void Empty(JPanel panel)
    {
        Component[] componentList = panel.getComponents();

        //Loop through the components
        for(Component c : componentList){

            panel.remove(c);
        }

        //IMPORTANT
        panel.revalidate();
        panel.repaint();
    }
    
    ////////////////////////////////////////////////// RECHERCHE SUR L'EDT POUR ADMIN ET REF PEDAGOGIQUE ///////////////////////////////////////
    
    /** Permet de changer la 3e compo box en fonction de la 2e*/
    public void changeRecapEdtSearch2(JComboBox valeurARecup, JComboBox jcbAChanger, JComboBox jcb3)
    {
        jcbAChanger.removeAllItems(); //Vide tous les elements
        jcb3.setVisible(false);
        
        String recherche = (String)valeurARecup.getSelectedItem();
        if(recherche == "Enseignant")
        {
            String nomEnseignant = "";
            
            try 
            {
                DAO<Enseignant> enseignantd = new EnseignantDAO(ConnexionSQL.getInstance());
                ArrayList<Integer> id_utilisateurs = enseignantd.FindEnseignant();
                
                for(int i=0; i<id_utilisateurs.size();i++)
                {
                    DAO<Utilisateur> utilisateurd = new UtilisateurDAO(ConnexionSQL.getInstance());
                    Utilisateur user = utilisateurd.find(id_utilisateurs.get(i));
                    nomEnseignant = user.getPrenom() + " " + user.getNom();
                    jcbAChanger.addItem(nomEnseignant);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(recherche == "Etudiant")
        {
            String nomEtudiant = "";
            try 
            {
                DAO<Etudiant> etudiantd = new EtudiantDAO(ConnexionSQL.getInstance());
                ArrayList<Integer> id_utilisateurs = etudiantd.FindEtudiant();
                
                for(int i=0; i<id_utilisateurs.size();i++)
                {
                    DAO<Utilisateur> utilisateurd = new UtilisateurDAO(ConnexionSQL.getInstance());
                    Utilisateur user = utilisateurd.find(id_utilisateurs.get(i));
                    nomEtudiant = user.getPrenom() + " " + user.getNom();
                    jcbAChanger.addItem(nomEtudiant);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(recherche == "Promotion")
        {
            String nomPromotion = "";
            try 
            {
                DAO<Promotion> promotiond = new PromotionDAO(ConnexionSQL.getInstance());
                ArrayList<Integer> id_promotion = promotiond.FindPromotion();
                
                for(int i=0; i<id_promotion.size();i++)
                {
                    Promotion promotion = promotiond.find(id_promotion.get(i));
                    nomPromotion = promotion.getNom();
                    jcbAChanger.addItem(nomPromotion);
                }
                jcb3.setVisible(true);
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(recherche == "Site")
        {
            String nomSite = "";
            try 
            {
                DAO<Site> sited = new SiteDAO(ConnexionSQL.getInstance());
                ArrayList<Integer> id_sites = sited.FindSite();
                
                for(int i=0; i<id_sites.size();i++)
                {
                    Site site = sited.find(id_sites.get(i));
                    nomSite = site.getNom();
                    jcbAChanger.addItem(nomSite);
                }
                jcb3.setVisible(true);
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /** Permet de changer la 4e combo box en fonction de la 3e*/
    public void changeRecapEdtSearch3(JComboBox recapSearch1, JComboBox recapSearch2, JComboBox aChanger)
    {
        aChanger.removeAllItems();
        String result1 = (String)recapSearch1.getSelectedItem();
        if(result1=="Promotion" || result1=="Site")
        {
            String result2 = (String)recapSearch2.getSelectedItem();
            if(result2 != null)
            {
                if(result1=="Promotion")
                {
                    try 
                    {
                        DAO<Promotion> promotiond = new PromotionDAO(ConnexionSQL.getInstance());
                        int id_promotion = promotiond.ID(result2);
                        
                        DAO<Groupe> grouped = new GroupeDAO(ConnexionSQL.getInstance());
                        ArrayList<String> nom_tds = grouped.ListInfo(id_promotion);
                        
                        for(int i=0; i<nom_tds.size(); i++)
                        {
                            aChanger.addItem(nom_tds.get(i));
                        }
                        
                    } catch (SQLException ex) 
                    {
                        Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(result1=="Site")
                {
                    try 
                    {
                        DAO<Site> sited = new SiteDAO(ConnexionSQL.getInstance());
                        int id_site = sited.ID(result2);
                        
                        DAO<Salle> salled = new SalleDAO(ConnexionSQL.getInstance());
                        ArrayList<String> nom_salles = salled.ListInfo(id_site);
                        
                        for(int i=0; i<nom_salles.size(); i++)
                        {
                            aChanger.addItem(nom_salles.get(i));
                        }
                        
                    } catch (SQLException ex) 
                    {
                        Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        }
        
    }
    
    /** affiche message erreur */
    public void changeMessageErreur(JLabel labelErreur, JComboBox jcbAChanger, JComboBox edtSearch3)
    {
        String labelErreurString = "";
        String recherche = (String)jcbAChanger.getSelectedItem();
        if(recherche == null)
        {
            labelErreurString = "ERREUR : Le deuxième champs est vide!";
        }
        else
        {
            String cb3String = (String)edtSearch3.getSelectedItem();
            if(edtSearch3.isVisible() && cb3String == null)
            {
                labelErreurString = "ERREUR : Le troisième champs est vide!";
            }
            else
                labelErreurString = "Voici les résultats de votre recherche.";
        }
        labelErreur.setText(labelErreurString);
    }
    
    //Avec le combobox fourni, recul l'email et le password 
    public void dessineEtudiantProfesseur(String email, String password, JComboBox recapEdtSearch, JComboBox prenomNom, JComboBox numSemaineCB, JPanel lundi, JPanel mardi, JPanel mercredi, JPanel jeudi, JPanel vendredi, JLabel lundiLabel, JLabel mardiLabel, JLabel mercrediLabel, JLabel jeudiLabel, JLabel vendrediLabel, JLabel anneeEdtLabel)
    {
        String typeRecherche = (String)recapEdtSearch.getSelectedItem();
        
        int droit = GetDroitInt(email, password);
        
        
        if(typeRecherche != null && typeRecherche != "Promotion" && typeRecherche != "Site")
        {
            String prenomNomString = (String)prenomNom.getSelectedItem();
            String numSemaineString = (String)(numSemaineCB.getSelectedItem());
            int numSemaine = Integer.parseInt(numSemaineString);
            if(prenomNomString != null)
            {
                String[] splitted = prenomNomString.split("\\s+");
                String prenom = splitted[0];
                String nom = splitted[1];
                try 
                {
                    DAO<Utilisateur> user = new UtilisateurDAO(ConnexionSQL.getInstance());
                    ArrayList<String> emailPassword = user.FindEmailPasswd(nom,prenom); //premier element email, deuxieme mot de passe

                    ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, numSemaine);
                    ChangeAnneeProgramme(anneeEdtLabel, numSemaine);
                    DrawSupprimer(numSemaine, lundi, mardi, mercredi, jeudi, vendredi, emailPassword.get(0), emailPassword.get(1), droit);

                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
        
    /**Dessine pour la promotion et le site */
    public void dessinePromotionSite(String email, String password, JComboBox recapEdtSearch ,JComboBox promotionSite, JComboBox groupeSalle, JComboBox numSemaineCB, JPanel lundi, JPanel mardi, JPanel mercredi, JPanel jeudi, JPanel vendredi, JLabel lundiLabel, JLabel mardiLabel, JLabel mercrediLabel, JLabel jeudiLabel, JLabel vendrediLabel, JLabel anneeEdtLabel)
    {
        String promSite = (String)promotionSite.getSelectedItem(); //on recupere la 1ere combobox
        String grpSalle = (String)groupeSalle.getSelectedItem(); //on recupere la 2eme combobox
        String typeRecherche = (String)recapEdtSearch.getSelectedItem();
        
        int droit = GetDroitInt(email,password);
        
        if(promotionSite != null && grpSalle != null)
        {
            String numSemaineString = (String)(numSemaineCB.getSelectedItem());
            int numSemaine = Integer.parseInt(numSemaineString);
                
            if(typeRecherche == "Promotion") //Ici on est dans le cas ou on recherche une promotion
            {
                
                ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, numSemaine);
                ChangeAnneeProgramme(anneeEdtLabel, numSemaine);
                Empty(lundi);
                Empty(mardi);
                Empty(mercredi);
                Empty(jeudi);
                Empty(vendredi);
                if(droit == 1)
                {
                    drawPromotionSite(getIdSeancesPromotion(promSite, grpSalle), numSemaine, 1, lundi);
                    drawPromotionSite(getIdSeancesPromotion(promSite, grpSalle), numSemaine, 2, mardi);
                    drawPromotionSite(getIdSeancesPromotion(promSite, grpSalle), numSemaine, 3, mercredi);
                    drawPromotionSite(getIdSeancesPromotion(promSite, grpSalle), numSemaine, 4, jeudi);
                    drawPromotionSite(getIdSeancesPromotion(promSite, grpSalle), numSemaine, 5, vendredi);
                }
                else
                {
                    drawPromotionSite(getIdSeancesPromotion(promSite, grpSalle), numSemaine, 1, lundi);
                    drawPromotionSite(getIdSeancesPromotion(promSite, grpSalle), numSemaine, 2, mardi);
                    drawPromotionSite(getIdSeancesPromotion(promSite, grpSalle), numSemaine, 3, mercredi);
                    drawPromotionSite(getIdSeancesPromotion(promSite, grpSalle), numSemaine, 4, jeudi);
                    drawPromotionSite(getIdSeancesPromotion(promSite, grpSalle), numSemaine, 5, vendredi);
                }
                
            }
            else if(typeRecherche == "Site") //Ici on est dans le cas ou on recherche un site
            {
                ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, numSemaine);
                ChangeAnneeProgramme(anneeEdtLabel, numSemaine);
                Empty(lundi);
                Empty(mardi);
                Empty(mercredi);
                Empty(jeudi);
                Empty(vendredi);
                drawPromotionSite(getIdSeancesSite(promSite, grpSalle), numSemaine, 1, lundi);
                drawPromotionSite(getIdSeancesSite(promSite, grpSalle), numSemaine, 2, mardi);
                drawPromotionSite(getIdSeancesSite(promSite, grpSalle), numSemaine, 3, mercredi);
                drawPromotionSite(getIdSeancesSite(promSite, grpSalle), numSemaine, 4, jeudi);
                drawPromotionSite(getIdSeancesSite(promSite, grpSalle), numSemaine, 5, vendredi);
            }
        }
    }
    
    //Pour dessiner dans les panels si c'est une recherche via promotion(+groupe) ou via un site(+salle) 
    public void drawPromotionSite(ArrayList<Integer> id_seances, int numSemaine, int jour, JPanel panel)
    {
        try
        {
            for(int i=0; i<id_seances.size();i++)
            {
                DAO<Seance> seanced = new SeanceDAO(ConnexionSQL.getInstance());
                Seance seance = seanced.find(id_seances.get(i));
                
                Date d = seance.getdate();
                if(jour == d.getDay() && numSemaine == seance.getSemaine())
                {
                    //La panneau du cours et son layout
                   JPanel cours = new JPanel();
                   cours.setLayout(new GridBagLayout());
                   GridBagConstraints gbc = new GridBagConstraints();
                   gbc.weightx = 1;
                   
                   //On change la couleur
                   cours.setBackground(new Color(seance.getR(),seance.getV(), seance.getB()));
                   
                   //Font et couleur des textes
                   Font font = new Font("Cambria", Font.PLAIN, 12);
                   Font font2 = new Font("Cambria", Font.BOLD, 12);
                   Color c = new Color(0,0,0); //noir
                   
                   //On affiche le status
                   JLabel status = new JLabel();
                   String statusString = seance.getStatus();
                   if(statusString.equals("ANNULE"))
                   {
                       status.setText(statusString);
                       status.setFont(font);
                       status.setForeground(Color.RED);
                   }
                   else
                   {
                       statusString = "";
                   }
                   
                   //On affiche le nom du cours
                   JLabel nomcours = new JLabel();
                   String nomTypeCours = "";
                   int idcours = seance.getId_cours();
                   DAO<Cours> coursd = new CoursDAO(ConnexionSQL.getInstance());
                   Cours coursName = coursd.find(idcours);
                   nomTypeCours += coursName.getNom();
                   nomTypeCours += " - ";
                   DAO<Type_Cours> type_coursd = new Type_CoursDAO(ConnexionSQL.getInstance());
                   Type_Cours type_cours = type_coursd.find(seance.getId_type());
                   nomTypeCours += type_cours.getNom();
                   nomcours.setText(nomTypeCours);
                   nomcours.setFont(font2);
                   nomcours.setForeground(c);
                   
                   //On affiche le nom des profs
                   JLabel nomProfs = new JLabel();
                   String nomProfsString = "";
                   int idseance = seance.getId();
                   DAO<Seance_Enseignant> seance_enseignantd = new Seance_EnseignantDAO(ConnexionSQL.getInstance());
                   ArrayList<Integer> id_utilisateurs = seance_enseignantd.ComposerFindEnseignant(idseance); //les ids utilisateurs sont des ids d enseignants
                   for(int j=0;j<id_utilisateurs.size();j++)
                   {
                       DAO<Utilisateur> Utilisateurdprof = new UtilisateurDAO(ConnexionSQL.getInstance());
                       Utilisateur userprof = Utilisateurdprof.find(id_utilisateurs.get(j));
                       nomProfsString += userprof.getNom();
                   }
                   nomProfs.setText(nomProfsString);
                   nomProfs.setFont(font);
                   nomProfs.setForeground(c);
                   
                   //On affiche promotion, groupes
                   JLabel promotionEtGroupe = new JLabel();
                   String promotionEtGroupeString = "";
                   int id_seance = seance.getId(); //l'id de la seance
                   int id_promotion = 0; //l'id de la promotion
                   DAO<Seance_Groupe> sgd = new Seance_GroupeDAO(ConnexionSQL.getInstance());
                   ArrayList<Integer> list_id_groupes = sgd.ComposerFindGroupe(id_seance); //la liste des id_groupe dans seance_groupe
                   for(int j=0;j<list_id_groupes.size();j++)
                   {
                       DAO<Groupe> grouped = new GroupeDAO(ConnexionSQL.getInstance());
                       Groupe groupe = grouped.find(list_id_groupes.get(j));
                       promotionEtGroupeString = promotionEtGroupeString + groupe.getNom() + " ";
                       id_promotion = groupe.getId_promotion();
                   }
                   DAO<Promotion> promotiond = new PromotionDAO(ConnexionSQL.getInstance());
                   Promotion prom = promotiond.find(id_promotion);
                   promotionEtGroupeString = promotionEtGroupeString + " - " + prom.getNom();
                   promotionEtGroupe.setText(promotionEtGroupeString);
                   promotionEtGroupe.setFont(font);
                   promotionEtGroupe.setForeground(c);
                   
                   //On affiche la salle, le site, le nbr de place
                   JLabel salleSiteCapacite = new JLabel();
                   String salleSiteCapaciteString = "";
                   String nomSalle = "";
                   String capaciteSalle = "";
                   String nomSite = "";
                   int id_seance2 = seance.getId(); //l'id de la seance
                   DAO<Seance_Salle> ssd = new Seance_SalleDAO(ConnexionSQL.getInstance());
                   Seance_Salle ss = ssd.find(id_seance2);
                   int id_salle = ss.getId_salle();
                   DAO<Salle> sd = new SalleDAO(ConnexionSQL.getInstance());
                   Salle s = sd.find(id_salle);
                   nomSalle += s.getNom();
                   capaciteSalle += s.getCapacite() + "";
                   int id_site = s.getId_site();
                   DAO<Site> sited = new SiteDAO(ConnexionSQL.getInstance());
                   Site site = sited.find(id_site);
                   nomSite = site.getNom();
                   salleSiteCapaciteString = nomSalle + " - " + nomSite + " (" + capaciteSalle + ")"; 
                   salleSiteCapacite.setText(salleSiteCapaciteString);
                   salleSiteCapacite.setFont(font);
                   salleSiteCapacite.setForeground(c);
                   
                   
                   
                   //On recupere le nbr de minutes que dure le cours pour agrandir en height le panel
                   //Changement de la dimension et de la hauteur du rectangle
                   Time ti = seance.getHeure_Debut();
                   Time tf = seance.getHeure_Fin();
                   long diffInMinutes = ((tf.getTime() - ti.getTime())/1000)/60; //la difference de temps entre cours en minutes, une minute = 1.034 height
                   Dimension dim = new Dimension();
                   dim.setSize(198,  1.03472222222 * diffInMinutes);
                   cours.setSize(dim);
                   long beginTimeCours = (ti.getTime()/1000)/60;
                   long huitHeureTrente = 510-60;
                   cours.setLocation(0, (int)(1.03472222222*(beginTimeCours-huitHeureTrente)));
                   
                   //On ajoute l'heure de début et l'heure de fin
                   JLabel heureLabel = new JLabel();
                   String heure = "";
                   heure += ti + " ~ " + tf;
                   heureLabel.setText(heure);
                   heureLabel.setFont(font);
                   heureLabel.setForeground(c);
                   
                   //On ajoutes tous les labels
                   gbc.gridx = 0;
                   gbc.gridy = 0;
                   cours.add(status, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 1;
                   cours.add(nomcours, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 2;
                   cours.add(nomProfs, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 3;
                   cours.add(promotionEtGroupe, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 4;
                   cours.add(salleSiteCapacite, gbc);
                   gbc.gridx = 0;
                   gbc.gridy = 5;
                   cours.add(heureLabel, gbc);
                   
                   //On ajoute au jour correspondant ce cours
                   panel.add(cours);
                }
            }
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    /**recupere les id_seances avec le nom de la promotion et le nom du groupe*/
    public ArrayList<Integer> getIdSeancesPromotion(String promotion, String nomGroupe)
    {
        ArrayList<Integer> id_seances = new ArrayList<>();
        try 
        {
            DAO<Promotion> promotiond = new PromotionDAO(ConnexionSQL.getInstance());
            int id_promotion = promotiond.ID(promotion);
            
            DAO<Groupe> grouped = new GroupeDAO(ConnexionSQL.getInstance());
            int id_groupe = grouped.GetUniqID(id_promotion, nomGroupe);
            
            DAO<Seance_Groupe> seance_grouped = new Seance_GroupeDAO(ConnexionSQL.getInstance());
            id_seances = seance_grouped.ComposerFindSeance(id_groupe);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id_seances;
    }
    
    /**recupere les id_seances avec le nom du site et le nom de la salle*/
    public ArrayList<Integer> getIdSeancesSite(String site, String salle)
    {
         ArrayList<Integer> id_seances = new ArrayList<>();
        try 
        {
            DAO<Site> sited = new SiteDAO(ConnexionSQL.getInstance());
            int id_site = sited.ID(site);
            
            DAO<Salle> salled = new SalleDAO(ConnexionSQL.getInstance());
            int id_salle = salled.GetUniqID(id_site, salle);
            
            DAO<Seance_Salle> seance_salled = new Seance_SalleDAO(ConnexionSQL.getInstance());
            id_seances = seance_salled.ComposerFindSeance(id_salle);
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id_seances;
    }
    
    public void MAJEdt(int numSemaine,JLabel anneeEdtLabel, JLabel lundiLabel, JLabel mardiLabel,JLabel mercrediLabel,JLabel jeudiLabel,JLabel vendrediLabel, JPanel lundiDisplayPanel, JPanel mardiDisplayPanel, JPanel mercrediDisplayPanel, JPanel jeudiDisplayPanel, JPanel vendrediDisplayPanel, String email, String password)
    {
        ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, numSemaine);
        ChangeAnneeProgramme(anneeEdtLabel, numSemaine);
        Draw(numSemaine, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }
    
    
    //////////////////////////////////////////////////////// RECAPITULATIF DE LA PERIODE //////////////////////////////////////////////////
    
    /** Mise a jour de la JTable du recapitulatif de la période*/
    public void MAJRecapPeriode(JTable table, String email, String password)
    {
        
        Object[] row = new Object[5];
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        //On recup l'utilisateur
        DAO<Utilisateur> Utilisateurd;
        try 
        {
            Utilisateurd = new UtilisateurDAO(ConnexionSQL.getInstance());
            Utilisateur user = Utilisateurd.find(email,password);
            int id_utilisateur = user.getId();
            int droit = user.getDroit();
            ArrayList<Integer> id_seances = new ArrayList<>();
            
            if(droit == 4) //etudiant
            {
                DAO<Etudiant> etudiantd = new EtudiantDAO(ConnexionSQL.getInstance());
                Etudiant etudiant = etudiantd.find(id_utilisateur);
                int id_groupe = etudiant.getId_groupe();
                
               
                DAO<Seance_Groupe> sgd = new Seance_GroupeDAO(ConnexionSQL.getInstance());
                id_seances = sgd.ComposerFindSeance(id_groupe);
                
                
                
            }
            else if(droit == 3) //enseignant
            {
                DAO<Seance_Enseignant> seance_enseignantd = new Seance_EnseignantDAO(ConnexionSQL.getInstance());
                id_seances = seance_enseignantd.ComposerFindSeance(id_utilisateur);
            }
            
            for(int i=0;i<id_seances.size();i++)
                {
                    DAO<Seance> seanced = new SeanceDAO(ConnexionSQL.getInstance());
                    Seance seance = seanced.find(id_seances.get(i)); //chaque seance
                    int id_cours = seance.getId_cours();
                    
                    DAO<Cours> coursd = new CoursDAO(ConnexionSQL.getInstance());
                    Cours cours = coursd.find(id_cours);
                    
                    String nomCours = cours.getNom(); //le nom du cours
                    
                    Date date = seance.getdate(); //la date du cours
                    
                    Time heureDebut = seance.getHeure_Debut();
                    Time heureFin = seance.getHeure_Fin();
                    
                    long longTimeDif = (heureFin.getTime() - heureDebut.getTime())/1000; //la durée totale de ce cours en secondes
                    float minutesDif = longTimeDif/60;
                    float heureDif = minutesDif/60;
                    
                    
                    
                    int nbrCours = 1; //on rajoute un cours en plus
                    
                    if(!existInTable(table, nomCours)) //Si n'existe pas dans la table, on rajoute cette ligne
                    {
                        row[0] = nomCours; //Un string
                        row[1] = date; // Une Date
                        row[2] = date; //Une date 
                        row[3] = heureDif; //un float
                        row[4] = nbrCours; //un int
                        model.addRow(row);
                    }
                    else //Sinon on recherche la ligne où ce cours est présent et on change les informations (le nom reste le meme)
                    {
                        int rowCount = table.getRowCount(); //le nbr de colonne
                        
                        for(int j=0; j<rowCount; j++)
                        {
                            String nomMatiereTable = table.getValueAt(j, 0).toString();
                            if(nomMatiereTable.equals(nomCours))
                            {
                                //On recupere et modifie la derniere seance et/ou/ou aucun la premiere seance 
                                Date premiereSeance = (Date)table.getValueAt(j, 1);
                                Date deuxiemeSeance = (Date)table.getValueAt(j, 2);
                                if(date.before(premiereSeance)) //Si la date du cours est avant celle de la table
                                {
                                    Object premSeance = date;
                                    table.setValueAt(premSeance, j, 1);
                                }
                                else if(date.after(deuxiemeSeance)) //Si la date du cours est apres celle de la table
                                {
                                    Object derSeance = date;
                                    table.setValueAt(derSeance, j, 2);
                                }
                                
                                //On recupere le temps total et on l'incremente
                                float tempsTotal = (Float)table.getValueAt(j, 3);
                                tempsTotal += heureDif;
                                Object tempsTotObj = tempsTotal;
                                table.setValueAt(tempsTotObj, j, 3);
                                
                                //On recupere le nbr de cours et on l'incremente
                                int nbrCoursTable = (Integer)table.getValueAt(j, 4);
                                nbrCoursTable += nbrCours;
                                Object nbrCoursTableObj = nbrCoursTable;
                                table.setValueAt(nbrCoursTableObj, j, 4);
                            }
                        }
                    }
                }
            
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table.setModel(model);
    }
    
    /** Si un string présent dans une jtable*/
    public boolean existInTable(JTable table, String nomMatiere)
    {
        boolean exist = false;
        
        // Get row and column count
        int colCount = table.getRowCount();
        
        for(int i=0; i<colCount; i++)
        {
            String nomMatiereInTable = table.getValueAt(i, 0).toString();
            if(nomMatiereInTable.equals(nomMatiere))
                return true;
        }
        
        return exist;
    }
    
    /** Change le message d'erreur pour la recap periode*/
    public void changeMessageLabelRecapPeriode(JComboBox etuEns, JLabel messageAChanger, JTable table)
    {
        String value = (String)etuEns.getSelectedItem();
        if(value != null)
        {
            messageAChanger.setText("Voici le résultat de votre recherche.");
            deleteAllRows((DefaultTableModel) table.getModel());
            MAJRecapPeriodeRefAdmin(table, etuEns);
        }
        else
        {
            messageAChanger.setText("ERREUR : le deuxième champ est vide");
        }
    }
    
    /** Recupere la valeur de la 1ere combobox, change la valeur de la 2e selon ce que choisis l'utilisateur*/
    public void changeRecapPeriodeSearch(JComboBox etuEns, JComboBox etuEnsValue)
    {   
        etuEnsValue.removeAllItems(); //Vide tous les elements
        
        String recherche = (String)etuEns.getSelectedItem();
        if(recherche == "Enseignant")
        {
            String nomEnseignant = "";
            
            try 
            {
                DAO<Enseignant> enseignantd = new EnseignantDAO(ConnexionSQL.getInstance());
                ArrayList<Integer> id_utilisateurs = enseignantd.FindEnseignant();
                
                for(int i=0; i<id_utilisateurs.size();i++)
                {
                    DAO<Utilisateur> utilisateurd = new UtilisateurDAO(ConnexionSQL.getInstance());
                    Utilisateur user = utilisateurd.find(id_utilisateurs.get(i));
                    nomEnseignant = user.getPrenom() + " " + user.getNom();
                    etuEnsValue.addItem(nomEnseignant);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(recherche == "Etudiant")
        {
            String nomEtudiant = "";
            try 
            {
                DAO<Etudiant> etudiantd = new EtudiantDAO(ConnexionSQL.getInstance());
                ArrayList<Integer> id_utilisateurs = etudiantd.FindEtudiant();
                
                for(int i=0; i<id_utilisateurs.size();i++)
                {
                    DAO<Utilisateur> utilisateurd = new UtilisateurDAO(ConnexionSQL.getInstance());
                    Utilisateur user = utilisateurd.find(id_utilisateurs.get(i));
                    nomEtudiant = user.getPrenom() + " " + user.getNom();
                    etuEnsValue.addItem(nomEtudiant);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void MAJRecapPeriodeRefAdmin(JTable table, JComboBox prenomNom)
    {
        String prenomNomString = (String)prenomNom.getSelectedItem();
        String[] splitted = prenomNomString.split("\\s+");
        String prenom = splitted[0];
        String nom = splitted[1];
        
        try 
        {
            DAO<Utilisateur> user = new UtilisateurDAO(ConnexionSQL.getInstance());
            ArrayList<String> emailPassword = user.FindEmailPasswd(nom,prenom); //premier element email, deuxieme mot de passe
            MAJRecapPeriode(table, emailPassword.get(0), emailPassword.get(1));
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /** Fonction pour vider une jtable, sauf l'entete */
    public static void deleteAllRows(final DefaultTableModel model) 
    {   
        for( int i = model.getRowCount() - 1; i >= 0; i-- ) {
            model.removeRow(i);
        }
    }
    
    
    ///////////: PARTIE ADMIN
    
    
    /** affiche les noms des profs selon le nombre qu on choisit */
    public void afficheEnseignantCB(JComboBox nbrEns ,JComboBox ens1, JComboBox ens2, JComboBox ens3, JComboBox ens4, JComboBox ens5)
    {
       String nbEnsS = nbrEns.getSelectedItem().toString();
        int nbEns = 1;
        try
        {
            nbEns = Integer.parseInt(nbEnsS);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Probleme conversion string en int : " + e.toString());
        }
        
        ens2.setVisible(false);
        ens3.setVisible(false);
        ens4.setVisible(false);
        ens5.setVisible(false);
        
        switch(nbEns)
        {
            case 1:
                ens1.setVisible(true);
                break;
            case 2:
                ens1.setVisible(true);
                ens2.setVisible(true);
                break;
            case 3:
                ens1.setVisible(true);
                ens2.setVisible(true);
                ens3.setVisible(true);
                break;
            case 4:
                ens1.setVisible(true);
                ens2.setVisible(true);
                ens3.setVisible(true);
                ens4.setVisible(true);
                break;
            case 5:
                ens1.setVisible(true);
                ens2.setVisible(true);
                ens3.setVisible(true);
                ens4.setVisible(true);
                ens5.setVisible(true);
                break;
            
        }
    }
    
    /** affiche les noms des profs selon le nombre qu on choisit */
    public void afficheTDCB(JComboBox nbrTd ,JComboBox td1, JComboBox td2, JComboBox td3, JComboBox td4, JComboBox td5, JComboBox td6, JComboBox td7, JComboBox td8, JComboBox td9, JComboBox td10)
    {
       String nbrTdS = nbrTd.getSelectedItem().toString();
        int nbrTdInt = 1;
        try
        {
            nbrTdInt = Integer.parseInt(nbrTdS);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Probleme conversion string en int : " + e.toString());
        }
        
        td1.setVisible(false);
        td2.setVisible(false);
        td3.setVisible(false);
        td4.setVisible(false);
        td5.setVisible(false);
        td6.setVisible(false);
        td7.setVisible(false);
        td8.setVisible(false);
        td9.setVisible(false);
        td10.setVisible(false);
        
        switch(nbrTdInt)
        {
            case 1:
                td1.setVisible(true);
                break;
            case 2:
                td1.setVisible(true);
                td2.setVisible(true);
                break;
            case 3:
                td1.setVisible(true);
                td2.setVisible(true);
                td3.setVisible(true);
                break;
            case 4:
                td1.setVisible(true);
                td2.setVisible(true);
                td3.setVisible(true);
                td4.setVisible(true);
                break;
            case 5:
                td1.setVisible(true);
                td2.setVisible(true);
                td3.setVisible(true);
                td4.setVisible(true);
                td5.setVisible(true);
                break;
            case 6:
                td1.setVisible(true);
                td2.setVisible(true);
                td3.setVisible(true);
                td4.setVisible(true);
                td5.setVisible(true);
                td6.setVisible(true);
                break;
            case 7:
                td1.setVisible(true);
                td2.setVisible(true);
                td3.setVisible(true);
                td4.setVisible(true);
                td5.setVisible(true);
                td6.setVisible(true);
                td7.setVisible(true);
                break;
            case 8:
                td1.setVisible(true);
                td2.setVisible(true);
                td3.setVisible(true);
                td4.setVisible(true);
                td5.setVisible(true);
                td6.setVisible(true);
                td7.setVisible(true);
                td8.setVisible(true);
                break;
            case 9:
                td1.setVisible(true);
                td2.setVisible(true);
                td3.setVisible(true);
                td4.setVisible(true);
                td5.setVisible(true);
                td6.setVisible(true);
                td7.setVisible(true);
                td8.setVisible(true);
                td9.setVisible(true);
                break;
            case 10:
                td1.setVisible(true);
                td2.setVisible(true);
                td3.setVisible(true);
                td4.setVisible(true);
                td5.setVisible(true);
                td6.setVisible(true);
                td7.setVisible(true);
                td8.setVisible(true);
                td9.setVisible(true);
                td10.setVisible(true);
                break;
        }
    }
    
    public void UpdateNomsEnseignant(JComboBox ens1, JComboBox ens2, JComboBox ens3, JComboBox ens4, JComboBox ens5)
    {
        ens1.removeAllItems();
        ens2.removeAllItems();
        ens3.removeAllItems();
        ens4.removeAllItems();
        ens5.removeAllItems();
        
        try 
        {
            DAO<Enseignant> enseignantd = new EnseignantDAO(ConnexionSQL.getInstance());
            ArrayList<Integer> enseignant = enseignantd.FindEnseignant();
            for(int i=0; i<enseignant.size();i++)
            {
                DAO<Utilisateur> utilisateurd = new UtilisateurDAO(ConnexionSQL.getInstance());
                Utilisateur user = utilisateurd.find(enseignant.get(i));
                String nomProf = user.getNom();
                
                ens1.addItem(nomProf);
                ens2.addItem(nomProf);
                ens3.addItem(nomProf);
                ens4.addItem(nomProf);
                ens5.addItem(nomProf);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(MiseAJourDonnees.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void UpdateNomPromotion(JComboBox promotionInsererCB)
    {
        
        //Promotion
        try 
        {
            DAO<Promotion> promotiond = new PromotionDAO(ConnexionSQL.getInstance());
            ArrayList<Integer> id_promotions = promotiond.FindPromotion();
            for(int i=0;i<id_promotions.size();i++)
            {
                Promotion promotion = promotiond.find(id_promotions.get(i));
                String nomPromo = promotion.getNom();
                promotionInsererCB.addItem(nomPromo);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(MiseAJourDonnees.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ChangeTdNom(JComboBox promotionInserer, JComboBox td1, JComboBox td2, JComboBox td3, JComboBox td4, JComboBox td5, JComboBox td6, JComboBox td7, JComboBox td8, JComboBox td9, JComboBox td10)
    {
        td1.removeAllItems();
        td2.removeAllItems();
        td3.removeAllItems();
        td4.removeAllItems();
        td5.removeAllItems();
        td6.removeAllItems();
        td7.removeAllItems();
        td8.removeAllItems();
        td9.removeAllItems();
        td10.removeAllItems();
        
        
        
        String nomPromotion = promotionInserer.getSelectedItem().toString();
        
        
        
        try 
        {
            DAO<Promotion> promotiond = new PromotionDAO(ConnexionSQL.getInstance());
            int id_promotion = promotiond.ID(nomPromotion);
            
            DAO<Groupe> grouped = new GroupeDAO(ConnexionSQL.getInstance());
            ArrayList<String> nomTdsList = grouped.ListInfo(id_promotion);
            for(int i=0;i<nomTdsList.size();i++)
            {
                
                td1.addItem(nomTdsList.get(i));
                td2.addItem(nomTdsList.get(i));
                td3.addItem(nomTdsList.get(i));
                td4.addItem(nomTdsList.get(i));
                td5.addItem(nomTdsList.get(i));
                td6.addItem(nomTdsList.get(i));
                td7.addItem(nomTdsList.get(i));
                td8.addItem(nomTdsList.get(i));
                td9.addItem(nomTdsList.get(i));
                td10.addItem(nomTdsList.get(i));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void UpdateSiteCB(JComboBox siteCB)
    {
        try 
        {
            DAO<Site> sited = new SiteDAO(ConnexionSQL.getInstance());
            ArrayList<Integer> list_id_sites = sited.FindSite();
            
            for(int i=0; i<list_id_sites.size(); i++)
            {
                Site site = sited.find(list_id_sites.get(i));
                String nomSite = site.getNom();
                
                siteCB.addItem(nomSite);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UpdateNomSalles(JComboBox siteCB, JComboBox salleCB)
    {
        String nomSite = siteCB.getSelectedItem().toString();
        salleCB.removeAllItems();
        
        try 
        {
            DAO<Site> sited = new SiteDAO(ConnexionSQL.getInstance());
            int id_site = sited.ID(nomSite);
            
            DAO<Salle> salled = new SalleDAO(ConnexionSQL.getInstance());
            ArrayList<String> nomDesSalles = salled.ListInfo(id_site);
            
            for(int i=0; i<nomDesSalles.size(); i++)
            {
                salleCB.addItem(nomDesSalles.get(i));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /** Rajoute les noms des cours dans la CB */
    public void UpdateNomsDesCours(JComboBox nomCoursCB)
    {
        nomCoursCB.removeAllItems();
        
        try 
        {
            DAO<Cours> coursd = new CoursDAO(ConnexionSQL.getInstance());
            ArrayList<Integer> list_id_cours = new ArrayList<>();
            
            for(int i = 0; i<list_id_cours.size(); i++)
            {
                Cours cours = coursd.find(list_id_cours.get(i));
                String nomDuCours = "";
                nomCoursCB.addItem(nomDuCours);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
