package package_modele;
import java.util.*;

public class Enseignant {
    
    //Liste des Utilisateur
    private Set<Utilisateur> listUtilisateur = new HashSet<Utilisateur>();

    //Liste des Courss
    private Set<Cours> listCours = new HashSet<Cours>();

    Enseignant(int id, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Enseignant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Enseignant(int id, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Set<Utilisateur> getListUtilisateur() {
        return listUtilisateur;
    }

    public void setListUtilisateur(Set<Utilisateur> listUtilisateur) {
        this.listUtilisateur = listUtilisateur;
    }

    public void addUtilisateur(Utilisateur utilisateur) {
        if (!listUtilisateur.contains(utilisateur)) {
            listUtilisateur.add(utilisateur);
        }
    }

    public void removeUtilisateur(Utilisateur utilisateur) {
        this.listUtilisateur.remove(utilisateur);
    }

    public Set<Cours> getListCours() {
        return listCours;
    }

    public void setListCours(Set<Cours> listCours) {
        this.listCours = listCours;
    }

    //Ajoute un élève à la classe
    public void addCours(Cours cours) {
        if (!this.listCours.contains(cours)) {
            this.listCours.add(cours);
        }
    }

    //Retire un élève de la classe
    public void removeCours(Cours cours) {
        this.listCours.remove(cours);
    }
    
}
