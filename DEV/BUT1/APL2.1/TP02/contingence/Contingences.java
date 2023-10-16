import javax.swing.*;
import java.awt.*;

public class Contingences {
  static final int VERTICAL_SCROLLBAR_AS_NEEDED=20;
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
    Boolean flag=true;
    JTextArea etiquette = new  JTextArea ("azertyuiopqsdfghjklmwxcvbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
    fenetre.add(etiquette, BorderLayout.NORTH);
    etiquette.setLineWrap(flag);
    JScrollPane ascenseur = new JScrollPane(etiquette);
    ascenseur.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
    JTextField etiquette3 = new JTextField ("azertyuiopqsdfghjklmwxcvbn");
    fenetre.add(etiquette3, BorderLayout.WEST);
    JTextArea etiquette2 = new JTextArea ("azertyuiopqsdfghjklmwxcvbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
    fenetre.add(etiquette2, BorderLayout.EAST);
    etiquette2.setLineWrap(flag);
    JTextArea etiquette4 = new JTextArea ("azertyuiopqsdfghjklmwxcvbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
    fenetre.add(etiquette4, BorderLayout.SOUTH);
    etiquette4.setLineWrap(flag);
    JTextArea etiquette5 = new JTextArea ("azertyuiopqsdfghjklmwxcvbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
    fenetre.add(etiquette5, BorderLayout.CENTER);
    etiquette5.setLineWrap(flag);
    // et on montre le resultat
    fenetre.setVisible(true);
  }
}