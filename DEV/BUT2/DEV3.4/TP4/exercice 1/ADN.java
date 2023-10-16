import java.util.*;
import java.text.*;
import java.awt.*;
import javax.swing.*;

public class ADN <E>{
    private Gene<E> maillon;


    public ADN(Gene<E> e){
        this.maillon=e;
    }
    public ADN(){
        this.maillon=null;
    }

    @Override
    public String toString(){
        String chaine;
        if(this.maillon!=null){
            chaine = ""+this.maillon.toString();
        }else{
            chaine = "null";
        }
        return chaine;
    }

    public void ajouter(E e,Gene<E> m){
        if(m==null){
            Gene<E> n= new Gene<E>(e);
            m=n;
            return;
        }
        if(m.getSuivant()==null){
            Gene<E> n= new Gene<E>(e);
            m.setSuivant(n);
            return;
        }
        this.ajouter(e,m.getSuivant());
    }

    public E retirer(){
        if(this.maillon==null){
            return null;
        }
        Gene<E> n=this.maillon;
        this.maillon=this.maillon.getSuivant();
        return n.getElement();
    }

    public Gene<E> getMaillon(){
        return this.maillon;
    }

    public void setMaillon(Gene<E> e){
        this.maillon=e;
    }
}