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
}