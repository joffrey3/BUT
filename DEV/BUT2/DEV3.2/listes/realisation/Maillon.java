import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

public class Maillon<E>{
    private E valeur;
    private Maillon<E> suivant;
    private Maillon<E> precedant;
    public Maillon(E v){
        this.valeur=v;
        this.suivant=null;
        this.precedant=null;
    }
    public Maillon(E v,Maillon<E> m){
        this.valeur=v;
        this.suivant=m;
        this.precedant=null;
    }
    public Maillon(Maillon<E> m,E v){
        this.valeur=v;
        this.suivant=null;
        this.precedant=m;
    }
    public Maillon(Maillon<E> m,E v,Maillon<E> n){
        this.valeur=v;
        this.suivant=m;
        this.precedant=n;
    }
    public void setSuivant(Maillon<E> m){
        this.suivant=m;
    }
    public Maillon<E> getSuivant(){
        return this.suivant;
    }
    public void setPrecedant(Maillon<E> m){
        this.precedant=m;
    }
    public Maillon<E> getPrecedant(){
        return this.precedant;
    }
    public void setValeur(E v){
        this.valeur=v;
    }
    public E getValeur(){
        return this.valeur;
    }
}