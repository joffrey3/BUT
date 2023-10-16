import java.util.*;
import java.text.*;
import java.awt.*;
import javax.swing.*;

public class Liste <E>{
    private Association<E> maillon;
    private ArrayList<Integer> tab;

    public Liste(Association<E> e){
        this.maillon=e;
    }
    public Liste(){
        this.maillon=null;
    }

    @Override
    public String toString(){
        String chaine;
        if(this.maillon!=null){
            chaine = "La liste est composée des élements suivants : \n"+this.maillon.toString();
        }else{
            chaine = "La liste est composée des élements suivants : null\n";
        }
        return chaine;
    }

    public void ajouter(E e,Association<E> m){
        if(m==null){
            Association<E> n= new Association<E>(e);
            m=n;
            return;
        }
        if(m.getSuivant()==null){
            Association<E> n= new Association<E>(e);
            m.setSuivant(n);
            return;
        }
        if(e==m.getElement()){
            m.setFrequence(m.getFrequence()+1);
            return;
        }
        this.ajouter(e,m.getSuivant());
    }

    public Association<E> getMaillon(){
        return this.maillon;
    }

    public void setMaillon(Association<E> e){
        this.maillon=e;
    }

    public ArrayList<Integer> getTab(){
        return this.tab;
    }

    public void setTab(ArrayList<Integer> t){
        this.tab=t;
    }
}