import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Fermeture extends JFrame implements WindowListener{ 
 public Fermeture() {
    setSize(1000, 1000);
    setLocation(0, 0);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    setLayout(null);
    setVisible(true);
    addWindowListener(this);
  }
 public void windowDeiconified(WindowEvent evenement) {
  }
  public void windowIconified(WindowEvent evenement) {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
      public void windowDeactivated(WindowEvent evenement) {
  }
  public void windowActivated(WindowEvent event) {
  }
      public void windowOpened(WindowEvent evenement) {
  }
  public void windowClosed(WindowEvent evenement) {
  }
      public void windowClosing(WindowEvent evenement) {
  }

}