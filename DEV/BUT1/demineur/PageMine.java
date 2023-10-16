import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;

public class PageMine { 
	public static void main(String[] args) {


		JFrame fenetre = new JFrame();
		fenetre.setSize(200,200);
		fenetre.setLocation(600,200);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setTitle("Page d'Accueil");

 Mine message = new Mine();
    
    fenetre.add(message);



		fenetre.setVisible(true);


	}
}