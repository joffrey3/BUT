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



public class Couleur extends JComponent{
	private BufferedImage image;
	public Couleur(BufferedImage img){
		super();
		this.image=img;
	}
	@Override
	protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    int i,j;
   	secondPinceau.drawImage(image,0,0,this);
    }

	public static void main(String[] args) {
	    /*try{
			FileInputStream fis = new FileInputStream("image.bin");
			DataInputStream dis = new DataInputStream(fis);
			JFrame fenetre = new JFrame();
			BufferedImage image = new BufferedImage(768,1024,BufferedImage.TYPE_3BYTE_BGR);
			fenetre.setSize(768,1024);
			fenetre.setLocation(0,0);
			int chaine;
			try{
				for(int i=0;i<768*1024;i++){
					int r=dis.readByte();
					int g=dis.readByte();
					int b=dis.readByte();
					chaine=(r<<16)+(g<<8)+b;
					image.setRGB(i%768,i/768,chaine);
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
			Image graph = new Image(image);
			fenetre.add(graph);
			fenetre.setVisible(true);
			//System.out.println(Arrays.toString(tab));
		}
		catch (IOException e){
				System.out.println("Erreur de ouverture du fichier de lecture");
		}*/
		try{
			FileOutputStream fis = new FileOutputStream("image.png");
			DataOutputStream dis = new DataOutputStream(fis);
			Color couleur=Color.decode(args[0]);
			int[] tab = new int[3];
			tab[0]=couleur.getRed();
			tab[1]=couleur.getGreen();
			tab[2]=couleur.getBlue();
			try{
			    int chaine =(tab[0]<<16)+(tab[1]<<8)+tab[2];
				for (int i=0 ;i<40;i++){
					dis.writeInt(chaine);
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
		}
	}
}
