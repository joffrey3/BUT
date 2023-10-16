import java.util.*;

public class Fusion{
    int taille;
    public Fusion(ArrayDeque<Double>  l){
        this.taille=l.size();
    }
    public ArrayDeque<Double> tri(ArrayDeque<Double> liste){
        if(liste.size()<=1){
            return liste;
        }
        ArrayDeque<ArrayDeque<Double>> tab =scinder(liste);
        ArrayDeque<Double> l1=new ArrayDeque<Double>();
        ArrayDeque<Double> l2=new ArrayDeque<Double>();
            if(!tab.isEmpty()){
                l1=tab.remove();
            }
            if(!tab.isEmpty()){
                l2=tab.remove();
            }
        l1=this.tri(l1);
        l2=this.tri(l2);
        return fusionner(l1,l2);
    }

    public ArrayDeque<ArrayDeque<Double>> scinder(ArrayDeque<Double> liste){
        ArrayDeque<Double> l1 = new ArrayDeque<Double>();
        ArrayDeque<Double> l2 = new ArrayDeque<Double>();
        for(;!liste.isEmpty();){
            l1.add(liste.remove());
            if(!liste.isEmpty()){
                l2.add(liste.remove());
            }
        }
        ArrayDeque<ArrayDeque<Double>> tab = new  ArrayDeque<ArrayDeque<Double>>() ;
        tab.add(l1);
        tab.add(l2);
        return tab;
    }

    public ArrayDeque<Double> fusionner(ArrayDeque<Double> l1,ArrayDeque<Double> l2){
        ArrayDeque<Double> l= new ArrayDeque<Double>();
        Double n1=0.0,n2=0.0;
        for(int i=1,j=1;!l1.isEmpty() || !l2.isEmpty();){
            if(i==1 && !l1.isEmpty()){
            n1=l1.remove();
            }
            if(j==1 && !l2.isEmpty()){
            n2=l2.remove();
            }
            if(n1<n2){
                l.add(n1);
                i=1;
                j=0;
            }else{
                l.add(n2);
                j=1;
                i=0;
            }
        }
        if(n1<n2){
            l.add(n2);
        }else{
            l.add(n1);
        }
        return l;
    }
}