import java.io.*;
import java.util.*;

public class Repertoires{
    public Repertoires(String s){
        File f = new File(s);
        ArrayDeque<File> a = new ArrayDeque<File>();
        a.add(f);
        Noeud n=this.tree(a);
        this.afficher(n,0);
    }
    public Noeud tree(ArrayDeque<File> a){
        File f = a.remove();
        if(f.isFile()){
            Noeud n = new Noeud(f);
            return n;
        }
        if(f.isDirectory()){
            Noeud n = new Noeud(f);
            File[] liste = f.listFiles();
            for(int i=0;i<liste.length;i++){
                a.add(liste[i]);
                Noeud m=this.tree(a);
                n.add(m);
            }
            return n;
        }
        return null;
    }
    public void afficher(Noeud n,int i){
        String chaine=""; 
        for(int j=0;j<i;j++){
            chaine = chaine+"   ";
        }
        chaine = chaine+n.getFile().getName();
        System.out.println(chaine);
        if(n.getN1()!=null){
            afficher(n.getN1(),i+1);
            if(n.getN2()!=null){
                afficher(n.getN2(),i+1);
                if(n.getN3()!=null){
                    afficher(n.getN3(),i+1);
                    if(n.getN4()!=null){
                        afficher(n.getN4(),i+1);
                    }
                }
            }
        }        
    }
}