package package_modele;

public class Site {
    protected int id;
    protected String Nom;

    
    public Site(int id, String Nom)
    {
        this.id=id;
        this.Nom=Nom;
    }
    
    public Site(Site site)
    {
        this.id=site.id;
        this.Nom=site.Nom;
    }

    Site() {
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
