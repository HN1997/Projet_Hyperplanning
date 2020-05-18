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
public class Type_Cours {
        protected int id;
    protected String Nom;
    
    public Type_Cours(int id, String Nom)
    {
        this.id=id;
        this.Nom=Nom;
    }
    
    public Type_Cours(Type_Cours type_cours)
    {
        this.id=type_cours.id;
        this.Nom=type_cours.Nom;
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
