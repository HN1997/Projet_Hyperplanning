package package_modele;


public class Groupe {

/************************************************************* Attributs *****************************************************************************************************/
    
    //ID du groupe   
    protected int id;
    //Nom du groupe
    protected String Nom;
    //ID de la promotion à laquelle appartient le groupe
    protected int id_promotion;

/********************************************************** Mise en place des constructeurs***********************************************************************************/    
    
    /**
     *
     * @param id
     * @param Nom
     * @param id_promotion
     */
    public Groupe(int id, String Nom, int id_promotion) {
        this.id = id;
        this.Nom = Nom;
        this.id_promotion = id_promotion;
    }

    /**
     *
     * @param groupe
     */
    public Groupe(Groupe groupe) {
        this.id = groupe.id;
        this.Nom = groupe.Nom;
        this.id_promotion = groupe.id_promotion;
    }

    Groupe() {
    }

/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/    
    
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

    /**
     *
     * @return
     */
    public String getNom() {
        return Nom;
    }

    /**
     *
     * @param Nom
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    /**
     *
     * @return
     */
    public int getId_promotion() {
        return id_promotion;
    }

    /**
     *
     * @param id_promotion
     */
    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }

}
