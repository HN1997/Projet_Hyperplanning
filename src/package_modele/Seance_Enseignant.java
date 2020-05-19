package package_modele;
import java.util.*;

public class Seance_Enseignant {
    
    //Liste des Seance
    private Set<Seance> listSeance = new HashSet<Seance>();

    //Liste des Enseignants
    private Set<Enseignant> listEnseignant = new HashSet<Enseignant>();

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

    public Set<Enseignant> getListEnseignant() {
        return listEnseignant;
    }

    public void setListEnseignant(Set<Enseignant> listEnseignant) {
        this.listEnseignant = listEnseignant;
    }

    //Ajoute un élève à la classe
    public void addEnseignant(Enseignant enseignant) {
        if (!this.listEnseignant.contains(enseignant)) {
            this.listEnseignant.add(enseignant);
        }
    }

    //Retire un élève de la classe
    public void removeEnseignant(Enseignant enseignant) {
        this.listEnseignant.remove(enseignant);
    }
    
    
}
