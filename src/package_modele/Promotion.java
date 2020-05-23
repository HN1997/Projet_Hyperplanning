package package_modele;

public class Promotion {
    
/************************************************************* Attributs *****************************************************************************************************/    
    
    //ID de la promotion
    protected int id;
    //Nom de la Promotion
    protected String Nom;

/********************************************************** Mise en place des constructeurs***********************************************************************************/
    
    /**
     *
     * @param id
     * @param Nom
     */
    public Promotion(int id, String Nom)
    {
        this.id=id;
        this.Nom=Nom;
    }
    
    /**
     *
     * @param promotion
     */
    public Promotion(Promotion promotion)
    {
        this.id=promotion.id;
        this.Nom=promotion.Nom;
    }

    Promotion() {
    }

/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    
    /**
     *
     * @return
     */
    public int getId()
    {
        return id;
    }
    
    /**
     *
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     *
     * @return
     */
    public String getNom()
    {
        return Nom;
    }
    
    /**
     *
     * @param Nom
     */
    public void setNom(String Nom)
    {
        this.Nom = Nom;
    }
}
