package package_modele;

public class Enseignant {

/************************************************************* Attributs *****************************************************************************************************/

    /**
     * ID de l'enseignant récupéré de l'Utilisateur 
     */
    protected int id;
    //

    /**
     * ID du cours au quel il est affecté 
     */
    protected int ID_cours;

/********************************************************** Mise en place des constructeurs***********************************************************************************/
    
    /**
     *Constructeur de la class Enseignant
     * @param id ID de l'enseignant récupéré de l'Utilisateur
     * @param ID_cours ID du cours au quel il est affecté 
     */
    public Enseignant(int id, int ID_cours)
    {
        this.id=id;
        this.ID_cours=ID_cours;
    }
    
    /**
     *Constructeur de la class Enseignant avec en paramètre une variable de type Enseignant 
     * @param enseignant
     */
    public Enseignant(Enseignant enseignant)
    {
        this.id=enseignant.id;
        this.ID_cours=enseignant.ID_cours;
    }

    /**
     *Constructeur par défault
     */
    Enseignant() {
    }

/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    
    /**
     * Récupére l'ID de l'Enseignant
     * @return ID de l'enseignant récupéré de l'Utilisateur
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Affecter une valeur à ID
     * @param id ID de l'enseignant récupéré de l'Utilisateur
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Récupére l'ID du Cours
     * @return ID du cours au quel il est affecté 
     */
    public int getID_cours()
    {
        return ID_cours;
    }
    
    /**
     * Affecter une valeur du cours
     * @param ID_cours ID du cours au quel il est affecté 
     */
    public void setID_cours(int ID_cours)
    {
        this.ID_cours = ID_cours;
    }
}
