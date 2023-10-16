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


public class  Devinette{
   public static void main(String[] args) {
   		Devinette nombre = new Devinette();
   		int nb;
		Random random = new Random();
	    int alea= random.nextInt(100);
   		for(int i=0;i<5;i++){
   			nb=nombre.demanderNombre();
   			if (nb<alea){
   				System.out.println("+");
   			}
   			if (nb>alea){
   				System.out.println("-");
   			}
   			if (nb==alea){
   				System.out.println("Gagné");
   				i=5;
   			}
   		}
	}
	public int demanderNombre() {
		try{    
	    	InputStreamReader isr= new InputStreamReader(System.in);
	    	BufferedReader br = new BufferedReader(isr);
	    	try{
	    		String l = br.readLine();
	    		int nb=Integer.parseInt(l);
	    		return nb;
			}
	    	catch(Exception e){
			System.out.println("Erreur de lecture");
		    }
    	}
   		catch(Exception e2){
		System.out.println("Erreur d'ouverture");
		}
		return 0;
	}
}