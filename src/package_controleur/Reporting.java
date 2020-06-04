package package_controleur;

import com.orsoncharts.plot.PiePlot3D;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JPanel;
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
    public void AfficheCours(String email, String password, JPanel panelToAddChart)
    {
        String droit = rih.GetDroit(email, password);
        
        if(droit.equals("Etudiant"))
        {
            DefaultPieDataset pieSat = new DefaultPieDataset();
            pieSat.setValue("One", new Integer(10));
            pieSat.setValue("Two", new Integer(20));
            pieSat.setValue("Three", new Integer(30));
            pieSat.setValue("Four", new Integer(40));
            JFreeChart chart = ChartFactory.createPieChart("Pie chart", pieSat, true, true, true);
            ChartPanel barPanel = new ChartPanel(chart);
            barPanel.setSize(200, 200);
            barPanel.setBackground(new Color(153,153,153));
            barPanel.setLocation(0, 0);
            
            RingPlot rp;
            
            
            panelToAddChart.removeAll();
            panelToAddChart.add(barPanel);
            panelToAddChart.validate();
        }
        else if(droit.equals("Enseignant"))
        {
            
        }
    }
}
