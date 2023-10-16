import java.util.*;
import java.text.*;
import java.awt.*;
import javax.swing.*;

public class Association <E>{
    private E element;
    private int frequence;
    public Association(E e,int f){
        this.element=e;
        this.frequence=f;
    }
    public Association(E e){
        this.element=e;
        this.frequence=1;
    }
    public Association(int f){
        this.element=null;
        this.frequence=f;
    }
    public Association(){
        this.element=null;
        this.frequence=1;
    }

    @Override
    public String toString(){
        String chaine = "l'element "+element.toString()+" est de fréquence "+Integer.toString(frequence);
        return chaine;
    }

    public E getElement(){
        return this.element;
    }

    public void setElement(E e){
        this.element=e;
    }

    public int getFrequence(){
        return this.frequence;   
    }

    public void setFrequence(int f){
        this.frequence=f;
    }
}