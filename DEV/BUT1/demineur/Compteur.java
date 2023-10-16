import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;
import java.lang.Object;
import java.awt.Font; 
//La classe Compteur gère le compteur du programme elle est appelée à chaque fois que l'on ajoute ou retire une étoile elle indique le nombre de mines restantes par rapport au nombre de marqueurs. elle prend le nombre de mines en argument et le nombre de colonnes de la grille 
public class Compteur extends JComponent{
    int compteur;
    int[] tab;
    Maths calcul;
    int colonne;
    public Compteur(int c,int col){
    this.compteur=c;
    this.tab = new int[4];
    this.calcul = new Maths();
    this.colonne=col;
  }

   //elle implémente un JComponent pour pouvoir dessiner, elle peut dessiner 11 ensembles différents, cela dépend du nombre de mines  et du nombre de marqueurs
  @Override
  protected void paintComponent(Graphics pinceau) {
		Graphics secondPinceau = pinceau.create();
		secondPinceau.setColor(Color.BLACK);
		secondPinceau.fillRect(0+this.calcul.Composant_centre(this.colonne),0,200,70);

		//affiche un moins devant le nombre si il est négatif
		if(this.compteur<0){
		secondPinceau.setColor(Color.RED);
		secondPinceau.fillRect(10+this.calcul.Composant_centre(this.colonne),30,30,10);
		}
		this.tab[3]=this.compteur%10;
		if(this.compteur<100 && this.compteur>-100){
			this.tab[1]=0;
			if(this.compteur<10 && this.compteur>0){
				this.tab[2]=0;
			}else{
			    this.tab[2]=this.compteur/10%10;
			}
		}else{
		  this.tab[2]=this.compteur/10%10;
			this.tab[1]=this.compteur/100;
		}
		for(int i=1;i<4;i++){
		secondPinceau.setColor(Color.RED);
		secondPinceau.fillRect(10+i*50+this.calcul.Composant_centre(this.colonne),10,30,50);
  	switch(this.tab[i]){

  		//Si le cas est 0 elle va dessiner le chiffre 0 en RED(rouge)
			case 0 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(20+i*50+this.calcul.Composant_centre(this.colonne),20,10,30);
			break;

			//Si le cas est 1 elle va dessiner le chiffre 1 en RED(rouge)
			case 1 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(10+i*50+this.calcul.Composant_centre(this.colonne),10,20,50);
			break;

			//Si le cas est 2 elle va dessiner le chiffre 2 en RED(rouge)
			case 2 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(10+i*50+this.calcul.Composant_centre(this.colonne),20,20,10);
			secondPinceau.fillRect(20+i*50+this.calcul.Composant_centre(this.colonne),40,20,10);
			break;

			//Si le cas est 3 elle va dessiner le chiffre 3 en RED(rouge)
			case 3 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(10+i*50+this.calcul.Composant_centre(this.colonne),20,20,10);
			secondPinceau.fillRect(10+i*50+this.calcul.Composant_centre(this.colonne),40,20,10);
			break;

			//Si le cas est 4 elle va dessiner le chiffre 4 en RED(rouge)
			case 4 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(20+i*50+this.calcul.Composant_centre(this.colonne),10,10,20);
			secondPinceau.fillRect(10+i*50+this.calcul.Composant_centre(this.colonne),40,20,20);
			break;

			//Si le cas est 5 elle va dessiner le chiffre 5 en RED(rouge)
			case 5 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(20+i*50+this.calcul.Composant_centre(this.colonne),20,20,10);
			secondPinceau.fillRect(10+i*50+this.calcul.Composant_centre(this.colonne),40,20,10);
			break;

			//Si le cas est 6 elle va dessiner le chiffre 6 en RED(rouge)
			case 6 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(20+i*50+this.calcul.Composant_centre(this.colonne),20,20,10);
			secondPinceau.fillRect(20+i*50+this.calcul.Composant_centre(this.colonne),40,10,10);
			break;

			//Si le cas est 7 elle va dessiner le chiffre 7 en RED(rouge)
			case 7 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(10+i*50+this.calcul.Composant_centre(this.colonne),20,20,40);
			break;

			//Si le cas est 8 elle va dessiner le chiffre 8 en RED(rouge)
			case 8 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(20+i*50+this.calcul.Composant_centre(this.colonne),20,10,10);
			secondPinceau.fillRect(20+i*50+this.calcul.Composant_centre(this.colonne),40,10,10);
			break;

			//Si le cas est 9 elle va dessiner le chiffre 9 en RED(rouge)
			case 9 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(20+i*50+this.calcul.Composant_centre(this.colonne),20,10,10);
			secondPinceau.fillRect(10+i*50+this.calcul.Composant_centre(this.colonne),40,20,10);
			break;

			//Si le cas est -1 elle va dessiner le chiffre 1 en RED(rouge)
			case -1 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(10+i*50+this.calcul.Composant_centre(this.colonne),10,20,50);
			break;

			//Si le cas est -2 elle va dessiner le chiffre 2 en RED(rouge)
			case -2 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(10+i*50+this.calcul.Composant_centre(this.colonne),20,20,10);
			secondPinceau.fillRect(20+i*50+this.calcul.Composant_centre(this.colonne),40,20,10);
			break;

			//Si le cas est -3 elle va dessiner le chiffre 3 en RED(rouge)
			case -3 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(10+i*50+this.calcul.Composant_centre(this.colonne),20,20,10);
			secondPinceau.fillRect(10+i*50+this.calcul.Composant_centre(this.colonne),40,20,10);
			break;

			//Si le cas est -4 elle va dessiner le chiffre 4 en RED(rouge)
			case -4 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(20+i*50+this.calcul.Composant_centre(this.colonne),10,10,20);
			secondPinceau.fillRect(10+i*50+this.calcul.Composant_centre(this.colonne),40,20,20);
			break;

			//Si le cas est -5 elle va dessiner le chiffre 5 en RED(rouge)
			case -5 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(20+i*50+this.calcul.Composant_centre(this.colonne),20,20,10);
			secondPinceau.fillRect(10+i*50+this.calcul.Composant_centre(this.colonne),40,20,10);
			break;

			//Si le cas est -6 elle va dessiner le chiffre 6 en RED(rouge)
			case -6 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(20+i*50+this.calcul.Composant_centre(this.colonne),20,20,10);
			secondPinceau.fillRect(20+i*50+this.calcul.Composant_centre(this.colonne),40,10,10);
			break;

			//Si le cas est -7 elle va dessiner le chiffre 7 en RED(rouge)
			case -7 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(10+i*50+this.calcul.Composant_centre(this.colonne),20,20,40);
			break;

			//Si le cas est -8 elle va dessiner le chiffre 8 en RED(rouge)
			case -8 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(20+i*50+this.calcul.Composant_centre(this.colonne),20,10,10);
			secondPinceau.fillRect(20+i*50+this.calcul.Composant_centre(this.colonne),40,10,10);
			break;

			//Si le cas est -9 elle va dessiner le chiffre 9 en RED(rouge)
			case -9 :
			secondPinceau.setColor(Color.BLACK);
			secondPinceau.fillRect(20+i*50+this.calcul.Composant_centre(this.colonne),20,10,10);
			secondPinceau.fillRect(10+i*50+this.calcul.Composant_centre(this.colonne),40,20,10);
			break;
		}
		}
	}
    public void plus() {
	 this.compteur++;
     }
     public void moins() {
	 this.compteur--;
     }
    public int getCompteur(){
     	return compteur;
     }
}
