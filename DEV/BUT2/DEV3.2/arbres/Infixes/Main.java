import java.util.*;

public class Main {
    public static void main(String[] args){
        String chaine;
        //Deque<Noeud> pile = new LinkedList<Noeud>();
        ArrayDeque<String> pile = new ArrayDeque<String>();
        for(int i=0;i<args.length;i++){
            chaine=args[i];
            pile.addFirst(chaine);
        }
        Arbre sapin = new Arbre();
        Noeud n=sapin.tree(pile);
        System.out.println(sapin.afficher(n,0));
    }
}