
package package_controleur;

import java.util.Calendar;


public class Rechercheinformations {
    
    
    
    //Cette méthode renvoie la semaine actuelle à laquelle on est
        public int GetSemaine(){
            return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        }
}
