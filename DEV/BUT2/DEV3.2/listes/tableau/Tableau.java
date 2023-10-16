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
            for(int i=0;i<temp.length;i++){
                this.tab[i]=temp[i];
            }
        }
        this.tab[this.curseur]=v;
        this.curseur++;
    }
    public Color get(int n){
        return this.tab[n];
    }
    public int size(){
        return this.curseur;
    }
}