package package_controleur;

import java.sql.SQLException;
import package_modele.Seance;
import package_modele.*;
import java.lang.String;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MiseAJourDonnees 
{
    public void Insertion(String nom, String jour, String mois, String annee, String hdebut, String hfin, String type, String nbenseignant, String promo, String nbdegrp, String salle, String site) throws SQLException 
    {
        
        
        
        
            Seance u = new Seance();
       //u.setSemaine();      sDateCalendar.get(Calendar.WEEK_OF_YEAR);
       //u.setId();
       u.setdate("annee"+"-"+"mois"+"-"+"jour");
       u.setHeure_Debut("hdebut");
       u.setHeure_Fin("hfin");
       u.setStatus("Valide");
       u.setR(0);
       u.setV(0);
       u.setB(0);
       //int promotion = promotionDAO.ID(String);



    try
        {
            DAO<Cours> Coursd = new CoursDAO(ConnexionSQL.getInstance());
            int courss = Coursd.ID(nom);
       
       u.setId_cours(courss);
       
            
        }catch (SQLException ex) {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
     try
        {
            DAO<Cours> typed = new CoursDAO(ConnexionSQL.getInstance());
            int types = typed.ID(type);
       
       u.setId_type(types);
       
            
        }catch (SQLException ex) {
            Logger.getLogger(RechercheInformationsHugo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
    }
}
      