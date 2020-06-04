package package_controleur;

import java.util.Calendar;
import java.util.Locale;
import package_modele.ConnexionSQL;

public class MainTestHugo 
{
    public static void main(String[] args)
    {
        RechercheInformationsHugo rih = new RechercheInformationsHugo();
        
        int numSemaine = rih.DateStringToNumSem("4", "Juin", "2020");
        System.out.println(numSemaine);
    }
}
