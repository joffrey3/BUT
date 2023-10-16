public class Main {
    public static void main (String[] args){
        Tableaux tableau = new Tableaux(args);
        int[] tab =tableau.transformer(args);
        String chaine =tableau.affichage(0);
        int nb_pair=tableau.parite(0,0);
        System.out.println(chaine);
        System.out.println(nb_pair);
    }
}