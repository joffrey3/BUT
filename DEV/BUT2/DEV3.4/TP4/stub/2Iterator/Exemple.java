// Fichier Exemple pour le dernier exercice sur l'ADN (Iterable)

public class Exemple{

        public static void main(String[] args) {
        
        // codon GCT code l'analine https://en.wikipedia.org/wiki/DNA_codon_table
        // stop codon TAG, voir https://en.wikipedia.org/wiki/Stop_codon
            
        System.out.println("construction du brin GCTTAG");
        MonMaillon l = new MonMaillon(Base.G);
        l = new MonMaillon(Base.A,l);
        l = new MonMaillon(Base.T,l);
        l = new MonMaillon(Base.T,l);
        l = new MonMaillon(Base.C,l);
        l = new MonMaillon(Base.G,l);

        MonBrin m = new MonBrin(l);
        
        System.out.println("l'affichage par défaut du brin ne va pas vous plaire");
        System.out.println(m.toString());
        
        System.out.println("On peut afficher en itérant avec forEach (une méthode proposée par Iterable, regardez la doc)");
        m.forEach(b -> System.out.println(b));

        System.out.println("On a découplé la navigation de la structuration en implémentant iterable plutôt que iterator. On peut maintenant naviguer 2 fois facilement, c'est vraiment trop fort.");
        m.forEach(b -> System.out.println(b));

        System.out.println("On peut même utiliser les boucles avancées de Java 8 et notre code en devient presque pythonesque");
        for(Base b: m){
            System.out.println(b);
        }
    }

}
