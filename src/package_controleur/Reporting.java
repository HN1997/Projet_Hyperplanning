package package_controleur;

import javax.swing.JPanel;
import org.jfree.data.general.DefaultPieDataset;

/** Classe pour le menu Reporting */
public class Reporting 
{
    private RechercheInformationsHugo rih;
    
    public Reporting()
    {
        rih = new RechercheInformationsHugo();
    }
    
    /** Pour afficher les cours du reporting */
    public void AfficheCours(String email, String password)
    {
        String droit = rih.GetDroit(email, password);
        
        if(droit.equals("Etudiant"))
        {
            DefaultPieDataset pieSat = new DefaultPieDataset();
        }
        else if(droit.equals("Enseignant"))
        {
            
        }
    }
}
