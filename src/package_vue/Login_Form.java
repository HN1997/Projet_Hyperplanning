package package_vue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import package_controleur.RechercheInformations;

/** Aiffche le menu du login */
public class Login_Form extends javax.swing.JFrame {
    
    RechercheInformations ri;
    EDT_Window edt;
    
    public Login_Form() {
        ri = new RechercheInformations();
        initComponents();
        
    }
    
    /** methode pour recup l'email et le password dans le fichier */
    public ArrayList<String> GetEmailPasswordLog()
    {
        String email = "";
        String password = "";
        ArrayList<String> retour = new ArrayList<>();
        
        try {
            File fichier = new File("LOGMDP.txt"); 
            Scanner scan = new Scanner(fichier);
            if(scan.hasNextLine())
            {
                email = scan.nextLine();
            }
            if(scan.hasNextLine())
            {
                password = scan.nextLine();
            }
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("An error occured.");
            Logger.getLogger(Login_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        retour.add(email);
        retour.add(password);
        return retour;
    }
    
    /* va a la prochaine fenetre si le fichier log comprend un email et mdp, renvoie true si cela a ete effectue */
    public boolean GoNextWindow(ArrayList<String> emailPassword)
    {
        String email = emailPassword.get(0);
        String password = emailPassword.get(1);
        Object[] res = ri.Connexion(email, password);
        if((boolean)res[0])
        {
            edt = new EDT_Window(email, password);
            edt.setVisible(true);
            SauvegardeFichier();
            return true;
        }
        return false;
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

    /** sauvegarde dans le fichier l'email et le mot de passe, où rien */
    public void SauvegardeFichier()
    {
        if(rememberCheckBox.isSelected()) //si il choisit de garder son mdp 
            {
                try
                {
                    FileWriter fw = new FileWriter("LOGMDP.txt");    //On peut spécifier ici le chemin que l'on veut, si on ne le fait pas ce sera automatiquement fait dans le pojet
                                                                    //Pour indiquer le chemin, par exemple : "C:\\Documents\\GestionFichier\\File1.txt"
                    fw.write(emailInput.getText() + "\n" + passwordInput.getText());
                    fw.close();
                    //System.out.println("Ecriture sur le fichier reussi");
                }
                catch(IOException e)
                {
                    System.out.println("An error has occured");
                    e.printStackTrace();
                }
            }
            else
            {
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
            }
    }
    
    /** Appuie sur le bouton "connexion" */
    private void connexionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connexionButtonActionPerformed
        Object[] res = ri.Connexion(emailInput.getText(), passwordInput.getText());
        if((boolean)res[0])
        {
            //JOptionPane.showMessageDialog(null, "L'utilisateur s'est bien connetecte! Son droit est = " + (Integer)res[1]);
            this.dispose();
            edt = new EDT_Window(emailInput.getText(), passwordInput.getText());
            edt.setVisible(true);
            SauvegardeFichier();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Email or password incorrect.");
            passwordInput.setText("");
        }
    }//GEN-LAST:event_connexionButtonActionPerformed

    
    private void rememberCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rememberCheckBoxActionPerformed
        // TODO add your handling code here:
        //blabla
    }//GEN-LAST:event_rememberCheckBoxActionPerformed

    /** lance l'appli */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login_Form lf = new Login_Form();
                boolean f = lf.GoNextWindow(lf.GetEmailPasswordLog());
                if(!f)
                    lf.setVisible(true);
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
