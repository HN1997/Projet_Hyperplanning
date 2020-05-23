package package_modele;
import java.util.*;


public class Groupe {
    protected int id;
    protected String Nom;
    
   protected int id_promotion;
    
    public Groupe(int id, String Nom,int id_promotion)
    {
        this.id=id;
        this.Nom=Nom;
        this.id_promotion=id_promotion;
    }
    
    public Groupe(Groupe groupe)
    {
        this.id=groupe.id;
        this.Nom=groupe.Nom;
        this.id_promotion=groupe.id_promotion;
    }

    Groupe() {
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
    
    public int getId_promotion()
    {
        return id_promotion;
    }
    
    public void setId_promotion(int id_promotion)
    {
        this.id_promotion = id_promotion;
    }
    

}
