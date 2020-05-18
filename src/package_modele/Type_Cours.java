package package_modele;

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

    Type_Cours() {
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
}
