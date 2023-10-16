// notez le s après Object. Permet entre autre de stipuler qu'un objet o n'est pas null avec la méthode Objects.requireNonNull(o, "message d'erreur détaillé");
import java.util.Objects;

/*
 * Sorte de Int du pauvre à laquelle on ajoute un nom sous forme textuelle.
 * 
 * Classe donnée à titre d'exemple pour illustrer les ingrédients techniques de la prog défensive.
 * et les assertions java
 */
public class MonInt {

    // un entier
    private int valeur ;
    // son nom sous forme textuelle
    private String nom ;
    
    public MonInt(int n, String s){
        this.valeur = n;
        this.nom = s;
    }

    /**
     * division du pauvre.
     *
     *
     * @param c le diviseur par lequel on souhaite diviser this
     */
    public void divise (MonInt c){
        Objects.requireNonNull(c, "la classe denominateur ne peut pas être null");

        int avant = this.valeur;
        
        this.valeur = this.valeur / c.getValeur();
        this.nom = "(" + this.nom + " divisé par " + c.getNom() +")";

        assert(this.valeur*c.getValeur() == avant); // NB. un assert qui ne marche pas tout le temps.
    }

    /**
     * Un getter superstitieux.
     * retourne une exception si la valeur vaut 13.
     */
    public int getValeur(){
        if (valeur == 13) throw new IllegalStateException("Comme disait Sacha Guitry, je ne suis pas superstitieux mais on ne sait jamais.");
        return valeur;
    }

    public String getNom(){
        return nom;
    }

    /**
    * @return String representant l'entier.
    */ 
    public String toString(){
        return this.getValeur() + " " + this.getNom();
    }

    /**
     * C'est un peu moche mais on peut pour simplifier mettre des tests manuels dans un main dans chaque classe.
     * C'est plutôt mieux que de mettre des print dans chaque méthode car vous êtes plus sûr de la stabilité de vos tests 
     * (vous pouvez rejouer les tests plus tard).
     *
     * Idéalement on utilise un outil dédié comme JUnit qui favorise au maximum cette automatisation.
     *
     * @param args pas de paramètre en ligne de commande prévu.
     */
    public static void main(String[] args) {
        MonInt c3 = new MonInt(3,"trois");
        MonInt c4 = new MonInt(4,"quatre");
        MonInt c9 = new MonInt(9,"neuf");
        MonInt c13 = new MonInt(13,"treize");
        System.out.println(c3.toString());
        System.out.println(c4.toString());
        System.out.println(c9.toString());


        c9.divise(c3);
        // 3
        System.out.println(c9.toString());

        c3.divise(c4);
        // 0
        System.out.println(c3.toString());

        // tester des exceptions pas pratique
        // Si on veut tester plusieurs exceptions
        // il faut attraper et vérifier que c'est le bon type d'exception.
        // ici manuellement en regardant le message.
        try {
            System.out.println(c13.toString()); // toucher au nbre 13 avec getValeur()
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        try{
            c9.divise(c3); //division par 0
            }
        catch(Exception e){
            System.out.println(e);
        }

        try{
            c9.divise(null); //division par null
        }
        catch(Exception e){
            System.out.println(e);
        }
        

    }
}
