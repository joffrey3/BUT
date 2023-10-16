public class Parite {
    public boolean pair (int n){
        if(n==1){
            return false;
        }
        if(n==0){
            return true;
        }
        boolean v=this.pair(n-2);
        return v;
    }
}