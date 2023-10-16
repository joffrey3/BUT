public class Main {
    public static void main (String[] args){
        Tableaux tableau = new Tableaux(args);
        int[] tab =tableau.transformer(args);
        String chaine =tableau.affichage(0);
        System.out.println(chaine);
    }
}