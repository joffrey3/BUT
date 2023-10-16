import static org.junit.Assert.assertTrue; // import static : une facilité offerte depuis java5 (pas besoin de mettre le préfixe)
import static org.junit.Assert.assertFalse; // 
import org.junit.Test;


/**
 * Une classe pour faire des tests sur la classe Carte avec JUnit
 */
public class TestCarte {

    // un test pour Junit4 c'est une méthode avec l'annotation @Test devant une méthode avec un type de retour void.
    @Test
    public void egaleSiIdentiquesEtVisible() {
        Carte un = new Carte(1);
        un.toggleVisible();
         // on peut stipuler que des choses sont normalement égales (il faut charger de manière statique les Assert si on veut éviter d'avoir à écrire de quelle classe on parle)
        assertTrue(un.egale(un));
    }

    // le nom du test doit être le plus explicite possible
    @Test
    public void egalSiMemeValeurEtVisible() {
       Carte un = new Carte(1);
       un.toggleVisible();
       Carte unBis = new Carte(1);
       unBis.toggleVisible();
       assertTrue(un.egale(unBis));
    }

    @Test
    public void pasEgalSiPasMemeValeurEtVisible() {
       Carte un = new Carte(1);
       un.toggleVisible();
       Carte deux = new Carte(2);
       deux.toggleVisible();
       assertFalse(un.egale(deux));
    }

    // un test pour Junit4 qui cherche à vérifier qu'il y a bien une exception
    @Test(expected = NullPointerException.class)
    public void egalPasFaitPourNull(){
        Carte bad = null;
        Carte un = new Carte(1);
        un.egale(bad);
        if (bad==null){
        NullPointerException test = new NullPointerException();
        throw test;
        }
    }

    // un autre test pour Junit4 qui cherche à vérifier qu'il y a bien une exception
    @Test(expected = IllegalArgumentException.class)
    public void egalPasFaitPourParametreNonVisible(){
        Carte un = new Carte(1);
        un.toggleVisible();
        Carte deux = new Carte(2);
        un.egale(deux);
        if (deux.getVisible()==false){
        IllegalArgumentException test = new IllegalArgumentException("Test");
        throw test;
        }
    }

    // un autre test pour Junit4 qui cherche à vérifier qu'il y a bien une exception
    @Test(expected = IllegalStateException.class)
    public void egalPasFaitPourCarteThisNonVisible(){
        Carte un = new Carte(1);
        Carte deux = new Carte(2);
        deux.toggleVisible();
        un.egale(deux);
        if (un.getVisible()==false){
        IllegalStateException test = new IllegalStateException();
        throw test;
        }
    }

    //Le monde est mal fait et parfois c'est le test qui est faux.
    //Notez que je suis vraiment méchant car ce test est satisfait au début avec le code proposé...
    //Moralité : faites des tests très simples et faites vous relire! 
    @Test 
    public void egalTestMalFait(){
        Carte un = new Carte(1);
        un.toggleVisible();
        Carte deux = new Carte(2);
        deux.toggleVisible();
        un.toggleVisible();//copié collé de la mort
        assertFalse(un.egale(deux));
    }

    // si on ne met pas l'annotation arobase test, le test n'est jamais pris en compte.
    // c'est juste une méthode annexe qui n'est pas appellée comme dans n'importe quelle classe.
    public void autreTestMalFait(){
        assertFalse(true);
    }  
}
