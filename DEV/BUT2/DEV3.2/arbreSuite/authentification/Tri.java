public class Tri {
    Noeud premierNoeud;
    public void ajouter(String k,String v, Noeud noeud){
        if(noeud==null){
            Noeud n= new Noeud(d);
            noeud=n;
        }
        if(this.premierNoeud==null){
            Noeud n= new Noeud(k,v);
            this.premierNoeud=n;
        }
        if(k.doubleValue()<noeud.getValue()){
            if(noeud.getInf()==null){
                noeud.setInf(new Noeud(k,v));
            }
            this.ajouter(d,noeud.getInf());
        }
        if(k.doubleValue()>noeud.getValue()){
            if(noeud.getSup()==null){
                noeud.setSup(new Noeud(k,v));
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