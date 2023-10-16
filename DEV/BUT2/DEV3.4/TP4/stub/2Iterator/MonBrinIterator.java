import java.util.Iterator;
import java.util.NoSuchElementException;

/** 
MonBrinIterator 

gère la navigation dans un Brin d'ADN

*/
public class MonBrinIterator implements Iterator<Base> {
    MonMaillon m;
    public MonBrinIterator(MonMaillon p){
        this.m=p;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
    
    /** Pour naviguer? 
        On implémente l'interface iterable de java.util ici
        L'avantage c'est que c'est standard et tout le monde comprendra sans trop de mal comment la navogation fonctionne.
    **/
    @Override
    public boolean hasNext(){
        if(this.m.getSuiteMaillon()==null){
            return false;
        }
        return true;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }

    @Override
    public Base next() {
        this.m=this.m.getSuiteMaillon();
        return this.m.getBase();
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
 
}


