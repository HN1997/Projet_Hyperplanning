package package_controleur;

import com.orsoncharts.plot.PiePlot3D;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Locale;
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

/** Classe pour le menu Reporting */
public class Reporting 
{
    private RechercheInformationsHugo rih;
    
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
        
        if(droit.equals("Etudiant"))
        {
            panelToAddChart.removeAll();
            
            for(int i = 0 ; i<10; i++)
            {
                
                DefaultPieDataset pieSat = new DefaultPieDataset();
                pieSat.setValue("80", new Integer(80));
                pieSat.setValue("20", new Integer(20));
                JFreeChart chart = ChartFactory.createRingChart("Algo", pieSat, false, false, false);
                ChartPanel barPanel = new ChartPanel(chart);
                barPanel.setSize(250, 200);
                barPanel.setBackground(new Color(153,153,153));
                barPanel.setLocation( posx , posy );
                posx+=260;
                if(posx%1040==0)
                {
                    posx=0;
                    posy+=220;
                }
                panelToAddChart.add(barPanel);
                jsp.setBounds(0, 0, 10, 10);
            }
            
            
            
            panelToAddChart.validate();
        }
        
        
        else if(droit.equals("Enseignant"))
        {
            
        }
    }
}
