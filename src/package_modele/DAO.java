package package_modele;
import java.sql.Connection;
import java.sql.Date;
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
  * Méthode de recherche des informations avec l'Email et le Mot de Passe
     * @param Email
     * @param Passwd
  * @return T
  */
  public abstract T find(String Email, String Passwd);
  
    /**
     *Méthode de recherche des informations avec l'ID
     * @param id
     * @return
     */
    public abstract T find(int id);
    
    
    /**
     *Méthode de recherche des informations avec les ID
     * @param id
     * @param id2
     * @param id3
     * @return
     */
    public abstract T find(int id,int id2, int id3);
    
    /**
     *Méthode de recherche des informations avec les ID
     * @param id
     * @param id2
     * @return
     */
    public abstract T find(int id,int id2);
    
    /**
     *Méthode qui renvoie une liste des seances pour une personne ou un groupe ou une salle en particulier 
     * @param id
     * @return
     */
    public abstract ArrayList<Integer> ComposerFindSeance (int id);
    
    /**
     *Méthode qui renvoie une liste des enseignants
     * @param id
     * @return
     */
    public abstract ArrayList<Integer> ComposerFindEnseignant(int id);

    
    /**
     *Méthode qui renvoie une liste des groupes
     * @param id
     * @return
     */
    public abstract ArrayList<Integer> ComposerFindGroupe(int id);
    
    /**
     *Méthode qui renvoie une liste des étudiants
     * @return
     */
    public abstract ArrayList<Integer> FindEtudiant();
    
    /**
     *Méthode qui renvoie une liste des ID des enseignants
     * @return
     */
    public abstract ArrayList<Integer> FindEnseignant();
    
    /**
     *Méthode qui renvoie une liste des ID des promotions
     * @return
     */
    public abstract ArrayList<Integer> FindPromotion();
    
    /**
     *Méthode qui renvoie une liste des ID des sites
     * @return
     */
    public abstract ArrayList<Integer> FindSite();
    
    /**
     *Méthode qui renvoie une liste de toutes les seances
     * @param id
     * @param id2
     * @return
     */
    public abstract ArrayList<Integer> FindAllSeance(int id, int id2);
    
    /**
     *Méthode qui renvoie une liste des Emails et des Mot de Passe 
     * @param Nom
     * @param Prenom
     * @return
     */
    public abstract ArrayList<String> FindEmailPasswd(String Nom,String Prenom);
    
    /**
     *Méthode qui renvoie l'ID avec Nom du groupe ou de l'enseignant 
     * @param nom
     * @return
     */
    public abstract int ID (String nom);
    
    /**
     *Méthode qui renvoie une liste des Nom des sites des groupes...
     * @param id
     * @return
     */
    public abstract ArrayList<String> ListInfo (int id);
    
    /**
     * Méthode qui renvoie l'unique ID 
     * @param id
     * @param Nom
     * @return
     */
    public abstract int GetUniqID (int id, String Nom);
    
    /**
     *Méthode qui renvoie une seance en fonction de la date
     * @param id
     * @param date
     * @return
     */
    public abstract Seance GetSeanceInfo (int id, Date date);

}
    

