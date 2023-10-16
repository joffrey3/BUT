import java.util.*;
import java.text.*;
import java.awt.*;
import javax.swing.*;

public class Association <E>{
    private E element;
    private int frequence;
    private Association<E> suivant;

    public Association(E e,int f,Association<E> s){
        this.element=e;
        this.frequence=f;
        this.suivant=s;
    }
    public Association(E e,Association<E> s){
        this.element=e;
        this.frequence=1;
        this.suivant=s;
    }
    public Association(int f,Association<E> s){
        this.element=null;
        this.frequence=f;
        this.suivant=s;
    }
    public Association(Association<E> s){
        this.element=null;
        this.frequence=1;
        this.suivant=s;
    }
    public Association(E e,int f){
        this.element=e;
        this.frequence=f;
        this.suivant=null;
    }
    public Association(E e){
        this.element=e;
        this.frequence=1;
        this.suivant=null;
    }
    public Association(int f){
        this.element=null;
        this.frequence=f;
        this.suivant=null;
    }
    public Association(){
        this.element=null;
        this.frequence=1;
        this.suivant=null;
    }

    @Override
    public String toString(){
        String chaine;
        if(this.suivant!=null){
            chaine = "l'element "+this.element.toString()+" est de fréquence "+Integer.toString(this.frequence)+" et le maillon d'après est \n"+this.suivant.toString();
        }else{
            chaine = "l'element "+this.element.toString()+" est de fréquence "+Integer.toString(this.frequence)+" et le maillon d'après est null\n";
        }
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

    public Association<E> getSuivant(){
        return this.suivant;
    }

    public void setSuivant(Association<E> s){
        this.suivant=s;
    }
}