import java.util.*;

public class Main {
    public static void main(String[] args){
        int res=0;
        String chaine;
        Tableau<Integer> pile = new Tableau<Integer>(1000);
        for(int i=0;i<args.length;i++){
            chaine=args[i];
            if(chaine.compareTo("+")!=0 && chaine.compareTo("-")!=0 && chaine.compareTo("x")!=0 && chaine.compareTo("/")!=0)
            {
                pile.addFirst(Integer.parseInt(args[i]));
            }
            if(chaine.compareTo("+")==0 || chaine.compareTo("-")==0 || chaine.compareTo("x")==0 || chaine.compareTo("/")==0)
            {
                //System.out.println(chaine);
                int n1=-1,n2=-1,n3=-1;
                if(!pile.isEmpty()){
                    n1= pile.removeFirst();
                }
                if(!pile.isEmpty()){
                    n2= pile.removeFirst();
                }
                System.out.println(n1);
                System.out.println(n2);
                if(chaine.compareTo("+")==0){
                    n3=n1+n2;
                }
                if(chaine.compareTo("-")==0){
                    n3=n2-n1;
                }
                if(chaine.compareTo("x")==0){
                    n3=n1*n2;
                }
                if(chaine.compareTo("/")==0){
                    n3=n2/n1;
                }
                pile.addFirst(n3);
            }
        }
        if(!pile.isEmpty()){
            res= pile.removeFirst();
        }
    System.out.println("= "+Integer.toString(res));
    }
}