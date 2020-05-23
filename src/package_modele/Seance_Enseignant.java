package package_modele;

public class Seance_Enseignant {

    protected int id_seance;
    protected int id_enseignant;
    
     /**
     *
     * @param id_seance
     * @param id_enseignant
     */
    public Seance_Enseignant(int id_seance, int id_enseignant)
    {
        this.id_enseignant=id_enseignant;
        this.id_seance=id_seance;
    }
    
    /**
     *
     * @param enseignant
     */
    public Seance_Enseignant(Seance_Enseignant enseignant)
    {
        this.id_enseignant=enseignant.id_enseignant;
        this.id_seance=enseignant.id_seance;
    }

    Seance_Enseignant() {
    }

/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    
    /**
     *
     * @return
     */
    public int getId_enseignant()
    {
        return id_enseignant;
    }
    
    /**
     *
     * @param id_enseignant
     */
    public void setId_enseignant(int id_enseignant)
    {
        this.id_enseignant = id_enseignant;
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
