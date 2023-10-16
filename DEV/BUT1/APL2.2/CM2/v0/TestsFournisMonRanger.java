import static org.junit.Assert.assertTrue;   // import static : une facilité offerte depuis java5 (pas besoin de mettre le préfixe)
import static org.junit.Assert.assertFalse;  //
import static org.junit.Assert.assertEquals; //
import static org.junit.Assert.assertNull;   //
import static org.junit.Assert.assertNotNull;   // 
import org.junit.Test;

import java.lang.StringBuilder;

/**
 * Une classe pour faire des tests sur la classe MonRanger avec JUnit
 *
 * Un certains nombres de tests sont fournis. Vous ne devez pas changer ces derniers.
 * vous devez exécuter ces tests puis changer le code de la classe MonRanger idéalement jusqu'à ce que les tests fournis soient satisfaits.
 * Chaque ligne de MonRanger.java changée devra être suivi du commentaire 
 *
 * //BUGFIX éventuellement suivi de texte
 * 
 * Par exemple : 
 * return (this.index); //BUGFIX enlevé +1
 *
 * C'est important de suivre les consignes car mon script de correction utilise grep BUGFIX
 *
 * le enlévé +1 est pour un humain. Si vous n'avez pas enlevé +1 dans votre correction de bug, 
 * l'humain va penser que vous n'avez pas bien compris l'exercice.
 *
 */
public class TestsFournisMonRanger {

    /**
     * On ne peut pas ajouter trop de contenu différent de null
     * version avec la même valeur de String
     */
    @Test(expected = IllegalStateException.class)
    public void addSamethingWhenFull(){
        MonRanger p = new MonRanger();
        int tooMuch = p.capacity()+1;
        String s = "Ga";
         for(int i = 0; i < tooMuch; i++){
             p.add(s);
         }
    }

     /**
     * On peut ajouter autant d'élément que la capacité sans avoir d'exception
     */
    @Test
    public void addSomeDifferentThingsUntilFull(){
        MonRanger p = new MonRanger();
        for(int i = 0; i<p.capacity(); i++){
            p.add("Ga"+i);
        }
    }

    /**
     * Si j'ajoute des éléments en remplissant
     * la mémoire et que j'en enlève un
     * alors la première position contient null, les autres ne sont pas null
     */
    @Test
    public void addSomeDifferentThingsUntilFullThenAddNull(){
        MonRanger p = new MonRanger();
        String s = "Albert ";
        for(int i = p.capacity()-1; i>=0; i--){
            p.add(s+i);
        }

        p.add(null);
        assertNull(p.content(0+1));
        
        for(int i = 1; i<p.capacity(); i++){
            assertNotNull(p.content(i+1));
        }       
    }

    

    /**
     * Si j'ajoute des éléments dans l'ordre alphabétique en remplissant
     * la mémoire 
     * alors le dernier est en première position, l'avant-dernier 
     * en seconde position et ainsi de suite jusqu'au premier qui est en dernière position. 
     */
    @Test
    public void addOrderedThingsUntilFullInCorrectOrder(){
        MonRanger p = new MonRanger();
        String s = "Albert";
        for(int i = 0; i<p.capacity(); i++){
            p.add(s+i);
        }
        for(int i = 0; i<p.capacity(); i++){
            assertEquals(s+(p.capacity()-1-i), p.content(i+1));
        }               
               
    }

    /**
     * Si j'ajoute des éléments dans l'ordre alphabétique inverse en remplissant
     * la mémoire 
     * alors le dernier est en première position, l'avant-dernier 
     * en seconde position et ainsi de suite jusqu'au premier qui est en dernière position. 
     */
    @Test
    public void addInverseOrderedThingsUntilFullInCorrectOrder(){
        MonRanger p = new MonRanger();
        String s = "Albert ";
        for(int i = p.capacity()-1; i>=0; i--){
            p.add(s+i);
        }
        for(int i = 0; i<p.capacity(); i++){
            assertEquals(s+(p.capacity()-1-i), p.content(i+1));
        }       
    }    
   
    
}
