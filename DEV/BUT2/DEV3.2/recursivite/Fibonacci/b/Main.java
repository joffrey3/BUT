public class Main {
    public static void main (String[] args){
        if(args.length>=1){
        Fibonacci fonction = new Fibonacci();
        fonction.fibo(Integer.parseInt(args[0]),0);
        //System.out.println(fonction.fibo(Integer.parseInt(args[0]),0));
        }
    }
}