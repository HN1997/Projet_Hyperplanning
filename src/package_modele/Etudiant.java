package package_modele;

/**
 *
 * @author ShadowZeus
 */
public class Etudiant {
    
/************************************************************* Attributs *****************************************************************************************************/
    
    //Numéro de l'étudiant
    protected int Numero;
    //ID de la promotion à laquelle appartient l'étudiant
    protected int id_promotion;
    //ID de l'utilisateur qui est l'étudiant
    protected int id_user;
    //ID du groupe auquel appartient l'étudiant
    protected int id_groupe;

/********************************************************** Mise en place des constructeurs***********************************************************************************/
    
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

/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/     
    
    /**
     *
     * @return
     */
    public int getNumero() {
        return Numero;
    }

    /**
     *
     * @param Numero
     */
    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    /**
     *
     * @return
     */
    public int getId_promotion() {
        return id_promotion;
    }

    /**
     *
     * @param id_promotion
     */
    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }
    
    /**
     *
     * @return
     */
    public int getId_user() {
        return id_user;
    }

    /**
     *
     * @param id_user
     */
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
    /**
     *
     * @return
     */
    public int getId_groupe() {
        return id_groupe;
    }

    /**
     *
     * @param id_groupe
     */
    public void setId_groupe(int id_groupe) {
        this.id_groupe = id_groupe;
    }
   
    
}
