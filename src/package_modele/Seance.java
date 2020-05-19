package package_modele;
import java.util.*;


public class Seance {
    
    private int id;
    private int semaine;
    private int date;
    private int Heure_Debut;
    private int Heure_Fin;
    private String Etat;
    private String Status ;
    private int R;
    private int V;
    private int B;
    
    private Set<Cours> ListCours = new HashSet<>();
    private Set<Type_Cours> ListType_Cours = new HashSet<>();
    
    
    public Seance(int id, int semaine,int date,int Heure_Debut,int Heure_Fin,String Etat,String Status, int R, int V, int B)
    {
        this.id=id;
        this.semaine=semaine;
        this.date=date;
        this.Heure_Debut=Heure_Debut;
        this.Heure_Fin= Heure_Fin;
        this.Etat=Etat;
        this.Status=Status;
        this.R=R;
        this.V=V;
        this.B=B;
    }
    
    public Seance(Seance seance)
    {
        this.id=seance.id;
        this.semaine=seance.semaine;
        this.date=seance.date;
        this.Etat=seance.Etat;
        this.Heure_Debut=seance.Heure_Debut;
        this.Heure_Fin=seance.Heure_Fin;
        this.Status=seance.Status;
        this.R=seance.R;
        this.V=seance.V;
        this.B=seance.B;
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public int getSemaine()
    {
        return semaine;
    }
    
    public void setSemaine(int semaine)
    {
        this.semaine = semaine;
    }
    
    public int getdate()
    {
        return date;
    }
    
    public void setdate(int date)
    {
        this.date = date;
    }
    
    public int getHeure_Debut()
    {
        return Heure_Debut;
    }
    
    public void setHeure_Debut(int Heure_Debut)
    {
        this.Heure_Debut = Heure_Debut;
    }
    
    public int getHeure_Fin()
    {
        return Heure_Fin;
    }
    
    public void setHeure_Fin(int Heure_Fin)
    {
        this.Heure_Fin = Heure_Fin;
    }
    
    public String getEtat()
    {
        return Etat;
    }
    
    public void setEtat(String Etat)
    {
        this.Etat = Etat;
    }
    
    public String getStatus()
    {
        return Status;
    }
    
    public void setStatus (String Status)
    {
        this.Status = Status;
    }
    
    public int getR()
    {
        return R;
    }
    
    public void setR(int R)
    {
        this.R = R;
    }
    
    public int getV()
    {
        return V;
    }
    
    public void setV(int V)
    {
        this.V = V;
    }
    public int getB()
    {
        return B;
    }
    
    public void setB(int B)
    {
        this.B = B;
    }
    
    public Set<Cours> getListCours() {
        return ListCours;
    }

    public void setListCours(Set<Cours> ListCours) {
        this.ListCours = ListCours;
    }

    //Ajoute une salle à un cours
    public void addCours(Cours cours) {
        this.ListCours.add(cours);
    }

    //Retire une salle à un cours
    public void removeCours(Cours cours) {
        this.ListCours.remove(cours);
    }
    
            public Set<Type_Cours> getListType_Cours() 
    {
        return ListType_Cours;
    }

    public void setListType_Cours(Set<Type_Cours> ListType_Cours) 
    {
        this.ListType_Cours = ListType_Cours;
    }

  //Ajoute une salle à un type_cours
    public void addType_Cours(Type_Cours type_cours)
    {
        this.ListType_Cours.add(type_cours);
    }

  //Retire une salle à un type_cours
    public void removeType_Cours(Type_Cours type_cours)
    {
        this.ListType_Cours.remove(type_cours);
    }
}
