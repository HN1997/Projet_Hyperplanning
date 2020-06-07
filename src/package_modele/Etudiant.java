package package_modele;

/**
 *
 * @author ShadowZeus
 */
public class Etudiant {
    
/************************************************************* Attributs *****************************************************************************************************/
    
    /**
     *Numéro de l'étudiant
     */
    protected int Numero;
   
    /**
     *ID de la promotion à laquelle appartient l'étudiant
     */
    protected int id_promotion;

    /**
     *ID de l'utilisateur qui est l'étudiant
     */
    protected int id_user;

    /**
     * ID du groupe auquel appartient l'étudiant
     */
    protected int id_groupe;

/********************************************************** Mise en place des constructeurs***********************************************************************************/
    
    /**
     * Constructeur de la class Etudiant
     * @param id_user
     * @param id_promotion ID de la promotion à laquelle appartient l'étudiant
     * @param Numero Numéro de l'étudiant
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
     * Récupére le numéro de l'étudiant
     * @return Numéro de l'étudiant
     */
    public int getNumero() {
        return Numero;
    }

    /**
     * Assigne un numéro à l'étudiant
     * @param Numero Numéro de l'étudiant
     */
    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    /**
     * Récupère l'ID de la promotion de l'étudiant 
     * @return ID de la promotion à laquelle appartient l'étudiant
     */
    public int getId_promotion() {
        return id_promotion;
    }

    /**
     * Affecte l'ID à l'étudiant 
     * @param id_promotion ID de la promotion à laquelle appartient l'étudiant
     */
    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }
    
    /**
     * Récupére l'ID de l'étudiant
     * @return ID de l'utilisateur qui est l'étudiant
     */
    public int getId_user() {
        return id_user;
    }

    /**
     * Affecte un ID à l'étudiant
     * @param id_user ID de l'utilisateur qui est l'étudiant
     */
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
    /**
     * Récupère l'ID du groupe de l'étudiant
     * @return ID du groupe auquel appartient l'étudiant
     */
    public int getId_groupe() {
        return id_groupe;
    }

    /**
     * Affecte une valeur à l'ID du groupe en adéquation avec l'étudiant
     * @param id_groupe ID du groupe auquel appartient l'étudiant
     */
    public void setId_groupe(int id_groupe) {
        this.id_groupe = id_groupe;
    }
   
    
}
