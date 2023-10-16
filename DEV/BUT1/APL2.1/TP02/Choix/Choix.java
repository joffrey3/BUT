import javax.swing.*;
import java.awt.*;
 
public class Choix {
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
    JRadioButton etiquette = new JRadioButton ("Griffondor");
    fenetre.add(etiquette, BorderLayout.NORTH);
    JRadioButton etiquette2 = new JRadioButton ("Serdaigle");
    fenetre.add(etiquette2, BorderLayout.CENTER);
    JRadioButton etiquette3 = new JRadioButton ("Serpentard");
    fenetre.add(etiquette3, BorderLayout.SOUTH);
    ButtonGroup maison = new ButtonGroup();
    maison.add(etiquette);
    maison.add(etiquette2);
    maison.add(etiquette3);
    // et on montre le resultat
    fenetre.setVisible(true);
  }
}