import static org.junit.Assert.assertTrue; // import static : une facilité offerte depuis java5 (pas besoin de mettre le préfixe)
import static org.junit.Assert.assertFalse; //
import static org.junit.Assert.assertEquals; // 
import org.junit.Test;

import java.lang.StringBuilder;

/**
 * Une classe pour faire des tests sur la classe MaMemoire avec JUnit
 *
 * Un certains nombres de tests sont fournis. Vous ne devez pas changer ces derniers.
 * vous devez exécuter ces tests puis changer le code de la classe MaMemoire idéalement jusqu'à ce que les tests fournis soient satisfaits.
 * Chaque ligne de MaMemoire.java changée devra être suivi du commentaire 
 * //BUGFIX éventuellement suivi de texte
 * 
 * Par exemple : 
 * return (this.index); //BUGFIX enlevé +1
 *
 */
public class TestsFournisMaMemoire {


    /**
     * On ne peut pas ajouter le mot null
     */
    @Test(expected = NullPointerException.class)
    public void addNull(){
        MaMemoire p = new MaMemoire();
        p.add(null);
    }
    
    /**
     * On ne peut pas ajouter deux fois un mot
     */
    @Test(expected = IllegalStateException.class)
    public void addTwice(){
        MaMemoire p = new MaMemoire();
        p.add("Ga");
        p.add("Bu");
        p.add("Ga");
    }

    /**
     * Remplir la mémoire entièrement ne doit pas renvoyer d'exception
     * NB. pas d'assert particulier puisque add ne retourne rien
     * On ne veut juste pas d'exception.
     */
    @Test
    public void fillUp(){
        MaMemoire p = new MaMemoire();
        p.add("Ga");
        p.add("Bu");
        p.add("Zo");
        p.add("Me");
    }

    /**
     * Excéder la limite retourne une exception.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void addTooMuch(){
        MaMemoire p = new MaMemoire();
        p.add("Ga");
        p.add("Bu");
        p.add("Zo");
        p.add("Me");
        p.add("Gi");
    }

    /**
     * Tester l'appartenance pour null retourne une exception
     */
    @Test(expected = NullPointerException.class)
    public void containNull(){
        MaMemoire p = new MaMemoire();
        p.contain(null);
    }

    
    /**
     * Test la méthode contain.
     * On ajoute des éléments à la mémoire, on teste qu'ils sont présents 
     * On teste que des éléments non ajoutés comme "autre", "" (le mot vide) 
     * et "null" ne sont pas contenu dans la mémoire.
     */
    @Test
    public void containOrNotContain(){
        MaMemoire p = new MaMemoire();
        p.add("Ga");
        p.add("Bu");
        p.add("Zo");
        p.add("Me");
        assertTrue(p.contain("Ga"));
        assertTrue(p.contain("Bu"));
        assertTrue(p.contain("Zo"));
        assertTrue(p.contain("Me"));
        assertFalse(p.contain("autre"));
        assertFalse(p.contain(""));
        assertFalse(p.contain("null"));
    }
    /**
     * Si j'ajoute un élément, la mémoire contient un élément.
     */    
    @Test
    public void addOneSizeOne(){
        MaMemoire p = new MaMemoire();
        String s = "Ga";
        p.add(s);
        assertEquals(1,p.size());
    }

    /**
     * Si j'ajoute deux éléments, la mémoire contient deux éléments.
     */    
    @Test
    public void addTwoSizeTwo(){
        MaMemoire p = new MaMemoire();
        String s1 = "Ga";
        String s2 = "Bu";
        p.add(s1);
        p.add(s2);
        assertEquals(2,p.size());
    }

   
    
}
