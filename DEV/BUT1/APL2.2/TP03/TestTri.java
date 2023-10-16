/*import java.lang.Object;
import java.lang.Throwable;
import java.lang.Error;*/
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TestTri{
	/**
			*/

	@Test
	public void TestVide(){
		double tab[]={};
		Tri.trier(tab);
	}
	@Test
	public void TestUnique(){
		double tab[]={2.3};
		Tri.trier(tab);
	}
	/*@Test(except )
	public void TestMauvaisElement(){
		double tab[]={"abc",3,"2.3",9L,'v'};
		Tri.trier(tab);
	}*/
	@Test
	public void TestJuste(){
		double tab[]={2.3,5.9,6.8};
		Tri.trier(tab);
	}
	@Test
	public void TestJuste2(){
		double tab[]={2.3,5.9,6.8};
		double tab2[]=Tri.trier(tab);
		assertEquals(tab2,tab);
	}
	@Test
	public void TestJuste3(){
		double tab[]={9.6,-87.5,987.256,2.3,5.9,6.8};
		double tab2[]=Tri.trier(tab);
		assertEquals(tab2,tab);
	}
	@Test
	public void TestToutEstVrai(){
		double tab[]={-87.5,2.3,5.9,6.8,9.6,987.256};
		double tab2[]=Tri.trier(tab);
		assertEquals(tab2[0],tab[0]);
		assertEquals(tab2[1],tab[1]);
		assertEquals(tab2[2],tab[0]);
		assertEquals(tab2[3],tab[3]);
		assertEquals(tab2[4],tab[4]);
	}
	@Test
	public void TestToutEstFaux(){
		double tab[]={987.256,9.6,6.8,5.9,2.3,-87.5};
		double tab2[]=Tri.trier(tab);
		assertEquals(tab2[0],tab[0]);
		assertEquals(tab2[1],tab[1]);
		assertEquals(tab2[2],tab[0]);
		assertEquals(tab2[3],tab[3]);
		assertEquals(tab2[4],tab[4]);
		assertEquals(tab2[5],tab[5]);
	}
	@Test
	public void TestComplet(){
		double tab[]={9.6,-87.5,987.256,2.3,5.9,6.8};
		double tab2[]=Tri.trier(tab);
		assertEquals(tab2[0],tab[0]);
		assertEquals(tab2[1],tab[1]);
		assertEquals(tab2[2],tab[0]);
		assertEquals(tab2[3],tab[3]);
		assertEquals(tab2[4],tab[4]);
		assertEquals(tab2[5],tab[5]);
		assertEquals(tab2[4],tab[0]);
		assertEquals(tab2[0],tab[1]);
		assertEquals(tab2[5],tab[2]);
		assertEquals(tab2[1],tab[3]);
		assertEquals(tab2[2],tab[4]);
		assertEquals(tab2[3],tab[5]);
	}

}