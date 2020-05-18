package package_modele;

public class Promotion {
        protected int id;
    protected String Nom;
    
    public Promotion(int id, String Nom)
    {
        this.id=id;
        this.Nom=Nom;
    }
    
    public Promotion(Promotion promotion)
    {
        this.id=promotion.id;
        this.Nom=promotion.Nom;
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
