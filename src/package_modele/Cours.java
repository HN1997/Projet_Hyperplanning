package package_modele;

public class Cours {

/************************************************************* Attributs *****************************************************************************************************/
    
    //ID du cours 
    protected int id;
    //Nom du cours
    protected String Nom;

/********************************************************** Mise en place des constructeurs***********************************************************************************/
    
    /**
     *
     * @param id
     * @param Nom
     */
    public Cours(int id, String Nom)
    {
        this.id=id;
        this.Nom=Nom;
    }
    
    /**
     *
     * @param cours
     */
    public Cours(Cours cours)
    {
        this.id=cours.id;
        this.Nom=cours.Nom;
    }

    Cours() {
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
