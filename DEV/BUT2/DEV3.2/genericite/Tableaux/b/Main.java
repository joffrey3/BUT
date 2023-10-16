import java.util.*;

public class Main {
    public static void main(String[] args){
        String[] tab = new String[1000];
        tab=Arrays.copyOf(args,5);
        System.out.println(Arrays.toString(tab));
    }
}