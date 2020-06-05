package package_controleur;

import com.orsoncharts.plot.PiePlot3D;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;
import package_modele.ConnexionSQL;
import package_modele.Cours;
import package_modele.CoursDAO;
import package_modele.DAO;
import package_modele.Enseignant;
import package_modele.EnseignantDAO;
import package_modele.Etudiant;
import package_modele.EtudiantDAO;
import package_modele.Seance;
import package_modele.SeanceDAO;
import package_modele.Seance_Enseignant;
import package_modele.Seance_EnseignantDAO;
import package_modele.Seance_Groupe;
import package_modele.Seance_GroupeDAO;
import package_modele.Utilisateur;
import package_modele.UtilisateurDAO;

/** Classe pour le menu Reporting */
public class Reporting 
{
    // Début des variables
    private ConnexionSQL connSQL;
    private RechercheInformationsHugo rih;
    // Fin des variables
    
    
    public Reporting()
    {
        rih = new RechercheInformationsHugo();
    }
    
    /** Pour afficher les cours du reporting */
    public void AfficheCours(String email, String password, JPanel panelToAddChart, JScrollPane jsp)
    {
        String droit = rih.GetDroit(email, password);
        int posx = 0;
        int posy = 0;
        
        
        try 
        {
            panelToAddChart.removeAll();
            
            DAO<Utilisateur> Utilisateurd = new UtilisateurDAO(ConnexionSQL.getInstance());
            Utilisateur user = Utilisateurd.find(email,password);
            int iduser = user.getId(); //id de l'utilisateur
            
            ArrayList<Integer> list_id_seances = new ArrayList<>(); //initialisation de la liste des id_seances 
            
            if(droit.equals("Etudiant"))
            {
                
                DAO<Etudiant> etudiantd = new EtudiantDAO(ConnexionSQL.getInstance());
                Etudiant etu = etudiantd.find(iduser);
                
                int idgroupe = etu.getId_groupe();
                
                DAO<Seance_Groupe> seance_grouped = new Seance_GroupeDAO(ConnexionSQL.getInstance());
                list_id_seances = seance_grouped.ComposerFindSeance(idgroupe); //Les listes des seances
                
            }
            else if(droit.equals("Enseignant"))
            {
                DAO<Enseignant> enseignantd = new EnseignantDAO(ConnexionSQL.getInstance());
                Enseignant Enseignant = enseignantd.find(iduser);
                int id_cours = Enseignant.getID_cours();
                
                DAO<Seance_Enseignant> sed = new Seance_EnseignantDAO(ConnexionSQL.getInstance());
                list_id_seances = sed.ComposerFindSeance(Enseignant.getId());
            }
            
            
            for(int i = 0 ; i<list_id_seances.size(); i++)
            {
                DAO<Seance> seanced = new SeanceDAO(ConnexionSQL.getInstance());
                Seance seance = seanced.find(list_id_seances.get(i));
                int id_cours = seance.getId_cours();
                
                DAO<Cours> coursd = new CoursDAO(ConnexionSQL.getInstance());
                Cours cours = coursd.find(id_cours);
                
                String nomducours = cours.getNom();
                
                
                DefaultPieDataset pieSat = new DefaultPieDataset();
                pieSat.setValue("80", new Integer(80));
                pieSat.setValue("20", new Integer(20));
                JFreeChart chart = ChartFactory.createRingChart(nomducours, pieSat, false, false, false);
                ChartPanel barPanel = new ChartPanel(chart);
                barPanel.setSize(250, 200);
                barPanel.setBackground(new Color(153,153,153));

                //Modification de l'emplacement du jfreechart
                barPanel.setLocation( posx , posy );
                posx+=260;
                if(posx%1040==0)
                {
                    posx=0;
                    posy+=220;
                }

                //On ajoute le panel contenant le jfreechart
                panelToAddChart.add(barPanel);

            }

            panelToAddChart.validate();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Reporting.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
