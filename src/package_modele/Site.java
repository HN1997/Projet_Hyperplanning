package package_modele;
import java.util.*;
public class Site {
    protected int id;
    protected String Nom;

    private Set<Salle> ListSalle = new HashSet<>();
    
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
