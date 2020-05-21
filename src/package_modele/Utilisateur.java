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
    

  //ID
  protected int id = 0;
  //Nom de l'élève
  protected String nom = "";
  protected String prenom = "";
  protected String email = "";
  protected String passwd = "";
  protected int droit = 0;

  public Utilisateur(int id, String nom, String prenom,String email,String passwd,int droit ) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.email=email;
    this.passwd=passwd;
    this.droit=droit;
  }
  public Utilisateur(){};


     
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }
  
  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }
  
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }
  
  public int getDroit() {
    return droit;
  }

  public void setDroit(int droit) {
    this.droit = droit;
  }
    
}
