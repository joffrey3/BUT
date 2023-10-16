/** 
    MonMaillon code un maillon d'un brin d'ADN.
    plusieurs instances reliées convenablement forment une structure de liste simplement chaînée contenant pour chaque maillon le nom de la base.
    On n'utilise pas java.util et on recode tout.

*/
public class MonMaillon {
    Base base;
    MonMaillon suivant;
    public MonMaillon(Base b){
        this.base=b;
        this.suivant=null;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }

    public MonMaillon(Base b, MonMaillon l){
        this.base=b;
        this.suivant=l;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }

    public Base getBase(){
        return this.base;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }

    public MonMaillon getSuiteMaillon(){
        return this.suivant;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
    
}


