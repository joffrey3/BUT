import java.util.*;

public class Tableaux {
    int[] tab;
    String chaine;
    public Tableaux(String[] args){
        this.tab=new int[args.length];
        this.chaine="";
    }
    public int[] transformer (String[] t){
        if(t.length<=1){
            //System.out.println(tab[0]);
            if(t.length==1){
            this.tab[0]=Integer.parseInt(t[0]);
            }
            //System.out.println(t[0]);
            return this.tab;
        }else{
            int ent = Integer.parseInt(t[t.length-1]);
            String[] t2 = Arrays.copyOfRange(t,0,t.length-1);
            //System.out.println(ent);
            this.tab=this.transformer(t2);
            this.tab[t.length-1]=ent;
            //System.out.println(ent);
            return this.tab;
        }
    }
    public String affichage (int t){
        if(t==this.tab.length){
            return "";
        }if(t+1==this.tab.length){
            return Integer.toString(this.tab[t]);
        }else{
            String ent = Integer.toString(this.tab[t]);
            //System.out.println(this.tab[0]);
            this.chaine=ent+" "+this.affichage(t+1);
            //System.out.println(chaine);
            return this.chaine;
        }
    }
    public int parite(int t,int i){
        if(i==this.tab.length){
            return 0;
        }else{
        t=this.parite(t,i+1);
        if(tab[i]%2==0){
            t=t+1;
        }
        return t;
        }
    }
    public int maximum(int max,int i){
        if(i==this.tab.length){
            return Integer.MIN_VALUE;
        }else{
        max=this.maximum(max,i+1);
        if(max<tab[i]){
            return tab[i];
        }
        return max;
        }
    }
}