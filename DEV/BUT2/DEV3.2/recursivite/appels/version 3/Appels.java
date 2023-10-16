public class Appels {
    public static int factorielle (int n){
        if(n<=1){
            System.out.println(n);
            return 1;
        }else{
            System.out.println(n);
            int m=Appels.factorielle(n-1)*n;
            System.out.println(m);
            return m;
        }
    }
}