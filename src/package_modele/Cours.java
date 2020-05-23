package package_modele;

public class Cours {
    
    protected int id;
    protected String Nom;
    
    public Cours(int id, String Nom)
    {
        this.id=id;
        this.Nom=Nom;
    }
    
    public Cours(Cours cours)
    {
        this.id=cours.id;
        this.Nom=cours.Nom;
    }

    Cours() {
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getNom()
    {
        return Nom;
    }
    
    public void setNom(String Nom)
    {
        this.Nom = Nom;
    }
}
