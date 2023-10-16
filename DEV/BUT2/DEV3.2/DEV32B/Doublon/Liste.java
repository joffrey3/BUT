//Fouché Joffrey

import java.util.*;
import javax.swing.*;

public class Liste{
    private Maillon premier;
    private int taille;
    public Liste(){
        this.premier=null;
        this.taille=0;
    }
    public void add(int v){
        Maillon m= new Maillon(v);
        m.setSuivant(this.premier);
        this.premier=m;
        this.taille++;
    }
    public boolean egale(int v){
        for(int i=0;i<this.taille;i++){
            if(this.get(i)==v){
                return true;
            }
        }
        return false;
    }
    public int get(int n){
        Maillon m=this.premier;
        for(int i=0;i<this.taille-n-1;i++){
            m=m.getSuivant();
        }
        return m.getValeur();
    }
    public int size(){
        return this.taille;
    }
}