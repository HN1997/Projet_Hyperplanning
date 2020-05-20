package package_modele;
import java.util.*;


public class Salle {
    protected int id;
    protected String Nom;
    protected int Capacite;
    private Set<Site> ListSite = new HashSet<>();
    
    public Salle(int id, String Nom,int Capacite)
    {
        this.id=id;
        this.Nom=Nom;
        this.Capacite=Capacite;
    }
    
    public Salle(Salle salle)
    {
        this.id=salle.id;
        this.Nom=salle.Nom;
        this.Capacite=salle.Capacite;
    }

    Salle() {
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
    
    public int getCapacite()
    {
        return Capacite;
    }
    
    public void setCapacite(int Capacite)
    {
        this.Capacite = Capacite;
    }
    
        public Set<Site> getListSite() 
    {
        return ListSite;
    }

    public void setListSite(Set<Site> ListSite) 
    {
        this.ListSite = ListSite;
    }

  //Ajoute une salle à un site
    public void addSite(Site site)
    {
        this.ListSite.add(site);
    }

  //Retire une salle à un site
    public void removeSite(Site site)
    {
        this.ListSite.remove(site);
    }
}
