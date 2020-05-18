package package_modele;
import java.util.*;

public class Seance_Salle {
    
        //Liste des Seance
    private Set<Seance> listSeance = new HashSet<Seance>();

    //Liste des Salles
    private Set<Salle> listSalle = new HashSet<Salle>();

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

    public Set<Salle> getListSalle() {
        return listSalle;
    }

    public void setListSalle(Set<Salle> listSalle) {
        this.listSalle = listSalle;
    }

    //Ajoute un élève à la classe
    public void addSalle(Salle salle) {
        if (!this.listSalle.contains(salle)) {
            this.listSalle.add(salle);
        }
    }

    //Retire un élève de la classe
    public void removeSalle(Salle salle) {
        this.listSalle.remove(salle);
    }
    
}
