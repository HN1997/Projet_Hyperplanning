/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_modele;

/**
 *
 * @author ShadowZeus
 */
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
