public class Noeud {
    Double value;
    Noeud inf;
    Noeud sup;
    public Noeud(Double d){
        this.value=d;
        this.inf=null;
        this.sup=null;
    }
    public Noeud(Noeud n,Double d){
        this.value=d;
        this.inf=n;
        this.sup=null;
    }
    public Noeud(Double d,Noeud n){
        this.value=d;
        this.inf=null;
        this.sup=n;
    }
    public Noeud(Noeud n1,Double d,Noeud n2){
        this.value=d;
        this.inf=n1;
        this.sup=n2;
    }
    public void setInf(Noeud n){
        this.inf=n;
    }
    public void setSup(Noeud n){
        this.sup=n;
    }
    public Double getValue(){
        return this.value;
    }
    public Noeud getInf(){
        return this.inf;
    }
    public Noeud getSup(){
        return this.sup;
    }
}