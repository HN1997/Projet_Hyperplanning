package package_controleur;

import package_modele.ConnexionSQL;

public class MainTestHugo 
{
    public static void main(String[] args)
    {
        ConnexionSQL connsql = new ConnexionSQL();
        String email = "anand.maisuria@edu.ece.fr"; //Pour nos tests
        String password = "753"; //pour nos tests
    
    
        System.out.println(connsql.CheckTD(email, password));
        
        
    }
}
