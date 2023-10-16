import javax.swing.*;
import java.awt.*;
 
public class Rose {
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
    GridLayout gestionnaire = new GridLayout(3, 3);
    fenetre.setLayout(gestionnaire);
    JLabel un = new JLabel("Mistral");
    un.setHorizontalAlignment(JLabel.LEFT);
    un.setVerticalAlignment(JLabel.TOP);
    fenetre.add(un);
    JLabel deux = new JLabel("Tramontane");
    deux.setHorizontalAlignment(JLabel.CENTER);
    deux.setVerticalAlignment(JLabel.TOP);
    fenetre.add(deux);
    JLabel trois = new JLabel("Grec");
    trois.setHorizontalAlignment(JLabel.RIGHT);
    trois.setVerticalAlignment(JLabel.TOP);
    fenetre.add(trois);
    JLabel quatre = new JLabel("Ponant");
    quatre.setHorizontalAlignment(JLabel.LEFT);
    quatre.setVerticalAlignment(JLabel.CENTER);
    fenetre.add(quatre);
    JLabel rien = new JLabel("");
    rien.setHorizontalAlignment(JLabel.CENTER);
    rien.setVerticalAlignment(JLabel.CENTER);
    fenetre.add(rien);
    JLabel cinq = new JLabel("Levant");
    cinq.setHorizontalAlignment(JLabel.RIGHT);
    cinq.setVerticalAlignment(JLabel.CENTER);
    fenetre.add(cinq);
    JLabel six = new JLabel("Libeccio");
    six.setHorizontalAlignment(JLabel.LEFT);
    six.setVerticalAlignment(JLabel.BOTTOM);
    fenetre.add(six);
    JLabel sept = new JLabel("Marin");
    sept.setHorizontalAlignment(JLabel.CENTER);
    sept.setVerticalAlignment(JLabel.BOTTOM);
    fenetre.add(sept);
    JLabel huit = new JLabel("Sirocco");
    huit.setHorizontalAlignment(JLabel.RIGHT);
    huit.setVerticalAlignment(JLabel.BOTTOM);
    fenetre.add(huit);
    fenetre.setVisible(true);
  }
}