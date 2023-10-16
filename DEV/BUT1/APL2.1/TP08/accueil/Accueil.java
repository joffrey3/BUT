import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;

public class Accueil { 
 public static void main(String[] args) {
    JFrame fenetre = new JFrame();
    fenetre.setSize(1000, 1000);
    fenetre.setLocation(0, 0);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dessin wtf = new Dessin();
    wtf.setSize(1000,1000);
    wtf.setLocation(0,0);
    JPanel panneau = new JPanel();
    JPanel panneau2 = new JPanel();
    GridLayout gestionnaire = new GridLayout(5,4);
    GridLayout gestionnaire2 = new GridLayout(6,3);
    panneau.setLayout(gestionnaire);
    panneau2.setLayout(gestionnaire2);
    JTextField login = new JTextField("ecrire ");
    JTextField login2 = new JTextField("ecrire ");
    fenetre.add(wtf);
    for (int i=0 ; i<17;i++){
    panneau2.add(new JLabel(""));
   }
   panneau2.add(login);
   for (int i=0 ; i<4;i++){
    panneau2.add(new JLabel(""));
   }
   panneau2.add(login2);
   for (int i=0 ; i<3;i++){
    panneau2.add(new JLabel(""));
   }
    panneau.add(panneau2);
    for(int i=0;i<19;i++){
    panneau.add(new JTextArea(""));
   }
    fenetre.add(panneau);
    fenetre.setVisible(true);
 }
}