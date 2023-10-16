import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.*;

/** feuille du motif composite */
public class Chef extends Person {
    private int sans;
    private int avec;
    private int best;

    private int taille;
    private ArrayList<Person> liste = new ArrayList<Person>();

    public boolean addSubalterne(Person p){
        if(p!=null){
            this.liste.add(p);
            return true;
        }
        return false;
    }


    
    /** constructeur
     *
     * @param n fun factor
     *
     */ 
    public Chef(int n){
        super(n);
        // d'autres choses peut-être.
    }

    
    /** 
     * La meilleure fête avec moi, c'est la meilleure fête sans mes subalternes pour eux plus moi. 
     *
     * @return retourne la valeur de la meilleure fête en invitant seulement les gens dont cette personne est le ou la supérieure hiérarchique, mais pas elle.
     *
     */ 
    public int bestPartyWithoutMe(){
        if(this.taille!=this.liste.size()){
            this.sans=0;
        for(int i=0;i<this.liste.size();i++){
            Person Subalterne =this.liste.get(i);
            this.sans=this.sans+Subalterne.bestParty();
        }
        this.taille=this.liste.size();
        }
        return this.sans;
        // to do
    }

    /**
     *  La meilleure fête est soit sans moi (c'est l'union des meilleures fêtes de mes subalternes). 
     *  soit c'est la meilleure fête avec moi.
     *
     * @return la valeur de la meilleure fête en invitant seulement les gens dont cette personne est le ou la supérieure hiérarchique (peut-être avec elle).
     *
     */ 
    public int bestParty(){
        if(this.taille!=this.liste.size()){
            this.bestPartyWithoutMe();
            this.avec=0;
        this.avec=super.getFunFactor();
        for(int i=0;i<this.liste.size();i++){
            Person Subalterne = this.liste.get(i);
            this.avec=this.avec+Subalterne.bestPartyWithoutMe();
        }
        if(this.avec>this.sans){
            this.best=this.avec;
        }else{
            this.best=this.sans;
        }
        this.taille=this.liste.size();
        }
        return this.best;
        // to do
    }
}


