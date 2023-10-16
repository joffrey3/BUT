import java.util.Iterator;
import java.util.NoSuchElementException;
/** 
    MonBrin code un brin d'ADN sous forme de liste simplement chaînée.

    Plusieurs instances de MonMaillon reliées convenablement forment une structure de liste simplement chaînée contenant pour chaque maillon le nom de la base.

    On n'utilise pas java.util et on recode tout.

    Cette version a un problème : la structuration et la navigation sont dans la même classe.
*/
public class MonBrin implements Iterator<Base>{
    MonMaillon m1;
    MonMaillon m2;
    MonMaillon m3;
    MonMaillon m0;
    public MonBrin(MonMaillon p){
        this.m1=p;
        this.m2=p;
        this.m3=p;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }

    public MonMaillon getDebutM1(){
        return this.m1;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
    public MonMaillon getDebutM2(){
        return this.m2;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
    public MonMaillon getDebutM3(){
        return this.m3;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
    
    public MonMaillon setDebutM0M1(){
        return this.m0=this.m1;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
    public MonMaillon setDebutM0M2(){
        return this.m0=this.m2;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
    public MonMaillon setDebutM0M3(){
        return this.m0=this.m3;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }

    public MonMaillon setDebutM1M0(){
        return this.m1=this.m0;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
    public MonMaillon setDebutM2M0(){
        return this.m2=this.m0;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
    public MonMaillon setDebutM3M0(){
        return this.m3=this.m0;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
    // rappel : on met @Override pour dire au compilateur qu'on veut surcharger (en particulier c'est le cas quand on implémente une interface)
    // ce n'est pas nécessaire dans ce cas mais ça permet d'avoir des messages d'alerte si on se trompe (typo dans le nom de la méthode ...)
    // voir https://stackoverflow.com/questions/94361/when-do-you-use-javas-override-annotation-and-why
    @Override
    public boolean hasNext(){
        if(this.m0.getSuiteMaillon()==null){
            return false;
        }
        return true;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }

    @Override
    public Base next() {
        this.m0=this.m0.getSuiteMaillon();
        return this.m0.getBase();
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
        //throw new NoSuchElementException();

    }

}




