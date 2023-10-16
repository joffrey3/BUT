import java.util.*;
import java.text.*;
import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args){

        Association<String> test1= new Association<String>("a",10);
        System.out.println(test1.toString());
        System.out.println("\n");

        Association<String> test2= new Association<String>("b",7,test1);
        System.out.println(test2.toString());
        System.out.println("\n");

        Association<String> test3= new Association<String>("c",4,test2);
        System.out.println(test3.toString());
        System.out.println("\n");

        Association<String> test4= new Association<String>("d",18,test3);
        System.out.println(test4.toString());
        System.out.println("\n");

        Association<String> test5= new Association<String>("e",1,test4);
        System.out.println(test5.toString());
        System.out.println("\n");
       
    }
}