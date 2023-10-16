/** feuille du motif composite */
public class Travailleur extends Person {
    private int sans;
    private int avec;
    private int best;
    /** constructeur
     *
     * @param n fun factor
     *
     */ 
    public Travailleur(int n){
        super(n);
        this.avec=super.getFunFactor();
        this.sans=0;
        this.best=this.avec;
    }
    
    /** 
     *
     * @return fête sans le travailleur
     */ 
    public int bestPartyWithoutMe(){
        return this.sans;
        // return null;
    }
    
    /**
     * @return fête avec le travailleur
     */
    public int bestParty(){
        return this.best;
        // return null;
    }
    
    
}


