package package_modele;

public class Salle 
{

/************************************************************* Attributs *****************************************************************************************************/
    
    protected int id;
    protected String Nom;
    protected int Capacite;
    protected int id_site;

/********************************************************** Mise en place des constructeurs***********************************************************************************/
    
    /**
     *
     * @param id
     * @param Nom
     * @param Capacite
     * @param id_site
     */
    public Salle(int id, String Nom,int Capacite,int id_site)
    {
        this.id=id;
        this.Nom=Nom;
        this.Capacite=Capacite;
        this.id_site=id_site;
    }
    
    /**
     *
     * @param salle
     */
    public Salle(Salle salle)
    {
        this.id=salle.id;
        this.Nom=salle.Nom;
        this.Capacite=salle.Capacite;
        this.id=salle.id_site;
    }

    Salle() {
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
    
    /**
     *
     * @return
     */
    public int getCapacite()
    {
        return Capacite;
    }
    
    /**
     *
     * @param Capacite
     */
    public void setCapacite(int Capacite)
    {
        this.Capacite = Capacite;
    }
    
    /**
     *
     * @return
     */
    public int getId_site()
    {
        return id_site;
    }
    
    /**
     *
     * @param id_site
     */
    public void setId_site(int id_site)
    {
        this.id_site = id_site;
    }
}
