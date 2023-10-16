import java.util.*;


public class Arbre {
    private Noeud premier=new Noeud(" ",false);
    private Noeud curseur=this.premier;
    private LinkedList<Noeud> pile= new LinkedList<Noeud>();
    public Arbre(){
        this.pile.addFirst(this.premier);
    }
    public void ajouter(String args){
        boolean valider=false;
        if(args.length()==0){
            this.curseur=this.premier;
            return;
        }
        if(args.length()==1){
            valider=true;
        }
        char[] texte= new char[1];
        texte[0]=args.charAt(0);
        Noeud n= new Noeud(new String(texte),valider);
        this.curseur.add(n);
        this.curseur=n;
        args=args.substring(1);
        this.ajouter(args);
    }
    public String afficherArbre(int nb){
        if(this.pile.isEmpty()){
            this.pile.addFirst(this.premier);
            return "";
        }
        Noeud n = this.pile.remove();
        ArrayList<Noeud> liste=n.getList();
        for(int i=0;i<liste.size();i++){
            this.pile.addFirst(liste.get(i));
        }
        String chaine= "";
        for(int j=0;j<nb;j++){
            chaine=chaine+" ";
        }
        chaine=chaine+n.getString();
        chaine=chaine+" "+afficherArbre(nb+1);
        return chaine;
    }
}
