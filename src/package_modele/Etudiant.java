package package_modele;

/**
 *
 * @author ShadowZeus
 */
public class Etudiant {
    
    protected int Numero;
    
    protected int id_promotion;
    
    protected int id_user;
    protected int id_groupe;
    
    /**
     *
     * @param id_user
     * @param id_promotion
     * @param Numero
     * @param id_groupe
     */
    public Etudiant(int id_user, int id_promotion,int Numero, int id_groupe) {
        this.Numero = Numero;
        this.id_promotion = id_promotion;
        this.id_user = id_user;
        this.id_groupe = id_groupe;
    }

    Etudiant() {
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public int getId_promotion() {
        return id_promotion;
    }

    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }
    
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
    public int getId_groupe() {
        return id_groupe;
    }

    public void setId_groupe(int id_groupe) {
        this.id_groupe = id_groupe;
    }
   
    
}
