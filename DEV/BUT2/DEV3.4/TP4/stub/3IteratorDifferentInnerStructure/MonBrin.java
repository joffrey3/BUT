import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.*;

/** 
MonBrin code un brin d'ADN sous forme de tableaux. Dynamiquement, la taille du tableau est augmentée en cas de besoin (la taille est initialement 3*4 elle est multipliée ensuite pour être toujours de la forme 3*2^n). 
On utilise System.arraycopy et java.util.Arrays.copyOfRange pour faire ça efficacement.
voir 
https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#arraycopy-java.lang.Object-int-java.lang.Object-int-int-
https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#copyOfRange-T:A-int-int-

Cette version est correcte : la structuration et la navigation sont dans 2 classes séparées.
La classe MonBrin implémente Iterable au sens où elle peut générer à la demande un objet Iterator.

NB : Notez que j'implémente Iterable<Base> plutôt que Iterable qui n'était pas tout à fait propre
c'est un peu technique et c'est lié aux types génériques.
 Il y a des détails ici 
https://stackoverflow.com/questions/20790770/why-cant-i-assign-a-raw-type-to-a-parameterized-type-java?rq=1
*/

public class MonBrin implements Iterable<Base> {
    Base base;
    ArrayList<MonBrin> liste;
    int length;
    int limit;
    int capacity;
    /**
      C'est le constructeur de base (pun intended) qui construit un brin à une base

      @param b : la base

      Ici je pourrais mettre un commentaire plus long sur le fonctionement détaillé de mon super constructeur.
      
    */
    public MonBrin(Base b){
        this.base=b;
        this.length=12;
        this.limit=0;
        this.capacity=this.length;
        this.liste = new ArrayList<MonBrin>(this.length);
    }

    /**
       C'est le constructeur évolué qui construit un brin en ajoutant la base donnée en argument devant le brin donné en argument.
       
       @param b : la base qui va aller devant
       @param l : le brin qui sera à la suite

       NB. Ce constructeur est un peu obsolète avec la nouvelle structure interne.
       On devrait en ajouter un qui prend en paramètre un tableau de bases.
    */
    public MonBrin(Base b, MonBrin l){
        this.base=b;
        this.liste.add(l);
        this.limit=this.limit+1;
        this.capacity=this.capacity-1;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }

    public Base getBase(){
        return this.base;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }

    public int length(){
        return this.length;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }

    public int limit(){
        return this.limit;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }

    public int capacity(){
        return this.capacity;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
    
    public Base getBase(int i){
        Base b=this.liste.get(this.limit).getBase();
        return b;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }    
    
    public Base[] getBases(){
        Base[] tab= new Base[this.limit];
        for(int i=0;i<this.limit;i++){
            Base b=this.liste.get(this.limit).getBase();
            tab[i]=b;
        }
        return tab;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
    
    /** Pour naviguer? 
        On implémente l'interface iterator de java.util ici
        L'avantage c'est que c'est standard et tout le monde comprendra sans trop de mal comment la navigation fonctionne.
    **/
    @Override
    public Iterator<Base> iterator() {
        //MonBrinIterator brin= new MonBrinIterator();
        //return brin;
        return null;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
    

}


