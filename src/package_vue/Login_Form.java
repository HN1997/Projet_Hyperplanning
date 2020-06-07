package package_vue;
import java.awt.event.WindowEvent;
import javafx.stage.Stage;
import javax.swing.*;
import package_controleur.RechercheInformationsHugo;
import package_controleur.Rechercheinformations;


public class Login_Form extends javax.swing.JFrame {
    
    RechercheInformationsHugo ri;
    EDT_Window edt;
    
    public Login_Form() {
        ri = new RechercheInformationsHugo();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        greenBackgroundPanel = new javax.swing.JPanel();
        imageEceLabel = new javax.swing.JLabel();
        loginTxt = new javax.swing.JLabel();
        emailTxt = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        connexionButton = new javax.swing.JButton();
        rememberCheckBox = new javax.swing.JCheckBox();
        rememberText = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        greenBackgroundPanel.setBackground(new java.awt.Color(0, 113, 121));

        imageEceLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\hugon\\OneDrive\\Documents\\HyperPlanning Ress\\ece_moyen.png")); // NOI18N
        imageEceLabel.setToolTipText("");

        loginTxt.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        loginTxt.setForeground(new java.awt.Color(255, 255, 255));
        loginTxt.setText("Login");

        emailTxt.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        emailTxt.setForeground(new java.awt.Color(255, 255, 255));
        emailTxt.setText("Email :");

        emailInput.setBackground(new java.awt.Color(255, 255, 255));
        emailInput.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        emailInput.setForeground(new java.awt.Color(0, 0, 0));

        passwordTxt.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        passwordTxt.setForeground(new java.awt.Color(255, 255, 255));
        passwordTxt.setText("Password :");

        passwordInput.setBackground(new java.awt.Color(255, 255, 255));
        passwordInput.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        passwordInput.setForeground(new java.awt.Color(0, 0, 0));
        passwordInput.setCaretColor(new java.awt.Color(102, 255, 102));

        connexionButton.setBackground(new java.awt.Color(255, 255, 255));
        connexionButton.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        connexionButton.setForeground(new java.awt.Color(0, 113, 121));
        connexionButton.setText("Connexion");
        connexionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connexionButtonActionPerformed(evt);
            }
        });

        rememberCheckBox.setBackground(new java.awt.Color(0, 113, 121));
        rememberCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        rememberCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rememberCheckBoxActionPerformed(evt);
            }
        });

        rememberText.setForeground(new java.awt.Color(255, 255, 255));
        rememberText.setText("Remember me next time ?");

        javax.swing.GroupLayout greenBackgroundPanelLayout = new javax.swing.GroupLayout(greenBackgroundPanel);
        greenBackgroundPanel.setLayout(greenBackgroundPanelLayout);
        greenBackgroundPanelLayout.setHorizontalGroup(
            greenBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(greenBackgroundPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(greenBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(greenBackgroundPanelLayout.createSequentialGroup()
                        .addGroup(greenBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(greenBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailInput)
                            .addComponent(passwordInput, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(greenBackgroundPanelLayout.createSequentialGroup()
                        .addComponent(rememberText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(greenBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(greenBackgroundPanelLayout.createSequentialGroup()
                                .addGap(0, 6, Short.MAX_VALUE)
                                .addGroup(greenBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, greenBackgroundPanelLayout.createSequentialGroup()
                                        .addComponent(loginTxt)
                                        .addGap(106, 106, 106))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, greenBackgroundPanelLayout.createSequentialGroup()
                                        .addComponent(connexionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(82, 82, 82))))
                            .addGroup(greenBackgroundPanelLayout.createSequentialGroup()
                                .addComponent(rememberCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addComponent(imageEceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        greenBackgroundPanelLayout.setVerticalGroup(
            greenBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageEceLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
            .addGroup(greenBackgroundPanelLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(loginTxt)
                .addGap(55, 55, 55)
                .addGroup(greenBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTxt)
                    .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(greenBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTxt))
                .addGap(30, 30, 30)
                .addGroup(greenBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(greenBackgroundPanelLayout.createSequentialGroup()
                        .addComponent(rememberText)
                        .addGap(30, 30, 30)
                        .addComponent(connexionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rememberCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(greenBackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(greenBackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Appuie sur le bouton "connexion" */
    private void connexionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connexionButtonActionPerformed
        Object[] res = ri.Connexion(emailInput.getText(), passwordInput.getText());
        if((boolean)res[0])
        {
            //JOptionPane.showMessageDialog(null, "L'utilisateur s'est bien connetecte! Son droit est = " + (Integer)res[1]);
            this.dispose();
            edt = new EDT_Window(emailInput.getText(), passwordInput.getText());
            edt.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Email or password incorrect.");
            passwordInput.setText("");
        }
    }//GEN-LAST:event_connexionButtonActionPerformed

    //Si on decide de se rappeler de son email/password
    private void rememberCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rememberCheckBoxActionPerformed
        // TODO add your handling code here:
        //blabla
    }//GEN-LAST:event_rememberCheckBoxActionPerformed

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connexionButton;
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel emailTxt;
    private javax.swing.JPanel greenBackgroundPanel;
    private javax.swing.JLabel imageEceLabel;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel loginTxt;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JLabel passwordTxt;
    private javax.swing.JCheckBox rememberCheckBox;
    private javax.swing.JLabel rememberText;
    // End of variables declaration//GEN-END:variables

}
