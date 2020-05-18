/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_modele;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ShadowZeus
 */
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
    
    public Set<Salle> getListSalle() 
    {
        return ListSalle;
    }

    public void setListSalle(Set<Salle> ListSalle) 
    {
        this.ListSalle = ListSalle;
    }

  //Ajoute une salle à un site
    public void addSalle(Salle salle)
    {
        this.ListSalle.add(salle);
    }

  //Retire une salle à un site
    public void removeSalle(Salle salle)
    {
        this.ListSalle.remove(salle);
    }
}
