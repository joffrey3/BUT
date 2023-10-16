//Fouché joffrey

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int compteur;
        String element="Charlie";
        Recherche r= new Recherche();
        List<String> l = new ArrayList<String>();
        for (int i=0;i<args.length;i++){
            l.add(args[i]);
        }
        //compteur=r.rechercher(l,element);
        compteur=r.rechercherEncore(l,element);
        System.out.println("L'element "+element+" est présent "+Integer.toString(compteur)+" fois");
    }
}