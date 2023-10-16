public class Appels {
    public static int factorielle (int n,int i){
        String chaine = new String();
        i=i+1;
        int temp = i;
        for (;temp!=0;temp--){
            chaine = chaine+ "  ";
        }
        if(n<=1){
            System.out.println(chaine+n);
            return 1;
        }else{
            System.out.println(chaine+n);
            int m=Appels.factorielle(n-1,i)*n;
            System.out.println(chaine+m);
            return m;
        }
    }
}