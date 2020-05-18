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

    Promotion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
