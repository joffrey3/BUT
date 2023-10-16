import java.util.*;

public class Tableau <E> implements Pile <E>{
    private int[] tab;
    private int pointeur;

    public Tableau(int taille){
        this.pointeur=0;
        this.tab= new int[1];
    }
    
    @Override
    public void addFirst(int element){
        if(this.pointeur==tab.length){
            int[] temp =this.tab;
            this.tab= new int[this.tab.length+1];
            for(int i=0;i<temp.length;i++){
                this.tab[i]=temp[i];
            }
        }
        this.tab[this.pointeur]=element;
        this.pointeur=this.pointeur+1;
    }

    @Override
    public int removeFirst(){
        int element =this.tab[this.pointeur-1];
        this.pointeur=this.pointeur-1;
        return element;
    }

    @Override
    public boolean isEmpty(){
        return this.pointeur==0;
    }
}