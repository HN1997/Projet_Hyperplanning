package package_modele;

public class Groupe {
    protected int id;
    protected String Nom;
    
    public Groupe(int id, String Nom)
    {
        this.id=id;
        this.Nom=Nom;
    }
    
    public Groupe(Groupe groupe)
    {
        this.id=groupe.id;
        this.Nom=groupe.Nom;
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
