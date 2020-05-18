package package_modele;
public class Utilisateur {
    
    protected int id; 
    protected String email;
    protected String password;
    protected String Nom;
    protected String Prenom;
    protected int droit;
    
//Création du constructeur 
    
    public Utilisateur(){
        
    }
    
    public Utilisateur(int id, String email, String password, String Nom, String Prenom, int droit)
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
    
    public String getNom()
    {
        return Nom;
    }
    
    public void setNom(String Nom)
    {
        this.Nom = Nom;
    }
    
    public String getPrenom()
    {
        return Prenom;
    }
    
    public void setPrenom(String Prenom)
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
