package package_controleur;

import java.util.Calendar;
import java.util.Locale;
import package_modele.ConnexionSQL;

public class MainTestHugo 
{
    public static void main(String[] args)
    {
        ConnexionSQL connsql = new ConnexionSQL();
        String email = "anand.maisuria@edu.ece.fr"; //Pour nos tests
        String password = "753"; //pour nos tests
    
    
        Calendar cal = Calendar.getInstance( new Locale("fr","FR") );
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        System.out.println("SEMAINE ACTUELLE : " + cal.getTime());
        
        cal.setWeekDate(2020, 50, Calendar.WEDNESDAY);
        System.out.println("SEMAINE 20 : " +cal.getTime());
    }
}
