import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;
import java.lang.Object;
import java.awt.Font; 
 
public class Cercle extends JComponent{
    public Cercle(int i){
      super();
      this.
    }
	
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    if (this.isOpaque()) {
      secondPinceau.setColor(this.getBackground());
      secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
    secondPinceau.setColor(new Color(55,55,55));
    secondPinceau.fillRect(0,0, 200, 200);
    secondPinceau.setColor(new Color(128, 128,128));
    secondPinceau.fillOval(25, 25, 100, 100);
  }
  protected void paintComponent(Graphics pinceau) { 
}
