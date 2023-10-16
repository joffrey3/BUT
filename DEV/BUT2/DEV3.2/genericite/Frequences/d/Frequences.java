import java.util.*;
import java.text.*;

public class Frequences {
    public static<E> Liste<E> nbElement(Liste<E> l){
        Association<E> m=l.getMaillon();
        ArrayList<Integer> numb = new ArrayList<Integer>();
        if(m==null){
            return null;
        }
        while(m.getSuivant()!=null){
            numb.add(m.getFrequence());
            m=m.getSuivant();
        }
        numb.add(m.getFrequence());
        l.setTab(numb);
        return l;
    }
}