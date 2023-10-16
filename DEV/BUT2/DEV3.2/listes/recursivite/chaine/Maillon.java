import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

public class Maillon<E>{
    private E valeur;
    private Maillon<E> suivant;
    public Maillon(E v){
        this.valeur=v;
        this.suivant=null;
    }
    public Maillon(E v,Maillon<E> m){
        this.valeur=v;
        this.suivant=m;
    }
    public void setSuivant(Maillon<E> m){
        this.suivant=m;
    }
    public Maillon<E> getSuivant(){
        return this.suivant;
    }
    public void setValeur(E v){
        this.valeur=v;
    }
    public E getValeur(){
        return this.valeur;
    }
}