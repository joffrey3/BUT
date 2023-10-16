public class Exemple {
     public static void main(String[] args) {
         // bar 2
         //   foo 5
         //     titi 4
         //     tata 4
         //     toto 6
         //   tete 6

         Travailleur titi = new Travailleur(4);
         Travailleur tata = new Travailleur(4);
         Travailleur toto = new Travailleur(6);

         Chef foo = new Chef(5);
         foo.addSubalterne(titi);
         foo.addSubalterne(tata);
         foo.addSubalterne(toto);
         System.out.println(foo.bestParty());
         System.out.println(foo.bestPartyWithoutMe());
         
         Travailleur tete = new Travailleur(6);
         // System.out.println(tete.bestParty());
         // System.out.println(tete.bestPartyWithoutMe());

         Chef bar = new Chef(2);
         bar.addSubalterne(foo);
         bar.addSubalterne(tete);
         System.out.println(bar.bestParty());
         //System.out.println(bar.bestPartyWithoutMe());
     }
    
}




