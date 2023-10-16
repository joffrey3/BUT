public class Noeud {
    String key;
    String value;
    Noeud inf;
    Noeud sup;
    public Noeud(String k,String v){
        this.key=k;
        this.value=v;
        this.inf=null;
        this.sup=null;
    }
    public Noeud(Noeud n,String k,String v){
        this.key=k;
        this.value=v;
        this.inf=n;
        this.sup=null;
    }
    public Noeud(String k,String v,Noeud n){
        this.key=k;
        this.value=v;
        this.inf=null;
        this.sup=n;
    }
    public Noeud(Noeud n1,String k,String v,Noeud n2){
        this.key=k;
        this.value=v;
        this.inf=n1;
        this.sup=n2;
    }
    public void setInf(Noeud n){
        this.inf=n;
    }
    public void setSup(Noeud n){
        this.sup=n;
    }
    public String getValue(){
        return this.value;
    }
    public Noeud getInf(){
        return this.inf;
    }
    public Noeud getSup(){
        return this.sup;
    }
}