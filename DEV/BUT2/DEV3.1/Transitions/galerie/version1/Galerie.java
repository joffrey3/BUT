import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import java.util.*;


public class Galerie implements MouseListener{
    JFrame fenetre;
    BorderLayout gestionnaire;
    JLabel image;
    int indent;
    final String[] tab={"image1.jpg","image2.jpg","image3.jpg","image4.jpg"};
    public Galerie(){
	this.indent=0;
	this.fenetre = new JFrame();
	this.fenetre.setSize(1920,1080);
	this.fenetre.setLocation(0,0);
	this.gestionnaire = new BorderLayout();
	this.fenetre.setLayout(gestionnaire);
	this.fenetre.setVisible(true);
	this.image= new JLabel(new ImageIcon("image1.jpg"));
	this.fenetre.add(this.image,BorderLayout.CENTER);
	fenetre.addMouseListener(this);
    }
    public void ajouterImage(String chaine){
	this.fenetre.remove(this.image);
	this.image= new JLabel(new ImageIcon(chaine));
	this.fenetre.add(this.image,BorderLayout.CENTER);
	this.fenetre.revalidate();
    }
    public void mouseClicked(MouseEvent e1){
	if(e1.getX()>=960){
	    if(this.indent!=3){
		this.indent=this.indent+1;
		this.ajouterImage(tab[this.indent]);
	    }
	    else{
		this.indent=0;
		this.ajouterImage(tab[indent]);
	    }
	}
	if(e1.getX()<960){
	    if(this.indent!=0){
		this.indent=this.indent-1;
		this.ajouterImage(tab[this.indent]);
	    }
	    else{
		this.indent=3;
		this.ajouterImage(tab[indent]);
	    }
	}
    }
    public void mouseEntered(MouseEvent e2){
	
    }
    public void mouseExited(MouseEvent e3){

    }
    public void mousePressed(MouseEvent e4){

    }
    public void mouseReleased(MouseEvent e5){

    }
}
