public class Exemple{

   /**
     * Exemple d'utilisation de MonRanger.
     *
     * @param args pas de paramètre en ligne de commande prévu.
     */
    public static void main(String[] args) {

        String s1 = "albert";
        String s2 = "babar";
        String s3 = "albertine";
        String s4 = "albert 1";
        String s5 = "albert 2";
        String s6 = "barbara";
        System.out.println(s1 +";" + s2 + ":" + s1.compareTo(s2));
        System.out.println(s2 +";" + s1 + ":" + s2.compareTo(s1));
        System.out.println(s2 +";" + s3 + ":" + s2.compareTo(s3));
        System.out.println(s1 +";" + s3 + ":" + s1.compareTo(s3));
        System.out.println(s1 +";" + s1 + ":" + s1.compareTo(s1));

        System.out.println(s4 + ";" + s5 + ":" + s4.compareTo(s5));

        System.out.println(s1 + ";" + s5 + ":" + s1.compareTo(s5));

        System.out.println(s2 + ";" + s5 + ":" + s2.compareTo(s5));

        System.out.println(s5 + ";" + s6 + ":" + s5.compareTo(s6));

        System.out.println(s1 + ";" + s6 + ":" + s1.compareTo(s6));
        
        MonRanger m = new MonRanger();
        System.out.println(m.toString());
        // m.add(null); // trop vide
        System.out.println("");
        m.add("Albert 3");
        m.add("Albert 2");
        m.add("Albert 1");
        System.out.println(m.toString());

        m.add("y");
        System.out.println(m.toString());

        m.add("y");
        System.out.println(m.toString());

        m.add(null);
        System.out.println(m.toString());

        m.add(null);
        System.out.println(m.toString());

        m.add("z");
        System.out.println(m.toString());

        m.add(null);
        m.add(null);
        m.add(null);
        System.out.println(m.toString());

        //m.add(null);//trop vide

        m.add("arb");
        System.out.println(m.toString());

        m.add("arbu");
        System.out.println(m.toString());

        m.add("arbustif");
        System.out.println(m.toString());

        m.add("z");
        System.out.println(m.toString());

        m.add("z");
        System.out.println(m.toString());
    }
    
}
