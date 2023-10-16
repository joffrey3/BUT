import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

public class InterfaceNiveau extends JFrame implements KeyListener{
    private DessinNiveau fond ;
    private LecteurTableau t;
    private int[] tab;
	public InterfaceNiveau(){
		this.setLocation(0,0);
		this.setSize(1720,1080);
		//this.setLayout(null);
		this.t = new LecteurTableau("../niveau/M1-1");
		this.tab =this.t.lireTableau();
		String chaine =new String();
		for(int i=0;i<36;i++){
		    for(int j=0;j<64;j++){
		        chaine=chaine+this.tab[i*64+j];
		    }
		    chaine=chaine+"\n";
		}
		System.out.println(chaine);
		this.fond = new DessinNiveau(1,1,this.tab);
		this.fond.setLocation(0,0);
		this.fond.setSize(1720,1080);
		this.add(this.fond);
		this.setVisible(true);
		this.addKeyListener(this);
	}
	public void keyTyped(KeyEvent evenement){
	}      
	public void keyPressed(KeyEvent evenement){
		int touche =evenement.getKeyCode();
		if(touche==KeyEvent.VK_UP){
		    this.t.mouvementJoueur(1);
		    this.tab =this.t.lireTableau();
		    String chaine =new String();
		for(int i=0;i<36;i++){
		    for(int j=0;j<64;j++){
		        chaine=chaine+this.tab[i*64+j];
		    }
		    chaine=chaine+"\n";
		}
		System.out.println(chaine);
		    this.remove(this.fond);
		    this.fond = new DessinNiveau(1,1,this.tab);
		    this.fond.setLocation(0,0);
		    this.fond.setSize(1720,1080);
		    this.add(this.fond);
		    this.setVisible(true);
		}
		if(touche==KeyEvent.VK_LEFT){
		    this.t.mouvementJoueur(3);
		    this.tab =this.t.lireTableau();
		    this.remove(this.fond);
		    this.fond = new DessinNiveau(1,1,this.tab);
		    this.fond.setLocation(0,0);
		    this.fond.setSize(1720,1080);
		    this.add(this.fond);
		    this.setVisible(true);
		}
		if(touche==KeyEvent.VK_RIGHT){
		    this.t.mouvementJoueur(4);
		    this.tab =this.t.lireTableau();
		    this.remove(this.fond);
		    this.fond = new DessinNiveau(1,1,this.tab);
		    this.fond.setLocation(0,0);
		    this.fond.setSize(1720,1080);
		    this.add(this.fond);
		    this.setVisible(true);
		}
		if(touche==KeyEvent.VK_DOWN){
		    this.t.mouvementJoueur(2);
		    this.tab =this.t.lireTableau();
		    this.remove(this.fond);
		    this.fond = new DessinNiveau(1,1,this.tab);
		    this.fond.setLocation(0,0);
		    this.fond.setSize(1720,1080);
		    this.add(this.fond);
		    this.setVisible(true);
		}
	}         
	public void keyReleased(KeyEvent evenement){
	}
}
