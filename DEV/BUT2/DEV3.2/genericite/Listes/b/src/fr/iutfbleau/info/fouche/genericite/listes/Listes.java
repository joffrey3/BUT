package fr.iutfbleau.info.fouche.genericite.listes;

import  java.util.*;

public class Listes {

    public Listes(){
        final int entier= 5;
        final float reel = 5.0f;
        final long longueur = 5;
	final int test1 = 0;
	final float test2 = 0.0f;
	final Number test3=0.0d;
        ArrayList <Integer> liste1= new ArrayList <Integer> ();
        ArrayList <Float> liste2= new ArrayList <Float> ();
        ArrayList <Number> liste3= new ArrayList <Number> ();
	liste1.add(test1);
	liste2.add(test2);
	liste3.add(test3);
	//assert(liste1.addAll(liste2)==false);
	//assert(liste1.addAll(liste3)==false);
	//assert(liste2.addAll(liste1)==false);
	//assert(liste2.addAll(liste3)==false);
	assert(liste3.addAll(liste1)==true);
	assert(liste3.addAll(liste2)==true);
    Test tentative= new Test();
	System.out.println(tentative.comparer(test1,entier,liste1));
	System.out.println(tentative.comparer(test1,reel,liste1));
	System.out.println(tentative.comparer(test1,longueur,liste1));
	System.out.println(tentative.comparer(test2,entier,liste2));
	System.out.println(tentative.comparer(test2,reel,liste2));
	System.out.println(tentative.comparer(test2,longueur,liste2));
	System.out.println(tentative.comparer(test3,entier,liste3));
	System.out.println(tentative.comparer(test3,reel,liste3));
	System.out.println(tentative.comparer(test3,longueur,liste3));
    }
 
}
