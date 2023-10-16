import java.util.*;
import java.text.*;
import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args){
        Association<String> test1= new Association<String>("a",10);
        Association<String> test2= new Association<String>("b",7,test1);
        Association<String> test3= new Association<String>("c",4,test2);
        Association<String> test4= new Association<String>("d",18,test3);
        Association<String> test5= new Association<String>("e",1,test4);

        Liste<String> l= new Liste<String>(test5);
        System.out.println(l.toString());
        l.ajouter("e",l.getMaillon());
        l.ajouter("f",l.getMaillon());
        l.ajouter("g",l.getMaillon());
        Frequences f=new Frequences();
        Association<String> temp=l.getMaillon();
        l=f.nbElement(l);
        l.setMaillon(temp);
        System.out.println(l.getTab().toString());
        System.out.println("\n");
        System.out.println(l.toString());
    }
}