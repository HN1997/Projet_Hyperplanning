package package_modele;

import java.util.ArrayList;

public class Seance_Groupe {

    /**
     * ID de la Seance
     */
    protected int id_seance;

    /**
     * ID du Groupe
     */
    protected int id_groupe;
    protected ArrayList<Integer> liste1;
    int element; 
    
     /**
     * Constructeur de la class de Seance_Groupe
     * @param id_groupe ID du Groupe 
     * @param id_seance ID de la Seance
     */
    public Seance_Groupe(int id_groupe,int id_seance)
    {
        this.id_groupe=id_groupe;
        this.id_seance=id_seance;
    }
    
    /**
     * Constructeur de la class de Seance_Groupe avec en paramètre un attribut du type Groupe
     * @param groupe
     */
    public Seance_Groupe(Seance_Groupe groupe)
    {
        this.id_groupe=groupe.id_groupe;
        this.id_seance=groupe.id_seance;
    }

    /**
     * Constructeur par défault
     */
    public Seance_Groupe() {}

/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    
    /**
     *Récupérer l'ID du Groupe 
     * @return ID du Groupe 
     */
    public int getId_groupe()
    {
        return id_groupe;
    }
    
    /**
     * Affecter un ID au Groupe 
     * @param id_groupe ID du Groupe
     */
    public void setId_groupe(int id_groupe)
    {
        this.id_groupe = id_groupe;
    }
    
    /**
     *Récupérer l'ID de la Seance
     * @return ID de la Seance
     */
    public int getId_seance()
    {
        return id_seance;
    }
    
    /**
     * Affecter un ID à la Seance
     * @param id_seance ID de la Seance
     */
    public void setId_seance(int id_seance)
    {
        this.id_seance = id_seance;
    }
}
