import java.util.Iterator;
import java.util.NoSuchElementException;
/** 
    MonBrin code un brin d'ADN sous forme de liste simplement chaînée.

    Plusieurs instances de MonMaillon reliées convenablement forment une structure de liste simplement chaînée contenant pour chaque maillon le nom de la base.

    On n'utilise pas java.util et on recode tout.

    Cette version est correcte : la structuration et la navigation sont dans 2 classes séparées.
La classe MonBrin implémente Iterable au sens où elle peut générer à la demande un objet Iterator.

NB : Notez que j'implémente Iterable<Base> plutôt que Iterable qui n'était pas tout à fait propre
c'est un peu technique et c'est lié aux types génériques.
 Il y a des détails ici 
https://stackoverflow.com/questions/20790770/why-cant-i-assign-a-raw-type-to-a-parameterized-type-java?rq=1
*/
public class MonBrin implements Iterable<Base>{
    MonMaillon m;
    public MonBrin(MonMaillon p){
        this.m=p;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }

    public MonMaillon getDebut(){
        return this.m;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
           
    /** Pour naviguer? 
        On implémente l'interface iterator de java.util ici
        L'avantage c'est que c'est standard et tout le monde comprendra sans trop de mal comment la navigation fonctionne.
    **/
    @Override
    public Iterator<Base> iterator() {
        MonBrinIterator b= new MonBrinIterator(this.m);
        return b;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
}
