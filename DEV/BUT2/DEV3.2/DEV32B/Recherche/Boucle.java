//Fouché Joffrey

import java.util.function.*;
public class Boucle<E> implements Consumer<E>{
    private int compteur;
    private E element;
    public Boucle(E e){
        this.compteur=0;
        this.element=e;
    }
    public void accept(E e){
        if(this.element.equals(e)){
            this.compteur=this.compteur+1;
        }
    }
    public int getCompteur(){
        return this.compteur;
    }
}