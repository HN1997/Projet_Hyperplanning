package package_controleur;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

public class DateTimeManager 
{
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
                                mois = "mais";
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
}
