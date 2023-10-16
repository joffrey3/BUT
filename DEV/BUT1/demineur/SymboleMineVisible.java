import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;
import java.lang.Object;
import java.awt.Font; 

//La classe SymboleMineVisible prend une position et un chiffre et déssine un symbole a cet endroit
public class SymboleMineVisible extends JComponent{
  int variable;
  int pos_x;
  int pos_y;
  public SymboleMineVisible(int y,int x,int v,int x_grille,int y_grille){
    this.variable=v;
    this.pos_x=x*30+x_grille;
    this.pos_y=y*30+y_grille;
  }
   //elle implémente un JComponent pour pouvoir dessiner, elle peut dessiner 2 ensembles différents, cela dépend si c'est la mine clickée ou pas
     @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    switch(this.variable){

      //Si le cas est 1 elle va dessiner la mine avec un fond RED(rouge) derrière
      case 1:
      secondPinceau.setColor(Color.RED);
      secondPinceau.fillRect(this.pos_x,this.pos_y,30,30);
      secondPinceau.setColor(Color.BLACK);      
      secondPinceau.fillRect(this.pos_x+14,this.pos_y+3,5,20);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+8,5,15);
      secondPinceau.fillRect(this.pos_x+19,this.pos_y+8,5,15);
      secondPinceau.drawRect(pos_x,pos_y,30,30);
      break;

      //Si le cas est 2 elle va dessiner la mine avec une croix dessus faite en couleure RED(rouge)
      case 2:
      secondPinceau.setColor(Color.BLACK);
      secondPinceau.fillRect(this.pos_x+14,this.pos_y+3,5,20);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+8,5,15);
      secondPinceau.fillRect(this.pos_x+19,this.pos_y+8,5,15);
      secondPinceau.setColor(Color.RED);
      secondPinceau.fillRect(this.pos_x+4,this.pos_y+3,5,5);
      secondPinceau.fillRect(this.pos_x+4,this.pos_y+23,5,5);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+8,5,5);
      secondPinceau.fillRect(this.pos_x+9,this.pos_y+18,5,5);
      secondPinceau.fillRect(this.pos_x+14,this.pos_y+13,5,5);
      secondPinceau.fillRect(this.pos_x+19,this.pos_y+8,5,5);
      secondPinceau.fillRect(this.pos_x+19,this.pos_y+18,5,5);
      secondPinceau.fillRect(this.pos_x+24,this.pos_y+3,5,5);
      secondPinceau.fillRect(this.pos_x+24,this.pos_y+23,5,5);
      break;
    }
  }

  //C'est une autre facon d'appeler un symbole
  public static SymboleMineVisible changement(int x,int y, int v,int x_grille,int y_grille){
    SymboleMineVisible symbole = new SymboleMineVisible(x,y,v,x_grille,y_grille);
    return symbole;
  }
}
