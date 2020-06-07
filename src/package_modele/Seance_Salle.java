package package_modele;

public class Seance_Salle {

    /**
     *ID de la Seance
     */
    protected int id_seance;

    /**
     * ID de la salle 
     */
    protected int id_salle;
    
     /**
     *Constructeur de la class Seance_Salle
     * @param id_seance ID de la Seance
     * @param id_salle ID de la salle
     */
    public Seance_Salle(int id_seance,int id_salle)
    {
        this.id_salle=id_salle;
        this.id_seance=id_seance;
    }
    
    /**
     *Constructeur de la class Seance_Salle avec en paramètre un attribut de type Seance_Salle
     * @param salle
     */
    public Seance_Salle(Seance_Salle salle)
    {
        this.id_salle=salle.id_salle;
        this.id_seance=salle.id_seance;
    }

    /**
     *Constructeur par défault
     */
    public Seance_Salle() {
    }

/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    
    /**
     * Récupérer l'ID de la salle
     * @return ID de la salle
     */
    public int getId_salle()
    {
        return id_salle;
    }
    
    /**
     *Affecter une ID à la salle
     * @param id_salle ID de la salle
     */
    public void setId_salle(int id_salle)
    {
        this.id_salle = id_salle;
    }
    
    /**
     * Récupérer l'ID de la Seance
     * @return ID de la Seance
     */
    public int getId_seance()
    {
        return id_seance;
    }
    
    /**
     * Affecter une ID à la Seance
     * @param id_seance ID de la Seance
     */
    public void setId_seance(int id_seance)
    {
        this.id_seance = id_seance;
    }
}
