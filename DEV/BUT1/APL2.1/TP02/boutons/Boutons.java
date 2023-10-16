import javax.swing.*;
import java.awt.*;
 
public class Boutons {
  public static void main(String[] args) {
    // un objet pour servir de fenetre
    JFrame fenetre = new JFrame();
    // on configure la fenetre
    fenetre.setSize(500, 300);
    fenetre.setLocation(0, 0);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // un composant pour afficher du texte
    Color vert= new Color(0,255,0);
    Color noir= new Color(0,0,0);
    Color gris= new Color(128,128,128);
    JButton  etiquette = new  JButton  ("azertyuiopqsdfghjklmwxcvbn");
    fenetre.add(etiquette, BorderLayout.NORTH);
    JButton etiquette2 = new JButton("azertyuiopqsdfghjklmwxcvbn");
    fenetre.add(etiquette2, BorderLayout.EAST);
    JButton etiquette3 = new JButton  ("azertyuiopqsdfghjklmwxcvbn");
    fenetre.add(etiquette3, BorderLayout.WEST);
    JButton etiquette4 = new JButton ("azertyuiopqsdfghjklmwxcvbn");
    fenetre.add(etiquette4, BorderLayout.SOUTH);
    JButton etiquette5 = new JButton ("azertyuiopqsdfghjklmwxcvbn");
    fenetre.add(etiquette5, BorderLayout.CENTER);
    // et on montre le resultat
    fenetre.setVisible(true);
  }
}