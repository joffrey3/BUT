// Fichier Exemple pour le second exercice sur l'ADN

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

        MonBrin b = new MonBrin(l);
        
        System.out.println("l'affichage par défaut du brin ne va pas vous plaire");
        System.out.println(b.toString());
        
        System.out.println("On peut maintenant afficher en itérant avec un while comme ceci");

        b.setDebutM0M1();
        while (b.hasNext()){
            System.out.println(b.next());
        }
        b.setDebutM1M0();

        System.out.println("Deuxieme individu");
        b.setDebutM0M2();
        while (b.hasNext()){
            System.out.println(b.next());
        }
        b.setDebutM2M0();

        System.out.println("troisieme individu");
        b.setDebutM0M3();
        while (b.hasNext()){
            System.out.println(b.next());
        }
        b.setDebutM3M0();
        // ajouter du code ici pour gérer les questions en plus
        // (simulation de plusieurs navigations successives)


        // (simulation de plusieurs navigations simultanées)
    }

}
