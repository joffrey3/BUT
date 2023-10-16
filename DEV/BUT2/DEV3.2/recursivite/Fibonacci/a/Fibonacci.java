public class Fibonacci {
    public int fibo (int f){
        if(f<=1){
            return f;
        }
        f = this.fibo(f-1)+this.fibo(f-2);
        return f;
    }
}