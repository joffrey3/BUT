import     java.lang.Object;
import     java.io.OutputStream;
import     java.io.FileOutputStream ;
import        java.io.InputStream;
import            java.io.FileInputStream;
import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;
import java.lang.Object;
import java.awt.Font;
import java.awt.event.*; 
import   java.lang.Throwable;
import  java.lang.Exception;
import      java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.awt.image.BufferedImage;

public class Main /*implements WindowsListener*/{
    public static void main(String[] args) {
	int x = 0;
	int y = 0;
	int h = 100;
	int l = 100;
	try{
	    FileInputStream fis = new FileInputStream("f.txt");
	    DataInputStream dis = new DataInputStream(fis);
	    try{
		x = dis.readInt();
		y = dis.readInt();
		h = dis.readInt();
		l = dis.readInt();
	    }catch(IOException e){
		System.out.println("Erreur de lecture");
	    }
	    try{
		dis.close();
	    }catch(IOException e){
		System.out.println("Erreur de fermeture lecture");
	    }
	}catch (IOException e){
	    System.out.println("Erreur d'ouverture lecture");
	    /*Fond fond = new Fond(x,y,h,l);
	    try{
		FileOutputStream fos = new FileOutputStream("fenetre.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		try{
		    dos.write(fond.getX());
		    dos.write(fond.getY());
		    dos.write(fond.getHeight());
		    dos.write(fond.getWidth());
		}catch(IOException e1){
		    System.out.println("Erreur de ecriture");
		}try{
		    dos.close();
		}catch(IOException e1){
		    System.out.println("Erreur de fermeture d'ecriture");
		}
	    }catch(IOException e1){
		System.out.println("Erreur d'ouverture d'ecriture");
		}*/
	}
	Fond fond = new Fond(x,y,l,h);
    }
	public static void taille(Fond fond){
	try{
	    FileOutputStream fos = new FileOutputStream("f.txt");
	    DataOutputStream dos = new DataOutputStream(fos);
	    try{
		dos.writeInt(fond.getX());
		dos.writeInt(fond.getY());
		dos.writeInt(fond.getHeight());
		dos.writeInt(fond.getWidth());
	    }catch(IOException e){
		System.out.println("Erreur d'ecriture");
	    }try{
		dos.close();
	    }catch(IOException e){
		System.out.println("Erreur de fermeture ecrit");
	    }
	}
	catch (IOException e){
	    System.out.println("Erreur d'ouverture ecrit");
	}	
    }
}
