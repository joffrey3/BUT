import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;
import java.lang.Object;
import java.awt.Font; 
 
public class Sauteur extends JComponent{
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    if (this.isOpaque()) {
      secondPinceau.setColor(this.getBackground());
      secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
    secondPinceau.setColor(new Color(0,0,255));
    int i,j;
    int[] x= {0,25,50,25};
    int[] y= {25,0,25,50};
    secondPinceau.fillPolygon(x,y,4);
    for(i=0;i<1000;i=i+50){
      for(j=0;j<1000;j=j+50){
          x[0]=i;
          x[1]=i+25;
          x[2]=i+50;
          x[3]=i+25;
          y[0]=j+25;
          y[1]=j;
          y[2]=j+25;
          y[3]=j+50;
          secondPinceau.fillPolygon(x,y,4);
      }
    }
  }
}