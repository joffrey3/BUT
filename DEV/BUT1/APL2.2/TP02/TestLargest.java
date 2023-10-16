import static org.junit.Assert.assertEquals;
import org.junit.Test;
 
public class TestLargest {
 
  @Test
  public void testVide() {
    assertEquals(-2147483648, Largest.largest(new int[] {}));
  }
  @Test
  public void testUnique() {
    assertEquals(7, Largest.largest(new int[] {7}));
  }
  @Test
  public void testSimple() {
    assertEquals(9, Largest.largest(new int[] {9,8,7}));
  }
  @Test
  public void testInverse() {
    assertEquals(9, Largest.largest(new int[] {7,8,9}));
  }
  @Test
  public void testSimple2() {
    assertEquals(-7, Largest.largest(new int[] {-9,-8,-7}));
  }
  @Test
  public void testInverse2() {
    assertEquals(-7, Largest.largest(new int[] {-7,-8,-9}));
  }
  @Test
  public void testMax() {
    assertEquals(2147483647, Largest.largest(new int[] {2147483647,0,-9}));
  }
   @Test
  public void testMin() {
    assertEquals(-2147483648, Largest.largest(new int[] {-2147483648,-2147483648,-2147483648}));
  }
  @Test
  public void testEfficacitéNombreTest() {
  	for (int i=0;i<2147483647;i++){
    	assertEquals(i, Largest.largest(new int[] {i,i-1,i-2}));
    }
  }
  @Test
  public void testEfficacitéTailleTest() {
  	int[] tab = new int[2147483647];
  	for (int i=0;i<2147483647;i++){
    	tab[i]=0;
    }
    assertEquals(0, Largest.largest(tab));
  }
}