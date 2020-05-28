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
  * @return boolean 
  */
  public abstract boolean create(T obj);

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract boolean delete(T obj);

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
  public abstract boolean update(T obj);

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
     * @return
     */
    public abstract ArrayList<String> FindEmailPasswd(String Nom,String Prenom);
    
}
    

