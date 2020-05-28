package package_controleur;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import package_modele.*;

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
                   
                   //On ajoute l'etat
                   JLabel status = new JLabel();
                   String statusString = seance.getStatus();
                   if(statusString == "ANNULE")
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
                   Type_Cours type_cours = type_coursd.find(seance.getId());
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
                   
                   //On ajoute le label de l'etat
                   JLabel status = new JLabel();
                   String statusString = seance.getStatus();
                   if(statusString == "ANNULE")
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
                   Type_Cours type_cours = type_coursd.find(seance.getId());
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
    
    public void changeMessageErreur(JLabel labelErreur, JComboBox jcbAChanger)
    {
        String labelErreurString = "";
        String recherche = (String)jcbAChanger.getSelectedItem();
        if(recherche == null)
        {
            labelErreurString = "ERREUR : Un des champs est vide!";
        }
        else
        {
            labelErreurString = "Voici les résultats de votre recherche.";
        }
        labelErreur.setText(labelErreurString);
    }
}
