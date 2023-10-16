public class Tri {
    Noeud premierNoeud;
    public void ajouter(Double d, Noeud noeud){
        if(noeud==null){
            Noeud n= new Noeud(d);
            noeud=n;
        }
        if(this.premierNoeud==null){
            Noeud n= new Noeud(d);
            this.premierNoeud=n;
        }
        if(d.doubleValue()<noeud.getValue()){
            if(noeud.getInf()==null){
                noeud.setInf(new Noeud(d));
            }
            this.ajouter(d,noeud.getInf());
        }
        if(d.doubleValue()>noeud.getValue()){
            if(noeud.getSup()==null){
                noeud.setSup(new Noeud(d));
            }
            this.ajouter(d,noeud.getSup());
        }
    }
    public String afficher(Noeud noeud){
        String chaine="";
        if(noeud==null){
            return "";
        }
        chaine = chaine+this.afficher(noeud.getInf());
        chaine = chaine+" ";
        chaine = chaine+noeud.getValue().toString();
        chaine = chaine+" ";
        chaine = chaine+this.afficher(noeud.getSup());
        return chaine;
    }
    public Noeud getPremier(){
        return this.premierNoeud;
    }
}