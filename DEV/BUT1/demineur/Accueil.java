import javax.swing.JComponent;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Accueil extends JComponent /*implements MouseListener*/{
	
//Instalation des images dans le code pour pouvoir les utilisés		
	private Image fond;
	private Image b1;
	private Image b2;
	private Image b3;
	private Image titre;

//Préparation des variable pour l'utilisation de la souris
  	public static final int BUTTON1 = 1;
  	public static final int BUTTON3 = 3;



//Création des variables avec des images pour pouvoir les appelers
	public Accueil(){
		super();
		this.fond = Toolkit.getDefaultToolkit().getImage("fond.png");
		this.b1 = Toolkit.getDefaultToolkit().getImage("bombe.png");
		this.b2 = Toolkit.getDefaultToolkit().getImage("bombe1.png");
		this.b3 = Toolkit.getDefaultToolkit().getImage("bombe2.png");
		this.titre = Toolkit.getDefaultToolkit().getImage("Titre.png");

	}

//Préparation de la page (décor,bouton)
	@Override
	protected void paintComponent(Graphics pinceau) {

		Graphics aPinceau = pinceau.create();
 

		if (this.isOpaque()) {
			aPinceau.setColor(this.getBackground());
			aPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
//Le fond de la page
		aPinceau.drawImage(this.fond,0,0,1950,1300,this);
  //Bouton nouvelle partie
		aPinceau.setColor(new Color(170,170,170));
		aPinceau.fillRect(140,150,200,70);
		aPinceau.setColor(Color.BLACK);
 		aPinceau.drawRect(140,150,200,70);
		aPinceau.drawString("Nouvelle Partie",148,172);
		aPinceau.drawImage(this.b1,280,160,60,60,this);
  //Bouton reprendre partie
		aPinceau.setColor(new Color(170,170,170));
		aPinceau.fillRect(360,150,200,70);
		aPinceau.setColor(Color.BLACK);
		aPinceau.drawRect(360,150,200,70);
		aPinceau.drawString("Reprendre Partie",364,172);
		aPinceau.drawImage(this.b2,500,160,60,60,this);
  //Bouton quitter le jeu
		aPinceau.setColor(new Color(170,170,170));
		aPinceau.fillRect(580,150,200,70);
		aPinceau.setColor(Color.BLACK);
		aPinceau.drawRect(580,150,200,70);
		aPinceau.drawString("Quitter le Jeu",587,172);
		aPinceau.drawImage(this.b3,720,160,60,60,this);
  //Titre du jeu
        aPinceau.drawRect(369,49,181,61);
		aPinceau.drawImage(this.titre,370,50,180,60,this);

/*System.out.printl(getx()+" "+gety());*/
		
		}
	}
