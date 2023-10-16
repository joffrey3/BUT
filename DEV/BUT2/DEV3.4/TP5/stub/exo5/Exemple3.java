public class Exemple3 {
     public static void main(String[] args) {

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

         Travailleur titi = new Travailleur(4);
         Travailleur tata = new Travailleur(4);
         Travailleur toto = new Travailleur(6);
         Chef foo = new Chef(5);
         foo.addSubalterne(titi);
         foo.addSubalterne(tata);
         foo.addSubalterne(toto);
         Chef bar = new Chef(2);
         bar.addSubalterne(foo);
         Travailleur tete = new Travailleur(6);
         bar.addSubalterne(tete);
         
         Chef x = new Chef(2);
         x.addSubalterne(g);
         x.addSubalterne(bar);
         Chef y = new Chef(39);
         y.addSubalterne(x);
         
         System.out.println(y.bestParty());
     }
    
}




