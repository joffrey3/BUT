import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

public class Tableau<E extends Color>{
    private int curseur;
    private Color[] tab;
    public Tableau(){
        this.curseur=0;
        this.tab= new Color[1];
    }
    public void add(E v){
        if(curseur==tab.length){
            Color[] temp =this.tab;
            this.tab= new Color[this.tab.length+1];
            this.remplir(temp,0);
        }
        this.tab[this.curseur]=v;
        this.curseur++;
    }
    public void remplir(Color[] temp,int i){
        if(i<temp.length){
            this.tab[i]=temp[i];
        }
    }
    public Color get(int n){
        return this.tab[n];
    }
    public int size(){
        return this.curseur;
    }
}