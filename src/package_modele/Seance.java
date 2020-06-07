package package_modele;

import java.sql.Date;
import java.sql.Time;


public class Seance {

/************************************************************* Attributs *****************************************************************************************************/
    
    /**
     * ID de la Seance
     */
    protected int id;

    /**
     * Numéro de la semaine de la Seance
     */
    protected int semaine;

    /**
     * Date de la Seance
     */
    protected String date1;

    /**
     * Date de la Seance
     */
    protected Date date;

    /**
     * Heure de début de la Seance
     */
    protected String Heure_Debut1;

    /**
     * Heure de début de la Seance
     */
    protected Time Heure_Debut;

    /**
     * Heure de fin de la Seance
     */
    protected String Heure_Fin1;

    /**
     * Heure de fin de la Seance
     */
    protected Time Heure_Fin;

    /**
     * Status de la Seance (Validé, En cours de validation, Annulé)
     */
    protected String Status ; 

    /**
     * Couleur Rouge
     */
    protected int R;

    /**
     * Couleur Vert 
     */
    protected int V;

    /**
     * Couleur bleu
     */
    protected int B;

    /**
     * ID du cours référencier par la Seance (Quel cours est concerné par la Seance)
     */
    protected int id_cours;

    /**
     * ID du Type de cours en question cad si c'est un cours magistral , un TD...
     */
    protected int id_type;
    //
/********************************************************** Mise en place des constructeurs***********************************************************************************/
    
    /**
     * Constructeur de la class Seance 
     * @param semaine Numéro de la semaine de la Seance
     * @param id ID de la Seance
     * @param date Date du seance
     * @param Heure_Debut Heure de début de la Seance
     * @param Heure_Fin Heure de fin de la Seance
     * @param Status Status de la Seance (Validé, En cours de validation, Annulé)
     * @param R Couleur Rouge
     * @param V Couleur Vert
     * @param B Couleur Bleu
     * @param id_cours ID du cours référencier par la Seance (Quel cours est concerné par la Seance)
     * @param id_type ID du Type de cours en question cad si c'est un cours magistral , un TD...
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
     * Constructeur de la class Seance en paramètre un attribut de type Seance
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

    /**
     * Constructeur par défault
     */
    public Seance() {
    }

/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    
    /**
     * Récupère l'ID de la seance
     * @return ID de la Seance
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Affecte l'ID de la seance 
     * @param id ID de la Seance
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Récupère le numéro de la semaine 
     * @return Numéro de la semaine de la Seance
     */
    public int getSemaine()
    {
        return semaine;
    }
    
    /**
     * Affecte un numéro de la semaine
     * @param semaine Numéro de la semaine de la Seance
     */
    public void setSemaine(int semaine)
    {
        this.semaine = semaine;
    }
    
    /**
     * Récupère la date de la seance (Type Date)
     * @return Date de la Seance
     */
    public Date getdate()
    {
        return date;
    }

    /**
     * Récupère la date de la seance (Type String)
     * @return Date de la Seance
     */
    public String getdate1() {
        return date1;
    }
    
    /**
     * Affecte à une seance une date 
     * @param date Date de la Seance
     */
    public void setdate(String date)
    {
        this.date1 = date;
    }
    
    /**
     * Récupère l'Heure de début de la seance (Type Time)
     * @return Heure de début de la Seance
     */
    public Time getHeure_Debut()
    {
        return Heure_Debut;
    }
    
    /**
     * Récupère l'Heure de début de la seance (Type String)
     * @return Heure de début de la Seance
     */
    public String getHeure_Debut1() {
        return Heure_Debut1;
    }
    
    /**
     * Affecte à une seance une heure de début 
     * @param Heure_Debut Heure de début de la Seance 
     */
    public void setHeure_Debut(String Heure_Debut)
    {
        this.Heure_Debut1 = Heure_Debut;
    }
    
    /**
     * Récupère l'Heure de fin de la seance (Type Time)
     * @return Heure de fin de la Seance
     */
    public Time getHeure_Fin()
    {
        return Heure_Fin;
    }

    /**
     * Récupère l'Heure de fin de la seance (Type String) 
     * @return Heure de fin de la Seance
     */
    public String getHeure_Fin1()
    {
        return Heure_Fin1;
    }
    
    /**
     * Affecte une heure de fin à une seance
     * @param Heure_Fin Heure de fin de la Seance
     */
    public void setHeure_Fin(String Heure_Fin)
    {
        this.Heure_Fin1 = Heure_Fin;
    }
    
    /**
     * Récupère le status de la seance
     * @return Status de la Seance (Validé, En cours de validation, Annulé)
     */
    public String getStatus()
    {
        return Status;
    }
    
    /**
     * Affecte un status à la seance
     * @param Status Status de la Seance (Validé, En cours de validation, Annulé)
     */
    public void setStatus (String Status)
    {
        this.Status = Status;
    }
    
    /**
     * Récupère la couleur Rouge 
     * @return Couleur Rouge
     */
    public int getR()
    {
        return R;
    }
    
    /**
     * Affecte la couleur
     * @param R Couleur Rouge
     */
    public void setR(int R)
    {
        this.R = R;
    }
    
    /**
     * Récupère la couleur verte
     * @return Couleur Vert
     */
    public int getV()
    {
        return V;
    }
    
    /**
     *Affecte la couleur verte 
     * @param V Couleur Vert
     */
    public void setV(int V)
    {
        this.V = V;
    }

    /**
     * Récupère la couleur bleu 
     * @return Couleur Bleu
     */
    public int getB()
    {
        return B;
    }
    
    /**
     * Affecte la couleur bleu 
     * @param B Couleur Bleu
     */
    public void setB(int B)
    {
        this.B = B;
    }
    
    /**
     * Récupère l'ID du cours référencier par la Seance (Quel cours est concerné par la Seance)
     * @return ID du cours référencier par la Seance (Quel cours est concerné par la Seance)
     */
    public int getId_cours()
    {
        return id_cours;
    }
    
    /**
     *Affecte un ID du cours référencier par la Seance (Quel cours est concerné par la Seance)
     * @param id_cours ID du cours référencier par la Seance (Quel cours est concerné par la Seance)
     */
    public void setId_cours(int id_cours)
    {
        this.id_cours = id_cours;
    }
    
    /**
     * Récupère l'ID du Type de cours en question cad si c'est un cours magistral , un TD...
     * @return ID du Type de cours en question cad si c'est un cours magistral , un TD...
     */
    public int getId_type()
    {
        return id_type;
    }
    
    /**
     *Affecte un ID du Type de cours en question cad si c'est un cours magistral , un TD...
     * @param id_type ID du Type de cours en question cad si c'est un cours magistral , un TD...
     */
    public void setId_type(int id_type)
    {
        this.id_type = id_type;
    }
    
}
