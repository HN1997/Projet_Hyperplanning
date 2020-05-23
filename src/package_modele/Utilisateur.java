package package_modele;

/**
 *
 * @author ShadowZeus and OpenclassRoom("https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java/26830-liez-vos-tables-avec-des-objets-java-le-pattern-dao") 
 */


public class Utilisateur {
    

  //ID de l'utilisateur
  protected int id = 0;
  //Nom de l'utilisateur
  protected String nom = "";
  //Prenom de l'utilisateur
  protected String prenom = "";
  //Email de l'utilisateur
  protected String email = "";
  //Mot de Passe de l'utilisateur
  protected String passwd = "";
  //Droit de l'utilisateur
  protected int droit = 0;

/********************************************************** Mise en place des constructeurs***********************************************************************************/  
   
  //Constructeur par défaut surchargé
  
    /**
     *
     * @param id
     * @param nom
     * @param prenom
     * @param email
     * @param passwd
     * @param droit
     */
    public Utilisateur(int id, String nom, String prenom,String email,String passwd,int droit ) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.email=email;
    this.passwd=passwd;
    this.droit=droit;
  }
  
  //Constructeur par défaut 

    /**
     *
     */
  public Utilisateur(){};
  
/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    

// Getter et Setter pour l'ID  
  /**
     *
     * @return
     */
  public int getId() {
    return id;
  }

    /**
     *
     * @param id
     */
    public void setId(int id) {
    this.id = id;
  }

  
// Getter et Setter pour le Nom  

    /**
     *
     * @return
     */

  public String getNom() {
    return nom;
  }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
    this.nom = nom;
  }

// Getter et Setter pour le Prenom

    /**
     *
     * @return
     */
  
  public String getPrenom() {
    return prenom;
  }

    /**
     *
     * @param prenom
     */
    public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

    
// Getter et Setter pour l'Email      
    
    /**
     *
     * @return
     */
    public String getEmail() {
    return email;
  }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
    this.email = email;
  }
    
// Getter et Setter pour le Mot de passe    
  
    /**
     *
     * @return
     */
    public String getPasswd() {
    return passwd;
  }

    /**
     *
     * @param passwd
     */
    public void setPasswd(String passwd) {
    this.passwd = passwd;
  }
    
// Getter et Setter pour le droit    
  
    /**
     *
     * @return
     */
    public int getDroit() {
    return droit;
  }

    /**
     *
     * @param droit
     */
    public void setDroit(int droit) {
    this.droit = droit;
  }
    
}
