import java.util.*;

public class Main {
    public static void main (String[] args){
        Map<Thread,StackTraceElement[]> dico =Thread.getAllStackTraces();
        Set<Map.Entry<Thread,StackTraceElement[]>> tab=dico.entrySet();
        Iterator ite=tab.iterator();
        for(;ite.hasNext();){
            //tab.clear();
            System.out.println(ite.next());
        }
        /*ArrayDeque<Double> l = new ArrayDeque<Double>();
        for(int i=0;i<args.length;i++){
            l.add(new Double(args[i]));
        }
        Fusion tri = new Fusion(l);
        l=tri.tri(l);
        for(int i=0;i<l.size();i++){
            System.out.println(l.remove());
        }*/
    }
}