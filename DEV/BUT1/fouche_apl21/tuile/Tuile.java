import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;

public class Tuile implements Windowlistener{ 
 public static void main(String[] args) {
    JFrame fenetre = new JFrame();
    fenetre.setSize(1000, 1000);
    fenetre.setLocation(0, 0);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Pavage image = new Pavage();
    fenetre.setLayout(null);
    image.setSize(1000,1000);
    image.setLocation(0,0);

    fenetre.add(image);
    fenetre.setVisible(true);
 }
 public void windowDeiconified(WindowEvent evenement) {
  }
  public void windowIconified(WindowEvent evenement) {
  }
      public void windowDeactivated(WindowEvent evenement) {
  }
  public void windowActivated(WindowEvent event) {
      
      
      evenement.add(new Cercle());
      evenement.add();
  }
      public void windowOpened(WindowEvent evenement) {
  }
  public void windowClosed(WindowEvent evenement) {
  }
      public void windowClosing(WindowEvent evenement) {
  }
}