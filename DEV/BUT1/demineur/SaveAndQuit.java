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
//La classe SaveAndQuit sauvegarde dans un fichier save.txt le nombre de lignes, de colonnes et les deux tableaux
public class SaveAndQuit extends JComponent{
    int ligne;
    int colonne;
    Maths calcul;
    public  SaveAndQuit(int l, int c){
	this.ligne=l;
	this.colonne=c;
	this.calcul= new Maths();
  }

  //elle implémente un JComponent pour pouvoir dessiner, elle dessine  les mots "save and quit" en rouge sur un fond noir
  @Override
  protected void paintComponent(Graphics pinceau) {
		Graphics secondPinceau = pinceau.create();
		secondPinceau.setColor(Color.BLACK);
		secondPinceau.fillRect(0+this.calcul.Composant_centre(this.colonne),this.ligne*30+70,200,32);

		secondPinceau.setColor(Color.RED);
		secondPinceau.fillRect(16+this.calcul.Composant_centre(this.colonne),this.ligne*30+80,6,2);
		secondPinceau.fillRect(14+this.calcul.Composant_centre(this.colonne),this.ligne*30+82,2,2);
		secondPinceau.fillRect(22+this.calcul.Composant_centre(this.colonne),this.ligne*30+82,2,2);
		secondPinceau.fillRect(16+this.calcul.Composant_centre(this.colonne),this.ligne*30+84,4,2);
		secondPinceau.fillRect(18+this.calcul.Composant_centre(this.colonne),this.ligne*30+86,4,2);
		secondPinceau.fillRect(14+this.calcul.Composant_centre(this.colonne),this.ligne*30+88,2,2);
		secondPinceau.fillRect(22+this.calcul.Composant_centre(this.colonne),this.ligne*30+88,2,2);
		secondPinceau.fillRect(16+this.calcul.Composant_centre(this.colonne),this.ligne*30+90,6,2);

		secondPinceau.fillRect(28+this.calcul.Composant_centre(this.colonne),this.ligne*30+86,10,2);
		secondPinceau.fillRect(28+this.calcul.Composant_centre(this.colonne),this.ligne*30+88,2,4);
		secondPinceau.fillRect(30+this.calcul.Composant_centre(this.colonne),this.ligne*30+82,2,4);
		secondPinceau.fillRect(32+this.calcul.Composant_centre(this.colonne),this.ligne*30+80,2,2);
		secondPinceau.fillRect(34+this.calcul.Composant_centre(this.colonne),this.ligne*30+82,2,4);
		secondPinceau.fillRect(36+this.calcul.Composant_centre(this.colonne),this.ligne*30+88,2,4);

		secondPinceau.fillRect(42+this.calcul.Composant_centre(this.colonne),this.ligne*30+80,2,6);
		secondPinceau.fillRect(44+this.calcul.Composant_centre(this.colonne),this.ligne*30+86,2,4);
		secondPinceau.fillRect(46+this.calcul.Composant_centre(this.colonne),this.ligne*30+90,2,2);
		secondPinceau.fillRect(48+this.calcul.Composant_centre(this.colonne),this.ligne*30+86,2,4);
		secondPinceau.fillRect(50+this.calcul.Composant_centre(this.colonne),this.ligne*30+80,2,6);

		secondPinceau.fillRect(58+this.calcul.Composant_centre(this.colonne),this.ligne*30+80,6,2);
		secondPinceau.fillRect(56+this.calcul.Composant_centre(this.colonne),this.ligne*30+82,2,8);
		secondPinceau.fillRect(64+this.calcul.Composant_centre(this.colonne),this.ligne*30+82,2,2);
		secondPinceau.fillRect(58+this.calcul.Composant_centre(this.colonne),this.ligne*30+85,4,2);
		secondPinceau.fillRect(64+this.calcul.Composant_centre(this.colonne),this.ligne*30+88,2,2);
		secondPinceau.fillRect(58+this.calcul.Composant_centre(this.colonne),this.ligne*30+90,6,2);



		
		secondPinceau.fillRect(80+this.calcul.Composant_centre(this.colonne),this.ligne*30+86,10,2);
		secondPinceau.fillRect(80+this.calcul.Composant_centre(this.colonne),this.ligne*30+88,2,4);
		secondPinceau.fillRect(82+this.calcul.Composant_centre(this.colonne),this.ligne*30+82,2,4);
		secondPinceau.fillRect(84+this.calcul.Composant_centre(this.colonne),this.ligne*30+80,2,2);
		secondPinceau.fillRect(86+this.calcul.Composant_centre(this.colonne),this.ligne*30+82,2,4);
		secondPinceau.fillRect(88+this.calcul.Composant_centre(this.colonne),this.ligne*30+88,2,4);

		secondPinceau.fillRect(94+this.calcul.Composant_centre(this.colonne),this.ligne*30+80,2,12);
		secondPinceau.fillRect(96+this.calcul.Composant_centre(this.colonne),this.ligne*30+82,2,2);
		secondPinceau.fillRect(98+this.calcul.Composant_centre(this.colonne),this.ligne*30+84,2,4);
		secondPinceau.fillRect(100+this.calcul.Composant_centre(this.colonne),this.ligne*30+88,2,2);
		secondPinceau.fillRect(102+this.calcul.Composant_centre(this.colonne),this.ligne*30+80,2,12);

		secondPinceau.fillRect(108+this.calcul.Composant_centre(this.colonne),this.ligne*30+80,2,12);
		secondPinceau.fillRect(110+this.calcul.Composant_centre(this.colonne),this.ligne*30+80,4,2);
		secondPinceau.fillRect(110+this.calcul.Composant_centre(this.colonne),this.ligne*30+90,4,2);
		secondPinceau.fillRect(114+this.calcul.Composant_centre(this.colonne),this.ligne*30+82,2,2);
		secondPinceau.fillRect(114+this.calcul.Composant_centre(this.colonne),this.ligne*30+88,2,2);
		secondPinceau.fillRect(116+this.calcul.Composant_centre(this.colonne),this.ligne*30+84,2,4);





		secondPinceau.fillRect(134+this.calcul.Composant_centre(this.colonne),this.ligne*30+80,6,2);
		secondPinceau.fillRect(134+this.calcul.Composant_centre(this.colonne),this.ligne*30+88,6,2);
		secondPinceau.fillRect(132+this.calcul.Composant_centre(this.colonne),this.ligne*30+82,2,6);
		secondPinceau.fillRect(140+this.calcul.Composant_centre(this.colonne),this.ligne*30+82,2,6);
		secondPinceau.fillRect(140+this.calcul.Composant_centre(this.colonne),this.ligne*30+90,2,2);
		
		secondPinceau.fillRect(146+this.calcul.Composant_centre(this.colonne),this.ligne*30+80,2,10);
		secondPinceau.fillRect(148+this.calcul.Composant_centre(this.colonne),this.ligne*30+90,6,2);
		secondPinceau.fillRect(154+this.calcul.Composant_centre(this.colonne),this.ligne*30+80,2,10);

		secondPinceau.fillRect(160+this.calcul.Composant_centre(this.colonne),this.ligne*30+80,10,2);
		secondPinceau.fillRect(164+this.calcul.Composant_centre(this.colonne),this.ligne*30+82,2,8);
		secondPinceau.fillRect(160+this.calcul.Composant_centre(this.colonne),this.ligne*30+90,10,2);

		secondPinceau.fillRect(174+this.calcul.Composant_centre(this.colonne),this.ligne*30+80,10,2);
		secondPinceau.fillRect(178+this.calcul.Composant_centre(this.colonne),this.ligne*30+82,2,10);
	}

	//Elle prend ses arguments qu'elle écrit progressivement dans le fichier 
    public void partie_sauvegarde(TableauCache tab_cache,TableauVisible tab_visible, int l, int c) {
	try{    
	    FileWriter fw= new FileWriter("save.txt");
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write(Integer.toString(l));
	    bw.write("\n");
	    bw.write(Integer.toString(c));
	    bw.write("\n");
	    try{
		for(int i=0;i<l;i++){
		    for(int j=0;j<c;j++){
			bw.write(Integer.toString(tab_cache.getCase(i,j)));
			bw.write("\n");
		    }
		}
		for(int i=0;i<l;i++){
		    for(int j=0;j<c;j++){
			bw.write(Integer.toString(tab_visible.getCase(i,j)));
			bw.write("\n");
		    }
		}
	    }catch(IOException e){
		System.out.println("Erreur d'ecriture");
	    }
	    try{
		bw.close();
	    }catch(IOException e){
		System.out.println("Erreur de fermeture");
	    }
	}catch(IOException e){
	    System.out.println("Erreur d'ouverture");
	}
     }
}
