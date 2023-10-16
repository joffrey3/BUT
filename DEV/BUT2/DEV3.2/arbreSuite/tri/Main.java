public class Main {
    public static void main (String[] args){
        Tri t = new Tri();
        for(int i=0;i<args.length;i++){
            t.ajouter(new Double(args[i]),t.getPremier());
        }
        System.out.println(t.afficher(t.getPremier()));
    }
}