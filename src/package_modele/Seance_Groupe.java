package package_modele;

import java.util.ArrayList;
import java.util.Set;

public class Seance_Groupe {

    protected int id_seance;
    protected int id_groupe;
    protected ArrayList<Integer> liste1;
    int element; 
    
     /**
     *
     * @param id_groupe
     * @param id_seance
     */
    public Seance_Groupe(int id_groupe,int id_seance)
    {
        this.id_groupe=id_groupe;
        this.id_seance=id_seance;
    }
    
    /**
     *
     * @param groupe
     */
    public Seance_Groupe(Seance_Groupe groupe)
    {
        this.id_groupe=groupe.id_groupe;
        this.id_seance=groupe.id_seance;
    }

    public Seance_Groupe() {}

/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    
    /**
     *
     * @return
     */
    public int getId_groupe()
    {
        return id_groupe;
    }
    
    /**
     *
     * @param id_groupe
     */
    public void setId_groupe(int id_groupe)
    {
        this.id_groupe = id_groupe;
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
