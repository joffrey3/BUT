import java.io.*;
import java.util.*;

public class Arbre {
    public Noeud tree(ArrayDeque<String> a){
        String chaine = a.removeFirst();
        if(chaine.compareTo("+")!=0 && chaine.compareTo("-")!=0 && chaine.compareTo("x")!=0 && chaine.compareTo("/")!=0)
        {
            Noeud n = new Noeud(chaine);
            return n;
        }else{
            Noeud n = new Noeud(chaine);
            n.add(this.tree(a));
            n.add(this.tree(a));
            return n;
        }
    }
    public String afficher(Noeud n,int i){
        String chaine=" ";
        chaine = chaine+n.getString();
        System.out.println(chaine);
        if(n.getN2()!=null){
            chaine = chaine +afficher(n.getN2(),i+1);
        }
        if(n.getN1()!=null){
            chaine = chaine + afficher(n.getN1(),i+1);
        }
        return chaine;
    }
}