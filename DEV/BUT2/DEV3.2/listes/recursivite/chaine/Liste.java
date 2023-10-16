import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

public class Liste<E>{
    private Maillon<E> premier;
    private int taille;
    public Liste(){
        this.premier=null;
        this.taille=0;
    }
    public void add(E v){
        Maillon<E> m= new Maillon<E>(v);
        m.setSuivant(this.premier);
        this.premier=m;
        this.taille++;
    }
    public E get(int i){
        Maillon<E> m= this.premier;
        return this.recursif(i,m);
    }
    public E recursif(int i,Maillon<E> m){
        if(i==0){
        return m.getValeur();
    }
        return this.recursif(i-1,m.getSuivant());
    }
    public int size(){
        return this.taille;
    }
}