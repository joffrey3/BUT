import javax.swing.*;
import java.awt.*;
 
public class Test {
  public static void main(String[] args) {
    // un objet pour servir de fenetre
    JFrame fenetre = new JFrame();
    // on configure la fenetre
    fenetre.setSize(600, 600);
    fenetre.setLocation(0, 0);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // un composant pour afficher du texte
    GridLayout gestionnaire = new GridLayout(3, 5);
    fenetre.setLayout(gestionnaire);
    for(int i = 0; i < 15; i++)
    fenetre.add(new JButton(""+i));
    FlowLayout gestionnaire2 = new FlowLayout(FlowLayout.CENTER);
    fenetre.setLayout(gestionnaire2);
    for(int i = 0; i < 15; i++)
    fenetre.add(new JButton(""+i));
    JPanel panneau = new JPanel();
    panneau.setBackground(Color.ORANGE);
    JButton bouton = new JButton("OK");
    panneau.add(bouton);
    JButton bouton2 = new JButton("Annuler");
    panneau.add(bouton2);
    fenetre.add(panneau, BorderLayout.SOUTH);
    JTextArea zoneDeTexte = new JTextArea("Composez votre message");
    zoneDeTexte.setBackground(Color.CYAN);
    fenetre.add(zoneDeTexte, BorderLayout.CENTER);
    // et on montre le resultat
    fenetre.setVisible(true);
  }
}