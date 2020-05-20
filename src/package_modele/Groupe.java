package package_modele;
import java.util.*;


public class Groupe {
    protected int id;
    protected String Nom;
    
    private Set<Promotion> ListPromotion = new HashSet<>();
    
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

    Groupe() {
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
    
    public Set<Promotion> getListPromotion() {
        return ListPromotion;
    }

    public void setListPromotion(Set<Promotion> ListPromotion) {
        this.ListPromotion = ListPromotion;
    }

    //Ajoute une salle à un promotion
    public void addPromotion(Promotion promotion) {
        this.ListPromotion.add(promotion);
    }

    //Retire une salle à un promotion
    public void removePromotion(Promotion promotion) {
        this.ListPromotion.remove(promotion);
    }
}
