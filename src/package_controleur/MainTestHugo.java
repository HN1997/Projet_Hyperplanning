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
    
    
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
        cal.setWeekDate(2020, 20, Calendar.DAY_OF_WEEK);
        System.out.println(cal.getTime());
    }
}
