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
