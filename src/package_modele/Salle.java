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
public class Salle {
    protected int id;
    protected String Nom;
    protected int Capacite;
    
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
}
