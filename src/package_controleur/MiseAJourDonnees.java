package package_controleur;

import java.sql.SQLException;
import package_modele.Seance;
import package_modele.*;
import java.lang.String;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class MiseAJourDonnees 
{
    private RechercheInformationsHugo rih;
    private ConnexionSQL connSQL;
    
    public MiseAJourDonnees()
    {
        rih = new RechercheInformationsHugo();
    }
    
    /** transforme un nom de mois en son entier en string ex : Janvier devient 01" */
    public String MoisToString(String mois)
    {
        String mois2 = "";
        
        if (mois.equalsIgnoreCase("Janvier")) {
            mois2 = "01";
        } else if (mois.equalsIgnoreCase("Février")) {
            mois2 = "02";
        } else if (mois.equalsIgnoreCase("Mars")) {
            mois2 = "03";
        } else if (mois.equalsIgnoreCase("Avril")) {
            mois2 = "04";
        } else if (mois.equalsIgnoreCase("Mai")) {
            mois2 = "05";
        } else if (mois.equalsIgnoreCase("Juin")) {
            mois2 = "06";
        } else if (mois.equalsIgnoreCase("Juillet")) {
            mois2 = "07";
        } else if (mois.equalsIgnoreCase("Août")) {
            mois2 = "08";
        } else if (mois.equalsIgnoreCase("Septembre")) {
            mois2 = "09";
        } else if (mois.equalsIgnoreCase("Octobre")) {
            mois2 = "10";
        } else if (mois.equalsIgnoreCase("Novembre")) {
            mois2 = "11";
        } else if (mois.equalsIgnoreCase("Décembre")) {
            mois2 = "12";
        }
        return mois2;
    }
    
    public String MoisToString2(String mois)
    {
        String mois2 = "";
        
        if (mois.equalsIgnoreCase("Janvier")) {
            mois2 = "0";
        } else if (mois.equalsIgnoreCase("Février")) {
            mois2 = "1";
        } else if (mois.equalsIgnoreCase("Mars")) {
            mois2 = "2";
        } else if (mois.equalsIgnoreCase("Avril")) {
            mois2 = "3";
        } else if (mois.equalsIgnoreCase("Mai")) {
            mois2 = "4";
        } else if (mois.equalsIgnoreCase("Juin")) {
            mois2 = "5";
        } else if (mois.equalsIgnoreCase("Juillet")) {
            mois2 = "6";
        } else if (mois.equalsIgnoreCase("Août")) {
            mois2 = "7";
        } else if (mois.equalsIgnoreCase("Septembre")) {
            mois2 = "8";
        } else if (mois.equalsIgnoreCase("Octobre")) {
            mois2 = "9";
        } else if (mois.equalsIgnoreCase("Novembre")) {
            mois2 = "10";
        } else if (mois.equalsIgnoreCase("Décembre")) {
            mois2 = "11";
        }
        return mois2;
    }
    
    /** Retourne true si le jour est ferie, code copie sur internet */
    public static boolean ferie(LocalDate date) {
		final int day = date.getDayOfMonth();
		switch (date.getMonth()) {
		case JANUARY:
			if (day == 1 || day == 6) {
				// Jour de l'an et Epiphanie
				return true;
			}
			break;
		case FEBRUARY:
			if (day == 14) {
				// St Valentin
				return true;
			}
			break;
		case MAY:
			if (day == 1 || day == 8) {
				// Fête du travail et Victoire 1945
				return true;
			}
			break;
		case JULY:
			if (day == 14) {
				// Fête Nationale
				return true;
			}
			break;
		case AUGUST:
			if (day == 15) {
				// Assomption
				return true;
			}
			break;
		case NOVEMBER:
			if (day == 1 || day == 11) {
				// Toussaint et Armistice 1918
				return true;
			}
			break;
		case DECEMBER:
			if (day == 25 || day == 31) {
				// Noël et Saint-sylvestre
				return true;
			}
			break;
		default:
		}
 
		if (date.getMonthValue() < 7) {
			// Avant juillet on doit aussi vérifier les fêtes liées à Paques
			LocalDate paques = date;
			int days = (int) ChronoUnit.DAYS.between(paques, date);
			switch (days) {
			case -47: // mardi gras : 47 jours avant Pâques
			case 0: // Paques
			case 1: // lundi de Pâques : 1 jour après Pâques
			case 39: // Ascension : 39 jours après Pâques
			case 50: // Pentecôte : 50 jours après Pâques
			case 51: // L. de Pentecôte : 51 jours après Paques
				return true;
			}
		}
		return false;
	}
    
    /** check si un jour est ok, renvoie true si il l'est */
    public boolean CheckDayOk(String jour, String mois, String annee)
    {
        boolean dayok = true;
        
        int jourInt;
        int moisInt = 0;
        int anneeInt;
        
        try
        {
            jourInt = Integer.parseInt(jour);
            if(mois.equalsIgnoreCase("Janvier"))
            {
                moisInt = 0;
                if(jourInt == 1 || jourInt == 6)
                {
                    dayok = false;
                }
            }
            else if(mois.equalsIgnoreCase("Février"))
            {
                moisInt = 1;
                if(jourInt == 14 || jourInt == 25 || jourInt == 29 || jourInt == 30 || jourInt == 31)
                {
                    dayok = false;
                }
            }
            else if(mois.equalsIgnoreCase("Mars"))
            {
                moisInt = 2;
            }
            else if(mois.equalsIgnoreCase("Avril"))
            {
                moisInt = 3;
                if(jourInt == 13 || jourInt == 31)
                {
                    dayok = false;
                }
            }
            else if(mois.equalsIgnoreCase("Mai") )
            {
                moisInt = 4;
                if(jourInt == 1 || jourInt == 8)
                {
                    dayok = false;
                }
            }
            else if(mois.equalsIgnoreCase("Juin"))
            {
                moisInt = 5;
                if(jourInt == 31)
                {
                    dayok = false;
                }
            }
            else if(mois.equalsIgnoreCase("Juillet"))
            {
                moisInt = 6;
                if(jourInt ==14)
                {
                    dayok = false;
                }
            }
            else if(mois.equalsIgnoreCase("Août"))
            {
                moisInt = 7;
                if(jourInt == 15)
                {
                    dayok = false;
                }
            }
            else if(mois.equalsIgnoreCase("Septembre"))
            {
                moisInt = 8;
                if(jourInt == 31)
                {
                    dayok = false;
                }
            }
            else if(mois.equalsIgnoreCase("Octobre"))
            {
                moisInt = 9;
            }
            else if(mois.equalsIgnoreCase("Novembre"))
            {
                moisInt = 10;
                if(jourInt == 1 || jourInt == 11 || jourInt == 30)
                {
                    dayok = false;
                }
            }
            else if(mois.equalsIgnoreCase("Décembre"))
            {
                moisInt = 11;
                if(jourInt == 25 || jourInt == 31)
                {
                    dayok = false;
                }
            }
            
            anneeInt = Integer.parseInt(annee);
            
            java.util.Date date = new GregorianCalendar(anneeInt, moisInt, jourInt).getTime();
            LocalDate date2 = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);

            
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY )
            {
                dayok = false;
            }
            
        }
        catch(NumberFormatException e)
        {
            System.out.println("Probleme conversion string en int : " + e.toString());
        }
        
        return dayok;
    }
    
    public boolean CheckTimeOk(long timeDif)
    {
        if(timeDif>=90)
        {
            return true;
        }
        else
            return false;
    }
    
    /** regarde si les profs sont differents, retourne true si c'est ok */
    public boolean CheckDifferentProf(int nbrProf, JComboBox prof1, JComboBox prof2, JComboBox prof3, JComboBox prof4, JComboBox prof5)
    {
        boolean ok = true;
        String prof1String = prof1.getSelectedItem().toString();
        String prof2String = prof2.getSelectedItem().toString();
        String prof3String = prof3.getSelectedItem().toString();
        String prof4String = prof4.getSelectedItem().toString();
        String prof5String = prof5.getSelectedItem().toString();
        
        if(nbrProf == 2)
        {
            if(prof1String.equalsIgnoreCase(prof2String))
            {
                return false;
            }
        }
        if(nbrProf == 3)
        {
            if(prof1String.equalsIgnoreCase(prof2String) || prof1String.equalsIgnoreCase(prof3String) || prof2String.equalsIgnoreCase(prof3String))
            {
                return false;
            }
        }
        if(nbrProf == 4)
        {
            if(prof1String.equalsIgnoreCase(prof2String) || prof1String.equalsIgnoreCase(prof3String) || prof1String.equalsIgnoreCase(prof4String) || prof2String.equalsIgnoreCase(prof3String) || prof2String.equalsIgnoreCase(prof4String) || prof3String.equalsIgnoreCase(prof4String))
            {
                return false;
            }
        }
        if(nbrProf == 5)
        {
            if(prof1String.equalsIgnoreCase(prof2String) || prof1String.equalsIgnoreCase(prof3String) || prof1String.equalsIgnoreCase(prof4String) || prof1String.equalsIgnoreCase(prof5String) || prof2String.equalsIgnoreCase(prof3String) || prof2String.equalsIgnoreCase(prof4String) || prof2String.equalsIgnoreCase(prof5String) || prof3String.equalsIgnoreCase(prof4String) || prof3String.equalsIgnoreCase(prof5String) ||  prof4String.equalsIgnoreCase(prof5String))
            {
                return false;
            }
        }
        
        return ok;
    }
    
    /** renvoie true si tous les td sont différents false sinon */
    public boolean CheckTDDifferent(JComboBox nbGroupe, JComboBox td1, JComboBox td2, JComboBox td3, JComboBox td4, JComboBox td5, JComboBox td6, JComboBox td7, JComboBox td8, JComboBox td9, JComboBox td10)
    {
        boolean ok = true;
        
        String nbGroupeString = nbGroupe.getSelectedItem().toString();
        String td1String = td1.getSelectedItem().toString();
        String td2String = td2.getSelectedItem().toString();
        String td3String = td3.getSelectedItem().toString();
        String td4String = td4.getSelectedItem().toString();
        String td5String = td5.getSelectedItem().toString();
        String td6String = td6.getSelectedItem().toString();
        String td7String = td7.getSelectedItem().toString();
        String td8String = td8.getSelectedItem().toString();
        String td9String = td9.getSelectedItem().toString();
        String td10String = td10.getSelectedItem().toString();
        
        int nbrGroupe = 1;
        
        try
        {
            nbrGroupe = Integer.parseInt(nbGroupeString);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Pb conversion string to int : " + e.toString());
        }
        
        if(nbrGroupe == 2)
        {
            if(td1String.equalsIgnoreCase(td2String))
            {
                ok = false;
            }
        }
        if(nbrGroupe == 3)
        {
            if(td1String.equalsIgnoreCase(td2String) || td1String.equalsIgnoreCase(td3String) || td2String.equalsIgnoreCase(td3String) )
            {
                ok = false;
            }
        }
        if(nbrGroupe == 4)
        {
            if(td1String.equalsIgnoreCase(td2String) || td1String.equalsIgnoreCase(td3String) || td1String.equalsIgnoreCase(td4String) || td1String.equalsIgnoreCase(td4String) || td2String.equalsIgnoreCase(td3String) || td2String.equalsIgnoreCase(td4String) || td3String.equalsIgnoreCase(td4String))
            {
                ok = false;
            }
        }
        
        return ok;
    }
    
    
    
    /** renvoie true si il est dispo */
    public boolean CheckDispo1Prof(JComboBox personne, String annee, String mois, String jour, Time hDebut, Time hFin)
    {
        boolean dispo = true;
        
        String nom = personne.getSelectedItem().toString();
        ArrayList<Integer> list_id_seance = new ArrayList<>();
        
        try 
        {
            DAO<Utilisateur> utilisateurd = new UtilisateurDAO(ConnexionSQL.getInstance());
            int iduser = utilisateurd.ID(nom);
            Utilisateur user = utilisateurd.find(iduser);
            
            DAO<Enseignant> enseignantd = new EnseignantDAO(ConnexionSQL.getInstance());
            int id_cours = enseignantd.find(iduser).getID_cours();

            DAO<Seance_Enseignant> seance_enseignantd = new Seance_EnseignantDAO(ConnexionSQL.getInstance());
            list_id_seance = seance_enseignantd.FindAllSeance(iduser, id_cours);

            if (!CheckHoraire(list_id_seance, annee, mois, jour, hDebut, hFin)) 
            {
                dispo = false;
            }
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(MiseAJourDonnees.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dispo;
    }
    
    /** renvoie true si il est dispo */
    public boolean CheckDispo1Groupe(JComboBox groupe, String annee, String mois, String jour, Time hDebut, Time hFin)
    {
        boolean dispo = true;
        
        String nom_groupe = groupe.getSelectedItem().toString();
        ArrayList<Integer> list_id_seance = new ArrayList<>();
        
        try 
        {
            DAO<Groupe> grouped = new GroupeDAO(ConnexionSQL.getInstance());
            int id_groupe = grouped.ID(nom_groupe);

            DAO<Seance_Groupe> seance_grouped = new Seance_GroupeDAO(ConnexionSQL.getInstance());
            list_id_seance = seance_grouped.ComposerFindSeance(id_groupe);
            
            if(!CheckHoraire(list_id_seance, annee, mois, jour, hDebut, hFin))
            {
                dispo = false;
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(MiseAJourDonnees.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dispo;
    }
    
    /** renvoie true si il est dispo */
    public boolean CheckDispoSalle(JComboBox salle, String annee, String mois, String jour, Time hDebut, Time hFin)
    {
        boolean dispo = true;
        
        String nom_salle = salle.getSelectedItem().toString();
        ArrayList<Integer> list_id_seance = new ArrayList<>();
        
        try 
        {
            DAO<Salle> salled = new SalleDAO(ConnexionSQL.getInstance());
            int id_salle = salled.ID(nom_salle);
            
            DAO<Seance_Salle> seance_salled = new Seance_SalleDAO(ConnexionSQL.getInstance());
            list_id_seance = seance_salled.ComposerFindSeance(id_salle);
            
            if(!CheckHoraire(list_id_seance, annee, mois, jour, hDebut, hFin))
            {
                dispo = false;
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(MiseAJourDonnees.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dispo;
    }
    
    /** renvoie true si l'horaire est disponible */
    public boolean CheckHoraire(ArrayList<Integer> list_id_seance, String annee, String mois, String jour, Time hDebut, Time hFin)
    {
        boolean ckeckOk = true;
        
        int anneeInt = Integer.parseInt(annee);
        int moisInt = Integer.parseInt(mois);
        int joursInt = Integer.parseInt(jour);
        Calendar cal = Calendar.getInstance();
        cal.set(anneeInt, moisInt, joursInt);
        Date dateD = new Date(cal.getTimeInMillis());
        java.sql.Date sqlDate = new java.sql.Date(dateD.getTime());
        
        for(int i=0; i<list_id_seance.size(); i++)
        {
            try 
            {
                DAO<Seance> seanced = new SeanceDAO(ConnexionSQL.getInstance());
                Seance seance = seanced.GetSeanceInfo(list_id_seance.get(i), sqlDate);
                if(seance.getHeure_Debut() != null && seance.getHeure_Fin()!= null)
                {
                    if(  !(hDebut.before(seance.getHeure_Debut()) && hFin.before(seance.getHeure_Debut()) ||  hDebut.after(seance.getHeure_Fin()) && hFin.after(seance.getHeure_Fin())) ) 
                    {
                        ckeckOk = false;
                    }
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(MiseAJourDonnees.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ckeckOk;
    }
    
    public boolean CheckDispoTous( JComboBox prof1, JComboBox etu1, JComboBox salle, String annee, String mois, String jour, Time hDebut, Time hFin)
    {
        if(CheckDispo1Prof(prof1, annee, mois, jour, hDebut, hFin) && CheckDispo1Groupe( etu1, annee, mois, jour, hDebut, hFin) && CheckDispoSalle( salle,  annee,  mois,  jour,  hDebut,  hFin))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    /** Fonction pour inserer un cours dans la bdd*/
    public void Insertion(JComboBox jour, JComboBox mois, JComboBox annee, JComboBox hdebut, JComboBox hfin, JComboBox typecours, JComboBox nbenseignant, JComboBox prof1, JComboBox prof2, JComboBox prof3, JComboBox prof4, JComboBox prof5, JComboBox nomPromo, JComboBox nbGroupe, JComboBox td1, JComboBox td2, JComboBox td3, JComboBox td4, JComboBox td5, JComboBox td6, JComboBox td7, JComboBox td8, JComboBox td9, JComboBox td10, JComboBox site, JComboBox salle, JComboBox nomCours, JLabel resumeInsertionLabel) 
    {
        //JOUR
       String jourStringBDD = jour.getSelectedItem().toString(); 
       String moisString = mois.getSelectedItem().toString(); //Janvier
       String moisStrinbBDD = MoisToString(moisString); //janvier c'est 01
       String moisStringString = MoisToString2(moisString); //0 = janvier
       String anneStringBDD = annee.getSelectedItem().toString(); 
       String date = anneStringBDD + "-" + moisStrinbBDD + "-" + jourStringBDD; // A ENVOYER
       int numSemaine = rih.DateStringToNumSem(jourStringBDD, moisString, anneStringBDD); //A ENVOYER
       
       //HEURE DEBUT HEURE FIN
       String hdebutStringBDD = hdebut.getSelectedItem().toString() + ":00"; //A ENVOYER
       Time timeDebut = Time.valueOf(hdebutStringBDD);
       String hfinStringBDD = hfin.getSelectedItem().toString() + ":00"; //A ENVOYER
       Time timeFin = Time.valueOf(hfinStringBDD);
       long diffInMinutes = ((timeFin.getTime()- timeDebut.getTime())/1000)/60; 
       
       //STATUT DU COURS
       String statusCours = "Valide"; // A ENVOYER
       
       //TYPE DE COURS
       String typeCours = typecours.getSelectedItem().toString();
       int id_typeBDD = 1; //A ENVOYER
        try 
        {
            DAO<Type_Cours> type_coursd = new Type_CoursDAO(ConnexionSQL.getInstance());
            id_typeBDD = type_coursd.ID(typeCours);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(MiseAJourDonnees.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //LES ENSEIGNANTS
        String nbEnsS = nbenseignant.getSelectedItem().toString();
        int nbEns = 1;
        try
        {
            nbEns = Integer.parseInt(nbEnsS);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Probleme conversion string en int : " + e.toString());
        }
        String ens1 = prof1.getSelectedItem().toString();
        String ens2 = prof2.getSelectedItem().toString();
        String ens3 = prof3.getSelectedItem().toString();
        String ens4 = prof4.getSelectedItem().toString();
        String ens5 = prof5.getSelectedItem().toString();
        
        //LES COULEURS
        ArrayList<Integer> rvb = new ArrayList<>(); 
        rvb.add(0, 110);
        rvb.add(0, 35);
        rvb.add(0, 72);
        
        // NOM DU COURS
        String nomDuCours = nomCours.getSelectedItem().toString();
        int id_cours = 1;
        try 
        {
            DAO<Cours> coursd = new CoursDAO(ConnexionSQL.getInstance());
            id_cours = coursd.ID(nomDuCours);
            rvb = coursd.ComposerFindSeance(id_cours);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(MiseAJourDonnees.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //COULEURS SUITE
        int rouge = rvb.get(0); //A ENVOYER
        int vert = rvb.get(1); //A ENVOYER
        int bleu = rvb.get(2); //A ENVOYER
        
        //LES GROUPES
        int nbrGroupeInt = 1;
        try
        {
            nbrGroupeInt = Integer.parseInt(nbGroupe.getSelectedItem().toString());
        }
        catch(NumberFormatException e)
        {
            System.out.println("erreur : " + e.toString());
        }
        String groupe1 =  td1.getSelectedItem().toString();
        String groupe2 =  td2.getSelectedItem().toString();
        String groupe3 =  td3.getSelectedItem().toString();
        String groupe4 =  td4.getSelectedItem().toString();
        String groupe5 =  td5.getSelectedItem().toString();
        String groupe6 =  td6.getSelectedItem().toString();
        String groupe7 =  td7.getSelectedItem().toString();
        String groupe8 =  td8.getSelectedItem().toString();
        String groupe9 =  td9.getSelectedItem().toString();
        String groupe10 = td10.getSelectedItem().toString();
        
        //SITE
        String siteS = site.getSelectedItem().toString();
        
        //SALLE
        String salleS = salle.getSelectedItem().toString();
        
       
       //On verifie : le créneau horaire est dispo pour prof + etudiant + salle -- le jour est ok -- le cours est bien >=90minutes -- on ne rentre jamais 2 fois le meme prof
       if(CheckDispoTous(prof1, td1, salle, anneStringBDD, moisStringString, jourStringBDD, timeDebut, timeFin) && CheckDayOk(jourStringBDD, moisString, anneStringBDD) && CheckTimeOk(diffInMinutes) && CheckDifferentProf(nbEns, prof1, prof2, prof3, prof4, prof5) && CheckTDDifferent(nbGroupe, td1, td2, td3, td4, td5, td6, td7, td8, td9, td10))
       {
           resumeInsertionLabel.setText("Insertion Effectuée!");
           
           //Creation d'une seance
           Seance seance = new Seance();
           boolean CheckCreationOk = true;
           int random = 1;
           do
           {
               random = (int)(Math.random()* 30001); //nbr aleat entre 1 et 30 000
               try 
               {
                   DAO<Seance> seanced = new SeanceDAO(ConnexionSQL.getInstance());
                   Seance seance2 = seanced.find(random);
                   if(seance2.getId() != 0) //si il existe deja une seance
                   {
                       CheckCreationOk = true;
                   }
                   else
                   {
                       CheckCreationOk = false;
                   }
               } 
               catch (SQLException ex) 
               {
                   Logger.getLogger(MiseAJourDonnees.class.getName()).log(Level.SEVERE, null, ex);
               }
               
               seance.setId(5000);
           }while(CheckCreationOk == true);
           
           seance.setId(random);
           seance.setSemaine(numSemaine);
           seance.setdate(date);
           seance.setHeure_Debut(hdebutStringBDD);
           seance.setHeure_Fin(hfinStringBDD);
           seance.setStatus(statusCours);
           seance.setR(rouge);
           seance.setV(vert);
           seance.setB(bleu);
           seance.setId_cours(id_cours);
           seance.setId_type(id_typeBDD);
           
           try 
           {
               DAO<Seance> seanced = new SeanceDAO(ConnexionSQL.getInstance());
               seanced.create(seance);
               int i = seance.getId();
               System.out.println(i);
           } 
           catch (SQLException ex) 
           {
               Logger.getLogger(MiseAJourDonnees.class.getName()).log(Level.SEVERE, null, ex);
           }
           
            //Creation d'une seance enseignant
            //Seance_Enseignant seance_enseignant = new Seance_Enseignant();
               
           //Creation d'une seance groupe
               
               
           //Creation d'une seance salle
       }
       else
       {
           resumeInsertionLabel.setText("Problème d'insertion.");
       }
       
       //CheckDispo1Prof(prof1, anneStringBDD, moisStringString, jourStringBDD, timeDebut, timeFin);
       //CheckDispo1Groupe(td1, anneStringBDD, moisStringString, jourStringBDD, timeDebut, timeFin);
       //CheckDispoSalle(salle, anneStringBDD, moisStringString, jourStringBDD, timeDebut, timeFin);
    }
}
      