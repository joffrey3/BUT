import java.lang.Object;
import java.awt.Component;
import java.awt.Container;
import java.awt.Window;
import java.awt.Frame;
import javax.swing.JFrame;

import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;

public class Cercle { 
 public static void main(String[] args) {
    JFrame fenetre = new JFrame();
    fenetre.setSize(1000, 1000);
    fenetre.setLocation(0, 0);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Fresque wtf = new Fresque();
    fenetre.setLayout(null);
    wtf.setSize(1000,1000);
    wtf.setLocation(0,0);

    fenetre.add(wtf);
    fenetre.setVisible(true);
 }
}