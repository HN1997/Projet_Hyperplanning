package package_controleur;

import java.sql.SQLException;
import package_modele.Seance;
import package_modele.*;
import java.lang.String;
import java.sql.Time;
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
            mois = "01";
        } else if (mois.equalsIgnoreCase("Février")) {
            mois = "02";
        } else if (mois.equalsIgnoreCase("Mars")) {
            mois = "03";
        } else if (mois.equalsIgnoreCase("Avril")) {
            mois = "04";
        } else if (mois.equalsIgnoreCase("Mai")) {
            mois = "05";
        } else if (mois.equalsIgnoreCase("Juin")) {
            mois = "06";
        } else if (mois.equalsIgnoreCase("Juillet")) {
            mois = "07";
        } else if (mois.equalsIgnoreCase("Août")) {
            mois = "08";
        } else if (mois.equalsIgnoreCase("Septembre")) {
            mois = "09";
        } else if (mois.equalsIgnoreCase("Octobre")) {
            mois = "10";
        } else if (mois.equalsIgnoreCase("Novembre")) {
            mois = "11";
        } else if (mois.equalsIgnoreCase("Décembre")) {
            mois = "12";
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
            LocalDate date2 = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            
            
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || ferie(date2))
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
        String prof2String = prof1.getSelectedItem().toString();
        String prof3String = prof1.getSelectedItem().toString();
        String prof4String = prof1.getSelectedItem().toString();
        String prof5String = prof1.getSelectedItem().toString();
        
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
        String td2String = td1.getSelectedItem().toString();
        String td3String = td1.getSelectedItem().toString();
        String td4String = td1.getSelectedItem().toString();
        String td5String = td1.getSelectedItem().toString();
        String td6String = td1.getSelectedItem().toString();
        String td7String = td1.getSelectedItem().toString();
        String td8String = td1.getSelectedItem().toString();
        String td9String = td1.getSelectedItem().toString();
        String td10String = td1.getSelectedItem().toString();
        
        int nbrGroupe = 1;
        
        try
        {
            nbrGroupe = Integer.parseInt(nbGroupeString);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Pb conversion string to int : " + e.toString());
        }
        
        if(nbrGroupe == 1)
        {
            
        }
        
        return ok;
    }
    
    
    /** Fonction pour inserer un cours dans la bdd*/
    public void Insertion(JComboBox jour, JComboBox mois, JComboBox annee, JComboBox hdebut, JComboBox hfin, JComboBox typecours, JComboBox nbenseignant, JComboBox prof1, JComboBox prof2, JComboBox prof3, JComboBox prof4, JComboBox prof5, JComboBox nomPromo, JComboBox nbGroupe, JComboBox td1, JComboBox td2, JComboBox td3, JComboBox td4, JComboBox td5, JComboBox td6, JComboBox td7, JComboBox td8, JComboBox td9, JComboBox td10, JComboBox site, JComboBox salle, JTextField nomCours) 
    {
       String jourStringBDD = jour.getSelectedItem().toString(); //A ENVOYER
       String moisString = mois.getSelectedItem().toString();
       String moisStrinbBDD = MoisToString(moisString); //A ENVOYER
       String anneStringBDD = annee.getSelectedItem().toString(); //A ENVOYER
       int numSemaine = rih.DateStringToNumSem(jourStringBDD, moisString, anneStringBDD);
       
       String hdebutStringBDD = hdebut.getSelectedItem().toString() + ":00"; //A ENVOYER
       Time timeDebut = Time.valueOf(hdebutStringBDD);
       String hfinStringBDD = hfin.getSelectedItem().toString() + ":00"; //A ENVOYER
       Time timeFin = Time.valueOf(hfinStringBDD);
       long diffInMinutes = ((timeFin.getTime()- timeDebut.getTime())/1000)/60; //difference en minutes entre heure de fin et heure debut
       
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
        
        //Les enseignants
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
        
        
        
       
       
       //On verifie : le jour est ok -- le cours est bien >=90minutes -- on ne rentre jamais 2 fois le meme prof
       if(CheckDayOk(jourStringBDD, moisString, anneStringBDD) && CheckTimeOk(diffInMinutes) && CheckDifferentProf(nbEns, prof1, prof2, prof3, prof4, prof5))
       {
           
       }
       
    }
}
      