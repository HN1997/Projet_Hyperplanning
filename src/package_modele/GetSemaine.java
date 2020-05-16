/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_modele;

import java.util.Calendar;

/**
 *
 * @author ShadowZeus
 */
public class GetSemaine {
    public static int getWeek() {
           return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
       }
    
}
