import java.util.Iterator;
import java.util.NoSuchElementException;

/** 
MonBrinIterator 

gère la navigation dans un Brin d'ADN

*/
public class MonBrinIterator implements Iterator<Base> {
    MonBrin b;
    int pos;
    //Le constructeur de base retourne un brin à une base;
    public MonBrinIterator(MonBrin brin){
        this.b=brin;
        this.pos=0;
    }
    
    /** Pour naviguer? 
        On implémente l'interface iterable de java.util ici
        L'avantage c'est que c'est standard et tout le monde comprendra sans trop de mal comment la navigation fonctionne.
    **/
    
    @Override
    public boolean hasNext(){
        if(this.b.capacity()==0){
            return false;
        }
        return true;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }

    @Override
    public Base next() {
        Base base=this.b.getBase(this.pos);
        this.pos=this.pos+1;
        return base;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
 
}


