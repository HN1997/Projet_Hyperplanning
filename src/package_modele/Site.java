package package_modele;

public class Site 
{

/************************************************************* Attributs *****************************************************************************************************/
    
    
    /**
     * ID de la salle
     */
    protected int id;

    /**
     *Nom de la salle
     */
    protected String Nom;

/********************************************************** Mise en place des constructeurs***********************************************************************************/        
    
    /**
     *Création d'un constructeur de la class
     * @param id ID de la salle
     * @param Nom Nom de la salle
     */
    public Site(int id, String Nom)
    {
        this.id=id;
        this.Nom=Nom;
    }
    
    /**
     *Création d'un constructeur surchargé
     * @param site
     */
    public Site(Site site)
    {
        this.id=site.id;
        this.Nom=site.Nom;
    }    

    /**
     *Création d'un constructeur défault 
     */
    public Site() {}
    
/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/    

//Getter et Setter pour l'ID     
    
    /**
     * Récupérer l'ID de la salle
     * @return ID de la salle
     */
    public int getId()
    {
        return id;
    }
    
    /**
     *Affecter un ID à la salle
     * @param id ID de la salle
     */
    public void setId(int id)
    {
        this.id = id;
    }

//Getter et Setter pour le Nom
    
    /**
     *Récupérer le Nom de la salle
     * @return Nom de la salle
     */
    public String getNom()
    {
        return Nom;
    }
    
    /**
     *Affecter un Nom à la salle
     * @param Nom Nom de la salle
     */
    public void setNom(String Nom)
    {
        this.Nom = Nom;
    }
}
