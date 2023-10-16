// Fichier Exemple pour le premier exercice sur l'ADN

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
        

        System.out.println("On peut afficher en avançant");
        System.out.println("Il faut s'en inspirer pour implémenter l'interface iterator de Java.util");
        MonMaillon actuel = b.getDebut();//NB: c'est comme l ci-dessus
        
        while (actuel != null){
            System.out.println(actuel.getBase());
            actuel = actuel.getSuiteMaillon();
        }
    }
}
