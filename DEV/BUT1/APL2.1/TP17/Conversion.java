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


public class  Conversion {
   public static void main(String[] args) {
   		Conversion converteur = new Conversion();
   		converteur.transformerFichier();
   		}
	public void transformerFichier() {
		String l="";
		try{    
	    	FileWriter fw= new FileWriter("conversion.html");
	    	BufferedWriter  bw = new BufferedWriter(fw);
			try{    
	    		FileReader fr= new FileReader("conversion.txt");
	   		 	BufferedReader br = new BufferedReader(fr);
		    	try{
		    		bw.write("<!DOCTYPE html>\n");
					bw.write("<html>\n");
					bw.write("<head>\n");
					bw.write("<meta charset='utf-8'>\n");
					bw.write("<title>connexion</title>\n");
					bw.write("</head>\n");
					bw.write("<body>\n");
					bw.write("<p>\n");
		    		bw.write(l);
	    			for(String i="";i!=null;){
	    				bw.write(l);
	    				bw.write("\n");
	    				l=br.readLine();	    				
	    				i=l;
	    			}
	    			bw.write("</p>\n");
					bw.write("</body>\n");
					bw.write("</html>\n");
				}
	    		catch(IOException e){
				System.out.println("Erreur de lecture");
			    }
			    try{
			    	br.close();
			    }catch(IOException e){
			    	System.out.println("Erreur de fermeture");
			    }
			    try{
			    	bw.close();
			    }catch(IOException e){
			    	System.out.println("Erreur de fermeture");
			    }
    		}
   			catch(IOException e2){
			System.out.println("Erreur d'ouverture");
			}
		}catch(IOException e2){
		System.out.println("Erreur d'ouverture");
		}
	}
}