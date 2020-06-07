package package_modele;

public class Salle 
{

/************************************************************* Attributs *****************************************************************************************************/
    
    /**
     * ID de la salle
     */
    protected int id;

    /**
     * Nom de la salle
     */
    protected String Nom;

    /**
     * Capacité de la salle
     */
    protected int Capacite;

    /**
     * Id du site au quel est attribué  la salle
     */
    protected int id_site;

/********************************************************** Mise en place des constructeurs***********************************************************************************/
    
    /**
     * Constructeur de la class Salle 
     * @param id ID de la salle
     * @param Nom Nom de la salle
     * @param Capacite Capacité de la salle
     * @param id_site Id du site au quel est attribué  la salle
     */
    public Salle(int id, String Nom,int Capacite,int id_site)
    {
        this.id=id;
        this.Nom=Nom;
        this.Capacite=Capacite;
        this.id_site=id_site;
    }
    
    /**
     * Constructeur de la class Salle avec en paramètre une variable du type Salle
     * @param salle
     */
    public Salle(Salle salle)
    {
        this.id=salle.id;
        this.Nom=salle.Nom;
        this.Capacite=salle.Capacite;
        this.id=salle.id_site;
    }

    /**
     * Constructeur par défault
     */
    public Salle() {
    }

/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    
    /**
     *
     * @return ID de la salle
     */
    public int getId()
    {
        return id;
    }
    
    /**
     *
     * @param id ID de la salle
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     *
     * @return Nom de la salle
     */
    public String getNom()
    {
        return Nom;
    }
    
    /**
     *
     * @param Nom Nom de la salle
     */
    public void setNom(String Nom)
    {
        this.Nom = Nom;
    }
    
    /**
     *
     * @return Capacité de la salle
     */
    public int getCapacite()
    {
        return Capacite;
    }
    
    /**
     *
     * @param Capacite Capacité de la salle
     */
    public void setCapacite(int Capacite)
    {
        this.Capacite = Capacite;
    }
    
    /**
     *
     * @return Id du site au quel est attribué  la salle
     */
    public int getId_site()
    {
        return id_site;
    }
    
    /**
     *
     * @param id_site Id du site au quel est attribué  la salle
     */
    public void setId_site(int id_site)
    {
        this.id_site = id_site;
    }
}
