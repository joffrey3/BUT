import java.lang.*;
import java.awt.*;
import javax.swing.JFrame;
import java.util.*;
import java.awt.event.*;
import java.io.*;

public class InterfaceDialogue extends JFrame implements KeyListener{
    private DessinDialogue fond ;
    private LecteurDialogue t;
    private String[] text;
    private String[] temp;
    private String portrait;
    private String nom;
    private Timer temps;
    private Temps action;
    private int ent;
	public InterfaceDialogue(){
	        this.setLocation(350,700);
		this.setSize(1000,240);
		//this.setLayout(null);
		String portrait="../xpm/MUR-1.xpm";
		String nom="";
		this.t = new LecteurDialogue("../dialogue/M1-1");
		this.text =this.t.lireDialogue();
		if(this.t.getMax()>50){
		    this.transformer();
		}
		this.temps = new Timer();
		this.action = new Temps(this,this.t,this.temp,-1,0,portrait,nom);
		this.fond = this.action.getDessinDialogue();
		this.ent=this.action.getInt();
	        this.fond.setLocation(350,700);
		this.fond.setSize(1000,200);
		this.add(this.fond);
		this.setVisible(true);
		this.temps.schedule(action,100L,100L);
		  this.addKeyListener(this);
	}
	public void keyTyped(KeyEvent evenement){
	}      
	public void keyPressed(KeyEvent evenement){
		int touche =evenement.getKeyCode();
		if(touche==KeyEvent.VK_ENTER){
		    int indent =this.action.getInt();
		    int taille=this.action.getTaille();
		    this.temp = new String[taille];
		    for(int i=0;i<taille;i++){
			this.temp[i]=this.action.getText(i);
		    }
		    String portrait = this.action.getPortrait();
		    String nom = this.action.getNom();
		    this.temps.cancel();
		    this.temps = new Timer();
		    this.action = new Temps(this,this.t,this.temp,indent,indent,portrait,nom);
		    this.action.pause();
		    this.temps.schedule(action,100L,100L);
		}
	        
	}         
	public void keyReleased(KeyEvent evenement){
	}
    public void modifier(DessinDialogue f,int n){
	this.ent=n;
	if(this.ent<this.action.getTaille()){
	    this.remove(this.fond);
	    this.fond=f;
	    this.add(this.fond);
	    this.setVisible(true);
	}
	if(this.ent>=this.action.getTaille()){
	    this.temps.cancel();
	}
    }
     public void transformer(){
	int max=this.t.getMax();
	int taille=this.t.getTaille();
	int nb_ligne=0;
        for(int i=0;i<taille;i++){
	    int longueur=0;
	    for(int j=0;j<max;j++){
		if(this.text[i*max+j]!=null || j==max-1){		       
		    longueur=longueur+1;
		}
	    }
	    nb_ligne=nb_ligne+1+(longueur-1)/50;
	}
        this.temp = new String[50*nb_ligne];
	int nombre_l=0;
	for(int i=0;i<taille;i++){
	    int longueur=0;
	    for(int j=0;j<max;j++){
		if(this.text[i*max+j]!=null || j==max-1){		       
		    longueur=longueur+1;
		}
	    }
	    int lon =(longueur-1)/50;
	    nombre_l=nombre_l+1;
	    for(int j=0;j<max;j++){	
		if(j<50 || this.text[i*max+j]!=null){
		this.temp[(nombre_l-1)*50+j%50]=this.text[i*max+j];
		}	
		if(lon>0 && j%50==49 && this.text[i*max+j]!=null){
		    lon=lon-1;
		    nombre_l=nombre_l+1;
		}
	    }
	}
    }
    public void arret(){
	this.temps.cancel();
    }
    public Temps getTemps(){
	return this.action;
    }
}
