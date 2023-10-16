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
//La classe ReturnAndContinue reprend le fichier save.txt et appelle la fenetre de la grille
public class  ReturnAndContinue{
    int ligne;
    int colonne;
    int compteur;
    public  ReturnAndContinue(){
	this.compteur=0;
  }

  //Elle lit dans le fichier et passe les informations dans des variables qui seront attributs de la fenetre
    public void partie_recharger() {
	try{    
	    FileReader fr= new FileReader("save.txt");
	    BufferedReader br = new BufferedReader(fr);
	    String l = br.readLine();
	    this.ligne=Integer.parseInt(l);
	    String c = br.readLine();
	    this.colonne=Integer.parseInt(c);
	    int[][] tab_c = new int[this.ligne][this.colonne];
	    int[][] tab_v = new int[this.ligne][this.colonne];
	    String chaine= "";
	    int liste;
	    try{
		for(int i=0;i<this.ligne;i++){
		    for(int j=0;j<this.colonne;j++){
			chaine = br.readLine();
			liste = Integer.parseInt(chaine);
			tab_c[i][j]=liste;
		    }
		}
		for(int i=0;i<this.ligne;i++){
		    for(int j=0;j<this.colonne;j++){
			chaine = br.readLine();
			liste = Integer.parseInt(chaine);
			tab_v[i][j]=liste;
			if (liste==9){
			    this.compteur++;
			}
		    }
		}
	    }catch(IOException e){
		System.out.println("Erreur d'ecriture");
	    }
	    try{
		br.close();
	    }catch(IOException e){
		System.out.println("Erreur de fermeture");
	    }
		TableauCache tab_cache = new TableauCache(this.ligne,this.colonne,tab_c);
		TableauVisible tab_visible = new TableauVisible(this.ligne,this.colonne,tab_v);
	  Fenetre f = new Fenetre(this.ligne,this.colonne,this.compteur,tab_cache,tab_visible);
	}catch(IOException e){
	    System.out.println("Erreur d'ouverture");
	}
     }
}
