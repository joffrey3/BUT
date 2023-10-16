import java.util.*;

public class Main {
    public static void main(String[] args) {
        Deque<String> tab= new LinkedList<String>();
        for(int i=0;i<args.length;i++){
            tab.add(args[i]);
        }
        Fraction f= new Fraction();
        f.separer(tab);
        System.out.println(f.afficherListeEntier());
        System.out.println(f.afficherListeCharactere());
    }
}
