import  java.lang.Object.*;
import  java.lang.Math.*;
import java.util.Random.*;
import java.util.*;

public class Aleatoire extends Random{
   private double nombre;
   public Aleatoire(){
      this.nombre=0;
   }
   public static void main(String[] args) {
      Aleatoire x = Aleatoire();
      double alea_1 = Math.random();
      double alea_2 = x.nextDouble();
      System.out.println("La methode random de Math donne : ");
      System.out.println(alea_1);
      System.out.println("La methode nextDouble de Random donne : ");
      System.out.println(alea_2);
   }
}