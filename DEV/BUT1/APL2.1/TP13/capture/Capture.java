import java.lang.Object;
import javax.swing.*;
import java.awt.*;
import java.util.EventObject;
import java.awt.AWTEvent;
import java.awt.event.ActionEvent;

public class Capture{
  public static void main(String[] args) {
    try {
    Capture.ArithmeticException();
    }
    catch (ArithmeticException e1){
      System.out.println("Error at arithmetic level");
    }
  }
  public static void ArithmeticException() {
    int tab = 5/0;
  }
}