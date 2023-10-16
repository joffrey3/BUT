import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class  LecteurDialogue {
    private File input;
    private int max;
    private int taille;
    public LecteurDialogue(String fichier){
	this.input=new File(fichier);
	this.taille=0;
	this.max=-1;
    }
    public String[] lireDialogue() {
	String[] l=new String[1];
	try{    
	    FileReader isr= new FileReader(this.input);
	    BufferedReader br = new BufferedReader(isr);
	    try{
		String temp="";
		temp=br.readLine();
		for(int i=0;temp!=null;i++){
		    if(temp.length()>max){
			max=temp.length();
		    }
		    this.taille=this.taille+1;
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
	l= new String[this.taille*this.max];
	try{    
	    FileReader isr= new FileReader(this.input);
	    BufferedReader br = new BufferedReader(isr);
	    try{
		String temp="";
		temp=br.readLine();
		for(int i=0;temp!=null;i++){
		    for(int j=0;j<temp.length();j++){
			char[] unique = {temp.charAt(j)};
			String t=new String(unique);
			l[i*this.max+j]=t;
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
    public int getMax(){
	return this.max;
    }
    public int getTaille(){
	return this.taille;
    }
}
