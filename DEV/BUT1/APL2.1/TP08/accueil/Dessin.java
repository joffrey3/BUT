import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;
import java.lang.Object;
import java.awt.Font; 
 
public class Dessin extends JComponent{
    private Image cercle;
    public Dessin(){
	super();
	this.cercle = Toolkit.getDefaultToolkit().getImage("login.jpg");
	}
	@Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    if (this.isOpaque()) {
      secondPinceau.setColor(this.getBackground());
      secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
    secondPinceau.drawImage(this.cercle,0,0,this);
    

  }
}
