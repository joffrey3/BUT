public class Exemple{

   /**
     * Exemple d'uilisation de MaMemoire.
     *
     * @param args pas de paramètre en ligne de commande prévu.
     */
    public static void main(String[] args) {

        Memoire m = new MaMemoire();
        System.out.println(m.toString()); //vide
        System.out.println("");
        m.add("GA");
        System.out.println(m.toString());//GA
        
        if (m.contain("GA")){
                System.out.println("OK");
            }
        else{
            System.out.println("KO");
        }

        m.add("BU");
        m.add("ZO");
        System.out.println(m.toString());//GA,BU,ZO

        System.out.println(m.remove()); // ZO

        System.out.println(m.toString()); // GA,BU
        m.add("ME");
        System.out.println(m.toString()); // GA,BU,ME
    }
    
}
