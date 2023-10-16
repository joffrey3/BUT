import java.util.*;

public class Main {
    public static void main (String[] args){
        ArrayDeque<Double> l = new ArrayDeque<Double>();
        for(int i=0;i<args.length;i++){
            l.add(new Double(args[i]));
        }
        Fusion tri = new Fusion(l);
        l=tri.tri(l);
        int seuil=l.size();
        for(int i=0;i<seuil;i++){
            System.out.println(l.remove());
        }
    }
}