import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;
import java.lang.Object;
import java.awt.Font; 
 
public class Fresque extends JComponent{
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    if (this.isOpaque()) {
      secondPinceau.setColor(this.getBackground());
      secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
    int i,j;
    for(i=0;i<1000;i=i+100){
      for(j=0;j<1000;j=j+100){
        secondPinceau.setColor(new Color(0,0+j/5,0+i/5));
        secondPinceau.fillOval(i,j,100,100);
        secondPinceau.setColor(new Color(255,255,255));
        secondPinceau.fillOval(i+25,j+25,50,50);
      }
    }
  }
}