import javax.swing.*;
import java.awt.*;
 
public class Saisie {
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
    JTextArea  etiquette = new  JTextArea  ("azertyuiopqsdfghjklmwxcvbn");
    fenetre.add(etiquette, BorderLayout.NORTH);
    etiquette.setForeground(vert);
    etiquette.setBackground(noir);
    JTextArea etiquette2 = new JTextArea("azertyuiopqsdfghjklmwxcvbn");
    fenetre.add(etiquette2, BorderLayout.EAST);
    etiquette2.setForeground(vert);
    etiquette2.setBackground(noir);
    JTextField  etiquette3 = new JTextField  ("azertyuiopqsdfghjklmwxcvbn");
    fenetre.add(etiquette3, BorderLayout.WEST);
    etiquette3.setForeground(vert);
    etiquette3.setBackground(gris);
    JTextArea etiquette4 = new JTextArea ("azertyuiopqsdfghjklmwxcvbn");
    fenetre.add(etiquette4, BorderLayout.SOUTH);
    etiquette4.setForeground(vert);
    etiquette4.setBackground(noir);
    JTextArea etiquette5 = new JTextArea ("azertyuiopqsdfghjklmwxcvbn");
    fenetre.add(etiquette5, BorderLayout.CENTER);
    etiquette5.setForeground(vert);
    etiquette5.setBackground(noir);
    // et on montre le resultat
    fenetre.setVisible(true);
  }
}