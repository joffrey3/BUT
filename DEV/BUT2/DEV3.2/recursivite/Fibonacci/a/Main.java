public class Main {
    public static void main (String[] args){
        if(args.length>=1){
        Fibonacci fonction = new Fibonacci();
        System.out.println(fonction.fibo(Integer.parseInt(args[0])));
        }
    }
}