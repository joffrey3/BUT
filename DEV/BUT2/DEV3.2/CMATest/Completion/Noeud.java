import java.io.*;
import java.util.*;

public class Noeud{
    private String f;
    private Boolean b;
    private ArrayList<Noeud> tab= new ArrayList<Noeud>();
    public Noeud(String s,Boolean v){
        this.f = s;
        this.b=v;
    }
    public void add(Noeud n){
        this.tab.add(n);
    }
    public void remove(Noeud n){
        this.tab.remove(n);
    }
    public String getString(){
        return this.f;
    }
    public Boolean getBool(){
        return this.b;
    }
    public ArrayList<Noeud> getList(){
        return this.tab;
    }
}