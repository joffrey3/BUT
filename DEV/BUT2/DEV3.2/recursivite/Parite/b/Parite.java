public class Parite {
    public boolean impair (int n){
        if(n==0){
            return false;
        }
        if(n==1){
            return true;
        }
        boolean v=this.impair(n-2);
        return v;
    }
}