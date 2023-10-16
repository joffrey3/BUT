import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;
import java.lang.Object;
import java.awt.Font; 
 
public class Bonjour extends JComponent{
    private Image cercle;
    public Bonjour(){
	super();
	this.cercle = Toolkit.getDefaultToolkit().getImage("cercles.png");
	}
	@Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    if (this.isOpaque()) {
      secondPinceau.setColor(this.getBackground());
      secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
    Font style = new Font(">o<",1,24);
    secondPinceau.setColor(new Color(0, 0, 255));
    secondPinceau.drawRect(10, 10, 50, 50);
    secondPinceau.setColor(new Color(0, 255, 0));
    secondPinceau.fillOval(100, 10, 25, 25);
    secondPinceau.setColor(new Color(255, 0, 255));
    secondPinceau.setFont(style);
    System.out.println(getFont());
    secondPinceau.drawString(">o<",200,50);
    secondPinceau.drawImage(this.cercle,150,150,this);
    

  }
}
