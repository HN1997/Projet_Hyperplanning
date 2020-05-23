package package_modele;

public class Enseignant {
    
    protected int id;
    protected int ID_cours;
    
    public Enseignant(int id, int ID_cours)
    {
        this.id=id;
        this.ID_cours=ID_cours;
    }
    
    public Enseignant(Enseignant enseignant)
    {
        this.id=enseignant.id;
        this.ID_cours=enseignant.ID_cours;
    }

    Enseignant() {
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public int getID_cours()
    {
        return ID_cours;
    }
    
    public void setID_cours(int ID_cours)
    {
        this.ID_cours = ID_cours;
    }
}
