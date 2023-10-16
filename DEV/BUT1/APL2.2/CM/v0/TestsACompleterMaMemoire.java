import static org.junit.Assert.assertTrue; // import static : une facilité offerte depuis java5 (pas besoin de mettre le préfixe)
import static org.junit.Assert.assertFalse; //
import static org.junit.Assert.assertEquals; // 
import org.junit.Test;

import java.lang.StringBuilder;

/**
 * Une classe pour faire des tests sur la classe MaMemoire avec JUnit
 *
 * Vous devez compléter les tests dont le squelette est fourni.
 */
public class TestsACompleterMaMemoire {



    /**
     * Enlever un élément d'une mémoire vide cause une exception
     */
    @Test(expected = IllegalStateException.class)
    public void removeWhenEmpty(){
	 MaMemoire p = new MaMemoire();
	 p.remove();
    }

    /**
     * Enlever un élément d'une mémoire non vide ne cause pas d'exception
     */
    @Test
    public void removeWhenNotEmpty(){
	MaMemoire p = new MaMemoire();
	p.add("GA");
	p.remove();
    }

    /**
     * Enlever tous les éléments d'une mémoire pleine ne cause pas d'exception
     */
    @Test
    public void removeAllWhenFull(){
	MaMemoire p = new MaMemoire();
	p.add("GA");
	p.add("BU");
	p.add("ZO");
	p.add("ME");
	assertTrue(p.size()==p.capacity());
	p.remove();
	p.remove();
	p.remove();
	p.remove();
    }

    
    
    /**
     * Si j'ajoute puis enlève un élément dans une mémoire vide, c'est le même.
     */    
    @Test
    public void addRemoveSameElement(){
	MaMemoire p = new MaMemoire();
	p.add("GA");
	String s=p.remove();
	assertEquals(s,"GA");
    }

    /**
     * Si j'ajoute puis enlève un élément dans une mémoire non-vide, c'est le même (variante avec plus d'éléments).
     */    
    @Test
    public void addRemoveSameElementMemoryFuller(){
	MaMemoire p = new MaMemoire();
	p.add("GA");
	p.add("BU");
	String s=p.remove();
	assertEquals(s,"BU");
    }

    
}
