import javax.swing.JComponent;
import java.awt.*;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
import java.util.EventObject;

public class Option extends JComponent implements MouseListener {

//Préparation des variable pour l'utilisation de la souris
	public static final int BUTTON1 = 1;
	public static final int BUTTON3 = 3;
	
//Instalation des images dans le code pour pouvoir les utiliser	
	private Image fond;
	private Image b1;
	private Image b2;
	private Image b3;
	private Image b4;
	private Image b5;
	private JFrame fenetre;
	private JFrame fenetre2;
	
//Création des variables avec des images pour pouvoir les appeler
    public Option(JFrame f,JFrame f2) {
		super();
		this.fond= Toolkit.getDefaultToolkit().getImage("fond.png");
		this.b1 = Toolkit.getDefaultToolkit().getImage("bombe.png");
		this.b2 = Toolkit.getDefaultToolkit().getImage("bombe1.png");
		this.b3 = Toolkit.getDefaultToolkit().getImage("bombe2.png");
		this.b4 = Toolkit.getDefaultToolkit().getImage("bombe3.png");
		this.b5 = Toolkit.getDefaultToolkit().getImage("bombe4.png");
		this.fenetre=f;
		this.fenetre2=f2;
		this.addMouseListener(this);
		this.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		if(e.getButton()==BUTTON1){
		//System.out.println(e.getX());
		//System.out.println(e.getY());
			if(e.getX()>=1120 && e.getX()<=1180 && e.getY()>=0 && e.getY()<=30){
			PageAccueil retour = new PageAccueil();
		 		this.fenetre.setVisible(false);
		  		this.fenetre2.setVisible(false);
				retour.setVisible(true);
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
	public static void main(String[] args) {
	}


//Préparation de la page (décor,bouton)
			@Override
			protected void paintComponent(Graphics pinceau) {

//Min et Max de la classe random
				Graphics aPinceau = pinceau.create();
				int minm = 1;
				int maxm = 4;

				if (this.isOpaque()) {
					aPinceau.setColor(this.getBackground());
					aPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
				}

//Le fond de la page et le dessin de bas de page
				aPinceau.drawImage(this.fond,0,0,1950,1300,this);
				aPinceau.setColor(new Color(170,170,170));
				aPinceau.fillRect(0,940,1940,90);
				aPinceau.setColor(Color.BLACK);
				aPinceau.drawRect(0,940,1940,90);

//Le ramdom permet juste de choisir quels décor sera en bas de page
				for(int i=0;i<5;i++) {
					Random random0 = new Random();
					int n = random0.nextInt(maxm + minm) + minm;
					random0.nextInt(n);

//ester egg en bas de la page
					switch(n){
						case 1: aPinceau.drawImage(this.b1,100+(400*i),940,100,100,this);
						break;
						case 2: aPinceau.drawImage(this.b2,100+(400*i),940,100,100,this);
						break;
						case 3: aPinceau.drawImage(this.b3,100+(400*i),940,100,100,this);
						break;
						case 4: aPinceau.drawImage(this.b4,100+(400*i),940,100,100,this);
						break;
						case 5: aPinceau.drawImage(this.b5,100+(400*i),940,100,100,this);

					}
				}

//Permet de faire apparaitre le choix de taille possible du démineur
				aPinceau.setColor(Color.RED);
				aPinceau.drawString("Nombre de ligne pour le démineur possible :",15,24);
				aPinceau.drawString("Nombre de colonne pour le démineur possible :",15,74);

	  //Régles du jeu	
				aPinceau.setColor(new Color(220,220,220));
				aPinceau.fillRect(40,130,500,170);
				aPinceau.setColor(Color.BLACK);
				aPinceau.drawRect(40,130,500,170);
				aPinceau.setColor(Color.RED);
				aPinceau.drawString("Régle:",45,145);
				aPinceau.setColor(Color.BLACK);
				aPinceau.drawString("Clic gauche révèle une case:",45,160);
				aPinceau.drawString("Clic droit permet a une case caché de changer de statut (Mine=  ★, Suspicion= ?)",45,175);
				aPinceau.drawString("But:",45,205);
				aPinceau.drawString("Ne pas déclancher les mines",45,220);
				aPinceau.drawString("Mettre des étoile sur toutes les mine",45,235);
				aPinceau.drawString("Déduire la position des mines avec les chiffres",45,250);
				aPinceau.drawString("Les chiffres indique le nombre de min sur les cases adjacentes",45,265);

//permet de faire apparaitre le choix de taille possible du démineur case par case
				for(int j=4;j<31;j++){
					aPinceau.setColor(new Color(220,220,220));
					aPinceau.fillRect((j*40)-120,30,30,30);
					aPinceau.setColor(Color.BLACK);
					aPinceau.drawString(""+j,(j*40)-110,50);
					aPinceau.drawRect((j*40)-120,30,30,30);

					aPinceau.setColor(new Color(220,220,220));
					aPinceau.fillRect((j*40)-120,80,30,30);
					aPinceau.setColor(Color.BLACK);
					aPinceau.drawString(""+j,(j*40)-110,100);
					aPinceau.drawRect((j*40)-120,80,30,30);

					aPinceau.setColor(Color.LIGHT_GRAY);
					aPinceau.fillRect(1120,0,60,30);
					aPinceau.setColor(Color.BLACK);
					aPinceau.drawString("Retour",1130,20);
				}
			}
		}


