import java.util.*;

public class Main {
    public static void main(String[] args) {
        Deque<String> tab= new LinkedList<String>();
        for(int i=0;i<args.length;i++){
            tab.add(args[i]);
        }
        Arbre a= new Arbre();
        a.ajouter(new String("à"));
        a.ajouter(new String("bal"));
        a.ajouter(new String("bar"));
        a.ajouter(new String("balle"));
        System.out.println(a.afficherArbre(0));
        //System.out.println(f.afficherArbre("ba"));
    }
}
