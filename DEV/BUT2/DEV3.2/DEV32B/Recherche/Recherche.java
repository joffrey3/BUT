//Fouché joffrey

import java.util.*;
import java.util.function.*;
public class Recherche {
    public <E> int rechercher(List<E> liste, E element){
        int compteur=0;
        for(int i=0;i<liste.size();i++){
            if(liste.get(i).equals(element)){
                compteur=compteur+1;
            }
        }
        return compteur;
    }
    public <E> int rechercherEncore(List<E> liste, E element){
        int compteur=0;
        Boucle<E> boucle= new Boucle<E>(element);
        liste.forEach(boucle);
        compteur=boucle.getCompteur();
        //compteur=boucle.getIncrement();
        return compteur;
    }
}
