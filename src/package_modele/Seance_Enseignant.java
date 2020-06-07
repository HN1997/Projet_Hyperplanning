package package_modele;

import java.util.ArrayList;

public class Seance_Enseignant {

    /**
     * ID de la seance 
     */
    protected int id_seance;

    /**
     * ID de l'enseignant 
     */
    protected int id_enseignant;

    /**
     * ID du cours
     */
    protected int id_cours;
    
    protected ArrayList<Object> liste1;
    int element; 
    
     /**
     * Constructeur de la class Seance_Enseignant
     * @param id_seance ID de la seance
     * @param id_enseignant ID de l'enseignant
     * @param id_cours ID du cours
     */
    public Seance_Enseignant(int id_seance, int id_enseignant,int id_cours)
    {
        this.id_enseignant=id_enseignant;
        this.id_seance=id_seance;
        this.id_cours=id_cours;
    }
    
    /**
     * Constructeur de la class Seance_Enseignant en paramètre un attribut de type Seance_Enseignant
     * @param enseignant
     */
    public Seance_Enseignant(Seance_Enseignant enseignant)
    {
        this.id_enseignant=enseignant.id_enseignant;
        this.id_seance=enseignant.id_seance;
        this.id_cours=enseignant.id_cours;
    }

    /**
     * Constructeur par défault
     */
    public Seance_Enseignant() {
        
    }
    

/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    
    /**
     * Récupèrer l'ID de l'enseignant
     * @return ID de l'enseignant
     */
    public int getId_enseignant()
    {
        return id_enseignant;
    }
    
    /**
     * Affecte l'ID de l'enseignant
     * @param id_enseignant ID de l'enseignant
     */
    public void setId_enseignant(int id_enseignant)
    {
        this.id_enseignant = id_enseignant;
    }
    
    /**
     * Récupère l'ID de la seance 
     * @return ID de la seance
     */
    public int getId_seance()
    {
        return id_seance;
    }
    
    /**
     * Affecte un ID de la seance
     * @param id_seance ID de la seance
     */
    public void setId_seance(int id_seance)
    {
        this.id_seance = id_seance;
    }
    
    /**
     * Récupère l'ID du cours
     * @return ID du cours
     */
    public int getId_cours()
    {
        return id_cours;
    }
    
    /**
     * Affecte un ID du cours
     * @param id_cours ID du cours
     */
    public void setId_cours(int id_cours)
    {
        this.id_cours = id_cours;
    }
    
    public Object retourne_object(){
        return liste1.get(element);
    }
}
