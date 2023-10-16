import static org.junit.Assert.assertTrue; // import static : une facilité offerte depuis java5 (pas besoin de mettre le préfixe)
import static org.junit.Assert.assertFalse; //
import static org.junit.Assert.assertEquals; //
import static org.junit.Assert.assertNull;   // 
import org.junit.Test;

import java.lang.StringBuilder;

/**
 * Une classe pour faire des tests sur la classe MonRanger avec JUnit
 *
 * Vous devez compléter les tests dont le squelette est fourni.
 */
public class TestsACompleterMonRanger {

    /**
     * On ne peut pas ajouter null dans une mémoire vide
     */
    @Test(expected = IllegalStateException.class)
    public void addNullInEmpty(){
        MonRanger p = new MonRanger();
        p.add(null);
    }

    /**
     * On ne peut pas ajouter trop de contenu différent de null
     * version avec des mots différents deux à deux et exactement un élément de plus que la capacité.
     * Il est possible que la capacité change dans le constructeur.
     */
    @Test(expected = IllegalStateException.class)
    public void addSomethingWhenFull(){
        MonRanger p = new MonRanger();
        int tooMuch = p.capacity()+1;
        String s = "Ga";
        String t = "Bu";
        p.add(s);
        p.add(t);
        p.add(s);
        p.add(t);
        p.add(s);
        p.add(t);
        p.add(s);
        p.add(t);
        p.add(s);
        p.add(t);
         /*for(int i = 0; i < tooMuch; i++){
            if(i%2==0){
                p.add(s);
            }
            if(i%2==1){
                p.add(t);
            }
         }*/
    }

    /**
     * On peut ajouter autant d'élément que la capacité sans avoir d'exception
     * même quand c'est toujours le même élément.
     */
    @Test
    public void addSameThingUntilFull(){
        MonRanger p = new MonRanger();
        int tooMuch = p.capacity();
        String s = "Ga";
         for(int i = 0; i < tooMuch; i++){
             p.add(s);
         }
    }

    /**
     * Si j'ajoute des éléments dans l'ordre alphabétique inverse en remplissant
     * la mémoire et que j'en enlève un
     * alors le dernier est null, l'avant-dernier est 
     * en seconde position et ainsi de suite jusqu'au premier qui est en dernière position. 
     */
    @Test
    public void addInverseOrderedThingsUntilFullThenAddNullInCorrectOrder(){
        MonRanger p = new MonRanger();
        String s = "Albert ";
        for(int i = p.capacity()-1; i>=0; i--){
            p.add(s+i);
        }
        p.add(null);
        for(int i = 0; i<p.capacity(); i++){
            if(i==0){
               assertEquals(null, p.content(i+1)); 
            }
            else{
                assertEquals(s+(p.capacity()-1-i), p.content(i+1));
            }
        }     
    }


}
