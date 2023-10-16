public class Main {
    public static void main (String[] args){
        if(args.length>=1){
        Parite p = new Parite();
        //pair.fibo(Integer.parseInt(args[0]),0);
        System.out.println(p.pair(Integer.parseInt(args[0])));
        }
    }
}