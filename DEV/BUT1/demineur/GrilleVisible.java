import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;
import java.lang.Object;
import java.awt.Font; 
//La classe GrilleVisible affiche la grille avec les marqueurs
public class GrilleVisible extends JComponent{
  int ligne;
  int colonne;
  int x_grille;
  int y_grille;
    TableauCache tab_cache;
    int pos_x;
    int pos_y;
  public GrilleVisible(int l,int c,TableauCache tab,int x,int y){
    this.ligne=l;
    this.colonne=c;
    this.tab_cache=tab;
    this.x_grille=x;
    this.y_grille=y;
    
  }
    @Override
    protected void paintComponent(Graphics pinceau) {
	Graphics secondPinceau = pinceau.create();
	int i,j,k,l;
	int[][] tab2=new int[this.ligne][this.colonne];
	for(i=0;i<this.ligne;i++){
	    for(j=0;j<this.colonne;j++){
	      tab2[i][j] = this.tab_cache.getCase(i,j);
	  }
      }
      for(k=0;k<this.ligne;k++){
	  for(l=0;l<this.colonne;l++){
	      if(tab2[k][l]==1 || tab2[k][l]==2 || tab2[k][l]==3 || tab2[k][l]==4 || tab2[k][l]==5){
	      }
	      this.pos_x=l*30+x_grille;
	      this.pos_y=k*30+y_grille;
	      if(tab2[k][l]==2){
		  secondPinceau.setColor(Color.BLACK);
		  secondPinceau.fillRect(this.pos_x+12,this.pos_y,5,5);
		  secondPinceau.fillRect(this.pos_x+10,this.pos_y+5,10,5);
		  secondPinceau.fillRect(this.pos_x,this.pos_y+10,30,5);
		  secondPinceau.fillRect(this.pos_x+5,this.pos_y+15,20,5);
		  secondPinceau.fillRect(this.pos_x,this.pos_y+20,10,5);
		  secondPinceau.fillRect(this.pos_x+20,this.pos_y+20,10,5);
		  secondPinceau.fillRect(this.pos_x,this.pos_y+25,5,5);
		  secondPinceau.fillRect(this.pos_x+25,this.pos_y+25,5,5);
	      }
	      if(tab2[k][l]==3){
		  secondPinceau.setColor(Color.LIGHT_GRAY);
		  secondPinceau.fillRect(this.pos_x+9,this.pos_y,5,10);
		  secondPinceau.fillRect(this.pos_x+14,this.pos_y,5,5);
		  secondPinceau.fillRect(this.pos_x+19,this.pos_y,5,15);
		  secondPinceau.fillRect(this.pos_x+14,this.pos_y+10,5,10);
		  secondPinceau.fillRect(this.pos_x+14,this.pos_y+25,5,5);
	      }
	      if(tab2[k][l]==4){
	      		      secondPinceau.setColor(Color.GRAY);
	      secondPinceau.fillRect(this.pos_x,this.pos_y,30,30);
		  secondPinceau.setColor(Color.BLACK);
		  secondPinceau.fillRect(this.pos_x+12,this.pos_y,5,5);
		  secondPinceau.fillRect(this.pos_x+10,this.pos_y+5,10,5);
		  secondPinceau.fillRect(this.pos_x,this.pos_y+10,30,5);
		  secondPinceau.fillRect(this.pos_x+5,this.pos_y+15,20,5);
		  secondPinceau.fillRect(this.pos_x,this.pos_y+20,10,5);
		  secondPinceau.fillRect(this.pos_x+20,this.pos_y+20,10,5);
		  secondPinceau.fillRect(this.pos_x,this.pos_y+25,5,5);
		  secondPinceau.fillRect(this.pos_x+25,this.pos_y+25,5,5);
		  secondPinceau.setColor(Color.RED);
		  secondPinceau.fillRect(this.pos_x+4,this.pos_y+3,5,5);
		  secondPinceau.fillRect(this.pos_x+4,this.pos_y+23,5,5);
		  secondPinceau.fillRect(this.pos_x+9,this.pos_y+8,5,5);
		  secondPinceau.fillRect(this.pos_x+9,this.pos_y+18,5,5);
		  secondPinceau.fillRect(this.pos_x+14,this.pos_y+13,5,5);
		  secondPinceau.fillRect(this.pos_x+19,this.pos_y+8,5,5);
		  secondPinceau.fillRect(this.pos_x+19,this.pos_y+18,5,5);
		  secondPinceau.fillRect(this.pos_x+24,this.pos_y+3,5,5);
		  secondPinceau.fillRect(this.pos_x+24,this.pos_y+23,5,5);
	      }
	      if(tab2[k][l]==5){
	      secondPinceau.setColor(Color.GRAY);
	      secondPinceau.fillRect(this.pos_x,this.pos_y,30,30);
		  secondPinceau.setColor(Color.LIGHT_GRAY);
		  secondPinceau.fillRect(this.pos_x+9,this.pos_y,5,10);
		  secondPinceau.fillRect(this.pos_x+14,this.pos_y,5,5);
		  secondPinceau.fillRect(this.pos_x+19,this.pos_y,5,15);
		  secondPinceau.fillRect(this.pos_x+14,this.pos_y+10,5,10);
		  secondPinceau.fillRect(this.pos_x+14,this.pos_y+25,5,5);
		  secondPinceau.setColor(Color.RED);
		  secondPinceau.fillRect(this.pos_x+4,this.pos_y+3,5,5);
		  secondPinceau.fillRect(this.pos_x+4,this.pos_y+23,5,5);
		  secondPinceau.fillRect(this.pos_x+9,this.pos_y+8,5,5);
		  secondPinceau.fillRect(this.pos_x+9,this.pos_y+18,5,5);
		  secondPinceau.fillRect(this.pos_x+14,this.pos_y+13,5,5);
		  secondPinceau.fillRect(this.pos_x+19,this.pos_y+8,5,5);
		  secondPinceau.fillRect(this.pos_x+19,this.pos_y+18,5,5);
		  secondPinceau.fillRect(this.pos_x+24,this.pos_y+3,5,5);
		  secondPinceau.fillRect(this.pos_x+24,this.pos_y+23,5,5);
	      }
	  }
      }
  }
}
