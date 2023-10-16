import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;
import java.lang.Object;
import java.awt.Font; 
 
public class Effacement extends JComponent{
  int variable;
  int pos_x;
  int pos_y;
  public Effacement(int x,int y){
    this.pos_x=x*30;
    this.pos_y=y*30;
  }
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
      secondPinceau.setColor(Color.GREEN);
      secondPinceau.fillRect(this.pos_x,this.pos_y,30,30);
      secondPinceau.setColor(Color.BLACK);
      secondPinceau.drawRect(this.pos_x,this.pos_y,30,30);
  }
}