/************************************************** Définiton du package *******************************************************************************************************/
package package_modele;

public class Type_Cours 

{

/************************************************************* Attributs *****************************************************************************************************/    
    
    
    /**
     *ID du type de cours 
     */
    protected int id;

    /**
     * Nom du type de cours 
     */
    protected String Nom;

/********************************************************** Mise en place des constructeurs***********************************************************************************/    
    
    /**
     *Constructeur de la class Type_Cours
     * @param id
     * @param Nom
     */
    public Type_Cours(int id, String Nom) {
        this.id = id;
        this.Nom = Nom;
    }
    
    /**
     *Création d'un constructeur surchargé
     * @param type_cours
     */
    public Type_Cours(Type_Cours type_cours) {
        this.id = type_cours.id;
        this.Nom = type_cours.Nom;
    }    

    /**
     *Création d'un constructeur par défault
     */
    
    public Type_Cours() {}
    
/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    
//Getter et Setter pour l'ID    
    
    /**
     *Récupérer ID du type de cours
     * @return ID du type de cours
     */
    public int getId() {
        return id;
    }

    /**
     *Affecter un ID au type de cours
     * @param id ID du type de cours
     */
    public void setId(int id) {
        this.id = id;
    }    
    
    /**
     *Récupérer le Nom du type de cours
     * @return Nom du type de cours
     */
    public String getNom() {
        return Nom;
    }

    /**
     *Affecte un Nom à au type de cours 
     * @param Nom Nom du type de cours
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }
}
