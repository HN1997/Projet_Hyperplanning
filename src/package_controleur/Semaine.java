/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_controleur;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author ShadowZeus
 */
public class Semaine {

    //Définition de toutes les variables 
    
    ArrayList<Cours> Lundi;
    ArrayList<Cours> Mardi;
    ArrayList<Cours> Mercredi;
    ArrayList<Cours> Jeudi;
    ArrayList<Cours> Vendredi;
    int idUtilisateur;
    
    
    
//Renvoie tous les cours pour le lundi    
    public ArrayList<Cours> GetLundi(int numSemaine) 
        {
        return null;
            
        }
    
//Renvoie tous les cours pour le mardi
        public ArrayList<Cours> GetMardi(int numSemaine) 
        {
        return null;
         
        }
        
//Renvoie tous les cours pour le Mercredi
        public ArrayList<Cours> GetMercredi(int numSemaine) 
        {
        return null;
            
        }
        
//Renvoie tous les cours pour le Jeudi
        public ArrayList<Cours> GetJeudi(int numSemaine) 
        {
        return null;
            
        }
        
//Renvoie tous les cours pour le vendredi
        public ArrayList<Cours> GetVendredi(int numSemaine) 
        {
        return null;
            
        }
        
        public ArrayList<Integer> GetNumSemaine(int Semaine) 
        {
        return null;
            
        }
        
        //Cette méthode renvoie la semaine actuelle à laquelle on est
        public int GetSemaineActuelle(){
            return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        }
        
        
        
    //Création du constructeur qui nous renvoie les cours par jour pour une semaine précise
    public Semaine(String email, String password){
                
    }
}
