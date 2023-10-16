import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class  LecteurTableau {
    private File input;
    public LecteurTableau(String fichier){
	this.input=new File(fichier);
    }
    public int[] lireTableau() {
	int[] l=new int[36*64];
	try{    
	    FileReader isr= new FileReader(this.input);
	    BufferedReader br = new BufferedReader(isr);
	    try{
		String temp="";
		String[] nb_info={"0","1","2","3","4"};
		for(int i=0;temp!=null;i++){
		    temp=br.readLine();
		    if(i<36){
			for(int j=0;j<temp.length();j++){
			    for(int k=0;k<5;k++){
				char[] unique = {temp.charAt(j)};
				String t=new String(unique);
				if(t.equals(nb_info[k])){
				    l[i*64+j]=k;
				}
			    }	
			}
		    }
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

    public void mouvementJoueur(int action) {
	//System.out.println("oui");
	String[] l=new String[36*64];
	int x=-1,y=-1;
	try{    
	    FileReader isr= new FileReader(this.input);
	    BufferedReader br = new BufferedReader(isr);
	    try{
		String temp="";
		String[] nb_info={"0","1","2","3","4"};
		for(int i=0;temp!=null;i++){
		    temp=br.readLine();
		    if(i<36){
			for(int j=0;j<temp.length();j++){
			    char[] unique = {temp.charAt(j)};
			    String t=new String(unique);
			    l[i*64+j]=t;
			    if(t.equals("1")){
				x=i;
				y=j;
			    }
			}
		    }
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
	String haut="";
	String bas="";
	String gauche="";
	String droite="";
	try{    
	    FileReader isr= new FileReader(this.input);
	    BufferedReader br = new BufferedReader(isr);
	    try{
		String temp="";
		String[] nb_info={"0","1","2","3","4"};
		for(int i=0;temp!=null;i++){
		    temp=br.readLine();
		    if(i<36){
			for(int j=0;j<temp.length();j++){
			    char[] unique = {temp.charAt(j)};
			    String t=new String(unique);
			    l[i*64+j]=t;
			    if(i==x-1 && j==y){
			        haut=t;
			    }
			    if(i==x+1 && j==y){
			        bas=t;
			    }
			    if(i==x && j==y-1){
			        gauche=t;
			    }
			    if(i==x && j==y+1){
			        droite=t;
			    }
			}
		    }
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
	boolean flag=false;
        if(action==1 && x!=0 && !haut.equals("2")){
	    flag=true;
	   }
	if(action==2 && x!=35 && !bas.equals("2")){
	    flag=true;
	   }
	if(action==3 && y!=0 && !gauche.equals("2")){
	    flag=true;
	   }
	if(action==4 && y!=63 && !droite.equals("2")){
	    flag=true;
	   }
	try{    
	    FileWriter isw= new FileWriter(this.input);
	    BufferedWriter bw = new BufferedWriter(isw);
	    try{
		String temp="";
		for(int i=0;i<l.length/64;i++){
		    for(int j=0;j<l.length/36;j++){
			if(x==i && y==j && flag==true){
			    temp=temp+"0";
			}
			else if(x==i+1 && y==j && action==1 && flag==true){
				temp=temp+"1";
			}
			else if(x==i-1 && y==j && action==2 && flag==true){
				temp=temp+"1";
			}
			else if(x==i && y==j+1 && action==3 && flag==true){
				temp=temp+"1";
			}
			else if(x==i && y==j-1 && action==4 && flag==true){
				temp=temp+"1";
			}
			else{
			    temp=temp+l[i*64+j];
			}
		    }
		    bw.write(temp,i*64,64);
		    bw.newLine();
		}
	    }
	    catch(IOException e){
		System.out.println("Erreur de lecture");
	    }try{
		bw.close();
	    }catch(IOException e){
		System.out.println("Erreur de fermeture");
		}
	}
	catch(IOException e2){
	    System.out.println("Erreur d'ouverture");
	}
    }
}
