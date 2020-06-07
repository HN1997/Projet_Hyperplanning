package package_modele;

public class Utilisateur {

    /**
     *ID de l'utilisateur
     */
  protected int id = 0;

    /**
     *Nom de l'utilisateur
     */
  protected String nom = "";

    /**
     *Prenom de l'utilisateur
     */
  protected String prenom = "";

    /**
     *Email de l'utilisateur
     */
  protected String email = "";

    /**
     *Mot de Passe de l'utilisateur
     */
  protected String passwd = "";
  //

    /**
     * Droit de l'utilisateur(1=Admin ; 2=Respo Pedagogique; 3= Enseignant ; 4= Etudiant )
     */
  protected int droit = 0;

/********************************************************** Mise en place des constructeurs***********************************************************************************/  
    
    /**
     * Constructeur pour la class Utilisateur 
     * @param id ID de l'utilisateur
     * @param nom Nom de l'utilisateur
     * @param prenom Prenom de l'utilisateur
     * @param email Email de l'utilisateur
     * @param passwd Mot de Passe de l'utilisateur
     * @param droit Droit de l'utilisateur(1=Admin ; 2=Respo Pedagogique; 3= Enseignant ; 4= Etudiant )
     */
    public Utilisateur(int id, String nom, String prenom,String email,String passwd,int droit ) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.email=email;
    this.passwd=passwd;
    this.droit=droit;
  }

    /**
     *Constructeur par défaut
     */
  public Utilisateur(){};
  
/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    

// Getter et Setter pour l'ID  
    /**
     * Récupérer l'ID de l'utilisateur 
     * @return ID de l'utilisateur
     */
  public int getId() {
    return id;
  }

    /**
     *Affecter un ID à l'utilisateur
     * @param id ID de l'utilisateur
     */
    public void setId(int id) {
    this.id = id;
  }

  
// Getter et Setter pour le Nom  

    /**
     *Récupérer le Nom de l'utilisateur
     * @return Nom de l'utilisateur
     */

  public String getNom() {
    return nom;
  }

    /**
     *Affecter un Nom à l'utilisateur
     * @param nom Nom de l'utilisateur
     */
    public void setNom(String nom) {
    this.nom = nom;
  }

// Getter et Setter pour le Prenom

    /**
     * Recuperer le Prenom de l'utilisateur
     * @return Prenom de l'utilisateur
     */
  
  public String getPrenom() {
    return prenom;
  }

    /**
     * Affecter un Prenom à l'utilisateur
     * @param prenom Prenom de l'utilisateur
     */
    public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

    
// Getter et Setter pour l'Email      
    
    /**
     * Récupérer l'Email de l'utilisateur
     * @return Email de l'utilisateur
     */
    public String getEmail() {
    return email;
  }

    /**
     *Affecter un Email à l'utilisateur 
     * @param email
     */
    public void setEmail(String email) {
    this.email = email;
  }
    
// Getter et Setter pour le Mot de passe    
  
    /**
     * Récupérer le mot de passe de l'utilisateur 
     * @return Mot de passe de l'utilisateur 
     */
    public String getPasswd() {
    return passwd;
  }

    /**
     *Affecter un mot de passe à un utilisateur 
     * @param passwd Mot de passe de l'utilisateur 
     */
    public void setPasswd(String passwd) {
    this.passwd = passwd;
  }
    
// Getter et Setter pour le droit    
  
    /**
     *Récuperer le droit de l'utilisateur 
     * @return Droit de l'utilisateur(1=Admin ; 2=Respo Pedagogique; 3= Enseignant ; 4= Etudiant )
     */
    public int getDroit() {
    return droit;
  }

    /**
     *Affecter un droit à l'utilisateur 
     * @param droit Droit de l'utilisateur(1=Admin ; 2=Respo Pedagogique; 3= Enseignant ; 4= Etudiant )
     */
    public void setDroit(int droit) {
    this.droit = droit;
  }
    
}
