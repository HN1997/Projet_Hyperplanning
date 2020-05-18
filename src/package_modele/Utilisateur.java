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
public class Utilisateur {
    
    protected int id; 
    protected String email;
    protected String password;
    protected char Nom;
    protected char Prenom;
    protected int droit;
    
//Création du constructeur 
    
    public Utilisateur(int id, String email, String password, char Nom, char Prenom, int droit)
    {
        this.id=id;
        this.email=email;
        this.password=password;
        this.Nom=Nom;
        this.Prenom=Prenom;
        this.droit=droit;
        
    }
    
    public Utilisateur(Utilisateur utilisateur)
    {
        this.id=utilisateur.id;
        this.email=utilisateur.email;
        this.password=utilisateur.password;
        this.Nom=utilisateur.Nom;
        this.Prenom=utilisateur.Prenom;
        this.droit=utilisateur.droit;
        
    }

    // Création des getteurs et setteurs pour chaque attributs 
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public char getNom()
    {
        return Nom;
    }
    
    public void setNom(char Nom)
    {
        this.Nom = Nom;
    }
    
    public char getPrenom()
    {
        return Prenom;
    }
    
    public void setPrenom(char Prenom)
    {
        this.Prenom = Prenom;
    }
    
    public int getDroit()
    {
        return droit;
    }
    
    public void setDroit(int droit)
    {
        this.droit = droit;
    }
    
    public String getPasswd()
    {
        return password;
    }
    
    public void setPasswd(String password)
    {
        this.password = password;
    }
    
    
    
}