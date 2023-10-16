public class Appels {
    public static int factorielle (int n){
        if(n<=1){
            Thread.dumpStack();
            return 1;
        }else{
            return Appels.factorielle(n-1)*n;
        }
    }
}