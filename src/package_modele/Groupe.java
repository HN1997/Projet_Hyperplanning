package package_modele;


public class Groupe {

/************************************************************* Attributs *****************************************************************************************************/
    
    /**
     * ID du groupe
     */
    protected int id;

    /**
     * Nom du groupe
     */
    protected String Nom;

    /**
     *ID de la promotion à laquelle appartient le groupe
     */
    protected int id_promotion;

/********************************************************** Mise en place des constructeurs***********************************************************************************/    
    
    /**
     * Construteur de la class Groupe 
     * @param id ID du Groupe
     * @param Nom Nom du Groupe
     * @param id_promotion ID de la promotion à laquelle appartient le Groupe
     */
    public Groupe(int id, String Nom, int id_promotion) {
        this.id = id;
        this.Nom = Nom;
        this.id_promotion = id_promotion;
    }

    /**
     * Construteur de la class Groupe avec en variable un type Groupe 
     * @param groupe 
     */
    public Groupe(Groupe groupe) {
        this.id = groupe.id;
        this.Nom = groupe.Nom;
        this.id_promotion = groupe.id_promotion;
    }

    /**
     * Constructeur par défaut
     */
    public Groupe() {
    }

/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/    
    
    /**
     * Récupère l'ID du Groupe
     * @return L'ID du groupe
     */
    public int getId() {
        return id;
    }

    /**
     * Affecte un ID en particulier 
     * @param id L'ID du groupe
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Récupère le Nom du Groupe
     * @return Le Nom du groupe
     */
    public String getNom() {
        return Nom;
    }

    /**
     * Affecte un Nom du Groupe en particulier 
     * @param Nom Nom du Groupe
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    /**
     * Récupère l'ID du promotion en fonction de la promotion
     * @return L'ID de la promotion au quel appartient le groupe 
     */
    public int getId_promotion() {
        return id_promotion;
    }

    /**
     * Affecte un ID à la promotion en adéquation avec le nom du groupe
     * @param id_promotion L'ID de la promotion au quel appartient le groupe
     */
    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }

}
