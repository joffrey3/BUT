import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

public class ListeIterator<E> implements ListIterator<E>{
    private Maillon<E> premier;
    private Maillon<E> curseur;
    private Maillon<E> dernier;
    public ListeIterator(){
        this.curseur=null;
        this.premier=null;
    }
    public void add(E v){
        Maillon<E> m= new Maillon<E>(v);
        m.setPrecedant(this.dernier);
        this.dernier.setSuivant(m);
        this.dernier=m;
    }
    public void set(E v){
        this.curseur.setValeur(v);
    }
    public void remove(){
        if(this.hasNext() && this.hasPrevious()){
            Maillon<E> n= this.curseur.getSuivant();
            this.curseur= this.curseur.getPrecedant();
            this.curseur.setSuivant(n);
            n.setPrecedant(this.curseur);
        }
        else if(this.hasNext()){
            this.curseur= this.curseur.getSuivant();
            this.premier= this.premier.getSuivant();
            this.premier.setPrecedant(null);
        }
        else if(this.hasPrevious()){
            this.curseur= this.curseur.getPrecedant();
            this.dernier= this.dernier.getPrecedant();
            this.dernier.setSuivant(null);
        }
        else{
            this.curseur=null;
        }
    }
    public int previousIndex(){
        if(this.curseur.getPrecedant()==null){
            return -1;
        }
        Maillon<E> m= this.premier;
        int i;
        for(i=0;!m.getSuivant().equals(this.curseur);i++){
            m=m.getSuivant();
        }
        return i;
    }
    public int nextIndex(){
        if(this.curseur.getSuivant()==null){
            return -1;
        }
        Maillon<E> m= this.dernier;
        int i;
        for(i=0;!m.getPrecedant().equals(this.curseur);i++){
            m=m.getPrecedant();
        }
        return i;
    }
    public E previous(){
        this.curseur=this.curseur.getPrecedant();
        return this.curseur.getValeur();
    }
    public E next(){
        this.curseur=this.curseur.getSuivant();
        return this.curseur.getValeur();
    }
    public boolean hasNext(){
        return this.curseur.getSuivant()==null;
    }
    public boolean hasPrevious(){
        return this.curseur.getPrecedant()==null;
    }
}