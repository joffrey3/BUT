import java.lang.Object;
import javax.swing.*;
import java.awt.*;
import java.awt.print.Paper;

public class Nuance {
  // attribut
  public void Case(JFrame fenetre,Color couleur,int incrementation,String texte) {
    int i;
    Color noir= new Color(0,0,0);
    //Color couleur= new Color(args[1]);
    JPanel panneau = new JPanel();
    JPanel panneau2 = new JPanel();
    fenetre.setLayout(null);
    panneau.setBackground(couleur);
    panneau2.setBackground(noir);
    GridLayout gestionnaire = new GridLayout(5,1);
    JLabel ecrit = new JLabel (texte);
    panneau2.add(ecrit);
    panneau.setLayout(gestionnaire);
    panneau.add(panneau2);
    // on configure la fenetre
    panneau.setSize(100,100);
    panneau.setLocation(10+incrementation*110,10);
    // un composant pour afficher du texte
    fenetre.add(panneau);
    //}
    // et on montre le resultat
  }
}
