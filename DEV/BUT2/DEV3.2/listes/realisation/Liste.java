import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

public class Liste<E> implements List<E>{
    private Maillon<E> premier;
    private int taille;
    public Liste(){
        this.premier=null;
        this.taille=0;
    }
    public boolean add(E v){
        if(v==null){
            return false;
        }
        Maillon<E> m= new Maillon<E>(v);
        m.setSuivant(this.premier);
        this.premier.setPrecedant(m);
        this.premier=m;
        this.taille++;
        return true;
    }
    public E get(int n){
        Maillon<E> m=this.premier;
        for(int i=0;i<this.taille-n-1;i++){
            m=m.getSuivant();
        }
        return m.getValeur();
    }
    public int size(){
        return this.taille;
    }
    public List<E> subList(int debut,int fin){
        Maillon<E> m = this.premier;
        for(int i=0;i<debut;i++){
            m=m.getSuivant();
        }
        Liste<E> l = new Liste<E>();
        for(int i=0;i<fin-debut;i++){
            E element= get(i);
            l.add(element);
        }
        return l;
    }
    public ListIterator<E> listIterator(int index){
        Maillon<E> m = this.premier;
        for(int i=0;i<index;i++){
            m=m.getSuivant();
        }
        ListIterator<E> l = new ListeIterator<E>();
        for(int i=0;i<this.size()-index;i++){
            l.add(m.getValeur());
            m=m.getSuivant();
        }
        return l;
    }
    public ListIterator<E> listIterator(){
        Maillon<E> m = this.premier;
        ListIterator<E> l = new ListeIterator<E>();
        for(int i=0;i<this.size();i++){
            l.add(m.getValeur());
            m=m.getSuivant();
        }
        return l;
    }
}