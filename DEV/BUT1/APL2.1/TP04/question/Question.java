import javax.swing.*;
import java.awt.*;
 
public class Question {
  public static void main(String[] args) {
    // un objet pour servir de fenetre
    JFrame fenetre = new JFrame();
    // on configure la fenetre
    Dimension taille = new Dimension(200,200);
    fenetre.setSize(400, 400);
    fenetre.setLocation(0, 0);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // un composant pour afficher du texte
    Color bleu= new Color(0,0,255);
    Color blanc= new Color(255,255,255);
    JPanel panneau = new JPanel();
    JPanel panneau2 = new JPanel();
    GridLayout gestionnaire3 = new GridLayout(2, 1);
    panneau2.setLayout(gestionnaire3);
    FlowLayout gestionnaire = new FlowLayout(FlowLayout.CENTER);
    panneau.setLayout(gestionnaire);
    JLabel question = new JLabel("Aimez-vous les chiens ?");
    question.setHorizontalAlignment(JLabel.CENTER);
    panneau2.add(question, BorderLayout.SOUTH);
    JButton bouton = new JButton("Oui");
    panneau.add(bouton);
    JButton bouton2 = new JButton("Non");
    panneau.add(bouton2);
    JButton bouton3 = new JButton("N SSP");
    panneau.add(bouton3);
    panneau2.add(panneau, BorderLayout.NORTH);
    fenetre.add(new JLabel(" "), BorderLayout.WEST);
    fenetre.add(new JLabel(" "), BorderLayout.EAST);
    fenetre.add(new JLabel(" "), BorderLayout.SOUTH);
    fenetre.add(new JLabel(" "), BorderLayout.NORTH);
    fenetre.add(panneau2, BorderLayout.CENTER);
    fenetre.setVisible(true);
  }
}