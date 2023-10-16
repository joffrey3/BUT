import java.util.*;
import javax.swing.*;

public class Chaine <E> extends AbstractQueue <E>{
    private Maillon<E> premier;
    private Maillon<E> curseur;
    private int taille;
    public Chaine(){
        super();
        this.premier=null;
        this.curseur=null;
        this.taille=0;
    }
    
    /*@Override
    public void addFirst(E element){
        Maillon<E> n = new Maillon<E>(element,this.m);
        this.m=n;
    }

    @Override
    public E removeFirst(){
        E element =this.m.getValue();
        this.m=this.m.getMaillon();
        return element;
    }

    @Override
    public boolean isEmpty(){
        return this.m==null;
    }*/
    public int iterator(){
        
    }
    public int size(){
        if(this.curseur==null){
            this.curseur=this.premier;
            return this.taille;
        }
        this.taille=this.taille+1;
        this.curseur=this.curseur.getMaillon();
        return this.size();
    }
}