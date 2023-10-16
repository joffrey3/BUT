public class Main {
    public static void main (String[] args){
        int nb =Appels.factorielle(Integer.parseInt(args[0]),0);
        System.out.println(new String(args[0]+"! = "+Integer.toString(nb)));
    }
}