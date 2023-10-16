import javax.swing.*;
import java.awt.*;
 
public class Piege {
  public static void main(String[] args) {
    // un objet pour servir de fenetre
    JFrame fenetre = new JFrame();
    // on configure la fenetre
    Dimension taille = new Dimension(200,200);
    fenetre.setSize(550, 450);
    fenetre.setLocation(0, 0);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // un composant pour afficher du texte
    Color bleu= new Color(0,0,255);
    Color blanc= new Color(255,255,255);
    JPanel panneau = new JPanel();
    GridLayout gestionnaire = new GridLayout(3, 3);
    fenetre.setLayout(null);
    JButton un = new JButton("1");
    un.setSize(400, 50);
    un.setLocation(0, 0);
    fenetre.add(un);
    JButton deux = new JButton("2");
    deux.setSize(100, 350);
    deux.setLocation(400, 0);
    fenetre.add(deux);
    JButton trois = new JButton("3");
    trois.setSize(400, 50);
    trois.setLocation(100, 350);
    fenetre.add(trois);
    JButton quatre = new JButton("4");
    quatre.setSize(100, 350);
    quatre.setLocation(0, 50);
    fenetre.add(quatre);
    JButton cinq = new JButton("5");
    cinq.setSize(300, 300);
    cinq.setLocation(100, 50);
    fenetre.add(cinq);
    fenetre.setVisible(true);
  }
}