public class Exemple2 {
     public static void main(String[] args) {
         // Exemple inspiré question Thibault B.
         // 1
         //   10
         //       1
         //         1
         //           10
         //              3
         //              4

         Travailleur a = new Travailleur(3);
         Travailleur b = new Travailleur(4);
         Chef c = new Chef(10);
         c.addSubalterne(a);
         c.addSubalterne(b);
         Chef d = new Chef(1);
         d.addSubalterne(c);
         Chef e = new Chef(1);
         e.addSubalterne(d);
         Chef f = new Chef(10);
         f.addSubalterne(e);
         Chef g = new Chef(1);
         g.addSubalterne(f);
         
         System.out.println(g.bestParty());
     }
    
}




