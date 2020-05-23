/************************************************** Définiton du package *******************************************************************************************************/
package package_modele;

public class Type_Cours 

{

/************************************************************* Attributs *****************************************************************************************************/    
    
    protected int id;
    protected String Nom;

/********************************************************** Mise en place des constructeurs***********************************************************************************/    

//Création d'un constructeur surchargé
    
    /**
     *
     * @param id
     * @param Nom
     */
    public Type_Cours(int id, String Nom) {
        this.id = id;
        this.Nom = Nom;
    }

//Création d'un constructeur surchargé    
    
    /**
     *
     * @param type_cours
     */
    public Type_Cours(Type_Cours type_cours) {
        this.id = type_cours.id;
        this.Nom = type_cours.Nom;
    }

//Création d'un constructeur par défault     
    
    Type_Cours() {}
    
/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    
//Getter et Setter pour l'ID    
    
    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

//Getter et Setter pour le Nom    
    
    /**
     *
     * @return
     */
    public String getNom() {
        return Nom;
    }

    /**
     *
     * @param Nom
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }
}
