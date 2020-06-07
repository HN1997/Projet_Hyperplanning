package package_modele;

public class Cours {

/************************************************************* Attributs *****************************************************************************************************/
    
    /**
     *ID du cours
     */    
    protected int id;

    /**
     *Nom du cours
     */
    protected String Nom;
    
    /**
     *Valeur de Rouge
     */
    protected int R;

    /**
     *Valeur de Vert
     */
    protected int V;

    /**
     *Valeur de Bleu
     */
    protected int B;

/********************************************************** Mise en place des constructeurs***********************************************************************************/
    
    /**
     *Constructeur de la class cours 
     * @param id ID du cours
     * @param Nom Nom du cours
     */
    public Cours(int id, String Nom)
    {
        this.id=id;
        this.Nom=Nom;
    }
    
    /**
     *Constructeur de la class Cours avec en paramètre une variable de type cours
     * @param cours
     */
    public Cours(Cours cours)
    {
        this.id=cours.id;
        this.Nom=cours.Nom;
    }

    /**
     * Constructeur par défaut
     */
    public Cours() {
    }

/********************************************** Mise en place des Getters et des Setters pour les différents attribut********************************************************/
    
    /**
     * Récupére l'ID du cours
     * @return ID du cours
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Affecter une valeur à ID 
     * @param id ID du cours
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     *Récupére le nom du cours
     * @return Nom du cours 
     */
    public String getNom()
    {
        return Nom;
    }
    
    /**
     *Affecte une valeur à nom 
     * @param Nom Nom du cours
     */
    public void setNom(String Nom)
    {
        this.Nom = Nom;
    }
    
    
    /**
     *Permet de récupèrer la couleur ROUGE de la table COURS
     * @return Valeur de Rouge 
     */
    public int getR()
    {
        return R;
    }
    
    /**
     *Affecte une valeur de ROUGE
     * @param R Valeur de Rouge
     */
    public void setR(int R)
    {
        this.R = R;
    }
    
    /**
     *Permet de récupèrer la couleur VERTE de la table COURS
     * @return Valeur de Vert
     */
    public int getV()
    {
        return V;
    }
    
    /**
     *Affecte une valeur de VERT
     * @param V Valeur de Vert
     */
    public void setV(int V)
    {
        this.V = V;
    }

    /**
     *Permet de récupèrer la couleur BLEU de la table COURS
     * @return Valeur de bleu
     */
    public int getB()
    {
        return B;
    }
    
    /**
     *Affecte une valeur de BlEU
     * @param B Valeur de bleu
     */
    public void setB(int B)
    {
        this.B = B;
    }
}
