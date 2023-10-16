import java.util.*;
import java.text.*;
import java.awt.*;
import javax.swing.*;

public class Gene <E>{
    private E element;
    private Gene<E> suivant;

    public Gene(E e,Gene<E> s){
        this.element=e;
        this.suivant=s;
    }
    public Gene(E e){
        this.element=e;
        this.suivant=null;
    }

    @Override
    public String toString(){
        String chaine;
        if(this.suivant!=null){
            chaine = " "+this.element.toString()+", "+this.suivant.toString();
        }else{
            chaine = " "+this.element.toString()+" null";
        }
        return chaine;
    }

    public E getElement(){
        return this.element;
    }

    public void setElement(E e){
        this.element=e;
    }

    public Gene<E> getSuivant(){
        return this.suivant;
    }

    public void setSuivant(Gene<E> s){
        this.suivant=s;
    }
}