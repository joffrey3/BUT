import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;
import java.lang.Object;
import java.awt.Font;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.Throwable;
import java.lang.Exception;
import java.io.IOException;
import java.util.Arrays;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader; 
 import java.util.Random;


public class  Image extends JComponent{
    int nb_x;
    int nb_y;
    String[] chaine;
    public Image() {
	this.nb_x=0;
	this.nb_y=0;
	this.chaine=this.lireImage();
	JFrame fenetre = new JFrame();
	fenetre.setSize(1000,1000);
	fenetre.setLocation(0,0);
	fenetre.add(this);
	fenetre.setVisible(true);
    }
    @Override
    protected void paintComponent(Graphics pinceau) {
	Graphics secondPinceau = pinceau.create();

	for(int i=0;i<nb_x;i++){
	    for(int j=0;j<nb_y;j++){
		secondPinceau.setColor(Color.decode(chaine[i*nb_x+j]));
		secondPinceau.fillRect(j*10,i*10,10,10);
	    }
	}
    }
    public static void main(String[] args) {
	Image img= new Image();
    }
    public String[] lireImage() {
	String[] l=new String[1];
	try{    
	    FileReader isr= new FileReader("image.xpm");
	    BufferedReader br = new BufferedReader(isr);
	    try{
		String temp="";
		String ligne="";
		//String information=br.readLine();
		int x=0,y=0,nb_color=0,pixel=0;
		String[] color=new String[1],symbol= new String[1];
		//System.out.println(x);
		//System.out.println(y);
		//System.out.println(color);
		//System.out.println(coupure);
		for(int i=0;temp!=null;i++){
		    temp=br.readLine();
		    System.out.println(temp);
		    if(i==3){
			x=Integer.parseInt(temp.substring(1,3));
			y=Integer.parseInt(temp.substring(4,6));
			this.nb_x=x;
			this.nb_y=y;
			nb_color=Integer.parseInt(temp.substring(7,9));
			pixel=Integer.parseInt(temp.substring(10,11));
			color= new String[nb_color];
			symbol= new String[nb_color];
			l=new String[y*x];
		    }
		    if(i>3 && i<4+nb_color){
			symbol[i-4]=temp.substring(1,2);
			color[i-4]=temp.substring(5,12);
		    }
		    if(i>4+nb_color && i<5+nb_color+y){
			ligne=temp.substring(1,x+1);
			for(int j=0;j<x;j++){
			    for(int k=0;k<nb_color;k++){
				char[] unique = {ligne.charAt(j)};
				String t=new String(unique);
				if(t.equals(symbol[k])){
				    l[(i-20)*x+j]=color[k];
				    /*System.out.println(l[(i-20)*x+j]);
				      System.out.println((i-20)*x+j);*/
				}
				/*System.out.println(t);
				  System.out.println(symbol[k]);
				  System.out.println(t.equals(symbol[k]));*/
			    }
			    
			}
		    }
		}
		/*System.out.println(x);
		  System.out.println(y);
		  System.out.println(nb_color);
		  System.out.println(pixel);*/
		return l;
	    }
	    catch(Exception e){
		System.out.println("Erreur de lecture");
	    }try{
		br.close();
	    }catch(Exception e){
		System.out.println("Erreur de fermeture");
	    }
	}
	catch(Exception e2){
	    System.out.println("Erreur d'ouverture");
	}
	return l;
    }
    public String ecrireImage() {
	try{    
	    FileWriter isw= new FileWriter("image.xpm");
	    BufferedWriter bw = new BufferedWriter(isw);
	    try{
		String l="";
		String temp="";
		for(;temp!=null;){
		    //temp=bw.readLine();
		    l=l+temp;
		}
		return l;
	    }
	    catch(Exception e){
		System.out.println("Erreur de ecriture");
	    }
    	}
	catch(Exception e2){
	    System.out.println("Erreur d'ouverture");
	}
	return "";
    }
}
