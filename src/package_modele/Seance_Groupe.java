package package_modele;
import java.util.*;

public class Seance_Groupe {
    
    //Liste des Seance
    private Set<Seance> listSeance = new HashSet<>();

    //Liste des Groupes
    private Set<Groupe> listGroupe = new HashSet<>();

    public Set<Seance> getListSeance() {
        return listSeance;
    }

    public void setListSeance(Set<Seance> listSeance) {
        this.listSeance = listSeance;
    }

    public void addSeance(Seance seance) {
        if (!listSeance.contains(seance)) {
            listSeance.add(seance);
        }
    }

    public void removeSeance(Seance seance) {
        this.listSeance.remove(seance);
    }

    public Set<Groupe> getListGroupe() {
        return listGroupe;
    }

    public void setListGroupe(Set<Groupe> listGroupe) {
        this.listGroupe = listGroupe;
    }

    //Ajoute un élève à la classe
    public void addGroupe(Groupe groupe) {
        if (!this.listGroupe.contains(groupe)) {
            this.listGroupe.add(groupe);
        }
    }

    //Retire un élève de la classe
    public void removeGroupe(Groupe groupe) {
        this.listGroupe.remove(groupe);
    }
    
}
