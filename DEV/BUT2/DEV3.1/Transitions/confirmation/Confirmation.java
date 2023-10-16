import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import java.util.*;


public class Confirmation implements MouseListener,WindowListener{
    JFrame fenetre;
    CardLayout gestionnaire;
    JPanel panneau;
    JLabel image;
    final String[] tab={"image1.jpg","image2.jpg","image3.jpg","image4.jpg"};
    public Confirmation(){
	this.fenetre = new JFrame();
	this.fenetre.setSize(1920,1080);
	this.fenetre.setLocation(0,0);
	this.fenetre.setLayout(null);
		
	this.panneau = new JPanel();
	this.panneau.setSize(1920,1080);
	this.panneau.setLocation(0,0);
	
	this.gestionnaire = new CardLayout();
	this.panneau.setLayout(gestionnaire);
	for(int i=0;i<tab.length;i++){
	    this.image= new JLabel(new ImageIcon(tab[i]));
	    this.panneau.add(this.image,Integer.toString(i));
	}
	this.fenetre.add(this.panneau);
	this.fenetre.setVisible(true);	
	this.panneau.addMouseListener(this);
	this.fenetre.addWindowListener(this);
    }
    public void mouseClicked(MouseEvent e1){
	if(e1.getX()>=960){
	        this.gestionnaire.next(this.panneau);
	}
	if(e1.getX()<960){
	        this.gestionnaire.previous(this.panneau);
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
    
    public void windowDeactivated(WindowEvent w1){
	
    }
    public void windowActivated(WindowEvent w2){
	
    }
    public void windowDeiconified(WindowEvent w3){
	
    }
    public void windowIconified(WindowEvent w4){
	
    }
    public void windowClosed(WindowEvent w5){
	
    }
    public void windowClosing(WindowEvent w6){
	Securite verication= new Securite(this.fenetre);
	
    }
    public void windowOpened(WindowEvent w7){
	
    }   
}
