package package_modele;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Seance_Groupe {

    protected int id_seance;
    protected int id_groupe;
    protected Set<Seance> listSeance = new HashSet<Seance>();
    protected Set<Groupe> listGroupe = new HashSet<Groupe>();
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
    
    public Set<Seance> getListSeance() {
        return listSeance;
    }

    public void setListSeance(Set<Seance> listSeance) {
        this.listSeance = listSeance;
    }
    
//    //Ajoute une matière à un professeur
    public void addSeance(Seance matiere) {
        this.listSeance.add(matiere);
    }

//    //Retire une matière à un professeur
    public void removeSeance(Seance matiere) {
        this.listSeance.remove(matiere);
    }
    
    public Set<Groupe> getListGroupe() {
        return listGroupe;
    }

    public void setListGroupe(Set<Groupe> listGroupe) {
        this.listGroupe = listGroupe;
    }

    //Ajoute une matière à un professeur
    public void addGroupe(Groupe matiere) {
        this.listGroupe.add(matiere);
    }

    //Retire une matière à un professeur
    public void removeGroupe(Groupe matiere) {
        this.listGroupe.remove(matiere);
    }
    
//    public Object retourne_object(){
//        return liste1.get(element);
//    }
//    
//    public void ajouter(int o){
//        liste1.add(o);
//    }
//    
//    public void affiche(){
//        for (int i=0; i<liste1.size();i++){
//           System.out.println(liste1.get(i));
//        }
//    }
    
}
