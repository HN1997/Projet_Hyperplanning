package package_modele;

public class Promotion {
    
/************************************************************* Attributs *****************************************************************************************************/    
    
    /**
     * ID de la promotion
     */
    protected int id;
    

    /**
     * Nom de la Promotion
     */
    protected String Nom;

/********************************************************** Mise en place des constructeurs***********************************************************************************/
    
    /**
     * Constructeur de la class Promotion
     * @param id ID de la promotion
     * @param Nom Nom de la Promotion
     */
    public Promotion(int id, String Nom)
    {
        this.id=id;
        this.Nom=Nom;
    }
    
    /**
     * Constructeur de la class Promotion avec en paramètre une variable de type promotion
     * @param promotion
     */
    public Promotion(Promotion promotion)
    {
        this.id=promotion.id;
        this.Nom=promotion.Nom;
    }

    /**
     * Constructeur par défault
     */
    public Promotion() {
    }

/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    
    /**
     * Récupère l'ID de la promotion 
     * @return ID de la promotion
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Affecte un ID à une promotion en particulier 
     * @param id ID de la promotion
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Recupère le Nom de la promotion
     * @return Nom de la Promotion
     */
    public String getNom()
    {
        return Nom;
    }
    
    /**
     * Affecte un Nom à une promotion en particulier  
     * @param Nom Nom de la Promotion
     */
    public void setNom(String Nom)
    {
        this.Nom = Nom;
    }
}
