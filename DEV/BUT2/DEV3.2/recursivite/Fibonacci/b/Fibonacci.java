public class Fibonacci {
    public int fibo (int f,int i){
        String chaine = new String();
        i=i+1;
        int temp = i;
        for (;temp!=0;temp--){
            chaine = chaine+ "  ";
        }
        if(f<=1){
            System.out.println(chaine+f);
            return f;
        }
        System.out.println(chaine+f);
        f = this.fibo(f-1,i)+this.fibo(f-2,i);
        System.out.println(chaine+f);
        return f;
    }
}