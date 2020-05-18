package package_modele;
import java.util.*;

public class Etudiant {
    
    private int Numero;
    
    //Liste des Utilisateur
    private Set<Utilisateur> listUtilisateur = new HashSet<Utilisateur>();
    //Liste des Groupes
    private Set<Groupe> listGroupe = new HashSet<Groupe>();
    
    public Etudiant(int Numero) {
        this.Numero = Numero;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
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
    
    public boolean equals(Etudiant etudiant) {
        return this.getNumero() == etudiant.getNumero();
    }
    
}
