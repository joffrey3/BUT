import java.io.*;
import java.util.*;

public class Noeud{
    private String f;
    private Noeud n1=null;
    private Noeud n2=null;
    private Noeud n3=null;
    private Noeud n4=null;
    public Noeud(String s){
        this.f = s;
    }
    public void add(Noeud n){
        if(n1!=null){
            n2=n;
            return;
        }
        n1=n;
        return;
    }
    public Noeud remove(Noeud n){
        if(n2!=null){
            return n2;
        }
        return n1;
    }
    public String getString(){
        return this.f;
    }
    public Noeud getN1(){
        return this.n1;
    }
    public Noeud getN2(){
        return this.n2;
    }
}