import java.io.*;
import java.util.*;

public class Noeud{
    private File f;
    private Noeud n1=null;
    private Noeud n2=null;
    private Noeud n3=null;
    private Noeud n4=null;
    public Noeud(File s){
        this.f = s;
    }
    /*public Noeud(String s, Noeud noeud1){java.io.File

    }
    public Noeud(String s, Noeud noeud1, Noeud noeud2, Noeud noeud3){
        this.f = new File(s);
        this.noeud1=n1;
        this.noeud2=n2;
        this.noeud3=n3;

    }
    public Noeud(String s, Noeud noeud1, Noeud noeud2, Noeud noeud3, Noeud noeud4){
        this.f = new File(s);
        this.noeud1=n1;
        this.noeud2=n2;
        this.noeud3=n3;
        this.noeud4=n4;

    }*/
    public void add(Noeud n){
        if(n1!=null){
            if(n2!=null){
                if(n3!=null){
                    n4=n;
                    return;
                }
                n3=n;
                return;
            }
            n2=n;
            return;
        }
        n1=n;
        return;
    }
    public File getFile(){
        return this.f;
    }
    public Noeud getN1(){
        return this.n1;
    }
    public Noeud getN2(){
        return this.n2;
    }
    public Noeud getN3(){
        return this.n3;
    }
    public Noeud getN4(){
        return this.n4;
    }
}