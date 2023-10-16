 import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;

public class Test extends JComponent{
 // maintenant on dessine ce que l'on veut
    public static void main(String[] args) {
    Color white= new Color(255,255,255);
    Color black= new Color(0,0,0);
    // un objet pour servir de fenetre
    JFrame fenetre = new JFrame();
    // on configure la fenetre
    fenetre.setSize(1000, 1000);
    fenetre.setLocation(0, 0);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // un composant pour afficher du texte
    Color bleu= new Color(0,0,255);
    Color blanc= new Color(255,255,255);
    Bonjour feuille= new Bonjour();
    Graphics stylo= feuille.getGraphics();
    stylo.setColor(black);
    //stylo.drawLine(1,3,1000,300);
    String texte=new String();
    texte="41415214";
    System.out.println(texte);
    //stylo.drawString(texte, 10, 10);
    //stylo.toString();
    //feuille.paintComponent(stylo);
    fenetre.add(feuille);
    // et on montre le resultat
    fenetre.setVisible(true);
  }
}