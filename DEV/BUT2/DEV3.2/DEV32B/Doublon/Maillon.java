//Fouché Joffrey

import java.util.*;
import javax.swing.*;

public class Maillon{
    private int valeur;
    private Maillon suivant;
    public Maillon(int v){
        this.valeur=v;
        this.suivant=null;
    }
    public Maillon(int v,Maillon m){
        this.valeur=v;
        this.suivant=m;
    }
    public void setSuivant(Maillon m){
        this.suivant=m;
    }
    public Maillon getSuivant(){
        return this.suivant;
    }
    public void setValeur(int v){
        this.valeur=v;
    }
    public int getValeur(){
        return this.valeur;
    }
}