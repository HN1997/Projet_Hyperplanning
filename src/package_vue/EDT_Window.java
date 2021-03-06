package package_vue;

import java.awt.Color;
import java.awt.Component;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import package_controleur.MiseAJourDonnees;
import package_controleur.RechercheInformations;
import package_controleur.Reporting;

public class EDT_Window extends javax.swing.JFrame {

    // Variables pour savoir quelle fenetre est ouverte
    private boolean edtSelected = true;
    private boolean recapSelected = false;
    private boolean majSelected = false;
    private boolean reportingSelected = false;
    // Fin
    
    
    // Variables pour savoir quelle categorie du gestionnaire de l'edt est ouverte
    private boolean insererBool = true;
    private boolean supprimerBool = false;
    private boolean modifierBool = false;
    // Fin
    
    //////////// Variable Rechercheinformations ////////////
    private RechercheInformations rih;
    private MiseAJourDonnees majDonnees;
    
    //////////// Variable Reporting ////////////
    private Reporting rep;
    
    
   //////////// EMAIL ET PASSWORD ////////////
    private String email;
    private String password;
    
    
    /** Initialise l'utilisateur */
    private void InitilisationUser(String email, String password)
    {
        rih = new RechercheInformations();
        rep = new Reporting();
        majDonnees = new MiseAJourDonnees();
        RechercheInformations.Clock(dateLabel, heureLabel); //Modifie l'heure et la date toutes les 1s
        InitialiseSemaine(rih.GetSemaine()); //Selectionne la semaine actuelle
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, RechercheInformations.GetSemaine()); //maj des labels semaines 
        rih.ChangeAnneeProgramme(anneeEdtLabel, RechercheInformations.GetSemaine()); //maj de l'annee 
        
        nameUserLabel.setText(rih.GetPrenomNom(email, password)); //Change le prenom nom de l'utilsateur
        droitLabel.setText(rih.GetDroit(email, password)); //Change le droit pas ex "etudiant"
        promotionLabel.setText(rih.getPromotion(email, password)); //Change la promotion
        tdLabel.setText(rih.getTD(email, password)); //Change le groupe
        
        recapEdtSearch3.setVisible(false);
        
        if(droitLabel.getText()!="Administrateur") //Si c'est un etudiant ou un prof ou un ref pedg on desactive le panel gestionnaire edt 
        {
            gestionnaireLabel.setVisible(false);
            gestionnaireLabel.setEnabled(false);
            gestionnairePanel.setVisible(false);
            gestionnairePanel.setEnabled(false);
            
            
        }
        
        if(droitLabel.getText()=="Etudiant" || droitLabel.getText()=="Enseignant") //Si c'est un etudiant ou un enseignant on desactive la recherche dans reporting et recap période et on met a jour la jtable du recap periode
        {
            recapPeriodeTriPanel.setVisible(false);
            recapPeriodeTriPanel.setEnabled(false);
            
            reportingPeriodeTriPanel.setVisible(false);
            reportingPeriodeTriPanel.setEnabled(false);
            
            rih.MAJRecapPeriode(recapTable, email, password); //mise à jour de la jtable
            rep.AfficheCours(email, password, reportingResumePanel2);
        }
        
        if(droitLabel.getText()=="Administrateur" || droitLabel.getText()=="Référent Pédagogique") //si c'est un admin ou ref ped, on change la fenetre de la semaine 
        {
            semainePickerPanel.setVisible(false);
            semainePickerPanel.setEnabled(false);
            
            adminRespoEdtPanel.setVisible(true);
            adminRespoEdtPanel.setEnabled(true);
        }
        
        //Partie admin
        enseignantCB2.setVisible(false);
        enseignantCB3.setVisible(false);
        enseignantCB4.setVisible(false);
        enseignantCB5.setVisible(false);
        tdCB2.setVisible(false);
        tdCB3.setVisible(false);
        tdCB4.setVisible(false);
        tdCB5.setVisible(false);
        tdCB6.setVisible(false);
        tdCB7.setVisible(false);
        tdCB8.setVisible(false);
        tdCB9.setVisible(false);
        tdCB10.setVisible(false);
        rih.UpdateNomsEnseignant(enseignantCB1, enseignantCB2, enseignantCB3, enseignantCB4, enseignantCB5);
        rih.UpdateNomPromotion(promotionInsererCB);
        rih.UpdateSiteCB(siteCB);
        rih.UpdateNomsDesCours(salleCB1);
        rih.changeRecapPeriodeSearch(recapSearch1, recapSearch2);
        rih.changeRecapPeriodeSearch(reportingSearch1, reportingSearch2);
    }
    
    //Fin initialisation du User
    
    /**
     * Creates new form EDT_Window
     */
    public EDT_Window(String email, String password) {
        this.email = email;
        this.password = password;
        initComponents();
        InitilisationUser(email, password);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        firstBackgroundPanel = new javax.swing.JPanel();
        leftGreenPanel = new javax.swing.JPanel();
        iconEce = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        welcomeLabel = new javax.swing.JLabel();
        nameUserLabel = new javax.swing.JLabel();
        droitLabel = new javax.swing.JLabel();
        promotionLabel = new javax.swing.JLabel();
        tdLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        emploidutempsLabel = new javax.swing.JLabel();
        recapitulatifLabel = new javax.swing.JLabel();
        reportingLabel = new javax.swing.JLabel();
        gestionnaireLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        dateLabel = new javax.swing.JLabel();
        heureLabel = new javax.swing.JLabel();
        deconnexionLabel = new javax.swing.JLabel();
        rightCardPanel = new javax.swing.JPanel();
        edtPanel = new javax.swing.JPanel();
        topEdtPanel = new javax.swing.JPanel();
        semainePickerPanel = new javax.swing.JPanel();
        semaine31 = new javax.swing.JToggleButton();
        semaine32 = new javax.swing.JToggleButton();
        semaine33 = new javax.swing.JToggleButton();
        semaine34 = new javax.swing.JToggleButton();
        semaine35 = new javax.swing.JToggleButton();
        semaine36 = new javax.swing.JToggleButton();
        semaine37 = new javax.swing.JToggleButton();
        semaine38 = new javax.swing.JToggleButton();
        semaine39 = new javax.swing.JToggleButton();
        semaine40 = new javax.swing.JToggleButton();
        semaine41 = new javax.swing.JToggleButton();
        semaine42 = new javax.swing.JToggleButton();
        semaine43 = new javax.swing.JToggleButton();
        semaine44 = new javax.swing.JToggleButton();
        semaine45 = new javax.swing.JToggleButton();
        semaine46 = new javax.swing.JToggleButton();
        semaine47 = new javax.swing.JToggleButton();
        semaine48 = new javax.swing.JToggleButton();
        semaine49 = new javax.swing.JToggleButton();
        semaine50 = new javax.swing.JToggleButton();
        semaine51 = new javax.swing.JToggleButton();
        semaine52 = new javax.swing.JToggleButton();
        semaine1 = new javax.swing.JToggleButton();
        semaine2 = new javax.swing.JToggleButton();
        semaine3 = new javax.swing.JToggleButton();
        semaine4 = new javax.swing.JToggleButton();
        semaine5 = new javax.swing.JToggleButton();
        semaine6 = new javax.swing.JToggleButton();
        semaine7 = new javax.swing.JToggleButton();
        semaine8 = new javax.swing.JToggleButton();
        semaine9 = new javax.swing.JToggleButton();
        semaine10 = new javax.swing.JToggleButton();
        semaine11 = new javax.swing.JToggleButton();
        semaine12 = new javax.swing.JToggleButton();
        semaine13 = new javax.swing.JToggleButton();
        semaine14 = new javax.swing.JToggleButton();
        semaine15 = new javax.swing.JToggleButton();
        semaine16 = new javax.swing.JToggleButton();
        semaine17 = new javax.swing.JToggleButton();
        semaine18 = new javax.swing.JToggleButton();
        semaine19 = new javax.swing.JToggleButton();
        semaine20 = new javax.swing.JToggleButton();
        semaine21 = new javax.swing.JToggleButton();
        semaine22 = new javax.swing.JToggleButton();
        semaine23 = new javax.swing.JToggleButton();
        semaine24 = new javax.swing.JToggleButton();
        semaine25 = new javax.swing.JToggleButton();
        semaine26 = new javax.swing.JToggleButton();
        semaine27 = new javax.swing.JToggleButton();
        semaine28 = new javax.swing.JToggleButton();
        semaine29 = new javax.swing.JToggleButton();
        semaine30 = new javax.swing.JToggleButton();
        adminRespoEdtPanel = new javax.swing.JPanel();
        trierparEdtLabel = new javax.swing.JLabel();
        semainePickerCB = new javax.swing.JComboBox<>();
        recapEdtSearch = new javax.swing.JComboBox<>();
        recapEdtSearch2 = new javax.swing.JComboBox<>();
        recapEdtSearch3 = new javax.swing.JComboBox<>();
        recapEdtRechercherButton = new javax.swing.JButton();
        recapMessageErreurEdt = new javax.swing.JLabel();
        edtPanelBotRight = new javax.swing.JPanel();
        edtDisplayPanel = new javax.swing.JPanel();
        lundiDisplayPanel = new javax.swing.JPanel();
        mardiDisplayPanel = new javax.swing.JPanel();
        mercrediDisplayPanel = new javax.swing.JPanel();
        jeudiDisplayPanel = new javax.swing.JPanel();
        vendrediDisplayPanel = new javax.swing.JPanel();
        lundiLabel = new javax.swing.JLabel();
        mardiLabel = new javax.swing.JLabel();
        mercrediLabel = new javax.swing.JLabel();
        jeudiLabel = new javax.swing.JLabel();
        vendrediLabel = new javax.swing.JLabel();
        huitLabel = new javax.swing.JLabel();
        neufLabel = new javax.swing.JLabel();
        dixLabel = new javax.swing.JLabel();
        onzeLabel = new javax.swing.JLabel();
        douzeLabel = new javax.swing.JLabel();
        treizeLabel = new javax.swing.JLabel();
        quatorzeLabel = new javax.swing.JLabel();
        quinzeLabel = new javax.swing.JLabel();
        seizeLabel = new javax.swing.JLabel();
        dixseptLabel = new javax.swing.JLabel();
        dixhuitLabel = new javax.swing.JLabel();
        dixneufLabel = new javax.swing.JLabel();
        vingtLabel = new javax.swing.JLabel();
        anneeEdtLabel = new javax.swing.JLabel();
        recapPanel = new javax.swing.JPanel();
        topRecapPanel = new javax.swing.JPanel();
        recapPeriodeLabelTop = new javax.swing.JLabel();
        recapPeriodeTriPanel = new javax.swing.JPanel();
        trierparRecapLabel = new javax.swing.JLabel();
        recapSearch1 = new javax.swing.JComboBox<>();
        recapSearch2 = new javax.swing.JComboBox<>();
        recapRechercherButton = new javax.swing.JButton();
        recapMessageErreur = new javax.swing.JLabel();
        recapScrollPane = new javax.swing.JScrollPane();
        recapTable = new javax.swing.JTable();
        reportingPanel = new javax.swing.JPanel();
        topReportingPanel1 = new javax.swing.JPanel();
        ReportingLabelTop = new javax.swing.JLabel();
        reportingPeriodeTriPanel = new javax.swing.JPanel();
        trierparReportingLabel = new javax.swing.JLabel();
        reportingSearch1 = new javax.swing.JComboBox<>();
        reportingSearch2 = new javax.swing.JComboBox<>();
        reportingRechercherButton = new javax.swing.JButton();
        reportingMessageErreur = new javax.swing.JLabel();
        reportingResumePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportingResumePanel2 = new javax.swing.JPanel();
        gestionnairePanel = new javax.swing.JPanel();
        topgestionnairePanel = new javax.swing.JPanel();
        topGestionnaireLabel = new javax.swing.JLabel();
        insererLabel = new javax.swing.JLabel();
        modifierLabel = new javax.swing.JLabel();
        separatorGEDT2 = new javax.swing.JSeparator();
        gestionnaireContainerPanel = new javax.swing.JPanel();
        insererPanel = new javax.swing.JPanel();
        jourLabel = new javax.swing.JLabel();
        jourCB = new javax.swing.JComboBox<>();
        moisLabel = new javax.swing.JLabel();
        moisCB = new javax.swing.JComboBox<>();
        anneeLabel = new javax.swing.JLabel();
        anneeCB = new javax.swing.JComboBox<>();
        heureDebutlabel = new javax.swing.JLabel();
        heureDebutCB = new javax.swing.JComboBox<>();
        heureFinlabel = new javax.swing.JLabel();
        heureFinCB = new javax.swing.JComboBox<>();
        typeCoursLabel = new javax.swing.JLabel();
        typeCoursCB = new javax.swing.JComboBox<>();
        nbrEnseignantLabel = new javax.swing.JLabel();
        nbrEnseignantCB = new javax.swing.JComboBox<>();
        virguleEnseignantLabel = new javax.swing.JLabel();
        enseignantCB1 = new javax.swing.JComboBox<>();
        enseignantCB2 = new javax.swing.JComboBox<>();
        enseignantCB3 = new javax.swing.JComboBox<>();
        enseignantCB4 = new javax.swing.JComboBox<>();
        enseignantCB5 = new javax.swing.JComboBox<>();
        promotionInsererLabel = new javax.swing.JLabel();
        promotionInsererCB = new javax.swing.JComboBox<>();
        nbrGroupeLabel = new javax.swing.JLabel();
        nbrGroupeCB = new javax.swing.JComboBox<>();
        virguleEnseignantLabel1 = new javax.swing.JLabel();
        tdCB1 = new javax.swing.JComboBox<>();
        tdCB2 = new javax.swing.JComboBox<>();
        tdCB3 = new javax.swing.JComboBox<>();
        tdCB4 = new javax.swing.JComboBox<>();
        tdCB5 = new javax.swing.JComboBox<>();
        tdCB6 = new javax.swing.JComboBox<>();
        tdCB7 = new javax.swing.JComboBox<>();
        tdCB8 = new javax.swing.JComboBox<>();
        tdCB9 = new javax.swing.JComboBox<>();
        tdCB10 = new javax.swing.JComboBox<>();
        siteLabel = new javax.swing.JLabel();
        siteCB = new javax.swing.JComboBox<>();
        salleLabel = new javax.swing.JLabel();
        salleCB = new javax.swing.JComboBox<>();
        insererButton = new javax.swing.JButton();
        resumeInsertionLabel = new javax.swing.JLabel();
        nomDuCoursLabel = new javax.swing.JLabel();
        salleCB1 = new javax.swing.JComboBox<>();
        modifierPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Emploi du temps");
        setResizable(false);

        firstBackgroundPanel.setBackground(new java.awt.Color(204, 204, 204));

        leftGreenPanel.setBackground(new java.awt.Color(0, 113, 121));

        iconEce.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ece_250.png"))); // NOI18N

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        welcomeLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(204, 204, 204));
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Bienvenue,");

        nameUserLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        nameUserLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameUserLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameUserLabel.setText("Hugo Navillod");

        droitLabel.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        droitLabel.setForeground(new java.awt.Color(204, 204, 204));
        droitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        droitLabel.setText("Etudiant");

        promotionLabel.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        promotionLabel.setForeground(new java.awt.Color(204, 204, 204));
        promotionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        promotionLabel.setText("ING1");

        tdLabel.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        tdLabel.setForeground(new java.awt.Color(204, 204, 204));
        tdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tdLabel.setText("TD05");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        emploidutempsLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        emploidutempsLabel.setForeground(new java.awt.Color(255, 255, 255));
        emploidutempsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emploidutempsLabel.setText("Emploi Du Temps");
        emploidutempsLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        emploidutempsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emploidutempsLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emploidutempsLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emploidutempsLabelMouseExited(evt);
            }
        });

        recapitulatifLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        recapitulatifLabel.setForeground(new java.awt.Color(153, 153, 153));
        recapitulatifLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recapitulatifLabel.setText("Récapitulatif Période");
        recapitulatifLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recapitulatifLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recapitulatifLabelMouseClicked(evt);
            }
        });

        reportingLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        reportingLabel.setForeground(new java.awt.Color(153, 153, 153));
        reportingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reportingLabel.setText("Reporting");
        reportingLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportingLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportingLabelMouseClicked(evt);
            }
        });

        gestionnaireLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        gestionnaireLabel.setForeground(new java.awt.Color(153, 153, 153));
        gestionnaireLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gestionnaireLabel.setText("Gestionnaire EDT");
        gestionnaireLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestionnaireLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gestionnaireLabelMouseClicked(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));

        dateLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("16 Mai 2020");

        heureLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        heureLabel.setForeground(new java.awt.Color(255, 255, 255));
        heureLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heureLabel.setText("17:30:49");

        deconnexionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deconnexionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DeconnexionIcon_50.png"))); // NOI18N
        deconnexionLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deconnexionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deconnexionLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout leftGreenPanelLayout = new javax.swing.GroupLayout(leftGreenPanel);
        leftGreenPanel.setLayout(leftGreenPanelLayout);
        leftGreenPanelLayout.setHorizontalGroup(
            leftGreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nameUserLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deconnexionLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(emploidutempsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(recapitulatifLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftGreenPanelLayout.createSequentialGroup()
                .addComponent(iconEce)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(droitLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(gestionnaireLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reportingLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftGreenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftGreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(promotionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(heureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        leftGreenPanelLayout.setVerticalGroup(
            leftGreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftGreenPanelLayout.createSequentialGroup()
                .addComponent(iconEce, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcomeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameUserLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(droitLabel)
                .addGap(5, 5, 5)
                .addComponent(promotionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tdLabel)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emploidutempsLabel)
                .addGap(18, 18, 18)
                .addComponent(recapitulatifLabel)
                .addGap(18, 18, 18)
                .addComponent(reportingLabel)
                .addGap(18, 18, 18)
                .addComponent(gestionnaireLabel)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heureLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deconnexionLabel)
                .addContainerGap())
        );

        rightCardPanel.setLayout(new java.awt.CardLayout());

        topEdtPanel.setBackground(new java.awt.Color(0, 113, 121));
        topEdtPanel.setForeground(new java.awt.Color(0, 113, 121));
        topEdtPanel.setLayout(new java.awt.CardLayout());

        semainePickerPanel.setBackground(new java.awt.Color(0, 113, 121));
        semainePickerPanel.setForeground(new java.awt.Color(0, 113, 121));
        semainePickerPanel.setLayout(new java.awt.GridLayout(3, 10, 5, 5));

        semaine31.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine31);
        semaine31.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine31.setForeground(new java.awt.Color(255, 255, 255));
        semaine31.setText("31");
        semaine31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine31ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine31);

        semaine32.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine32);
        semaine32.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine32.setForeground(new java.awt.Color(255, 255, 255));
        semaine32.setText("32");
        semaine32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine32ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine32);

        semaine33.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine33);
        semaine33.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine33.setForeground(new java.awt.Color(255, 255, 255));
        semaine33.setText("33");
        semaine33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine33ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine33);

        semaine34.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine34);
        semaine34.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine34.setForeground(new java.awt.Color(255, 255, 255));
        semaine34.setText("34");
        semaine34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine34ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine34);

        semaine35.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine35);
        semaine35.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine35.setForeground(new java.awt.Color(255, 255, 255));
        semaine35.setText("35");
        semaine35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine35ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine35);

        semaine36.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine36);
        semaine36.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine36.setForeground(new java.awt.Color(255, 255, 255));
        semaine36.setText("36");
        semaine36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine36ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine36);

        semaine37.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine37);
        semaine37.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine37.setForeground(new java.awt.Color(255, 255, 255));
        semaine37.setText("37");
        semaine37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine37ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine37);

        semaine38.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine38);
        semaine38.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine38.setForeground(new java.awt.Color(255, 255, 255));
        semaine38.setText("38");
        semaine38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine38ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine38);

        semaine39.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine39);
        semaine39.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine39.setForeground(new java.awt.Color(255, 255, 255));
        semaine39.setText("39");
        semaine39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine39ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine39);

        semaine40.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine40);
        semaine40.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine40.setForeground(new java.awt.Color(255, 255, 255));
        semaine40.setText("40");
        semaine40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine40ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine40);

        semaine41.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine41);
        semaine41.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine41.setForeground(new java.awt.Color(255, 255, 255));
        semaine41.setText("41");
        semaine41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine41ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine41);

        semaine42.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine42);
        semaine42.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine42.setForeground(new java.awt.Color(255, 255, 255));
        semaine42.setText("42");
        semaine42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine42ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine42);

        semaine43.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine43);
        semaine43.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine43.setForeground(new java.awt.Color(255, 255, 255));
        semaine43.setText("43");
        semaine43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine43.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine43ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine43);

        semaine44.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine44);
        semaine44.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine44.setForeground(new java.awt.Color(255, 255, 255));
        semaine44.setText("44");
        semaine44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine44.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine44ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine44);

        semaine45.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine45);
        semaine45.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine45.setForeground(new java.awt.Color(255, 255, 255));
        semaine45.setText("45");
        semaine45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine45.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine45ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine45);

        semaine46.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine46);
        semaine46.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine46.setForeground(new java.awt.Color(255, 255, 255));
        semaine46.setText("46");
        semaine46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine46.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine46ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine46);

        semaine47.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine47);
        semaine47.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine47.setForeground(new java.awt.Color(255, 255, 255));
        semaine47.setText("47");
        semaine47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine47.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine47ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine47);

        semaine48.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine48);
        semaine48.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine48.setForeground(new java.awt.Color(255, 255, 255));
        semaine48.setText("48");
        semaine48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine48.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine48ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine48);

        semaine49.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine49);
        semaine49.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine49.setForeground(new java.awt.Color(255, 255, 255));
        semaine49.setText("49");
        semaine49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine49.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine49ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine49);

        semaine50.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine50);
        semaine50.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine50.setForeground(new java.awt.Color(255, 255, 255));
        semaine50.setText("50");
        semaine50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine50.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine50ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine50);

        semaine51.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine51);
        semaine51.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine51.setForeground(new java.awt.Color(255, 255, 255));
        semaine51.setText("51");
        semaine51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine51.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine51ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine51);

        semaine52.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine52);
        semaine52.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine52.setForeground(new java.awt.Color(255, 255, 255));
        semaine52.setText("52");
        semaine52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine52.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine52ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine52);

        semaine1.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine1);
        semaine1.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine1.setForeground(new java.awt.Color(255, 255, 255));
        semaine1.setText("1");
        semaine1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine1ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine1);

        semaine2.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine2);
        semaine2.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine2.setForeground(new java.awt.Color(255, 255, 255));
        semaine2.setText("2");
        semaine2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine2ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine2);

        semaine3.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine3);
        semaine3.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine3.setForeground(new java.awt.Color(255, 255, 255));
        semaine3.setText("3");
        semaine3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine3ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine3);

        semaine4.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine4);
        semaine4.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine4.setForeground(new java.awt.Color(255, 255, 255));
        semaine4.setText("4");
        semaine4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine4ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine4);

        semaine5.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine5);
        semaine5.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine5.setForeground(new java.awt.Color(255, 255, 255));
        semaine5.setText("5");
        semaine5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine5ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine5);

        semaine6.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine6);
        semaine6.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine6.setForeground(new java.awt.Color(255, 255, 255));
        semaine6.setText("6");
        semaine6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine6ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine6);

        semaine7.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine7);
        semaine7.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine7.setForeground(new java.awt.Color(255, 255, 255));
        semaine7.setText("7");
        semaine7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine7ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine7);

        semaine8.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine8);
        semaine8.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine8.setForeground(new java.awt.Color(255, 255, 255));
        semaine8.setText("8");
        semaine8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine8ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine8);

        semaine9.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine9);
        semaine9.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine9.setForeground(new java.awt.Color(255, 255, 255));
        semaine9.setText("9");
        semaine9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine9ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine9);

        semaine10.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine10);
        semaine10.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine10.setForeground(new java.awt.Color(255, 255, 255));
        semaine10.setText("10");
        semaine10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine10ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine10);

        semaine11.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine11);
        semaine11.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine11.setForeground(new java.awt.Color(255, 255, 255));
        semaine11.setText("11");
        semaine11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine11ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine11);

        semaine12.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine12);
        semaine12.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine12.setForeground(new java.awt.Color(255, 255, 255));
        semaine12.setText("12");
        semaine12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine12ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine12);

        semaine13.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine13);
        semaine13.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine13.setForeground(new java.awt.Color(255, 255, 255));
        semaine13.setText("13");
        semaine13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine13ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine13);

        semaine14.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine14);
        semaine14.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine14.setForeground(new java.awt.Color(255, 255, 255));
        semaine14.setText("14");
        semaine14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine14ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine14);

        semaine15.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine15);
        semaine15.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine15.setForeground(new java.awt.Color(255, 255, 255));
        semaine15.setText("15");
        semaine15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine15ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine15);

        semaine16.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine16);
        semaine16.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine16.setForeground(new java.awt.Color(255, 255, 255));
        semaine16.setText("16");
        semaine16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine16ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine16);

        semaine17.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine17);
        semaine17.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine17.setForeground(new java.awt.Color(255, 255, 255));
        semaine17.setText("17");
        semaine17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine17ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine17);

        semaine18.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine18);
        semaine18.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine18.setForeground(new java.awt.Color(255, 255, 255));
        semaine18.setText("18");
        semaine18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine18ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine18);

        semaine19.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine19);
        semaine19.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine19.setForeground(new java.awt.Color(255, 255, 255));
        semaine19.setText("19");
        semaine19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine19ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine19);

        semaine20.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine20);
        semaine20.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine20.setForeground(new java.awt.Color(255, 255, 255));
        semaine20.setText("20");
        semaine20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine20ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine20);

        semaine21.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine21);
        semaine21.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine21.setForeground(new java.awt.Color(255, 255, 255));
        semaine21.setText("21");
        semaine21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine21ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine21);

        semaine22.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine22);
        semaine22.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine22.setForeground(new java.awt.Color(255, 255, 255));
        semaine22.setText("22");
        semaine22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine22ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine22);

        semaine23.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine23);
        semaine23.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine23.setForeground(new java.awt.Color(255, 255, 255));
        semaine23.setText("23");
        semaine23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine23ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine23);

        semaine24.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine24);
        semaine24.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine24.setForeground(new java.awt.Color(255, 255, 255));
        semaine24.setText("24");
        semaine24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine24ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine24);

        semaine25.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine25);
        semaine25.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine25.setForeground(new java.awt.Color(255, 255, 255));
        semaine25.setText("25");
        semaine25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine25ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine25);

        semaine26.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine26);
        semaine26.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine26.setForeground(new java.awt.Color(255, 255, 255));
        semaine26.setText("26");
        semaine26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine26ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine26);

        semaine27.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine27);
        semaine27.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine27.setForeground(new java.awt.Color(255, 255, 255));
        semaine27.setText("27");
        semaine27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine27ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine27);

        semaine28.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine28);
        semaine28.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine28.setForeground(new java.awt.Color(255, 255, 255));
        semaine28.setText("28");
        semaine28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine28ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine28);

        semaine29.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine29);
        semaine29.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine29.setForeground(new java.awt.Color(255, 255, 255));
        semaine29.setText("29");
        semaine29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine29ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine29);

        semaine30.setBackground(new java.awt.Color(102, 0, 102));
        buttonGroup1.add(semaine30);
        semaine30.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semaine30.setForeground(new java.awt.Color(255, 255, 255));
        semaine30.setText("30");
        semaine30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semaine30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        semaine30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaine30ActionPerformed(evt);
            }
        });
        semainePickerPanel.add(semaine30);

        topEdtPanel.add(semainePickerPanel, "card2");

        adminRespoEdtPanel.setBackground(new java.awt.Color(0, 113, 121));
        adminRespoEdtPanel.setForeground(new java.awt.Color(110, 35, 72));

        trierparEdtLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        trierparEdtLabel.setForeground(new java.awt.Color(255, 255, 255));
        trierparEdtLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trierparEdtLabel.setText("Trier par : ");

        semainePickerCB.setBackground(new java.awt.Color(0, 153, 153));
        semainePickerCB.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        semainePickerCB.setForeground(new java.awt.Color(255, 255, 255));
        semainePickerCB.setMaximumRowCount(5);
        semainePickerCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52" }));
        semainePickerCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        recapEdtSearch.setBackground(new java.awt.Color(0, 153, 153));
        recapEdtSearch.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        recapEdtSearch.setForeground(new java.awt.Color(255, 255, 255));
        recapEdtSearch.setMaximumRowCount(50);
        recapEdtSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enseignant", "Etudiant", "Promotion", "Site" }));
        recapEdtSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recapEdtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recapEdtSearchActionPerformed(evt);
            }
        });

        recapEdtSearch2.setBackground(new java.awt.Color(0, 153, 153));
        recapEdtSearch2.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        recapEdtSearch2.setForeground(new java.awt.Color(255, 255, 255));
        recapEdtSearch2.setMaximumRowCount(50);
        recapEdtSearch2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recapEdtSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recapEdtSearch2ActionPerformed(evt);
            }
        });

        recapEdtSearch3.setBackground(new java.awt.Color(0, 153, 153));
        recapEdtSearch3.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        recapEdtSearch3.setForeground(new java.awt.Color(255, 255, 255));
        recapEdtSearch3.setMaximumRowCount(50);
        recapEdtSearch3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        recapEdtRechercherButton.setBackground(new java.awt.Color(0, 153, 153));
        recapEdtRechercherButton.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        recapEdtRechercherButton.setForeground(new java.awt.Color(57, 17, 45));
        recapEdtRechercherButton.setText("Rechercher");
        recapEdtRechercherButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recapEdtRechercherButton.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                recapEdtRechercherButtonAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        recapEdtRechercherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recapEdtRechercherButtonActionPerformed(evt);
            }
        });

        recapMessageErreurEdt.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        recapMessageErreurEdt.setForeground(new java.awt.Color(110, 35, 72));

        javax.swing.GroupLayout adminRespoEdtPanelLayout = new javax.swing.GroupLayout(adminRespoEdtPanel);
        adminRespoEdtPanel.setLayout(adminRespoEdtPanelLayout);
        adminRespoEdtPanelLayout.setHorizontalGroup(
            adminRespoEdtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminRespoEdtPanelLayout.createSequentialGroup()
                .addGroup(adminRespoEdtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trierparEdtLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
                    .addGroup(adminRespoEdtPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(semainePickerCB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recapEdtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recapEdtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recapEdtSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(recapEdtRechercherButton)
                        .addGap(30, 30, 30)
                        .addComponent(recapMessageErreurEdt, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        adminRespoEdtPanelLayout.setVerticalGroup(
            adminRespoEdtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminRespoEdtPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(trierparEdtLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(adminRespoEdtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminRespoEdtPanelLayout.createSequentialGroup()
                        .addGroup(adminRespoEdtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(recapEdtSearch)
                            .addComponent(recapEdtSearch2)
                            .addComponent(recapEdtRechercherButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(semainePickerCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(recapEdtSearch3))
                        .addGap(1, 1, 1))
                    .addComponent(recapMessageErreurEdt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        topEdtPanel.add(adminRespoEdtPanel, "card3");

        edtPanelBotRight.setBackground(new java.awt.Color(153, 153, 153));

        edtDisplayPanel.setBackground(new java.awt.Color(102, 102, 102));

        lundiDisplayPanel.setBackground(new java.awt.Color(51, 51, 51));
        lundiDisplayPanel.setLayout(null);

        mardiDisplayPanel.setBackground(new java.awt.Color(51, 51, 51));
        mardiDisplayPanel.setLayout(null);

        mercrediDisplayPanel.setBackground(new java.awt.Color(51, 51, 51));
        mercrediDisplayPanel.setLayout(null);

        jeudiDisplayPanel.setBackground(new java.awt.Color(51, 51, 51));
        jeudiDisplayPanel.setLayout(null);

        vendrediDisplayPanel.setBackground(new java.awt.Color(51, 51, 51));
        vendrediDisplayPanel.setLayout(null);

        javax.swing.GroupLayout edtDisplayPanelLayout = new javax.swing.GroupLayout(edtDisplayPanel);
        edtDisplayPanel.setLayout(edtDisplayPanelLayout);
        edtDisplayPanelLayout.setHorizontalGroup(
            edtDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edtDisplayPanelLayout.createSequentialGroup()
                .addComponent(lundiDisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mardiDisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mercrediDisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jeudiDisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vendrediDisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        edtDisplayPanelLayout.setVerticalGroup(
            edtDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mardiDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
            .addComponent(mercrediDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jeudiDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(vendrediDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lundiDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lundiLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        lundiLabel.setForeground(new java.awt.Color(110, 35, 72));
        lundiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lundiLabel.setText("Lundi 2 mai");

        mardiLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        mardiLabel.setForeground(new java.awt.Color(110, 35, 72));
        mardiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mardiLabel.setText("Mardi 3 mai");

        mercrediLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        mercrediLabel.setForeground(new java.awt.Color(110, 35, 72));
        mercrediLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mercrediLabel.setText("Mercredi 4 mai");

        jeudiLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jeudiLabel.setForeground(new java.awt.Color(110, 35, 72));
        jeudiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jeudiLabel.setText("Jeudi 5 mai");

        vendrediLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        vendrediLabel.setForeground(new java.awt.Color(110, 35, 72));
        vendrediLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vendrediLabel.setText("Vendredi 6 mai");

        huitLabel.setBackground(new java.awt.Color(61, 43, 31));
        huitLabel.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        huitLabel.setForeground(new java.awt.Color(61, 43, 31));
        huitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        huitLabel.setText("8:30");

        neufLabel.setBackground(new java.awt.Color(61, 43, 31));
        neufLabel.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        neufLabel.setForeground(new java.awt.Color(61, 43, 31));
        neufLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        neufLabel.setText("9:30");

        dixLabel.setBackground(new java.awt.Color(61, 43, 31));
        dixLabel.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        dixLabel.setForeground(new java.awt.Color(61, 43, 31));
        dixLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dixLabel.setText("10:30");

        onzeLabel.setBackground(new java.awt.Color(61, 43, 31));
        onzeLabel.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        onzeLabel.setForeground(new java.awt.Color(61, 43, 31));
        onzeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        onzeLabel.setText("11:30");

        douzeLabel.setBackground(new java.awt.Color(61, 43, 31));
        douzeLabel.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        douzeLabel.setForeground(new java.awt.Color(61, 43, 31));
        douzeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        douzeLabel.setText("12:30");

        treizeLabel.setBackground(new java.awt.Color(61, 43, 31));
        treizeLabel.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        treizeLabel.setForeground(new java.awt.Color(61, 43, 31));
        treizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        treizeLabel.setText("13:30");

        quatorzeLabel.setBackground(new java.awt.Color(61, 43, 31));
        quatorzeLabel.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        quatorzeLabel.setForeground(new java.awt.Color(61, 43, 31));
        quatorzeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quatorzeLabel.setText("14:30");

        quinzeLabel.setBackground(new java.awt.Color(61, 43, 31));
        quinzeLabel.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        quinzeLabel.setForeground(new java.awt.Color(61, 43, 31));
        quinzeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quinzeLabel.setText("15:30");

        seizeLabel.setBackground(new java.awt.Color(61, 43, 31));
        seizeLabel.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        seizeLabel.setForeground(new java.awt.Color(61, 43, 31));
        seizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seizeLabel.setText("16:30");

        dixseptLabel.setBackground(new java.awt.Color(61, 43, 31));
        dixseptLabel.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        dixseptLabel.setForeground(new java.awt.Color(61, 43, 31));
        dixseptLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dixseptLabel.setText("17:30");

        dixhuitLabel.setBackground(new java.awt.Color(61, 43, 31));
        dixhuitLabel.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        dixhuitLabel.setForeground(new java.awt.Color(61, 43, 31));
        dixhuitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dixhuitLabel.setText("18:30");

        dixneufLabel.setBackground(new java.awt.Color(61, 43, 31));
        dixneufLabel.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        dixneufLabel.setForeground(new java.awt.Color(61, 43, 31));
        dixneufLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dixneufLabel.setText("19:30");

        vingtLabel.setBackground(new java.awt.Color(61, 43, 31));
        vingtLabel.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        vingtLabel.setForeground(new java.awt.Color(61, 43, 31));
        vingtLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vingtLabel.setText("20:30");

        anneeEdtLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        anneeEdtLabel.setForeground(new java.awt.Color(110, 35, 72));
        anneeEdtLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        anneeEdtLabel.setText("Année 2030-2031");

        javax.swing.GroupLayout edtPanelBotRightLayout = new javax.swing.GroupLayout(edtPanelBotRight);
        edtPanelBotRight.setLayout(edtPanelBotRightLayout);
        edtPanelBotRightLayout.setHorizontalGroup(
            edtPanelBotRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edtPanelBotRightLayout.createSequentialGroup()
                .addGroup(edtPanelBotRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(edtPanelBotRightLayout.createSequentialGroup()
                        .addGroup(edtPanelBotRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(huitLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(neufLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dixLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(onzeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(douzeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(treizeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(quatorzeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(quinzeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(seizeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(dixseptLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(dixhuitLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(dixneufLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(vingtLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(edtPanelBotRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(edtPanelBotRightLayout.createSequentialGroup()
                                .addComponent(lundiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mardiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mercrediLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jeudiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vendrediLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(edtPanelBotRightLayout.createSequentialGroup()
                                .addComponent(edtDisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(edtPanelBotRightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(anneeEdtLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        edtPanelBotRightLayout.setVerticalGroup(
            edtPanelBotRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edtPanelBotRightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(anneeEdtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(edtPanelBotRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jeudiLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mercrediLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mardiLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lundiLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vendrediLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(edtPanelBotRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(edtPanelBotRightLayout.createSequentialGroup()
                        .addComponent(huitLabel)
                        .addGap(40, 40, 40)
                        .addComponent(neufLabel)
                        .addGap(42, 42, 42)
                        .addComponent(dixLabel)
                        .addGap(46, 46, 46)
                        .addComponent(onzeLabel)
                        .addGap(53, 53, 53)
                        .addComponent(douzeLabel)
                        .addGap(41, 41, 41)
                        .addComponent(treizeLabel)
                        .addGap(48, 48, 48)
                        .addComponent(quatorzeLabel)
                        .addGap(47, 47, 47)
                        .addComponent(quinzeLabel)
                        .addGap(48, 48, 48)
                        .addComponent(seizeLabel)
                        .addGap(49, 49, 49)
                        .addComponent(dixseptLabel)
                        .addGap(47, 47, 47)
                        .addComponent(dixhuitLabel)
                        .addGap(45, 45, 45)
                        .addComponent(dixneufLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(vingtLabel))
                    .addComponent(edtDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout edtPanelLayout = new javax.swing.GroupLayout(edtPanel);
        edtPanel.setLayout(edtPanelLayout);
        edtPanelLayout.setHorizontalGroup(
            edtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, edtPanelLayout.createSequentialGroup()
                .addGroup(edtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(topEdtPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edtPanelBotRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        edtPanelLayout.setVerticalGroup(
            edtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, edtPanelLayout.createSequentialGroup()
                .addComponent(topEdtPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtPanelBotRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        rightCardPanel.add(edtPanel, "card2");

        recapPanel.setBackground(new java.awt.Color(204, 204, 204));

        topRecapPanel.setBackground(new java.awt.Color(57, 17, 45));
        topRecapPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        recapPeriodeLabelTop.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        recapPeriodeLabelTop.setForeground(new java.awt.Color(255, 255, 255));
        recapPeriodeLabelTop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recapPeriodeLabelTop.setText("Récapitulatif de la période");

        javax.swing.GroupLayout topRecapPanelLayout = new javax.swing.GroupLayout(topRecapPanel);
        topRecapPanel.setLayout(topRecapPanelLayout);
        topRecapPanelLayout.setHorizontalGroup(
            topRecapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topRecapPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(recapPeriodeLabelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        topRecapPanelLayout.setVerticalGroup(
            topRecapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topRecapPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(recapPeriodeLabelTop, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );

        recapPeriodeTriPanel.setBackground(new java.awt.Color(153, 153, 153));
        recapPeriodeTriPanel.setForeground(new java.awt.Color(153, 153, 153));

        trierparRecapLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        trierparRecapLabel.setForeground(new java.awt.Color(255, 255, 255));
        trierparRecapLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trierparRecapLabel.setText("Trier par : ");

        recapSearch1.setBackground(new java.awt.Color(0, 153, 153));
        recapSearch1.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        recapSearch1.setForeground(new java.awt.Color(255, 255, 255));
        recapSearch1.setMaximumRowCount(50);
        recapSearch1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enseignant", "Etudiant" }));
        recapSearch1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recapSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recapSearch1ActionPerformed(evt);
            }
        });

        recapSearch2.setBackground(new java.awt.Color(0, 153, 153));
        recapSearch2.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        recapSearch2.setForeground(new java.awt.Color(255, 255, 255));
        recapSearch2.setMaximumRowCount(50);
        recapSearch2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        recapRechercherButton.setBackground(new java.awt.Color(0, 153, 153));
        recapRechercherButton.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        recapRechercherButton.setForeground(new java.awt.Color(57, 17, 45));
        recapRechercherButton.setText("Rechercher");
        recapRechercherButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recapRechercherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recapRechercherButtonActionPerformed(evt);
            }
        });

        recapMessageErreur.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        recapMessageErreur.setForeground(new java.awt.Color(110, 35, 72));

        javax.swing.GroupLayout recapPeriodeTriPanelLayout = new javax.swing.GroupLayout(recapPeriodeTriPanel);
        recapPeriodeTriPanel.setLayout(recapPeriodeTriPanelLayout);
        recapPeriodeTriPanelLayout.setHorizontalGroup(
            recapPeriodeTriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recapPeriodeTriPanelLayout.createSequentialGroup()
                .addGroup(recapPeriodeTriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(trierparRecapLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
                    .addGroup(recapPeriodeTriPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(recapSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recapSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(recapRechercherButton)
                        .addGap(37, 37, 37)
                        .addComponent(recapMessageErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        recapPeriodeTriPanelLayout.setVerticalGroup(
            recapPeriodeTriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recapPeriodeTriPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(trierparRecapLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(recapPeriodeTriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(recapPeriodeTriPanelLayout.createSequentialGroup()
                        .addGroup(recapPeriodeTriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(recapSearch1)
                            .addComponent(recapSearch2)
                            .addComponent(recapRechercherButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(recapMessageErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        recapTable.setAutoCreateRowSorter(true);
        recapTable.setBackground(new java.awt.Color(0, 188, 197));
        recapTable.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        recapTable.setForeground(new java.awt.Color(255, 255, 255));
        recapTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matières", "Première Séance", "Dernière Séance", "Durée totale (heure)", "Nombre de Cours"
            }
        ));
        recapTable.setAutoscrolls(false);
        recapTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recapTable.setFocusable(false);
        recapTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        recapTable.setRowHeight(25);
        recapTable.setRowSelectionAllowed(false);
        recapTable.setSelectionBackground(new java.awt.Color(0, 153, 153));
        recapTable.setShowHorizontalLines(false);
        //Mon Code En Plus
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) recapTable.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);
        recapTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
            {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
                {
                    final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    c.setBackground(row % 2 == 0 ? new Color(0, 113, 121) : new Color(0, 143, 151));
                    return c;
                }
            });

            recapTable.getTableHeader().setBackground(new Color(255, 255, 255));
            recapTable.getTableHeader().setForeground(new Color(2, 129, 166));
            //Fin de mon code en plus
            recapTable.setVerifyInputWhenFocusTarget(false);
            recapTable.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    recapTableMouseClicked(evt);
                }
            });
            recapScrollPane.setViewportView(recapTable);

            javax.swing.GroupLayout recapPanelLayout = new javax.swing.GroupLayout(recapPanel);
            recapPanel.setLayout(recapPanelLayout);
            recapPanelLayout.setHorizontalGroup(
                recapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(recapScrollPane)
                .addComponent(topRecapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recapPanelLayout.createSequentialGroup()
                    .addComponent(recapPeriodeTriPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            recapPanelLayout.setVerticalGroup(
                recapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recapPanelLayout.createSequentialGroup()
                    .addComponent(topRecapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(recapPeriodeTriPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(recapScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE))
            );

            rightCardPanel.add(recapPanel, "card3");

            reportingPanel.setBackground(new java.awt.Color(204, 204, 204));

            topReportingPanel1.setBackground(new java.awt.Color(57, 17, 45));
            topReportingPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

            ReportingLabelTop.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
            ReportingLabelTop.setForeground(new java.awt.Color(255, 255, 255));
            ReportingLabelTop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            ReportingLabelTop.setText("Reporting");

            javax.swing.GroupLayout topReportingPanel1Layout = new javax.swing.GroupLayout(topReportingPanel1);
            topReportingPanel1.setLayout(topReportingPanel1Layout);
            topReportingPanel1Layout.setHorizontalGroup(
                topReportingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(topReportingPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ReportingLabelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            topReportingPanel1Layout.setVerticalGroup(
                topReportingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(topReportingPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ReportingLabelTop, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addContainerGap())
            );

            reportingPeriodeTriPanel.setBackground(new java.awt.Color(153, 153, 153));
            reportingPeriodeTriPanel.setForeground(new java.awt.Color(153, 153, 153));

            trierparReportingLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
            trierparReportingLabel.setForeground(new java.awt.Color(255, 255, 255));
            trierparReportingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            trierparReportingLabel.setText("Trier par : ");

            reportingSearch1.setBackground(new java.awt.Color(0, 153, 153));
            reportingSearch1.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
            reportingSearch1.setForeground(new java.awt.Color(255, 255, 255));
            reportingSearch1.setMaximumRowCount(50);
            reportingSearch1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enseignant", "Etudiant" }));
            reportingSearch1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            reportingSearch1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    reportingSearch1ActionPerformed(evt);
                }
            });

            reportingSearch2.setBackground(new java.awt.Color(0, 153, 153));
            reportingSearch2.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
            reportingSearch2.setForeground(new java.awt.Color(255, 255, 255));
            reportingSearch2.setMaximumRowCount(50);
            reportingSearch2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            reportingRechercherButton.setBackground(new java.awt.Color(0, 153, 153));
            reportingRechercherButton.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
            reportingRechercherButton.setForeground(new java.awt.Color(57, 17, 45));
            reportingRechercherButton.setText("Rechercher");
            reportingRechercherButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            reportingRechercherButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    reportingRechercherButtonActionPerformed(evt);
                }
            });

            reportingMessageErreur.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
            reportingMessageErreur.setForeground(new java.awt.Color(110, 35, 72));

            javax.swing.GroupLayout reportingPeriodeTriPanelLayout = new javax.swing.GroupLayout(reportingPeriodeTriPanel);
            reportingPeriodeTriPanel.setLayout(reportingPeriodeTriPanelLayout);
            reportingPeriodeTriPanelLayout.setHorizontalGroup(
                reportingPeriodeTriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(reportingPeriodeTriPanelLayout.createSequentialGroup()
                    .addGroup(reportingPeriodeTriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(trierparReportingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
                        .addGroup(reportingPeriodeTriPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(reportingSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(reportingSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(reportingRechercherButton)
                            .addGap(53, 53, 53)
                            .addComponent(reportingMessageErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );
            reportingPeriodeTriPanelLayout.setVerticalGroup(
                reportingPeriodeTriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(reportingPeriodeTriPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(trierparReportingLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(reportingPeriodeTriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(reportingPeriodeTriPanelLayout.createSequentialGroup()
                            .addGroup(reportingPeriodeTriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(reportingSearch1)
                                .addComponent(reportingSearch2)
                                .addComponent(reportingRechercherButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                        .addComponent(reportingMessageErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
            );

            reportingResumePanel.setBackground(new java.awt.Color(153, 153, 153));
            reportingResumePanel.setForeground(new java.awt.Color(153, 153, 153));

            jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            javax.swing.GroupLayout reportingResumePanel2Layout = new javax.swing.GroupLayout(reportingResumePanel2);
            reportingResumePanel2.setLayout(reportingResumePanel2Layout);
            reportingResumePanel2Layout.setHorizontalGroup(
                reportingResumePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 1101, Short.MAX_VALUE)
            );
            reportingResumePanel2Layout.setVerticalGroup(
                reportingResumePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 1997, Short.MAX_VALUE)
            );

            jScrollPane1.setViewportView(reportingResumePanel2);

            javax.swing.GroupLayout reportingResumePanelLayout = new javax.swing.GroupLayout(reportingResumePanel);
            reportingResumePanel.setLayout(reportingResumePanelLayout);
            reportingResumePanelLayout.setHorizontalGroup(
                reportingResumePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1)
            );
            reportingResumePanelLayout.setVerticalGroup(
                reportingResumePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
            );

            javax.swing.GroupLayout reportingPanelLayout = new javax.swing.GroupLayout(reportingPanel);
            reportingPanel.setLayout(reportingPanelLayout);
            reportingPanelLayout.setHorizontalGroup(
                reportingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(topReportingPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reportingResumePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(reportingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportingPeriodeTriPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            reportingPanelLayout.setVerticalGroup(
                reportingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(reportingPanelLayout.createSequentialGroup()
                    .addComponent(topReportingPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(81, 81, 81)
                    .addComponent(reportingResumePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(reportingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reportingPanelLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(reportingPeriodeTriPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(733, Short.MAX_VALUE)))
            );

            rightCardPanel.add(reportingPanel, "card4");

            gestionnairePanel.setBackground(new java.awt.Color(204, 204, 204));

            topgestionnairePanel.setBackground(new java.awt.Color(57, 17, 45));
            topgestionnairePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

            topGestionnaireLabel.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
            topGestionnaireLabel.setForeground(new java.awt.Color(255, 255, 255));
            topGestionnaireLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            topGestionnaireLabel.setText("Gestionnaire de l'Emploi Du Temps");

            insererLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
            insererLabel.setForeground(new java.awt.Color(255, 255, 255));
            insererLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            insererLabel.setText("Insérer");
            insererLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            insererLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    insererLabelMouseClicked(evt);
                }
            });

            modifierLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
            modifierLabel.setForeground(new java.awt.Color(153, 153, 153));
            modifierLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            modifierLabel.setText("Modifier");
            modifierLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            modifierLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    modifierLabelMouseClicked(evt);
                }
            });

            separatorGEDT2.setBackground(new java.awt.Color(255, 255, 255));
            separatorGEDT2.setForeground(new java.awt.Color(255, 255, 255));
            separatorGEDT2.setOrientation(javax.swing.SwingConstants.VERTICAL);

            javax.swing.GroupLayout topgestionnairePanelLayout = new javax.swing.GroupLayout(topgestionnairePanel);
            topgestionnairePanel.setLayout(topgestionnairePanelLayout);
            topgestionnairePanelLayout.setHorizontalGroup(
                topgestionnairePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(topGestionnaireLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(topgestionnairePanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(insererLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(separatorGEDT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(modifierLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            topgestionnairePanelLayout.setVerticalGroup(
                topgestionnairePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(topgestionnairePanelLayout.createSequentialGroup()
                    .addComponent(topGestionnaireLabel)
                    .addGroup(topgestionnairePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(topgestionnairePanelLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(topgestionnairePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(insererLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(modifierLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topgestionnairePanelLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                            .addComponent(separatorGEDT2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())))
            );

            gestionnaireContainerPanel.setBackground(new java.awt.Color(153, 153, 153));
            gestionnaireContainerPanel.setForeground(new java.awt.Color(153, 153, 153));
            gestionnaireContainerPanel.setLayout(new java.awt.CardLayout());

            insererPanel.setBackground(new java.awt.Color(153, 153, 153));
            insererPanel.setForeground(new java.awt.Color(153, 153, 153));

            jourLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
            jourLabel.setForeground(new java.awt.Color(255, 255, 255));
            jourLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            jourLabel.setText("Jour : ");

            jourCB.setBackground(new java.awt.Color(0, 153, 153));
            jourCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
            jourCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            moisLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
            moisLabel.setForeground(new java.awt.Color(255, 255, 255));
            moisLabel.setText("Mois :");

            moisCB.setBackground(new java.awt.Color(0, 153, 153));
            moisCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre" }));
            moisCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            anneeLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
            anneeLabel.setForeground(new java.awt.Color(255, 255, 255));
            anneeLabel.setText("Année : ");

            anneeCB.setBackground(new java.awt.Color(0, 153, 153));
            anneeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020" }));
            anneeCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            heureDebutlabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
            heureDebutlabel.setForeground(new java.awt.Color(255, 255, 255));
            heureDebutlabel.setText("Heure de début : ");

            heureDebutCB.setBackground(new java.awt.Color(0, 153, 153));
            heureDebutCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:30", "08:35", "08:40", "08:45", "08:50", "08:55", "09:00", "09:05", "09:10", "09:15", "09:20", "09:25", "09:30", "09:35", "09:40", "09:45", "09:50", "09:55", "10:00", "10:05", "10:10", "10:15", "10:20", "10:25", "10:30", "10:35", "10:40", "10:45", "10:50", "10:55", "11:00", "11:05", "11:10", "11:15", "11:20", "11:25", "11:30", "11:35", "11:40", "11:45", "11:50", "11:55", "12:00", "12:05", "12:10", "12:15", "12:20", "12:25", "12:30", "12:35", "12:40", "12:45", "12:50", "12:55", "13:00", "13:05", "13:10", "13:15", "13:20", "13:25", "13:30", "13:35", "13:40", "13:45", "13:50", "13:55", "14:00", "14:05", "14:10", "14:15", "14:20", "14:25", "14:30", "14:35", "14:40", "14:45", "14:50", "14:55", "15:00", "15:05", "15:10", "15:15", "15:20", "15:25", "15:30", "15:35", "15:40", "15:45", "15:50", "15:55", "16:00", "16:05", "16:10", "16:15", "16:20", "16:25", "16:30", "16:35", "16:40", "16:45", "16:50", "16:55", "17:00", "17:05", "17:10", "17:15", "17:20", "17:25", "17:30", "17:35", "17:40", "17:45", "17:50", "17:55", "18:00", "18:05", "18:10", "18:15", "18:20", "18:25", "18:30", "18:35", "18:40", "18:45", "18:50", "18:55", "19:00" }));
            heureDebutCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            heureFinlabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
            heureFinlabel.setForeground(new java.awt.Color(255, 255, 255));
            heureFinlabel.setText("Heure de fin : ");

            heureFinCB.setBackground(new java.awt.Color(0, 153, 153));
            heureFinCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:00", "10:05", "10:10", "10:15", "10:20", "10:25", "10:30", "10:35", "10:40", "10:45", "10:50", "10:55", "11:00", "11:05", "11:10", "11:15", "11:20", "11:25", "11:30", "11:35", "11:40", "11:45", "11:50", "11:55", "12:00", "12:05", "12:10", "12:15", "12:20", "12:25", "12:30", "12:35", "12:40", "12:45", "12:50", "12:55", "13:00", "13:05", "13:10", "13:15", "13:20", "13:25", "13:30", "13:35", "13:40", "13:45", "13:50", "13:55", "14:00", "14:05", "14:10", "14:15", "14:20", "14:25", "14:30", "14:35", "14:40", "14:45", "14:50", "14:55", "15:00", "15:05", "15:10", "15:15", "15:20", "15:25", "15:30", "15:35", "15:40", "15:45", "15:50", "15:55", "16:00", "16:05", "16:10", "16:15", "16:20", "16:25", "16:30", "16:35", "16:40", "16:45", "16:50", "16:55", "17:00", "17:05", "17:10", "17:15", "17:20", "17:25", "17:30", "17:35", "17:40", "17:45", "17:50", "17:55", "18:00", "18:05", "18:10", "18:15", "18:20", "18:25", "18:30", "18:35", "18:40", "18:45", "18:50", "18:55", "19:00", "19:05", "19:10", "19:15", "19:20", "19:25", "19:30", "19:35", "19:40", "19:45", "19:50", "19:55", "20:00", "20:05", "20:10", "20:15", "20:20", "20:25", "20:30" }));
            heureFinCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            typeCoursLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
            typeCoursLabel.setForeground(new java.awt.Color(255, 255, 255));
            typeCoursLabel.setText("Type de cours : ");

            typeCoursCB.setBackground(new java.awt.Color(0, 153, 153));
            typeCoursCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Magistral", "TD", "TP", "Soutien", "Reunion", "Conference" }));
            typeCoursCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            nbrEnseignantLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
            nbrEnseignantLabel.setForeground(new java.awt.Color(255, 255, 255));
            nbrEnseignantLabel.setText("Nombre d'Enseignant : ");

            nbrEnseignantCB.setBackground(new java.awt.Color(0, 153, 153));
            nbrEnseignantCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));
            nbrEnseignantCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            nbrEnseignantCB.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    nbrEnseignantCBActionPerformed(evt);
                }
            });

            virguleEnseignantLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
            virguleEnseignantLabel.setForeground(new java.awt.Color(255, 255, 255));
            virguleEnseignantLabel.setText(":");

            enseignantCB1.setBackground(new java.awt.Color(0, 153, 153));
            enseignantCB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M.SEGADO", "M.RAVAUD", "M.HINA" }));
            enseignantCB1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            enseignantCB2.setBackground(new java.awt.Color(0, 153, 153));
            enseignantCB2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M.SEGADO", "M.RAVAUD", "M.HINA" }));
            enseignantCB2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            enseignantCB3.setBackground(new java.awt.Color(0, 153, 153));
            enseignantCB3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M.SEGADO", "M.RAVAUD", "M.HINA" }));
            enseignantCB3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            enseignantCB4.setBackground(new java.awt.Color(0, 153, 153));
            enseignantCB4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M.SEGADO", "M.RAVAUD", "M.HINA" }));
            enseignantCB4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            enseignantCB5.setBackground(new java.awt.Color(0, 153, 153));
            enseignantCB5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M.SEGADO", "M.RAVAUD", "M.HINA" }));
            enseignantCB5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            promotionInsererLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
            promotionInsererLabel.setForeground(new java.awt.Color(255, 255, 255));
            promotionInsererLabel.setText("Promotion :");

            promotionInsererCB.setBackground(new java.awt.Color(0, 153, 153));
            promotionInsererCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            promotionInsererCB.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    promotionInsererCBActionPerformed(evt);
                }
            });

            nbrGroupeLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
            nbrGroupeLabel.setForeground(new java.awt.Color(255, 255, 255));
            nbrGroupeLabel.setText("Nombre de Groupe :");

            nbrGroupeCB.setBackground(new java.awt.Color(0, 153, 153));
            nbrGroupeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));
            nbrGroupeCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            nbrGroupeCB.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    nbrGroupeCBActionPerformed(evt);
                }
            });

            virguleEnseignantLabel1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
            virguleEnseignantLabel1.setForeground(new java.awt.Color(255, 255, 255));
            virguleEnseignantLabel1.setText(":");

            tdCB1.setBackground(new java.awt.Color(0, 153, 153));
            tdCB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TD01", "TD02", "TD03", "TD04", "TD05", "TD06", "TD07", "TD08", "TD09", "TD10" }));
            tdCB1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            tdCB2.setBackground(new java.awt.Color(0, 153, 153));
            tdCB2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TD01", "TD02", "TD03", "TD04", "TD05", "TD06", "TD07", "TD08", "TD09", "TD10" }));
            tdCB2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            tdCB3.setBackground(new java.awt.Color(0, 153, 153));
            tdCB3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TD01", "TD02", "TD03", "TD04", "TD05", "TD06", "TD07", "TD08", "TD09", "TD10" }));
            tdCB3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            tdCB4.setBackground(new java.awt.Color(0, 153, 153));
            tdCB4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TD01", "TD02", "TD03", "TD04", "TD05", "TD06", "TD07", "TD08", "TD09", "TD10" }));
            tdCB4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            tdCB5.setBackground(new java.awt.Color(0, 153, 153));
            tdCB5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TD01", "TD02", "TD03", "TD04", "TD05", "TD06", "TD07", "TD08", "TD09", "TD10" }));
            tdCB5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            tdCB6.setBackground(new java.awt.Color(0, 153, 153));
            tdCB6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TD01", "TD02", "TD03", "TD04", "TD05", "TD06", "TD07", "TD08", "TD09", "TD10" }));
            tdCB6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            tdCB7.setBackground(new java.awt.Color(0, 153, 153));
            tdCB7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TD01", "TD02", "TD03", "TD04", "TD05", "TD06", "TD07", "TD08", "TD09", "TD10" }));
            tdCB7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            tdCB8.setBackground(new java.awt.Color(0, 153, 153));
            tdCB8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TD01", "TD02", "TD03", "TD04", "TD05", "TD06", "TD07", "TD08", "TD09", "TD10" }));
            tdCB8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            tdCB9.setBackground(new java.awt.Color(0, 153, 153));
            tdCB9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TD01", "TD02", "TD03", "TD04", "TD05", "TD06", "TD07", "TD08", "TD09", "TD10" }));
            tdCB9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            tdCB10.setBackground(new java.awt.Color(0, 153, 153));
            tdCB10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TD01", "TD02", "TD03", "TD04", "TD05", "TD06", "TD07", "TD08", "TD09", "TD10" }));
            tdCB10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            siteLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
            siteLabel.setForeground(new java.awt.Color(255, 255, 255));
            siteLabel.setText("Site :");

            siteCB.setBackground(new java.awt.Color(0, 153, 153));
            siteCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            siteCB.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    siteCBActionPerformed(evt);
                }
            });

            salleLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
            salleLabel.setForeground(new java.awt.Color(255, 255, 255));
            salleLabel.setText("Salle :");

            salleCB.setBackground(new java.awt.Color(0, 153, 153));
            salleCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            insererButton.setBackground(new java.awt.Color(0, 153, 153));
            insererButton.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
            insererButton.setForeground(new java.awt.Color(57, 17, 45));
            insererButton.setText("Valider");
            insererButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            insererButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    insererButtonActionPerformed(evt);
                }
            });

            resumeInsertionLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
            resumeInsertionLabel.setForeground(new java.awt.Color(57, 17, 45));
            resumeInsertionLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

            nomDuCoursLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
            nomDuCoursLabel.setForeground(new java.awt.Color(255, 255, 255));
            nomDuCoursLabel.setText("Nom du cours:");

            salleCB1.setBackground(new java.awt.Color(0, 153, 153));
            salleCB1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            javax.swing.GroupLayout insererPanelLayout = new javax.swing.GroupLayout(insererPanel);
            insererPanel.setLayout(insererPanelLayout);
            insererPanelLayout.setHorizontalGroup(
                insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(insererPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(insererPanelLayout.createSequentialGroup()
                            .addComponent(promotionInsererLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(promotionInsererCB, 0, 100, Short.MAX_VALUE)
                            .addGap(814, 814, 814))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insererPanelLayout.createSequentialGroup()
                            .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(resumeInsertionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, insererPanelLayout.createSequentialGroup()
                                    .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(insererPanelLayout.createSequentialGroup()
                                            .addComponent(nbrEnseignantLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(nbrEnseignantCB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(19, 19, 19))
                                        .addGroup(insererPanelLayout.createSequentialGroup()
                                            .addComponent(anneeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(anneeCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(insererPanelLayout.createSequentialGroup()
                                            .addComponent(heureDebutlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(heureDebutCB, 0, 100, Short.MAX_VALUE))
                                        .addGroup(insererPanelLayout.createSequentialGroup()
                                            .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(typeCoursLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(heureFinlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(heureFinCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(typeCoursCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(insererPanelLayout.createSequentialGroup()
                                            .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(moisLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jourLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jourCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(moisCB, 0, 100, Short.MAX_VALUE))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(virguleEnseignantLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(enseignantCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(enseignantCB2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(enseignantCB3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(enseignantCB4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(enseignantCB5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(14, 14, 14))
                        .addGroup(insererPanelLayout.createSequentialGroup()
                            .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(insererButton)
                                .addGroup(insererPanelLayout.createSequentialGroup()
                                    .addComponent(nbrGroupeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nbrGroupeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(virguleEnseignantLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tdCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tdCB2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tdCB3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tdCB4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tdCB5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tdCB6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tdCB7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tdCB8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tdCB9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tdCB10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, insererPanelLayout.createSequentialGroup()
                                        .addComponent(nomDuCoursLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(salleCB1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, insererPanelLayout.createSequentialGroup()
                                        .addComponent(salleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(salleCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, insererPanelLayout.createSequentialGroup()
                                        .addComponent(siteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(siteCB, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(0, 0, Short.MAX_VALUE))))
            );
            insererPanelLayout.setVerticalGroup(
                insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(insererPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jourLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jourCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(moisLabel)
                        .addComponent(moisCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(anneeLabel)
                        .addComponent(anneeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(heureDebutlabel)
                        .addComponent(heureDebutCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(heureFinlabel)
                        .addComponent(heureFinCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(typeCoursLabel)
                        .addComponent(typeCoursCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nbrEnseignantLabel)
                        .addComponent(nbrEnseignantCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(virguleEnseignantLabel)
                        .addComponent(enseignantCB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(enseignantCB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(enseignantCB3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(enseignantCB4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(enseignantCB5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(promotionInsererLabel)
                        .addComponent(promotionInsererCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nbrGroupeLabel)
                        .addComponent(nbrGroupeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(virguleEnseignantLabel1)
                        .addComponent(tdCB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tdCB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tdCB3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tdCB4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tdCB5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tdCB6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tdCB7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tdCB8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tdCB9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tdCB10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(siteLabel)
                        .addComponent(siteCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(salleLabel)
                        .addComponent(salleCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(insererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nomDuCoursLabel)
                        .addComponent(salleCB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addComponent(insererButton)
                    .addGap(30, 30, 30)
                    .addComponent(resumeInsertionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addGap(162, 162, 162))
            );

            gestionnaireContainerPanel.add(insererPanel, "card2");

            modifierPanel.setBackground(new java.awt.Color(153, 153, 153));
            modifierPanel.setForeground(new java.awt.Color(153, 153, 153));

            javax.swing.GroupLayout modifierPanelLayout = new javax.swing.GroupLayout(modifierPanel);
            modifierPanel.setLayout(modifierPanelLayout);
            modifierPanelLayout.setHorizontalGroup(
                modifierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 1104, Short.MAX_VALUE)
            );
            modifierPanelLayout.setVerticalGroup(
                modifierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 802, Short.MAX_VALUE)
            );

            gestionnaireContainerPanel.add(modifierPanel, "card4");

            javax.swing.GroupLayout gestionnairePanelLayout = new javax.swing.GroupLayout(gestionnairePanel);
            gestionnairePanel.setLayout(gestionnairePanelLayout);
            gestionnairePanelLayout.setHorizontalGroup(
                gestionnairePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(topgestionnairePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gestionnaireContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            );
            gestionnairePanelLayout.setVerticalGroup(
                gestionnairePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(gestionnairePanelLayout.createSequentialGroup()
                    .addComponent(topgestionnairePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(gestionnaireContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            rightCardPanel.add(gestionnairePanel, "card5");

            javax.swing.GroupLayout firstBackgroundPanelLayout = new javax.swing.GroupLayout(firstBackgroundPanel);
            firstBackgroundPanel.setLayout(firstBackgroundPanelLayout);
            firstBackgroundPanelLayout.setHorizontalGroup(
                firstBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(firstBackgroundPanelLayout.createSequentialGroup()
                    .addComponent(leftGreenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(rightCardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            firstBackgroundPanelLayout.setVerticalGroup(
                firstBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(leftGreenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(firstBackgroundPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(rightCardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(firstBackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(firstBackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////// ACTIVATION/DESACTIVATION DES PANELS //////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /** Initilialise les 4 catégories a gauche */
    public void clickItemMenu(JPanel active, boolean panel, JLabel labelSelected) //Quand on appuie a gauche sur un menu, on desactive tous les panels, on réactive celui passé en parametre et on change la couleur de tous les textes a gauche du menu
    {
        //Desactive tous les panels
        edtPanel.setVisible(false);
        edtPanel.setEnabled(false);
        edtSelected = false;
        emploidutempsLabel.setForeground(new java.awt.Color(153, 153, 153));
        
        recapPanel.setVisible(false);
        recapPanel.setEnabled(false);
        recapSelected = false;
        recapitulatifLabel.setForeground(new java.awt.Color(153, 153, 153));
        
        gestionnairePanel.setVisible(false);
        gestionnairePanel.setEnabled(false);
        majSelected = false;
        gestionnaireLabel.setForeground(new java.awt.Color(153, 153, 153));
        
        reportingPanel.setVisible(false);
        reportingPanel.setEnabled(false);
        reportingSelected = false;
        reportingLabel.setForeground(new java.awt.Color(153, 153, 153));
        
        //Active le panel sur lequel on clique
        active.setVisible(true);
        active.setEnabled(true);
        panel = true;
        labelSelected.setForeground(new java.awt.Color(255, 255, 255));
    }
    
    public void clickItemGestionnaire(JPanel active, boolean panel, JLabel labelSelected)
    {
        //Desactive tous les panels
        insererPanel.setVisible(false);
        insererPanel.setEnabled(false);
        insererBool = false;
        insererLabel.setForeground(new java.awt.Color(153, 153, 153));
        
        
        
        modifierPanel.setVisible(false);
        modifierPanel.setEnabled(false);
        modifierBool = false;
        modifierLabel.setForeground(new java.awt.Color(153, 153, 153));
        
        //Active le panel sur lequel on clique
        active.setVisible(true);
        active.setEnabled(true);
        panel = true;
        labelSelected.setForeground(new java.awt.Color(255, 255, 255));
    }
    
    //Pour le menu Reporting
    
    //////////////////////////////////// FIN ACTIVATION/DESACTIVATION DES PANELS //////////////////////////////////
    
    /** Fonction pour pré-selectionner la semaine a l'ouverture de l'application */
    public void InitialiseSemaine(int semaineActuelle) 
    {
        switch(semaineActuelle)
        {
            case 1:
                semaine1.setSelected(true);
                rih.MAJEdt(1,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 2:
                semaine2.setSelected(true);
                rih.MAJEdt(2,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 3:
                semaine3.setSelected(true);
                rih.MAJEdt(3,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 4:
                semaine4.setSelected(true);
                rih.MAJEdt(4,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 5:
                semaine2.setSelected(true);
                rih.MAJEdt(5,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 52:
                semaine52.setSelected(true);
                rih.MAJEdt(52,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 6:
                semaine6.setSelected(true);
                rih.MAJEdt(6,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 7:
                semaine7.setSelected(true);
                rih.MAJEdt(7,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 8:
                semaine8.setSelected(true);
                rih.MAJEdt(8,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 9:
                semaine9.setSelected(true);
                rih.MAJEdt(9,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 10:
                semaine10.setSelected(true);
                rih.MAJEdt(10,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 11:
                semaine11.setSelected(true);
                rih.MAJEdt(11,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 12:
                semaine12.setSelected(true);
                rih.MAJEdt(12,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 13:
                semaine13.setSelected(true);
                rih.MAJEdt(13,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 14:
                semaine14.setSelected(true);
                rih.MAJEdt(14,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 15:
                semaine15.setSelected(true);
                rih.MAJEdt(15,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 16:
                semaine16.setSelected(true);
                rih.MAJEdt(16,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 17:
                semaine17.setSelected(true);
                rih.MAJEdt(17,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 18:
                semaine18.setSelected(true);
                rih.MAJEdt(18,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 19:
                semaine19.setSelected(true);
                rih.MAJEdt(19,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 20:
                semaine20.setSelected(true);
                rih.MAJEdt(20,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 21:
                semaine21.setSelected(true);
                rih.MAJEdt(21,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 22:
                semaine22.setSelected(true);
                rih.MAJEdt(22,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 23:
                semaine23.setSelected(true);
                rih.MAJEdt(23,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 24:
                semaine24.setSelected(true);
                rih.MAJEdt(24,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 25:
                semaine25.setSelected(true);
                rih.MAJEdt(25,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 26:
                semaine26.setSelected(true);
                rih.MAJEdt(26,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 27:
                semaine27.setSelected(true);
                rih.MAJEdt(27,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 28:
                semaine28.setSelected(true);
                rih.MAJEdt(28,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 29:
                semaine29.setSelected(true);
                rih.MAJEdt(29,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 30:
                semaine30.setSelected(true);
                rih.MAJEdt(30,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 31:
                semaine31.setSelected(true);
                rih.MAJEdt(31,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 32:
                semaine32.setSelected(true);
                rih.MAJEdt(32,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 33:
                semaine33.setSelected(true);
                rih.MAJEdt(33,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 34:
                semaine34.setSelected(true);
                rih.MAJEdt(34,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 35:
                semaine35.setSelected(true);
                rih.MAJEdt(35,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 36:
                semaine36.setSelected(true);
                rih.MAJEdt(36,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 37:
                semaine37.setSelected(true);
                rih.MAJEdt(37,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 38:
                semaine38.setSelected(true);
                rih.MAJEdt(38,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 39:
                semaine39.setSelected(true);
                rih.MAJEdt(39,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 40:
                semaine40.setSelected(true);
                rih.MAJEdt(40,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 41:
                semaine41.setSelected(true);
                rih.MAJEdt(41,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 42:
                semaine42.setSelected(true);
                rih.MAJEdt(42,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 43:
                semaine43.setSelected(true);
                rih.MAJEdt(43,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 44:
                semaine44.setSelected(true);
                rih.MAJEdt(44,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 45:
                semaine45.setSelected(true);
                rih.MAJEdt(45,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 46:
                semaine46.setSelected(true);
                rih.MAJEdt(46,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 47:
                semaine47.setSelected(true);
                rih.MAJEdt(47,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 48:
                semaine48.setSelected(true);
                rih.MAJEdt(48,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 49:
                semaine49.setSelected(true);
                rih.MAJEdt(49,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 50:
                semaine50.setSelected(true);
                rih.MAJEdt(50,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            case 51:
                semaine51.setSelected(true);
                rih.MAJEdt(51,anneeEdtLabel,lundiLabel,mardiLabel,mercrediLabel,jeudiLabel, vendrediLabel, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
                break;
            default:
                break;
        }
    }
    
    /** Si on clique sur le bouton Gestionnaire de l'EDT */
    private void gestionnaireLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestionnaireLabelMouseClicked
        clickItemMenu(gestionnairePanel, majSelected, gestionnaireLabel);
    }//GEN-LAST:event_gestionnaireLabelMouseClicked

    /**Quand on clique sur le bouton Reporting*/
    private void reportingLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportingLabelMouseClicked
        clickItemMenu(reportingPanel, reportingSelected, reportingLabel);
    }//GEN-LAST:event_reportingLabelMouseClicked

    /** Quand on clique sur le bouton recapitulatif de la periode */
    private void recapitulatifLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recapitulatifLabelMouseClicked
        clickItemMenu(recapPanel, recapSelected, recapitulatifLabel);
    }//GEN-LAST:event_recapitulatifLabelMouseClicked

    /**Si la souris quitte le texte emploi du temps*/
    private void emploidutempsLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emploidutempsLabelMouseExited

    }//GEN-LAST:event_emploidutempsLabelMouseExited

    /**Si la souris passe sur le texte emploi du temps*/
    private void emploidutempsLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emploidutempsLabelMouseEntered

    }//GEN-LAST:event_emploidutempsLabelMouseEntered

    /** Si on clique sur l'onglet emploi du temps */
    private void emploidutempsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emploidutempsLabelMouseClicked
        // TODO add your handling code here:
        clickItemMenu(edtPanel, edtSelected, emploidutempsLabel); //On ouvre la fenetre de l'emploi du temps
        //InitialiseSemaine(GetSemaine.getWeek()); //On se remet a la semaine actuelle
    }//GEN-LAST:event_emploidutempsLabelMouseClicked

    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////// TABLEAU RECAPITULATIF PERIODE ////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**Quand on clique sur le tableau du recapitulatif de la periode*/
    private void recapTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recapTableMouseClicked
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) recapTable.getModel();
        int index = recapTable.getSelectedRow(); //L'index sur lequel on clique
        
    }//GEN-LAST:event_recapTableMouseClicked

    
    //////////////////////////////////// FIN TABLEAU RECAPITULATIF PERIODE ////////////////////////////////////////
    
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////// LES 3 BOUTONS INSERER SUPPRIMER MODIFIER /////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**Quand on appuie sur le bouton "Rechercher" en tant qu'admin ou ref peda dans le recapitulatif de la periode*/
    private void insererLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insererLabelMouseClicked
        // TODO add your handling code here:
        clickItemGestionnaire(insererPanel, insererBool, insererLabel);
    }//GEN-LAST:event_insererLabelMouseClicked

    private void modifierLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifierLabelMouseClicked
        // TODO add your handling code here:
        clickItemGestionnaire(modifierPanel, modifierBool, modifierLabel);
    }//GEN-LAST:event_modifierLabelMouseClicked

    //////////////////////////////////// FIN - LES 3 BOUTONS INSERER SUPPRIMER MODIFIER ////////////////////////
    
    /**Quand on appuie sur le bouton "Rechercher" en tant qu'admin ou ref peda dans le recapitulatif de la periode*/
    private void recapRechercherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recapRechercherButtonActionPerformed
        //On update le message d'erreur - recherche reussi ou non
        rih.changeMessageLabelRecapPeriode(recapSearch2, recapMessageErreur, recapTable);
    }//GEN-LAST:event_recapRechercherButtonActionPerformed

    /**Quand on appuie sur le bouton "Rechercher" en tant qu'admin ou ref peda dans le reporting*/
    private void reportingRechercherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportingRechercherButtonActionPerformed
        //On update le message d'erreur - recherche reussi ou non
        String emailRep = rih.RecupEmailPassword(reportingSearch2).get(0);
        String passwordRep = rih.RecupEmailPassword(reportingSearch2).get(1);
        rep.AfficheCours(emailRep, passwordRep, reportingResumePanel2);
    }//GEN-LAST:event_reportingRechercherButtonActionPerformed

    /** inserer bouton */
    private void insererButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insererButtonActionPerformed
        // TODO add your handling code here:
        majDonnees.Insertion(jourCB, moisCB, anneeCB, heureDebutCB, heureFinCB, typeCoursCB, nbrEnseignantCB, enseignantCB1, enseignantCB2, enseignantCB3, enseignantCB4, enseignantCB5, promotionInsererCB, nbrGroupeCB, tdCB1, tdCB2, tdCB3, tdCB4, tdCB5, tdCB6, tdCB7, tdCB8, tdCB8, tdCB10, siteCB, salleCB, salleCB1, resumeInsertionLabel); 
        
    }//GEN-LAST:event_insererButtonActionPerformed

    /**Quand on appuie sur le bouton "Rechercher" en tant qu'admin ou ref peda pour afficher l'edt */
    private void recapEdtRechercherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recapEdtRechercherButtonActionPerformed
        //On update le message d'erreur - recherche reussi ou non
        rih.changeMessageErreur(recapMessageErreurEdt, recapEdtSearch2, recapEdtSearch3);
        
        //On affiche l'edt recherche
        rih.dessineEtudiantProfesseur(email, password, recapEdtSearch, recapEdtSearch2, semainePickerCB, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, anneeEdtLabel); //cas d'un etudiant ou professeur, se fera automatiquement
        rih.dessinePromotionSite(email, password, recapEdtSearch, recapEdtSearch2, recapEdtSearch3, semainePickerCB, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, anneeEdtLabel); //cas ou on fait une recherche par promotion ou site
    }//GEN-LAST:event_recapEdtRechercherButtonActionPerformed

    /////////////////////////// QUAND ON APPUIE SUR LES BOUTONS DES SEMAINES ///////////////////////////
    
    /** quand on appuie sur un des boutons en haut sur le num de semaine */
    private void semaine31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine31ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 31);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 31);
        rih.Draw(31, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine31ActionPerformed

    private void semaine32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine32ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 32);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 32);
        rih.Draw(32, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine32ActionPerformed

    private void semaine33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine33ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 33);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 33);
        rih.Draw(33, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine33ActionPerformed

    private void semaine34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine34ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 34);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 34);
        rih.Draw(34, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine34ActionPerformed

    private void semaine35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine35ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 35);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 35);
        rih.Draw(35, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine35ActionPerformed

    private void semaine36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine36ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 36);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 36);
        rih.Draw(36, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine36ActionPerformed

    private void semaine37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine37ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 37);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 37);
        rih.Draw(37, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine37ActionPerformed

    private void semaine38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine38ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 38);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 38);
        rih.Draw(38, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine38ActionPerformed

    private void semaine39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine39ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 39);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 39);
        rih.Draw(39, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine39ActionPerformed

    private void semaine40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine40ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 40);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 40);
        rih.Draw(40, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine40ActionPerformed

    private void semaine41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine41ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 41);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 41);
        rih.Draw(41, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine41ActionPerformed

    private void semaine42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine42ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 42);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 42);
        rih.Draw(42, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine42ActionPerformed

    private void semaine43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine43ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 43);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 43);
        rih.Draw(43, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine43ActionPerformed

    private void semaine44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine44ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 44);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 44);
        rih.Draw(44, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine44ActionPerformed

    private void semaine45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine45ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 45);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 45);
        rih.Draw(45, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine45ActionPerformed

    private void semaine46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine46ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 46);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 46);
        rih.Draw(46, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine46ActionPerformed

    private void semaine47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine47ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 47);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 47);
        rih.Draw(47, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine47ActionPerformed

    private void semaine48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine48ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 48);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 48);
        rih.Draw(48, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine48ActionPerformed

    private void semaine49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine49ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 49);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 49);
        rih.Draw(49, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine49ActionPerformed

    private void semaine50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine50ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 50);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 50);
        rih.Draw(50, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine50ActionPerformed

    private void semaine51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine51ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 51);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 51);
        rih.Draw(51, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine51ActionPerformed

    private void semaine52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine52ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 52);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 52);
        rih.Draw(52, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine52ActionPerformed

    private void semaine1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine1ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 1);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 1);
        rih.Draw(1, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine1ActionPerformed

    private void semaine2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine2ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 2);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 2);
        rih.Draw(2, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine2ActionPerformed

    private void semaine3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine3ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 3);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 3);
        rih.Draw(3, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine3ActionPerformed

    private void semaine4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine4ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 4);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 4);
        rih.Draw(4, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine4ActionPerformed

    private void semaine5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine5ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 5);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 5);
        rih.Draw(5, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine5ActionPerformed

    private void semaine6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine6ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 6);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 6);
        rih.Draw(6, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine6ActionPerformed

    private void semaine7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine7ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 7);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 7);
        rih.Draw(7, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine7ActionPerformed

    private void semaine8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine8ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 8);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 8);
        rih.Draw(8, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine8ActionPerformed

    private void semaine9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine9ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 9);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 9);
        rih.Draw(9, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine9ActionPerformed

    private void semaine10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine10ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 10);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 10);
        rih.Draw(10, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine10ActionPerformed

    private void semaine11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine11ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 11);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 11);
        rih.Draw(11, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine11ActionPerformed

    private void semaine12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine12ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 12);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 12);
        rih.Draw(12, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine12ActionPerformed

    private void semaine13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine13ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 13);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 13);
        rih.Draw(13, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine13ActionPerformed

    private void semaine14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine14ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 14);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 14);
        rih.Draw(14, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine14ActionPerformed

    private void semaine15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine15ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 15);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 15);
        rih.Draw(15, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine15ActionPerformed

    private void semaine16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine16ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 16);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 16);
        rih.Draw(16, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine16ActionPerformed

    private void semaine17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine17ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 17);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 17);
        rih.Draw(17, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine17ActionPerformed

    private void semaine18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine18ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 18);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 18);
        rih.Draw(18, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine18ActionPerformed

    private void semaine19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine19ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 19);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 19);
        rih.Draw(19, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine19ActionPerformed

    private void semaine20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine20ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 20);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 20);
        rih.Draw(20, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine20ActionPerformed

    private void semaine21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine21ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 21);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 21);
        rih.Draw(21, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine21ActionPerformed

    private void semaine22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine22ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 22);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 22);
        rih.Draw(22, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine22ActionPerformed

    private void semaine23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine23ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 23);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 23);
        rih.Draw(23, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine23ActionPerformed

    private void semaine24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine24ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 24);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 24);
        rih.Draw(24, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine24ActionPerformed

    private void semaine25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine25ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 25);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 25);
        rih.Draw(25, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine25ActionPerformed

    private void semaine26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine26ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 26);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 26);
        rih.Draw(26, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine26ActionPerformed

    private void semaine27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine27ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 27);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 27);
        rih.Draw(27, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine27ActionPerformed

    private void semaine28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine28ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 28);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 28);
        rih.Draw(28, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine28ActionPerformed

    private void semaine29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine29ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 29);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 29);
        rih.Draw(29, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine29ActionPerformed

    private void semaine30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaine30ActionPerformed
        // TODO add your handling code here:
        rih.ChangeLabelJours(lundiLabel, mardiLabel, mercrediLabel, jeudiLabel, vendrediLabel, 30);
        rih.ChangeAnneeProgramme(anneeEdtLabel, 30);
        rih.Draw(30, lundiDisplayPanel, mardiDisplayPanel, mercrediDisplayPanel, jeudiDisplayPanel, vendrediDisplayPanel, email, password);
    }//GEN-LAST:event_semaine30ActionPerformed

    /////////////////////////// FIN QUAND ON APPUIE SUR LES BOUTONS DES SEMAINES ///////////////////////////
    
    
    /////////////////////////// QUAND ON FAIT UNE RECHERCHE SUR L'EDT (admin & ref ped) ///////////////////////////
    
    
    /**Quand on appuie sur une des options (enseignant etudiant promotion salle)*/
    private void recapEdtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recapEdtSearchActionPerformed
        //On change la valeur de recapedtseach2
        rih.changeRecapEdtSearch2(recapEdtSearch, recapEdtSearch2, recapEdtSearch3);
    }//GEN-LAST:event_recapEdtSearchActionPerformed

    //Quand on appuie sur la 3e recherche
    private void recapEdtSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recapEdtSearch2ActionPerformed
        rih.changeRecapEdtSearch3(recapEdtSearch, recapEdtSearch2, recapEdtSearch3);
    }//GEN-LAST:event_recapEdtSearch2ActionPerformed

    //Dans recap periode, quand on choisi etudiant ou enseignant
    private void recapSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recapSearch1ActionPerformed
        // TODO add your handling code here:
        rih.changeRecapPeriodeSearch(recapSearch1, recapSearch2);
    }//GEN-LAST:event_recapSearch1ActionPerformed

    private void recapEdtRechercherButtonAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_recapEdtRechercherButtonAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_recapEdtRechercherButtonAncestorAdded

    
    private void nbrEnseignantCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nbrEnseignantCBActionPerformed
        // TODO add your handling code here:
        rih.afficheEnseignantCB(nbrEnseignantCB, enseignantCB1, enseignantCB2, enseignantCB3, enseignantCB4, enseignantCB5);
    }//GEN-LAST:event_nbrEnseignantCBActionPerformed

    private void nbrGroupeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nbrGroupeCBActionPerformed
        // TODO add your handling code here:
        rih.afficheTDCB(nbrGroupeCB, tdCB1, tdCB2,tdCB3,tdCB4,tdCB5,tdCB6,tdCB7,tdCB8,tdCB9,tdCB10);
    }//GEN-LAST:event_nbrGroupeCBActionPerformed

    private void promotionInsererCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promotionInsererCBActionPerformed
        // TODO add your handling code here:
        rih.ChangeTdNom(promotionInsererCB, tdCB1, tdCB2, tdCB3, tdCB4, tdCB5, tdCB6, tdCB7, tdCB8, tdCB9, tdCB10);
    }//GEN-LAST:event_promotionInsererCBActionPerformed

    //Quand on modifie le nom du site
    private void siteCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siteCBActionPerformed
        // TODO add your handling code here:
        rih.UpdateNomSalles(siteCB, salleCB);
    }//GEN-LAST:event_siteCBActionPerformed

    private void reportingSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportingSearch1ActionPerformed
        // TODO add your handling code here:
        rih.changeRecapPeriodeSearch(reportingSearch1, reportingSearch2);
    }//GEN-LAST:event_reportingSearch1ActionPerformed

    //////////////////////////////////// CLIQUE SUR LES JOURS DE LA SEMAINE ///////////////////////////////////
    
    /** Si on appuie sur le bouton deconnexion */
    private void deconnexionLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deconnexionLabelMouseClicked
        // TODO add your handling code here:
        this.dispose();
        Login_Form lf = new Login_Form();
        lf.setVisible(true);
        
        /* oublie le mdp de l'utilisateur */
        
        try
        {
            FileWriter fw = new FileWriter("LOGMDP.txt");    //On peut spécifier ici le chemin que l'on veut, si on ne le fait pas ce sera automatiquement fait dans le pojet
                                                                    //Pour indiquer le chemin, par exemple : "C:\\Documents\\GestionFichier\\File1.txt"
            fw.write("");
            fw.close();
            //System.out.println("Ecriture sur le fichier reussi");
        }
        catch(IOException e)
        {
            System.out.println("An error has occured");
                e.printStackTrace();
        }
    }//GEN-LAST:event_deconnexionLabelMouseClicked

   
    /////////////////////////// FIN QUAND ON FAIT UNE RECHERCHE SUR L'EDT (admin & ref ped) ///////////////////////////
    
    

    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ReportingLabelTop;
    private javax.swing.JPanel adminRespoEdtPanel;
    private javax.swing.JComboBox<String> anneeCB;
    private javax.swing.JLabel anneeEdtLabel;
    private javax.swing.JLabel anneeLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel deconnexionLabel;
    private javax.swing.JLabel dixLabel;
    private javax.swing.JLabel dixhuitLabel;
    private javax.swing.JLabel dixneufLabel;
    private javax.swing.JLabel dixseptLabel;
    private javax.swing.JLabel douzeLabel;
    private javax.swing.JLabel droitLabel;
    private javax.swing.JPanel edtDisplayPanel;
    private javax.swing.JPanel edtPanel;
    private javax.swing.JPanel edtPanelBotRight;
    private javax.swing.JLabel emploidutempsLabel;
    private javax.swing.JComboBox<String> enseignantCB1;
    private javax.swing.JComboBox<String> enseignantCB2;
    private javax.swing.JComboBox<String> enseignantCB3;
    private javax.swing.JComboBox<String> enseignantCB4;
    private javax.swing.JComboBox<String> enseignantCB5;
    private javax.swing.JPanel firstBackgroundPanel;
    private javax.swing.JPanel gestionnaireContainerPanel;
    private javax.swing.JLabel gestionnaireLabel;
    private javax.swing.JPanel gestionnairePanel;
    private javax.swing.JComboBox<String> heureDebutCB;
    private javax.swing.JLabel heureDebutlabel;
    private javax.swing.JComboBox<String> heureFinCB;
    private javax.swing.JLabel heureFinlabel;
    private javax.swing.JLabel heureLabel;
    private javax.swing.JLabel huitLabel;
    private javax.swing.JLabel iconEce;
    private javax.swing.JButton insererButton;
    private javax.swing.JLabel insererLabel;
    private javax.swing.JPanel insererPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel jeudiDisplayPanel;
    private javax.swing.JLabel jeudiLabel;
    private javax.swing.JComboBox<String> jourCB;
    private javax.swing.JLabel jourLabel;
    private javax.swing.JPanel leftGreenPanel;
    private javax.swing.JPanel lundiDisplayPanel;
    private javax.swing.JLabel lundiLabel;
    private javax.swing.JPanel mardiDisplayPanel;
    private javax.swing.JLabel mardiLabel;
    private javax.swing.JPanel mercrediDisplayPanel;
    private javax.swing.JLabel mercrediLabel;
    private javax.swing.JLabel modifierLabel;
    private javax.swing.JPanel modifierPanel;
    private javax.swing.JComboBox<String> moisCB;
    private javax.swing.JLabel moisLabel;
    private javax.swing.JLabel nameUserLabel;
    private javax.swing.JComboBox<String> nbrEnseignantCB;
    private javax.swing.JLabel nbrEnseignantLabel;
    private javax.swing.JComboBox<String> nbrGroupeCB;
    private javax.swing.JLabel nbrGroupeLabel;
    private javax.swing.JLabel neufLabel;
    private javax.swing.JLabel nomDuCoursLabel;
    private javax.swing.JLabel onzeLabel;
    private javax.swing.JComboBox<String> promotionInsererCB;
    private javax.swing.JLabel promotionInsererLabel;
    private javax.swing.JLabel promotionLabel;
    private javax.swing.JLabel quatorzeLabel;
    private javax.swing.JLabel quinzeLabel;
    private javax.swing.JButton recapEdtRechercherButton;
    private javax.swing.JComboBox<String> recapEdtSearch;
    private javax.swing.JComboBox<String> recapEdtSearch2;
    private javax.swing.JComboBox<String> recapEdtSearch3;
    private javax.swing.JLabel recapMessageErreur;
    private javax.swing.JLabel recapMessageErreurEdt;
    private javax.swing.JPanel recapPanel;
    private javax.swing.JLabel recapPeriodeLabelTop;
    private javax.swing.JPanel recapPeriodeTriPanel;
    private javax.swing.JButton recapRechercherButton;
    private javax.swing.JScrollPane recapScrollPane;
    private javax.swing.JComboBox<String> recapSearch1;
    private javax.swing.JComboBox<String> recapSearch2;
    private javax.swing.JTable recapTable;
    private javax.swing.JLabel recapitulatifLabel;
    private javax.swing.JLabel reportingLabel;
    private javax.swing.JLabel reportingMessageErreur;
    private javax.swing.JPanel reportingPanel;
    private javax.swing.JPanel reportingPeriodeTriPanel;
    private javax.swing.JButton reportingRechercherButton;
    private javax.swing.JPanel reportingResumePanel;
    private javax.swing.JPanel reportingResumePanel2;
    private javax.swing.JComboBox<String> reportingSearch1;
    private javax.swing.JComboBox<String> reportingSearch2;
    private javax.swing.JLabel resumeInsertionLabel;
    private javax.swing.JPanel rightCardPanel;
    private javax.swing.JComboBox<String> salleCB;
    private javax.swing.JComboBox<String> salleCB1;
    private javax.swing.JLabel salleLabel;
    private javax.swing.JLabel seizeLabel;
    private javax.swing.JToggleButton semaine1;
    private javax.swing.JToggleButton semaine10;
    private javax.swing.JToggleButton semaine11;
    private javax.swing.JToggleButton semaine12;
    private javax.swing.JToggleButton semaine13;
    private javax.swing.JToggleButton semaine14;
    private javax.swing.JToggleButton semaine15;
    private javax.swing.JToggleButton semaine16;
    private javax.swing.JToggleButton semaine17;
    private javax.swing.JToggleButton semaine18;
    private javax.swing.JToggleButton semaine19;
    private javax.swing.JToggleButton semaine2;
    private javax.swing.JToggleButton semaine20;
    private javax.swing.JToggleButton semaine21;
    private javax.swing.JToggleButton semaine22;
    private javax.swing.JToggleButton semaine23;
    private javax.swing.JToggleButton semaine24;
    private javax.swing.JToggleButton semaine25;
    private javax.swing.JToggleButton semaine26;
    private javax.swing.JToggleButton semaine27;
    private javax.swing.JToggleButton semaine28;
    private javax.swing.JToggleButton semaine29;
    private javax.swing.JToggleButton semaine3;
    private javax.swing.JToggleButton semaine30;
    private javax.swing.JToggleButton semaine31;
    private javax.swing.JToggleButton semaine32;
    private javax.swing.JToggleButton semaine33;
    private javax.swing.JToggleButton semaine34;
    private javax.swing.JToggleButton semaine35;
    private javax.swing.JToggleButton semaine36;
    private javax.swing.JToggleButton semaine37;
    private javax.swing.JToggleButton semaine38;
    private javax.swing.JToggleButton semaine39;
    private javax.swing.JToggleButton semaine4;
    private javax.swing.JToggleButton semaine40;
    private javax.swing.JToggleButton semaine41;
    private javax.swing.JToggleButton semaine42;
    private javax.swing.JToggleButton semaine43;
    private javax.swing.JToggleButton semaine44;
    private javax.swing.JToggleButton semaine45;
    private javax.swing.JToggleButton semaine46;
    private javax.swing.JToggleButton semaine47;
    private javax.swing.JToggleButton semaine48;
    private javax.swing.JToggleButton semaine49;
    private javax.swing.JToggleButton semaine5;
    private javax.swing.JToggleButton semaine50;
    private javax.swing.JToggleButton semaine51;
    private javax.swing.JToggleButton semaine52;
    private javax.swing.JToggleButton semaine6;
    private javax.swing.JToggleButton semaine7;
    private javax.swing.JToggleButton semaine8;
    private javax.swing.JToggleButton semaine9;
    private javax.swing.JComboBox<String> semainePickerCB;
    private javax.swing.JPanel semainePickerPanel;
    private javax.swing.JSeparator separatorGEDT2;
    private javax.swing.JComboBox<String> siteCB;
    private javax.swing.JLabel siteLabel;
    private javax.swing.JComboBox<String> tdCB1;
    private javax.swing.JComboBox<String> tdCB10;
    private javax.swing.JComboBox<String> tdCB2;
    private javax.swing.JComboBox<String> tdCB3;
    private javax.swing.JComboBox<String> tdCB4;
    private javax.swing.JComboBox<String> tdCB5;
    private javax.swing.JComboBox<String> tdCB6;
    private javax.swing.JComboBox<String> tdCB7;
    private javax.swing.JComboBox<String> tdCB8;
    private javax.swing.JComboBox<String> tdCB9;
    private javax.swing.JLabel tdLabel;
    private javax.swing.JPanel topEdtPanel;
    private javax.swing.JLabel topGestionnaireLabel;
    private javax.swing.JPanel topRecapPanel;
    private javax.swing.JPanel topReportingPanel1;
    private javax.swing.JPanel topgestionnairePanel;
    private javax.swing.JLabel treizeLabel;
    private javax.swing.JLabel trierparEdtLabel;
    private javax.swing.JLabel trierparRecapLabel;
    private javax.swing.JLabel trierparReportingLabel;
    private javax.swing.JComboBox<String> typeCoursCB;
    private javax.swing.JLabel typeCoursLabel;
    private javax.swing.JPanel vendrediDisplayPanel;
    private javax.swing.JLabel vendrediLabel;
    private javax.swing.JLabel vingtLabel;
    private javax.swing.JLabel virguleEnseignantLabel;
    private javax.swing.JLabel virguleEnseignantLabel1;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
