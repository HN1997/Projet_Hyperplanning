package package_modele;

public class Enseignant {

/************************************************************* Attributs *****************************************************************************************************/
    
    //ID de l'enseignant récupéré de l'Utilisateur
    protected int id;
    //ID du cours au quel il est affecté 
    protected int ID_cours;

/********************************************************** Mise en place des constructeurs***********************************************************************************/
    
    /**
     *
     * @param id
     * @param ID_cours
     */
    public Enseignant(int id, int ID_cours)
    {
        this.id=id;
        this.ID_cours=ID_cours;
    }
    
    /**
     *
     * @param enseignant
     */
    public Enseignant(Enseignant enseignant)
    {
        this.id=enseignant.id;
        this.ID_cours=enseignant.ID_cours;
    }

    Enseignant() {
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
    public int getID_cours()
    {
        return ID_cours;
    }
    
    /**
     *
     * @param ID_cours
     */
    public void setID_cours(int ID_cours)
    {
        this.ID_cours = ID_cours;
    }
}
