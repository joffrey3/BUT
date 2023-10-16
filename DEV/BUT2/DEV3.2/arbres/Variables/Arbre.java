import java.io.*;
import java.util.*;

public class Arbre {
    public int increment=0;
    public HashMap<String,String> dico=new HashMap<String,String>();
    public Noeud tree(ArrayDeque<String> a){
        String chaine = a.removeFirst();
        if(chaine.compareTo("+")==0 || chaine.compareTo("-")==0 || chaine.compareTo("x")==0 || chaine.compareTo("/")==0)
        {
            Noeud n = new Noeud(chaine);
            n.add(this.tree(a));
            n.add(this.tree(a));
            return n;
        }if(chaine.compareTo("0")==0 || chaine.compareTo("1")==0 || chaine.compareTo("2")==0 || chaine.compareTo("3")==0 || chaine.compareTo("4")==0 || chaine.compareTo("5")==0 || chaine.compareTo("6")==0 || chaine.compareTo("7")==0 || chaine.compareTo("8")==0 || chaine.compareTo("9")==0)
        {
            Noeud n = new Noeud(chaine);
            return n;
        }else{
            int flag=0;
            for(String key : dico.keySet()){
                if(dico.get(key)==chaine){
                    flag=1;
                }
            }
            if(flag==0){
                this.dico.put(Integer.toString(this.increment),chaine);
                this.increment=this.increment+1;
            }
            Noeud n = new Noeud(chaine);
            return n;
        }
    }
    public String afficher(Noeud n,int i){
        String chaine="";
        if(n.getN2()!=null){
            chaine = chaine+"(";
            chaine = chaine +afficher(n.getN2(),i+1);
        }
        chaine = chaine+n.getString();
        if(n.getN1()!=null){
            chaine = chaine + afficher(n.getN1(),i+1);
            chaine = chaine+")";
        }
        return chaine;
    }
    /*public void demande(){
        for(String key : dico.keySet()){
            
        }
    }*/
}