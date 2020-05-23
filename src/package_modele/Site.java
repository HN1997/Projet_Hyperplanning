package package_modele;

/**
 *
 * @author ShadowZeus
 */


public class Site 
{

/************************************************************* Attributs *****************************************************************************************************/
    
    protected int id;
    protected String Nom;

/********************************************************** Mise en place des constructeurs***********************************************************************************/        

//Création d'un constructeur surchargé
    
    /**
     *
     * @param id
     * @param Nom
     */
    public Site(int id, String Nom)
    {
        this.id=id;
        this.Nom=Nom;
    }

//Création d'un constructeur surchargé
    
    /**
     *
     * @param site
     */
    public Site(Site site)
    {
        this.id=site.id;
        this.Nom=site.Nom;
    }

//Création d'un constructeur défault    
    
    Site() {}
    
/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/    

//Getter et Setter pour l'ID     
    
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

//Getter et Setter pour le Nom
    
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
