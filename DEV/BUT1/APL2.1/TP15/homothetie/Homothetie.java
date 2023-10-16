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



public class Homothetie extends JComponent{
        int[] x;
    int[] y;
    int n;
	public Homothetie(int[] abs,int[] ord,int nombre){
	this.x=abs;
	this.y=ord;
	this.n=nombre;
	}
	@Override
	protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
            secondPinceau.fillPolygon(x,y,n);
    }

	public static void main(String[] args) {
		try{
			FileInputStream fis = new FileInputStream("polygone.bin");
			DataInputStream dis = new DataInputStream(fis);
			JFrame fenetre = new JFrame();
			//BufferedImage image = new BufferedImage(768,1024,BufferedImage.TYPE_3BYTE_BGR);
			fenetre.setSize(768,1024);
			fenetre.setLocation(0,0);
			int pos_h, pos_v;
			int n=6;
			int[] x= new int[n];
			int[] y= new int[n];
			try{
				for(int i=0;i<n;i++){
					pos_h=dis.readInt();
					pos_v=dis.readInt();
					x[i]=pos_h*2;
					y[i]=pos_v*2;
				}
			}
			catch (IOException e){
				System.out.println("Erreur de lecture du fichier de lecture");
			}
			try{
				dis.close();
			}
			catch (IOException e){
				System.out.println("Erreur de fermeture du fichier de lecture");
			}
		        Homothetie graph = new Homothetie(x,y,n);
			fenetre.add(graph);
			fenetre.setVisible(true);
			//System.out.println(Arrays.toString(tab));
		}
		catch (IOException e){
				System.out.println("Erreur de ouverture du fichier de lecture");
		}
		/*try{
			FileOutputStream fis = new FileOutputStream("image.bin");
			DataOutputStream dis = new DataOutputStream(fis);
			//tab = new byte[dis.available()/4];
			try{
				for (int i=0 ;i<tab.length;i++){
					tab[i]=dis.readByte();
				}
			}
			catch (IOException e){
				System.out.println("Erreur d'ecriture du fichier d'ecriture");
			}
			try{
				dis.close();
			}
			catch (IOException e){
				System.out.println("Erreur de fermeture du fichier d'ecriture");
			}
			//System.out.println(Arrays.toString(tab));
		}
		catch (IOException e){
				System.out.println("Erreur de ouverture du fichier d'ecriture");
		}*/
	}
}
