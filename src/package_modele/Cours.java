package package_modele;

public class Cours {

/************************************************************* Attributs *****************************************************************************************************/
    
    //ID du cours 
    protected int id;
    //Nom du cours
    protected String Nom;

/********************************************************** Mise en place des constructeurs***********************************************************************************/
    
    /**
     *Constructeur de la class cours 
     * @param id
     * @param Nom
     */
    public Cours(int id, String Nom)
    {
        this.id=id;
        this.Nom=Nom;
    }
    
    /**
     *Constructeur de la class Cours avec en paramètre une variable de type cours
     * @param cours
     */
    public Cours(Cours cours)
    {
        this.id=cours.id;
        this.Nom=cours.Nom;
    }

    public Cours() {
    }

/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    
    /**
     * Récupére l'ID du cours
     * @return
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Affecter une valeur à ID 
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     *Récupére le nom du cours
     * @return
     */
    public String getNom()
    {
        return Nom;
    }
    
    /**
     *Affecte une valeur à nom 
     * @param Nom
     */
    public void setNom(String Nom)
    {
        this.Nom = Nom;
    }
}
