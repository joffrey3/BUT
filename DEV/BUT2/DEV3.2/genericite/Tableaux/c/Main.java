import java.util.*;
import java.text.*;

public class Main {
    public static void main(String[] args){
        String[] tab = args;
        Collator comparateur = Collator.getInstance();
        Arrays.sort(tab,comparateur);
        System.out.println(Arrays.toString(tab));
    }
}