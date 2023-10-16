import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;
import java.lang.Object;
import java.awt.Font; 
//La classe SymboleVisible prend une position et un chiffre et déssine un symbole a cet endroit
public class SymboleVisible extends JComponent{
  int variable;
  int pos_x;
  int pos_y;
  public SymboleVisible(int y,int x,int v,int x_grille,int y_grille){
    this.variable=v;
    this.pos_x=x*30+x_grille;
    this.pos_y=y*30+y_grille;
  }

  //elle implémente un JComponent pour pouvoir dessiner, elle peut dessiner 8 ensembles différents, cela dépend du nombre de mines autour
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    switch(this.variable){

      //Si le cas est 0 elle ne va rien dessiner et transformer la case en LIGHT_GRAY
      case 0:
      secondPinceau.setColor(Color.LIGHT_GRAY);
      secondPinceau.fillRect(this.pos_x,this.pos_y,30,30);
      secondPinceau.setColor(Color.BLACK);
      secondPinceau.drawRect(this.pos_x,this.pos_y,30,30);
      break ;

      //Si le cas est 1 elle va dessiner le chiffre 1 et transformer la case en LIGHT_GRAY
      case 1:
      secondPinceau.setColor(Color.BLUE);
      secondPinceau.fillRect(this.pos_x+14,this.pos_y+3,5,20);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+8,5,5);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+23,15,5);
      break ;

      //Si le cas est 2 elle va dessiner le chiffre 2 et transformer la case en LIGHT_GRAY
      case 2:
      secondPinceau.setColor(Color.GREEN);
      secondPinceau.fillRect(this.pos_x+14,this.pos_y+3,5,5);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+8,5,5);
      secondPinceau.fillRect(this.pos_x+19,this.pos_y+8,5,10);
      secondPinceau.fillRect(this.pos_x+14,this.pos_y+18,5,5);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+23,15,5);
      break;

      //Si le cas est 3 elle va dessiner le chiffre 3 et transformer la case en LIGHT_GRAY
      case 3:
      secondPinceau.setColor(Color.RED);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+3,10,5);
      secondPinceau.fillRect(this.pos_x+19,this.pos_y+8,5,5);
      secondPinceau.fillRect(this.pos_x+14,this.pos_y+13,5,5);
      secondPinceau.fillRect(this.pos_x+19,this.pos_y+18,5,5);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+23,10,5);
      break;

      //Si le cas est 4 elle va dessiner le chiffre 4 et transformer la case en LIGHT_GRAY
      case 4:
      secondPinceau.setColor(Color.MAGENTA);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+3,5,10);
      secondPinceau.fillRect(this.pos_x+14,this.pos_y+13,5,5);
      secondPinceau.fillRect(this.pos_x+19,this.pos_y+3,5,25);
      break;

      //Si le cas est 5 elle va dessiner le chiffre 5 et transformer la case en LIGHT_GRAY
      case 5:
      secondPinceau.setColor(Color.ORANGE);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+3,15,5);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+8,5,5);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+13,10,5);
      secondPinceau.fillRect(this.pos_x+19,this.pos_y+18,5,5);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+23,10,5);
      break;

      //Si le cas est 6 elle va dessiner le chiffre 6 et transformer la case en LIGHT_GRAY
      case 6:
      secondPinceau.setColor(Color.CYAN);
      secondPinceau.fillRect(this.pos_x+14,this.pos_y+3,10,5);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+8,5,15);
      secondPinceau.fillRect(this.pos_x+14,this.pos_y+13,5,5);
      secondPinceau.fillRect(this.pos_x+19,this.pos_y+18,5,5);
      secondPinceau.fillRect(this.pos_x+14,this.pos_y+23,5,5);
      break;

      //Si le cas est 7 elle va dessiner le chiffre 7 et transformer la case en LIGHT_GRAY
      case 7:
      secondPinceau.setColor(Color.PINK);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+3,15,5);
      secondPinceau.fillRect(this.pos_x+19,this.pos_y+8,5,10);
      secondPinceau.fillRect(this.pos_x+14,this.pos_y+18,5,10);
      break;

      //Si le cas est 8 elle va dessiner le chiffre 8 et transformer la case en LIGHT_GRAY
      case 8:
      secondPinceau.setColor(Color.YELLOW);
      secondPinceau.fillRect(this.pos_x+14,this.pos_y+3,5,5);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+8,5,5);
      secondPinceau.fillRect(this.pos_x+19,this.pos_y+8,5,5);
      secondPinceau.fillRect(this.pos_x+14,this.pos_y+13,5,5);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+18,5,5);
      secondPinceau.fillRect(this.pos_x+19,this.pos_y+18,5,5);
      secondPinceau.fillRect(this.pos_x+14,this.pos_y+23,5,5);
      break;
    }
  }

  //C'est une autre facon d'appeler un symbole
  public static SymboleVisible changement(int x,int y, int v,int x_grille,int y_grille){
    SymboleVisible symbole = new SymboleVisible(x,y,v,x_grille,y_grille);
    return symbole;
  }
}
