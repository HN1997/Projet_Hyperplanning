package package_modele;

import java.util.ArrayList;

public class Seance_Enseignant {

    protected int id_seance;
    protected int id_enseignant;
    protected int id_cours;
    protected ArrayList<Object> liste1;
    int element; 
    
     /**
     *
     * @param id_seance
     * @param id_enseignant
     * @param id_cours
     */
    public Seance_Enseignant(int id_seance, int id_enseignant,int id_cours)
    {
        this.id_enseignant=id_enseignant;
        this.id_seance=id_seance;
        this.id_cours=id_cours;
    }
    
    /**
     *
     * @param enseignant
     */
    public Seance_Enseignant(Seance_Enseignant enseignant)
    {
        this.id_enseignant=enseignant.id_enseignant;
        this.id_seance=enseignant.id_seance;
        this.id_cours=enseignant.id_cours;
    }

    public Seance_Enseignant() {
        
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
    
    public int getId_cours()
    {
        return id_cours;
    }
    
    /**
     * @param id_cours
     */
    public void setId_cours(int id_cours)
    {
        this.id_cours = id_cours;
    }
    
    public Object retourne_object(){
        return liste1.get(element);
    }
}
