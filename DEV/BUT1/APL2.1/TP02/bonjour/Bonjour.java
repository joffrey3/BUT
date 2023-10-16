import javax.swing.*;
import java.awt.*;
 
public class Bonjour {
  public static void main(String[] args) {
    // un objet pour servir de fenetre
    JFrame fenetre = new JFrame();
    // on configure la fenetre
    fenetre.setSize(200, 200);
    fenetre.setLocation(100, 100);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // un composant pour afficher du texte
    JLabel etiquette = new JLabel("Bonjour !");
    // on configure l'etiquette
    etiquette.setHorizontalAlignment(JLabel.CENTER);
    // on ajoute le composant dans la fenetre, au milieu
    fenetre.add(etiquette, BorderLayout.CENTER);
    // et on montre le resultat
    fenetre.setVisible(true);
  }
}