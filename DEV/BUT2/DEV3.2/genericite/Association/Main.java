import java.util.*;
import java.text.*;
import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args){
        //Frequence.elementRecurrent(args);
        String chaine="oui";
        Integer nb=3,nb2=8;
        JFrame fenetre=new JFrame();
        Association<String> test= new Association<String>(chaine,nb);
        System.out.println(test.getElement());
        System.out.println(test.getFrequence());
        System.out.println(test.toString());
        test.setElement(new String("non"));
        test.setFrequence(10);
        chaine=test.getElement();
        nb=test.getFrequence();
        System.out.println(chaine);
        System.out.println(nb);
        System.out.println(test.toString());

        Association<JFrame> test2= new Association<JFrame>(fenetre,nb2);
        System.out.println(test2.getElement());
        System.out.println(test2.getFrequence());
        System.out.println(test2.toString());
        test2.setElement(new JFrame("joli vue"));
        test2.setFrequence(20);
        fenetre=test2.getElement();
        nb=test2.getFrequence();
        System.out.println(fenetre);
        System.out.println(nb);
        System.out.println(test2.toString());
    }
}