import java.lang.Object;
import javax.swing.*;
import java.awt.*;
import java.util.EventObject;
import java.awt.AWTEvent;
import java.awt.event.ActionEvent;

public class Plantages{
  public static void main(String[] args) {
    //Plantages.ArrayIndexOutOfBoundsException();
    //Plantages.NumberFormatException();
    //Plantages.ArithmeticException();
    //Plantages.NullPointerException();
    Plantages.RuntimeException();
  }
  public static void ArrayIndexOutOfBoundsException() {
    int[] tab = new int[1];
    int x=tab[2];
  }
  public static void NumberFormatException() {
    String x= new String("oui");
    int tab = Integer.parseInt(x);
  }
  public static void ArithmeticException() {
    int tab = 5/0;
  }
  public static void NullPointerException() {
    String tab = null;
    tab.length();
  }
  public static void RuntimeException() {
    RuntimeException tab = new RuntimeException();
    throw tab;
  }
}
