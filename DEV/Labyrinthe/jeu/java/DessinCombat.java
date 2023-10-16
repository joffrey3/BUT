import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class DessinCombat extends JComponent{
    private LecteurXPM bouton1;
    private LecteurXPM bouton2;
    private LecteurXPM bouton3;
    private LecteurDecor decor1;
    private String[] chaine1;
    private String[] chaine2;
    private String[] chaine3;
    private String[] chaine_decor;
    private String[][] chainetab;
    private int nb_x1;
    private int nb_y1;
    private int nb_x2;
    private int nb_y2;
    private int nb_x3;
    private int nb_y3;
    private int nb_x4;
    private int nb_y4; 
    public DessinCombat(String d) {
	this.bouton1 = new LecteurXPM(); 
	this.chaine1=this.bouton1.lireImage(new File("../xpm/J.xpm"));
	this.bouton2 = new LecteurXPM(); 
	this.chaine2=this.bouton2.lireImage(new File("../xpm/E1-1.xpm"));
	this.chainetab= new String[13][10000];
	for(int k=0;k<13;k++){
	    String texte =new String();
	    texte="../xpm/STAT-"+"FOR"+".xpm";
	    this.bouton3 = new LecteurXPM(); 
	    this.chaine3=this.bouton3.lireImage(new File(texte));
	    this.chainetab[k]=this.chaine3;
	}
	this.nb_x1=this.bouton1.getX();
	this.nb_y1=this.bouton1.getY();
	this.nb_x2=this.bouton2.getX();
	this.nb_y2=this.bouton2.getY();
	this.nb_x3=this.bouton3.getX();
	this.nb_y3=this.bouton3.getY();
	this.decor1 = new LecteurDecor(d);
	this.decor1.taillefichier();
	this.chaine_decor=this.decor1.lireDecor();
	
    }
    @Override
    protected void paintComponent(Graphics pinceau) {
	Graphics secondPinceau = pinceau.create();
	
	for(int i=0;i<this.decor1.getX();i++){
	    for(int j=0;j<this.decor1.getY();j++){
		secondPinceau.setColor(Color.BLACK);
		secondPinceau.drawString(this.chaine_decor[i*this.decor1.getX()+j],i,j);
	    }
	}
	/*for(int i=0;i<this.nb_x1;i++){
	    for(int j=0;j<this.nb_y1;j++){
		secondPinceau.setColor(Color.decode(this.chaine1[i*nb_y1+j]));
		secondPinceau.fillRect(200+j,500+i,1,1);
	    }
	}
	for(int i=0;i<this.nb_x2;i++){
	    for(int j=0;j<this.nb_y2;j++){
		secondPinceau.setColor(Color.decode(this.chaine2[i*nb_y2+j]));
		secondPinceau.fillRect(700+j,500+i,1,1);
	    }
	}
	for(int k=0;k<13;k++){
	    System.out.println(k);
	    for(int i=0;i<this.nb_x3;i++){
		for(int j=0;j<this.nb_y3;j++){
		    secondPinceau.setColor(Color.decode(this.chainetab[k][i*nb_y3+j]));
		    secondPinceau.fillRect(200*(k/6)+j,50*(k%6)+i,1,1);
		}
	    }
	}
	for(int k=0;k<12;k++){
	    System.out.println(k);
	    for(int i=0;i<100;i++){
		for(int j=0;j<100;j++){
		    secondPinceau.setColor(Color.decode(this.chainetab[k][0]));
		    secondPinceau.fillRect(100*(k/3)+j,100*(k%3)+600+i,1,1);
		}
	    }
	    }*/
    }
}
