import java.util.*;
import java.text.*;

public class Frequence {
    public static<T> T elementRecurrent(T[] args){
        T[] tab = args;
        int iteration = 0, position=0;
        T element;
        String texte1,texte2;
        Collator comparateur = Collator.getInstance();
        ArrayList<Integer> numb = new ArrayList<Integer>();
        ArrayList<T> chaine = new ArrayList<T>();
        Arrays.parallelSort(tab,comparateur);
        System.out.println(Arrays.toString(tab));
        element=tab[0];
        chaine.add(tab[0]);
        texte1=element.toString();
        for (int i=0;i<tab.length;i++){
                texte2=tab[i].toString();
            if(texte1.compareTo(texte2)==0){
                iteration=iteration+1;
            }
            else{
                numb.add(iteration);
                element=tab[i];
                chaine.add(element);
                position=position+1;
                iteration=1;
                texte1=element.toString();
            }
        }
        numb.add(iteration);
        System.out.println(chaine.toString());
        System.out.println(numb.toString());
        int max=0;
        for (int i=0;i<chaine.size();i++){
            if (max<numb.get(i)){
                max=numb.get(i);
                element=chaine.get(i);
            }
        }
        System.out.println(element);
        return element;
    }
}