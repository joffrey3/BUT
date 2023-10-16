import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;
import java.lang.Object;
import java.awt.Font; 
//La classe Attention ne sert qu'a une seule chose, elle empèche la personne de rentrer des informations inapproprié pour créer une grille de démineur
public class Attention extends JComponent{
  int x;
  int y;
  public Attention(int pos_x, int pos_y){
    this.x=pos_x;
    this.y=pos_y;
  }

  //Lorsqu'elle est appelée, elle est ajoutée à une fenetre et écrit les limites acceptables par le programme.
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
      secondPinceau.setColor(Color.RED);
      secondPinceau.fillRect(0,0,x,y);
      secondPinceau.setColor(Color.WHITE);
      secondPinceau.drawString("Attention",20,20);
      secondPinceau.drawString("Il faut remplir tous les champs",20,40);
      secondPinceau.drawString("Le nombre de lignes ne peut pas etre inférieur à 4",20,60);
      secondPinceau.drawString("Le nombre de lignes ne peut pas etre supérieur à 30",20,80);
      secondPinceau.drawString("Le nombre de colonnes ne peut pas etre inférieur à 4",20,100);
      secondPinceau.drawString("Le nombre de colonnes ne peut pas etre supérieur à 30",20,120);
      secondPinceau.drawString("Le nombre de mines ne peut pas etre inférieur à 1",20,140);
      secondPinceau.drawString("Le nombre de mines ne peut pas etre supérieur au nombre de lignes multiplié par le nombre de colonnes moins une",20,160);
      secondPinceau.drawString("Exemple 4 lignes, 4 colonnes , entre 1 et 15 mines (4*4=16)",20,200);
      secondPinceau.drawString("Exemple 30 lignes, 30 colonnes , entre 1 et 899 mines (30*30=900)",20,220);
  }
}
