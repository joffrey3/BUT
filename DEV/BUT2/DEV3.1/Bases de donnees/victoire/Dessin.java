import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Dessin extends JComponent{
    int nb;
    String ch;
    public Dessin(int nombre, String chaine){
	this.nb=nombre;
	this.ch=chaine;
     }
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    secondPinceau.drawString(this.ch,40,20);
    secondPinceau.drawString(Integer.toString(this.nb),40,50);
  }
}
