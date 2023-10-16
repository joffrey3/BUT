import java.lang.*;
import java.awt.*;
import javax.swing.JComponent;
import java.util.*;
import java.io.*;

public class DessinDialogue extends JComponent{
    private InterfaceDialogue fenetre;
    private int ent;
    private int index;
    private String[] tab;
    private int lon;
    private LecteurXPM bouton0;
    private String[] portrait;
    private String nom;
    private Graphics secondPinceau;
    public DessinDialogue(InterfaceDialogue i,int longueur,String[] tableau, int entier,int ind ,String p,String n) {
	this.fenetre=i;
	this.ent=entier;
	this.index=ind;
	this.tab=tableau;
	this.lon=longueur;
	this.nom=n;
	this.bouton0 = new LecteurXPM(); 
	this.portrait=this.bouton0.lireImage(new File(p));
    }
    @Override
    protected void paintComponent(Graphics pinceau) {
        this.secondPinceau = pinceau.create();
	this.secondPinceau.setColor(Color.BLACK);
	this.secondPinceau.fillRect(0,0,1720,900);
	this.secondPinceau.setColor(Color.WHITE);
	//this.secondPinceau.drawRect(100,50,120,120);
	//this.secondPinceau.drawRect(780,50,120,120);
	this.secondPinceau.drawString(this.nom,250,60);
	for(int i=this.index;i<this.ent;i++){
	    int ligne = (i-this.index)/this.lon;
	    if(tab[i]!=null){
		this.secondPinceau.drawString(this.tab[i],250+i%this.lon*10,90+ligne*15);
	    }
	}
	for(int k=0;k<30;k++){
	    for(int l=0;l<30;l++){
		secondPinceau.setColor(Color.decode(this.portrait[k*30+l]));
		secondPinceau.fillRect(100+l,50+k,1,1);
	    }
	}
    }
}
