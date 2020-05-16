/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_vue;

/**
 *
 * @author hugon
 */
public class EDT_Window extends javax.swing.JFrame {

    private boolean edtSelected = true;
    private boolean recapSelected = false;
    private boolean majSelected = false;
    
    /**
     * Creates new form EDT_Window
     */
    public EDT_Window() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        gestionnaireLabel = new javax.swing.JLabel();
        deconnexionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        firstBackgroundPanel.setBackground(new java.awt.Color(204, 204, 204));

        leftGreenPanel.setBackground(new java.awt.Color(0, 113, 121));

        iconEce.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ece_200.png"))); // NOI18N

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
        promotionLabel.setText("ING3");

        tdLabel.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        tdLabel.setForeground(new java.awt.Color(204, 204, 204));
        tdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tdLabel.setText("TD05");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        emploidutempsLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        emploidutempsLabel.setForeground(new java.awt.Color(255, 255, 255));
        emploidutempsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emploidutempsLabel.setText("Emploi Du Temps");
        emploidutempsLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        recapitulatifLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        recapitulatifLabel.setForeground(new java.awt.Color(153, 153, 153));
        recapitulatifLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recapitulatifLabel.setText("Récapitulatif Période");

        gestionnaireLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        gestionnaireLabel.setForeground(new java.awt.Color(153, 153, 153));
        gestionnaireLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gestionnaireLabel.setText("Gestionnaire EDT");

        deconnexionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deconnexionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DeconnexionIcon_50.png"))); // NOI18N

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
            .addGroup(leftGreenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftGreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(promotionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(gestionnaireLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leftGreenPanelLayout.setVerticalGroup(
            leftGreenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftGreenPanelLayout.createSequentialGroup()
                .addComponent(iconEce, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(gestionnaireLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
                .addComponent(deconnexionLabel)
                .addContainerGap())
        );

        javax.swing.GroupLayout firstBackgroundPanelLayout = new javax.swing.GroupLayout(firstBackgroundPanel);
        firstBackgroundPanel.setLayout(firstBackgroundPanelLayout);
        firstBackgroundPanelLayout.setHorizontalGroup(
            firstBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstBackgroundPanelLayout.createSequentialGroup()
                .addComponent(leftGreenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1077, Short.MAX_VALUE))
        );
        firstBackgroundPanelLayout.setVerticalGroup(
            firstBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftGreenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EDT_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EDT_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EDT_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EDT_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EDT_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel deconnexionLabel;
    private javax.swing.JLabel droitLabel;
    private javax.swing.JLabel emploidutempsLabel;
    private javax.swing.JPanel firstBackgroundPanel;
    private javax.swing.JLabel gestionnaireLabel;
    private javax.swing.JLabel iconEce;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel leftGreenPanel;
    private javax.swing.JLabel nameUserLabel;
    private javax.swing.JLabel promotionLabel;
    private javax.swing.JLabel recapitulatifLabel;
    private javax.swing.JLabel tdLabel;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
