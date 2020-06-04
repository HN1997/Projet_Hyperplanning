package package_modele;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author ShadowZeus
 * @param <T>
 */
public abstract class DAO<T> {
    
  protected Connection connect = null;
   
    /**
     *
     * @param conn
     */
    public DAO(Connection conn){
    this.connect = conn;
  }
   
  /**
  * Méthode de création
  * @param obj 
  */
  public abstract void create(T obj);

  /**
  * Méthode pour effacer
  * @param obj 
  */
  public abstract void delete(T obj);

  /**
  * Méthode de mise à jour
  * @param obj
  */
  public abstract void update(T obj);

  /**
  * Méthode de recherche des informations
     * @param Email
     * @param Passwd
  * @return T
  */
  public abstract T find(String Email, String Passwd);
  
    /**
     *
     * @param id
     * @return
     */
    public abstract T find(int id);
    
    /**
     *
     * @param id
     * @return
     */
    public abstract ArrayList<Integer> ComposerFindSeance (int id);
    
    /**
     *
     * @param id
     * @return
     */
    public abstract ArrayList<Integer> ComposerFindEnseignant(int id);

    
    /**
     *
     * @param id
     * @return
     */
    public abstract ArrayList<Integer> ComposerFindGroupe(int id);
    
    /**
     *
     * @return
     */
    public abstract ArrayList<Integer> FindEtudiant();
    
    /**
     *
     * @return
     */
    public abstract ArrayList<Integer> FindEnseignant();
    
    /**
     *
     * @return
     */
    public abstract ArrayList<Integer> FindPromotion();
    
    /**
     *
     * @return
     */
    public abstract ArrayList<Integer> FindSite();
    
    /**
     *
     * @param Nom
     * @param Prenom
     * @return
     */
    public abstract ArrayList<String> FindEmailPasswd(String Nom,String Prenom);
    
    /**
     *
     * @param nom
     * @return
     */
    public abstract int ID (String nom);
    
    /**
     *
     * @param id
     * @return
     */
    public abstract ArrayList<String> ListInfo (int id);
    
    /**
     *
     * @param id
     * @param Nom
     * @return
     */
    public abstract int GetUniqID (int id, String Nom);

}
    

