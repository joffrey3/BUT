import java.util.*;
import java.text.*;
import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args){
        Gene<String> test1= new Gene<String>("G");
        Gene<String> test2= new Gene<String>("A",test1);
        Gene<String> test3= new Gene<String>("T",test2);
        Gene<String> test4= new Gene<String>("T",test3);
        Gene<String> test5= new Gene<String>("C",test4);
        Gene<String> test6= new Gene<String>("G",test5);

        ADN<String> l= new ADN<String>(test6);
        System.out.println(l.toString());
        l.ajouter("e",l.getMaillon());
        l.ajouter("f",l.getMaillon());
        l.ajouter("g",l.getMaillon());
        //Frequences f=new Frequences();
        Gene<String> temp=l.getMaillon();
        //l=f.nbElement(l);
        l.setMaillon(temp);
        //System.out.println(l.getTab().toString());
        System.out.println("\n");
        System.out.println(l.toString());
    }
}