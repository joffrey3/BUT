import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;
import java.lang.Object;
import java.awt.Font; 

public class Pavage extends JComponent{
    private Image pavage;
    public Pavage(){
  super();
  this.pavage = Toolkit.getDefaultToolkit().getImage("tuile.jpg");
  }
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    /*for (int i=0;i<10;i++){
    secondPinceau.drawImage(this.pavage,i*pavage.getWidth(ImageObserver observer),pavage.getHeight(ImageObserver observer),this);
  }
  for (int i=0;i<10;i++){
    secondPinceau.drawImage(this.pavage,i*pavage.getWidth(ImageObserver observer),pavage.getHeight(ImageObserver observer),this);
  }*/
    secondPinceau.drawImage(this.pavage,0,0,this);
  }
}
