import java.util.*;


public class Fraction {
    private Deque<Integer> fileEntier = new LinkedList<Integer>(); 
    private Deque<String> fileCharactere = new LinkedList<String>(); 
    public void separer(Deque<String> args){
        if(args.isEmpty()){
            return;
        }
        String chaine=args.remove();
        try{
            Integer.parseInt(chaine);
            this.fileEntier.add(new Integer(chaine));
        }catch(NumberFormatException e){
            this.fileCharactere.add(chaine);
        }
        this.separer(args);
    }
    public String afficherListeEntier(){
        if(this.fileEntier.isEmpty()){
            return "";
        }
        String chaine=Integer.toString(this.fileEntier.remove().intValue());
        chaine=chaine+" "+afficherListeEntier();
        return chaine;
    }
    public String afficherListeCharactere(){
        if(this.fileCharactere.isEmpty()){
            return "";
        }
        String chaine=this.fileCharactere.remove();
        chaine=chaine+" "+afficherListeCharactere();
        return chaine;
    }
}
