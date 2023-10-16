/** 
    MonBrin code un brin d'ADN sous forme de liste simplement chaînée.

    Plusieurs instances de MonMaillon reliées convenablement forment une structure de liste simplement chaînée contenant pour chaque maillon le nom de la base.

    On n'utilise pas java.util et on recode tout.

    Cette version a un problème : la navigation n'est pas raisonnable
*/
public class MonBrin {
    MonMaillon m;
    //Le constructeur fabrique un brin à partir du premier maillon p;
    public MonBrin(MonMaillon p){
        this.m=p;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }

    public MonMaillon getDebut(){
        return this.m;
        //throw new UnsupportedOperationException("cette méthode n'est pas implémentée");
    }
    
    /** et pour naviguer? 
        On pourrait implémenter l'interface iterator de java.util ici
    **/
       

}


