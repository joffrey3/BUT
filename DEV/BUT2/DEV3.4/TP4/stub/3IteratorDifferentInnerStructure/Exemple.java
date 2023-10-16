// Fichier Exemple pour le dernier exercice sur l'ADN (Iterable)

public class Exemple{

        public static void main(String[] args) {
        
        // codon GCT code l'analine https://en.wikipedia.org/wiki/DNA_codon_table
        // codon CAT code Histidine
        // codon CGT code Arginine
        // codon GCC code Analine
        // stop codon TAG, voir https://en.wikipedia.org/wiki/Stop_codon
        
        System.out.println("construction du brin CGT CAT CGT GCC CAT GCT TAG");
        MonBrin l = new MonBrin(Base.G);
        l = new MonBrin(Base.A,l);
        l = new MonBrin(Base.T,l);
        //
        l = new MonBrin(Base.T,l);
        l = new MonBrin(Base.C,l);
        l = new MonBrin(Base.G,l);
        //
        l = new MonBrin(Base.T,l);
        l = new MonBrin(Base.A,l);
        l = new MonBrin(Base.C,l);
        //
        l = new MonBrin(Base.C,l);
        l = new MonBrin(Base.C,l);
        l = new MonBrin(Base.G,l);
        //
        l = new MonBrin(Base.T,l);
        l = new MonBrin(Base.G,l);
        l = new MonBrin(Base.C,l);
        //
        l = new MonBrin(Base.T,l);
        l = new MonBrin(Base.A,l);
        l = new MonBrin(Base.C,l);
        //
        l = new MonBrin(Base.T,l);
        l = new MonBrin(Base.G,l);
        l = new MonBrin(Base.C,l);
        //

        System.out.println("l'affichage par défaut ne va toujours pas vous plaire");
        System.out.println(l.toString());

        System.out.println("On peut afficher en itérant avec forEach (une méthode proposée par Iterable, regardez la doc)");
        l.forEach(b -> System.out.println(b));

        System.out.println("On a découplé la navigation de la structuration en implémentant iterable plutôt que iterator. On peut maintenant naviguer 2 fois facilement, c'est vraiment trop fort.");
        l.forEach(b -> System.out.println(b));

        System.out.println("On peut même utiliser les boucles avancées de Java 8 et notre code en devient presque pythonesque");
        for(Base b: l){
            System.out.println(b);
        }
    }

}
