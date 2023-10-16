import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class  LecteurDecor {
    private File input;
    private int X;
    private int Y;
    public LecteurDecor(String fichier){
	this.input=new File(fichier);
	this.X=0;
	this.Y=0;
    }
    public String[] lireDecor() {
	String[] l= new String[this.X*this.Y];;
	try{    
	    FileReader isr= new FileReader(this.input);
	    BufferedReader br = new BufferedReader(isr);
	    try{
		String temp="";
		temp=br.readLine();
		for(int i=0;temp!=null;i++){
		    for(int j=0;j<temp.length();j++){
			    char[] unique = {temp.charAt(j)};
			    l[i*this.X+j]= new String(unique);
			    
		    }
		    temp=br.readLine();
		}
	    }
	    catch(IOException e){
		System.out.println("Erreur de lecture");
	    }try{
		br.close();
	    }catch(IOException e){
		System.out.println("Erreur de fermeture");
	    }
	}
	catch(FileNotFoundException e2){
	    System.out.println("Erreur d'ouverture");
	}
	return l;
    }

    public void taillefichier() {
	try{    
	    FileReader isr= new FileReader(this.input);
	    BufferedReader br = new BufferedReader(isr);
	    try{
		int lignes=0,colonnes=0;
		String temp="";
		temp=br.readLine();
		for(int i=0;temp!=null;i++){
		    lignes=lignes+1;
		    for(int j=0;j<temp.length();j++){
			colonnes=colonnes+1;
		    }
		    temp=br.readLine();
		}
		this.X=colonnes;
		this.Y=lignes;
	    }
	    catch(IOException e){
		System.out.println("Erreur de lecture");
	    }try{
		br.close();
	    }catch(IOException e){
		System.out.println("Erreur de fermeture");
	    }
	}
	catch(FileNotFoundException e2){
	    System.out.println("Erreur d'ouverture");
	}
    }
    public int getX() {
	return this.X;
    }
    public int getY() {
	return this.Y;
    }
}
