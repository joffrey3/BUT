import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;

public class Formes { 
 public static void main(String[] args) {
    JFrame fenetre = new JFrame();
    fenetre.setSize(1000, 1000);
    fenetre.setLocation(0, 0);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Bonjour wtf = new Bonjour();
    fenetre.setLayout(null);
    wtf.setSize(666,666);
    wtf.setLocation(0,0);

    fenetre.add(wtf);
    fenetre.setVisible(true);
 }
}