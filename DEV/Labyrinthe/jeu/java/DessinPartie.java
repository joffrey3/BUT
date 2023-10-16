import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class DessinPartie extends JComponent{
    private LecteurXPM bouton1;
    private LecteurXPM bouton2;
    private String[] chaine1;
    private String[] chaine2;
    private int nb_x1;
    private int nb_y1;
    private int nb_x2;
    private int nb_y2;
    public DessinPartie() {
	this.bouton1 = new LecteurXPM(); 
	this.chaine1=this.bouton1.lireImage(new File("../xpm/jouer.xpm"));
	this.bouton2 = new LecteurXPM(); 
	this.chaine2=this.bouton2.lireImage(new File("../xpm/option.xpm"));
	this.nb_x1=this.bouton1.getX();
	this.nb_y1=this.bouton1.getY();
	this.nb_x2=this.bouton2.getX();
	this.nb_y2=this.bouton2.getY();
    }
    @Override
    protected void paintComponent(Graphics pinceau) {
	Graphics secondPinceau = pinceau.create();

	for(int i=0;i<this.nb_x1;i++){
	    for(int j=0;j<this.nb_y1;j++){
		secondPinceau.setColor(Color.decode(this.chaine1[i*nb_y1+j]));
		secondPinceau.fillRect(700+j,600+i,1,1);
	    }
	}
	for(int i=0;i<this.nb_x2;i++){
	    for(int j=0;j<this.nb_y2;j++){
		secondPinceau.setColor(Color.decode(this.chaine2[i*nb_y2+j]));
		secondPinceau.fillRect(775+j,750+i,1,1);
	    }
	}
    }
}
