import javax.swing.JComponent;
import java.awt.*;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;

public class Mine extends JComponent{

	public int[][] MinerTableau(int ligne, int colonne,int mine) {

//conversion ses args en int
        //a=ligne b=colonne c=mine
		//String ligne = l;
		int a = ligne;
		//Integer.parseInt(ligne);
		//String colonne = c;
		int b = colonne;
		//Integer.parseInt(colonne);
		//String mine = m;
		int c = mine;
		//Integer.parseInt(mine);

//initialisation max et min des ramdom pour le placement des mines et du tableau
		int[][] tab = new int[a][b];
		int minm = 1;
		int maxm = a-1;
		int minm2 = 1;
		int maxm2 = b-1;
		int l = 0;
		int h = 0;
		int compteur =0;

//Remplisage du tableau
		for(l=0;l<a;l++){
			for(h=0;h<b;h++){
				tab[l][h]=0;
			}
		}

//vérification du nombre de mine par rapport au nombre de case libre et début du placement
		if(c <= a*b){

			for(int g=0;g<c;g++){
				Random random0 = new Random();
				int placementl = random0.nextInt(maxm + minm) + minm;
				random0.nextInt(placementl);

				Random random1 = new Random();
				int placementc = random1.nextInt(maxm2 + minm2) + minm2;
				random0.nextInt(placementc);
				placementl = placementl -1;
				placementc = placementc -1;
		  

				for(l=0;l<a;l++){
					for(h=0;h<b;h++){


						if(placementl==l && placementc==h){

                           if(tab[placementl][placementc]==9){
                           g--;
                           }else{
                              tab[l][h]=9;
                              compteur++;     
                           }
							

						}else{

				            
	
						}
					}
				}
			}

		} else {
			System.out.println("TROP DE MINE");

		}

//affiche dans le terminale la grille avec les mines
		/*for (int tour0=0;tour0<a;tour0++){
			System.out.println("");
			for (int tour1=0;tour1<b;tour1++){
				System.out.print(" "+tab[tour0][tour1]);
			}
		}


		System.out.println("");
		System.out.println(compteur);*/
		return tab;
	}
}