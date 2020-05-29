package package_modele;

public class Seance_Salle {

    protected int id_seance;
    protected int id_salle;
    
     /**
     *
     * @param id_seance
     * @param id_salle
     */
    public Seance_Salle(int id_seance,int id_salle)
    {
        this.id_salle=id_salle;
        this.id_seance=id_seance;
    }
    
    /**
     *
     * @param salle
     */
    public Seance_Salle(Seance_Salle salle)
    {
        this.id_salle=salle.id_salle;
        this.id_seance=salle.id_seance;
    }

    Seance_Salle() {
    }

/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    
    /**
     *
     * @return
     */
    public int getId_salle()
    {
        return id_salle;
    }
    
    /**
     *
     * @param id_salle
     */
    public void setId_salle(int id_salle)
    {
        this.id_salle = id_salle;
    }
    
    /**
     *
     * @return
     */
    public int getId_seance()
    {
        return id_seance;
    }
    
    /**
     * @param id_seance
     */
    public void setId_seance(int id_seance)
    {
        this.id_seance = id_seance;
    }
}
