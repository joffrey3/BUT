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

//La classe Fenetre est la base de tout le démineur il suffit de l'appeler pour construire le démineur
//elle hérite de la classe JFrame car il est necessaire d'ouvrir une fenetre pour voir le démineur
public class Fenetre extends JFrame implements MouseListener {

	int ligne;
  	int colonne;
  	int x_mine;
  	int y_mine;
  	int x_grille;
  	int y_grille;
    GrilleCache test4;
    GrilleVisible test3;
    boolean fin;
    Compteur compte;
	int compteur;
    SaveAndQuit sauvegarde;
    Maths calcul;
    public static final int BUTTON1 = 1;
	public static final int BUTTON3 = 3;
    public Fenetre (int l,int c,int mine) {
	this.fin=false;
	this.ligne=l;
	this.colonne=c;
	this.x_mine=-1;
	this.y_mine=-1;
	this.calcul= new Maths();
	this.x_grille=this.calcul.Grille_centre(this.colonne);
	this.y_grille=70;
  	this.test4 = new GrilleCache(l,c,mine,this.x_grille,this.y_grille);
	this.test3 = new GrilleVisible(this.ligne,this.colonne,this.test4.tab_cache,this.x_grille,this.y_grille);
	this.compte = new Compteur(mine,this.colonne);
	this.compteur=mine;
	this.sauvegarde= new SaveAndQuit(this.ligne,this.colonne);
	setLocation(0, 0);
	setSize(this.calcul.Fenetre_taille(this.colonne),140+this.ligne*30);
	Dimension size = new Dimension(this.calcul.Fenetre_taille(this.colonne),140+this.ligne*30);
	setMinimumSize(size);
	setMaximumSize(size);
	setPreferredSize(size);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.addMouseListener(this);
	this.test4.setSize(1000,1000);
	this.test4.setLocation(0,0);
	this.test3.setSize(1000,1000);
	this.test3.setLocation(0,0);
	this.compte.setSize(1000,70);
	this.compte.setLocation(0,0);
	this.sauvegarde.setSize(200,32);
	this.sauvegarde.setLocation(0,0);
	this.add(this.test4);
	this.add(this.test3);
	this.add(this.compte);
	this.add(this.sauvegarde);
	setVisible(true);

}
    //Le deuxieme constructeur de la classe est sensiblement identique donc nous n'allons aborder que les changements de celui ci
    //Cela passe principalement par la définition des attributs pour surcharger la classe
    //On retrouve dans celui ci, le nombre de lignes, le nombre de colonnes, le nombre de mines auquel on ajoute cette fois un objet TableauCache et un objet TableauVisible qui seront définis dans leurs fichiers respectifs 
    public Fenetre (int l,int c,int mine,TableauCache tab_c,TableauVisible tab_v) {
		this.fin=false;
		this.ligne=l;
		this.colonne=c;
		this.x_mine=-1;
		this.y_mine=-1;
		this.calcul= new Maths();
		this.x_grille=this.calcul.Grille_centre(this.colonne);
		this.y_grille=70;
  		this.test4 = new GrilleCache(l,c,mine,this.x_grille,this.y_grille,tab_c,tab_v);
		this.test3 = new GrilleVisible(this.ligne,this.colonne,tab_c,this.x_grille,this.y_grille);
		int etoile=0;
		for(int i=0;i<this.ligne;i++){
			for(int j=0;j<this.colonne;j++){
				if (this.test4.tab_cache.getCase(i,j)==2){
					etoile++;
				}
			}
		}
		this.compte = new Compteur(mine-etoile,this.colonne);
		this.compteur=mine-etoile;
		this.sauvegarde= new SaveAndQuit(this.ligne,this.colonne);
  		//this.panneau = new JPanel();
		setLocation(0, 0);
		setSize(this.calcul.Fenetre_taille(this.colonne),140+this.ligne*30);
		Dimension size = new Dimension(this.calcul.Fenetre_taille(this.colonne),140+this.ligne*30);
		setMinimumSize(size);
		setMaximumSize(size);
		setPreferredSize(size);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		this.addMouseListener(this);
		this.test4.setSize(1000,1000);
		this.test4.setLocation(0,0);
		this.test3.setSize(1000,1000);
		this.test3.setLocation(0,0);
		this.compte.setSize(1000,70);
		this.compte.setLocation(0,0);
		this.sauvegarde.setSize(200,32);
		this.sauvegarde.setLocation(0,0);
		for(int i=0;i<this.ligne;i++){
			for(int j=0;j<this.colonne;j++){
				if (this.test4.tab_cache.getCase(i,j)==0){
					RevelerCase(i,j);
				}
			}
		}
		this.add(this.test3);
		this.add(this.test4);
		this.add(this.compte);
		this.add(this.sauvegarde);
		setVisible(true);

}
    
	@Override
	public void mouseClicked(MouseEvent evenement){
		if(!this.fin){
		    if(evenement.getX()>0+this.calcul.Composant_centre(this.colonne) && evenement.getX()<200+this.calcul.Composant_centre(this.colonne) && evenement.getY()>100+this.ligne*30 && evenement.getY()<132+this.ligne*30){
		        this.sauvegarde.partie_sauvegarde(this.test4.tab_cache,this.test4.tab_visible,this.ligne,this.colonne);
			this.setVisible(false);
		    }else if(evenement.getX()>0 && evenement.getX()<this.colonne*30+this.x_grille && evenement.getY()>100 && evenement.getY()<100+this.ligne*30){
			if(evenement.getButton()==BUTTON1){
			    for(int p=0;p<2;p++){
				this.RevelerCaseClick(((evenement.getX())-5-this.x_grille)/30,(evenement.getY()-this.y_grille)/30-1);
			    }
			    this.PotentielVictoire();
			}
			else if(evenement.getButton()==BUTTON3){
			    this.MarquerCaseClick((evenement.getX()-5-this.x_grille)/30,(evenement.getY()-this.y_grille)/30-1);
			}
		    }
		}
	}
	@Override
	public void mouseEntered(MouseEvent evenement){

	}
	@Override
	public void mouseExited(MouseEvent evenement){

	}
	@Override
	public void mousePressed(MouseEvent evenement){

	}
	@Override
	public void mouseReleased(MouseEvent evenement){

	}
	public void RevelerCaseClick(int y,int x){
	    if(this.test4.tab_cache.getCase(x,y)!=2 && this.test4.tab_cache.getCase(x,y)!=3){
			this.test4.RevelerTableauCache(x,y);
			this.test4.RevelerTableauVisible(x,y);
			switch(this.test4.getNumberVisible(x,y)){
			case 0 : this.AjouterSymboleVisible(x,y,0);
			break;
			case 1 : this.AjouterSymboleVisible(x,y,1);
			break;
			case 2 : this.AjouterSymboleVisible(x,y,2);
			break;
			case 3 : this.AjouterSymboleVisible(x,y,3);
			break;
			case 4 : this.AjouterSymboleVisible(x,y,4);
			break;
			case 5 : this.AjouterSymboleVisible(x,y,5);
			break;
			case 6 : this.AjouterSymboleVisible(x,y,6);
			break;
			case 7 : this.AjouterSymboleVisible(x,y,7);
			break;
			case 8 : this.AjouterSymboleVisible(x,y,8);
			break;
			case 9 : 
			this.x_mine=x;
			this.y_mine=y;
			this.AjouterSymboleMineVisible(x,y,1);
			break;
			}
			if(this.test4.getNumberVisible(x,y)==0){
			    this.ConditionCasesAutour(x,y);
			}
			if(this.test4.getNumberVisible(x,y)==9){
				this.FinPerduDuProgramme();
			}
			this.setVisible(true);

	    }
	}
	public void RevelerCase(int x,int y){
			this.test4.RevelerTableauCache(x,y);
			this.test4.RevelerTableauVisible(x,y);
			switch(this.test4.getNumberVisible(x,y)){
			case 0 : this.AjouterSymboleVisible(x,y,0);
			break;
			case 1 : this.AjouterSymboleVisible(x,y,1);
			break;
			case 2 : this.AjouterSymboleVisible(x,y,2);
			break;
			case 3 : this.AjouterSymboleVisible(x,y,3);
			break;
			case 4 : this.AjouterSymboleVisible(x,y,4);
			break;
			case 5 : this.AjouterSymboleVisible(x,y,5);
			break;
			case 6 : this.AjouterSymboleVisible(x,y,6);
			break;
			case 7 : this.AjouterSymboleVisible(x,y,7);
			break;
			case 8 : this.AjouterSymboleVisible(x,y,8);
			break;
			case 9 : 
			if (this.x_mine==x && this.y_mine==y){
				this.AjouterSymboleMineVisible(x,y,1);
			}else{
				this.AjouterSymboleMineVisible(x,y,2);
			}
			break;
			}
			if(this.test4.getNumberVisible(x,y)==0){
			    this.ConditionCasesAutour(x,y);
			}
			this.setVisible(true);

	}
	public void MarquerCaseClick(int y,int x){
	    if(this.test4.tab_cache.getCase(x,y)!=0){
		int nombre=this.test4.AppliquerTableauCache(x,y);
		if(this.test4.tab_cache.getCase(x,y)==2){
		    this.compte.moins();
		}
		if(this.test4.tab_cache.getCase(x,y)==3){
		    this.compte.plus();
		}
		this.MarquerCase(x,y,nombre);
		this.setVisible(true);
	    }
	}
    public void MarquerCase(int x, int y, int nombre){
	this.test4.tab_cache.setCase(x,y,nombre);
	this.test3=new GrilleVisible(this.ligne,this.colonne,this.test4.tab_cache,this.x_grille,this.y_grille);
	this.add(this.compte);
	this.add(this.test4);
	this.add(this.test3);
	}
	public void AjouterSymboleVisible(int x,int y,int v){
		SymboleVisible symbole = new SymboleVisible(x,y,v,this.x_grille,this.y_grille);
		this.add(this.test3);
	        this.add(this.test4);
		this.add(symbole);
	}
	public void AjouterSymboleMineVisible(int x,int y,int v){
		SymboleMineVisible symbole = new SymboleMineVisible(x,y,v,this.x_grille,this.y_grille);
		this.add(this.test3);
	        this.add(this.test4);
		this.add(symbole);
	}
		public void ConditionCasesAutour(int x,int y){
		if(x==0 && y==0){
			this.RevelerCasesAutour(x,y,0,1,0,1);
		}
		else if(x==0 && y==this.colonne-1){
			this.RevelerCasesAutour(x,y,0,1,-1,0);
		}
		else if(x==this.ligne-1 && y==0){
			this.RevelerCasesAutour(x,y,-1,0,0,1);
		}
		else if(x==this.ligne-1 && y==this.colonne-1){
			this.RevelerCasesAutour(x,y,-1,0,-1,0);
		}
		else if(x==0){
			this.RevelerCasesAutour(x,y,0,1,-1,1);
		}
		else if(y==0){
			this.RevelerCasesAutour(x,y,-1,1,0,1);
		}
		else if(x==this.ligne-1){
			this.RevelerCasesAutour(x,y,-1,0,-1,1);
		}
		else if(y==this.colonne-1){
			this.RevelerCasesAutour(x,y,-1,1,-1,0);
		}
		else{
			this.RevelerCasesAutour(x,y,-1,1,-1,1);
		}
	}

	public void RevelerCasesAutour(int x,int y,int inf_1,int sup_1,int inf_2,int sup_2){
		for(int k=inf_1;k<=sup_1;k++){
			for(int l=inf_2;l<=sup_2;l++){
			    if(this.test4.getNumberCache(x+k,y+l)==1){
					this.RevelerCase(x+k,y+l);
					this.RevelerCase(x+k,y+l);
				}
			}
		}
	}
	public void FinPerduDuProgramme(){
	for(int i=0;i<this.ligne;i++){
			for(int j=0;j<this.colonne;j++){
				if(this.test4.tab_visible.getCase(i,j)==9){
				    if(this.test4.tab_cache.getCase(i,j)==1){
						this.RevelerCase(i,j);
						this.RevelerCase(i,j);
					}
				}
				if(this.test4.tab_cache.getCase(i,j)==2){
				    if(this.test4.tab_visible.getCase(i,j)!=9){
					this.MarquerCase(i,j,4);
					this.MarquerCase(i,j,4);
				    }
				}
				if(this.test4.tab_cache.getCase(i,j)==3){
				    if(this.test4.tab_visible.getCase(i,j)!=9){
					this.MarquerCase(i,j,5);
					this.MarquerCase(i,j,5);
				    }
				}
			}
		}
		this.RevelerCase(this.x_mine,this.y_mine);
		this.RevelerCase(this.x_mine,this.y_mine);
		Find perdre= new Find();
		this.fin=true;
	}
    public void PotentielVictoire(){
	boolean flag=true;
	for(int i=0;i<this.ligne;i++){
	    for(int j=0;j<this.colonne;j++){
		if(this.test4.tab_visible.getCase(i,j)!=9){
		    if(this.test4.tab_cache.getCase(i,j)!=0){
		        flag=false;
		    }
		}
	    }
	}
	if(flag){
	    this.FinGagneDuProgramme();
	}
    }
    public void FinGagneDuProgramme(){
	for(int i=0;i<this.ligne;i++){
	    for(int j=0;j<this.colonne;j++){
		if(test4.tab_visible.getCase(i,j)==9){
		    if(test4.tab_cache.getCase(i,j)==1){
			int nombre=this.test4.AppliquerTableauCache(i,j);
		    }
		    if(test4.tab_cache.getCase(i,j)==3){
			int nombre=this.test4.AppliquerTableauCache(i,j);
			int nombre2=this.test4.AppliquerTableauCache(i,j);
		    }
		}
	    }
	}
	Finv gagne= new Finv();
	this.fin=true;
    }
}
