import javax.swing.*;
import java.awt.*;
 
public class Choix {
  public static void main(String[] args) {
    // un objet pour servir de fenetre
    JFrame fenetre = new JFrame();
    // on configure la fenetre
    fenetre.setSize(300, 300);
    Dimension taille = new Dimension(200,200);
    fenetre.setMinimumSize(taille);
    fenetre.setSize(300,300);
    fenetre.setLocation(0, 0);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // un composant pour afficher du texte
    Color vert= new Color(0,255,0);
    Color noir= new Color(0,0,0);
    Color gris= new Color(128,128,128);
    GridLayout gestionnaire = new GridLayout(2, 2);
    fenetre.setLayout(gestionnaire);
    JRadioButton etiquette = new JRadioButton ("Griffondor");
    fenetre.add(etiquette);
    JRadioButton etiquette2 = new JRadioButton ("Serdaigle");
    fenetre.add(etiquette2);
    JRadioButton etiquette3 = new JRadioButton ("Serpentard");
    fenetre.add(etiquette3);
    JRadioButton etiquette4 = new JRadioButton ("Poufsouffle");
    fenetre.add(etiquette4);
    ButtonGroup maison = new ButtonGroup();
    maison.add(etiquette);
    maison.add(etiquette2);
    maison.add(etiquette3);
    maison.add(etiquette4);
    // et on montre le resultat
    fenetre.setVisible(true);
  }
}