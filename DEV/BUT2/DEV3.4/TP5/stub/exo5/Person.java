
/** "Les personnes sont soit des chefs, soit des travailleurs" */
public abstract class  Person{
    /**
    * valeur indiquant le niveau de coolitude de la personne
    */
    private int funFactor;

    /**
     * @return  la valeur indiquant le niveau de coolitude de la personne. plus cete valeur est grande, plus la personne contribue à améliorer l'ambiance dans une fête.
     *
     */
    public int getFunFactor(){
        return this.funFactor;
    }

    /**
     * constructeur 
     *
     * <b>NB</b>. Cette méthode ne peut pas être appelé directement pour instancier un objet car la classe est abstraite, mais sert dans les constructeurs de classes dérivées.
     *
     * @see Travailleur, Chef
     */
    // 
    public Person(int n){
        if (n < 0)
            throw new IllegalArgumentException("Le fun facteur est positif ou nul, vous avez proposé " + n);
        this.funFactor = n;
    }
        
    /** 
     *
     * @return retourne la valeur de la meilleure fête en invitant seulement les gens dont cette personne est le ou la supérieure hiérarchique, mais pas elle.
     */ 
    public abstract int bestPartyWithoutMe();


    /** 
     *
     * @return la valeur de la meilleure fête en invitant seulement les gens dont cette personne est le ou la supérieure hiérarchique (peut-être avec elle).
     */ 
    public abstract int bestParty();
}

