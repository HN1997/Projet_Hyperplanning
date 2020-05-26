package package_modele;

import java.sql.Date;
import java.sql.Time;


public class Seance {

/************************************************************* Attributs *****************************************************************************************************/
    
    //ID de la Seance
    protected int id;
    //Numéro de la semaine de la Seance
    protected int semaine;
    //Date de la Seance
    protected Date date;
    //Heure de début de la Seance
    protected Time Heure_Debut;
    //Heure de fin de la Seance
    protected Time Heure_Fin;
    //Status de la Seance
    protected String Status ;
    // R.V.B pour le code couleur de la Seance 
    protected int R;
    protected int V;
    protected int B;
    //ID du cours référencier par la Seance (Quel cours est concerné par la Seance)
    protected int id_cours;
    //ID du Type de cours en question cad si c'est un cours magistral , un TD...
    protected int id_type;
    //
/********************************************************** Mise en place des constructeurs***********************************************************************************/
    
    /**
     *
     * @param semaine
     * @param id
     * @param date
     * @param Heure_Debut
     * @param Heure_Fin
     * @param Status
     * @param R
     * @param V
     * @param B
     * @param id_cours
     * @param id_type
     */
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
    
    /**
     *
     * @param seance
     */
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

/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    
    /**
     *
     * @return
     */
    public int getId()
    {
        return id;
    }
    
    /**
     *
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     *
     * @return
     */
    public int getSemaine()
    {
        return semaine;
    }
    
    /**
     *
     * @param semaine
     */
    public void setSemaine(int semaine)
    {
        this.semaine = semaine;
    }
    
    /**
     *
     * @return
     */
    public Date getdate()
    {
        return date;
    }
    
    /**
     *
     * @param date
     */
    public void setdate(Date date)
    {
        this.date = date;
    }
    
    /**
     *
     * @return
     */
    public Time getHeure_Debut()
    {
        return Heure_Debut;
    }
    
    /**
     *
     * @param Heure_Debut
     */
    public void setHeure_Debut(Time Heure_Debut)
    {
        this.Heure_Debut = Heure_Debut;
    }
    
    /**
     *
     * @return
     */
    public Time getHeure_Fin()
    {
        return Heure_Fin;
    }
    
    /**
     *
     * @param Heure_Fin
     */
    public void setHeure_Fin(Time Heure_Fin)
    {
        this.Heure_Fin = Heure_Fin;
    }
    
    /**
     *
     * @return
     */
    public String getStatus()
    {
        return Status;
    }
    
    /**
     *
     * @param Status
     */
    public void setStatus (String Status)
    {
        this.Status = Status;
    }
    
    /**
     *
     * @return
     */
    public int getR()
    {
        return R;
    }
    
    /**
     *
     * @param R
     */
    public void setR(int R)
    {
        this.R = R;
    }
    
    /**
     *
     * @return
     */
    public int getV()
    {
        return V;
    }
    
    /**
     *
     * @param V
     */
    public void setV(int V)
    {
        this.V = V;
    }

    /**
     *
     * @return
     */
    public int getB()
    {
        return B;
    }
    
    /**
     *
     * @param B
     */
    public void setB(int B)
    {
        this.B = B;
    }
    
    /**
     *
     * @return
     */
    public int getId_cours()
    {
        return id_cours;
    }
    
    /**
     *
     * @param id_cours
     */
    public void setId_cours(int id_cours)
    {
        this.id_cours = id_cours;
    }
    
    /**
     *
     * @return
     */
    public int getId_type()
    {
        return id_type;
    }
    
    /**
     *
     * @param id_type
     */
    public void setId_type(int id_type)
    {
        this.id_type = id_type;
    }
    
}
