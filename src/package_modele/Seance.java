package package_modele;

import java.sql.Date;
import java.sql.Time;


public class Seance {
    
    protected int id;
    protected int semaine;
    protected Date date;
    protected Time Heure_Debut;
    protected Time Heure_Fin;
    protected String Etat;
    protected String Status ;
    protected int R;
    protected int V;
    protected int B;
    protected int id_cours;
    protected int id_type;
    
    
    
    public Seance(int semaine, int id,Date date,Time Heure_Debut,Time Heure_Fin,String Status, int R, int V, int B,int id_cours,int id_type)
    {
        this.id=id;
        this.semaine=semaine;
        this.date=date;
        this.Heure_Debut=Heure_Debut;
        this.Heure_Fin= Heure_Fin;
        this.Status=Status;
        this.R=R;
        this.V=V;
        this.B=B;
        this.id_cours=id_cours;
        this.id_type=id_type;
    }
    
    public Seance(Seance seance)
    {
        this.id=seance.id;
        this.semaine=seance.semaine;
        this.date=seance.date;
        this.Heure_Debut=seance.Heure_Debut;
        this.Heure_Fin=seance.Heure_Fin;
        this.Status=seance.Status;
        this.R=seance.R;
        this.V=seance.V;
        this.B=seance.B;
    }

    Seance() {
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
    
    public Date getdate()
    {
        return date;
    }
    
    public void setdate(Date date)
    {
        this.date = date;
    }
    
    public Time getHeure_Debut()
    {
        return Heure_Debut;
    }
    
    public void setHeure_Debut(Time Heure_Debut)
    {
        this.Heure_Debut = Heure_Debut;
    }
    
    public Time getHeure_Fin()
    {
        return Heure_Fin;
    }
    
    public void setHeure_Fin(Time Heure_Fin)
    {
        this.Heure_Fin = Heure_Fin;
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
    
    public int getId_cours()
    {
        return id_cours;
    }
    
    public void setId_cours(int id_cours)
    {
        this.id_cours = id_cours;
    }
    
    public int getId_type()
    {
        return id_type;
    }
    
    public void setId_type(int id_type)
    {
        this.id_type = id_type;
    }
    
}
