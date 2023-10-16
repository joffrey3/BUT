import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

public class PageOption extends JFrame implements ActionListener{ 

	private JFrame fenetre2;
	private JTextField zone01;
	private JTextField zone02;
    private JTextField zone03;
    private JFrame fenetre;

	public PageOption(JFrame f) {

//Page des proposition de choix
		this.fenetre = f;
		this.fenetre.setSize(1200,350);
		this.fenetre.setLocation(300,100);
		this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.fenetre.setTitle("Page Option");

		//Option message = new Option(fenetre,this);
		//	this.fenetre.add(message);
		//this.fenetre.setVisible(true);


      //Page des choix
		this.fenetre2 = new JFrame();
		this.fenetre2.setSize(200,250);
		this.fenetre2.setLocation(1000,350); 
		this.fenetre2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.fenetre2.setTitle("Entrez votre choix de taille");
		
//Création des texte et des petites zones de texte dans les options
		JButton bouton = new JButton("Commencer");
		JLabel text1 = new JLabel("Nb ligne");
		JLabel text2 = new JLabel("Nb colonne");
		JLabel text3 = new JLabel("Nb mine");
		this.zone01 = new JTextField();
		this.zone02 = new JTextField();
		this.zone03 = new JTextField();
		LimitJTextField limit1 = new LimitJTextField(2,zone01);
		LimitJTextField limit2 = new LimitJTextField(2,zone02);
		LimitJTextField limit3 = new LimitJTextField(3,zone03);


		 //Oblige les joeurs a mettre des chiffre dans le choix des mine,ligne,colonne
		zone01.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}}});

		zone02.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}}});

		zone03.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}}});


  //Mise en page des choix
		Color  couleur01 = new Color(170,170,170);
		Color  couleur02 = new Color(200,200,200);
		this.zone01.setBackground(couleur01);
		this.zone02.setBackground(couleur01);
		this.zone03.setBackground(couleur01);
		text1.setBounds(20,20,100,28);
		this.zone01.setBounds(20,40,100,20);
		text2.setBounds(20,70,100,28);
		this.zone02.setBounds(20,90,100,20);
		text3.setBounds(20,120,100,28);
		this.zone03.setBounds(20,140,100,20);
		bouton.setBackground(couleur01);
		bouton.setBounds(25,185,150,25);


		this.zone01.setDocument(limit1);
		this.zone02.setDocument(limit2);
		this.zone03.setDocument(limit3);


//Mise en page des choix
		this.fenetre2.setLayout(null);
		this.fenetre2.add(zone01);
		this.fenetre2.add(zone02);
		this.fenetre2.add(zone03);
		this.fenetre2.add(text1);
		this.fenetre2.add(text2);
		this.fenetre2.add(text3);
		this.fenetre2.add(bouton);
		this.fenetre2.setVisible(true);
		bouton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent evenement) {
	    Attention avertissement = new Attention(800,300);
	    JFrame erreur = new JFrame();
	    erreur.setSize(800,300);
	    erreur.setLocation(100,600);
	    erreur.add(avertissement);
	    try{
		int ent1=Integer.parseInt(this.zone01.getText());
		int ent2=Integer.parseInt(this.zone02.getText());
		int ent3=Integer.parseInt(this.zone03.getText());
		if(ent1>=4 && ent1<=30 && ent2>=4 && ent2<=30 && ent3>=1 && ent3<=ent1*ent2-1) {
		    Fenetre f = new Fenetre(ent1,ent2,ent3);
		    this.fenetre2.setVisible(false);
		    this.fenetre.setVisible(false);
		}else {
		    erreur.setVisible(true);
		}
	    }catch(NumberFormatException e){
		erreur.setVisible(true);
	    }
	}

//permet d'obliger le joueurs de mettre un nombre de caractére limité dans le choix des colonne, ligne et mine 
	class LimitJTextField extends PlainDocument {

		private int max;
		   //private JTextField zone;
		LimitJTextField(int max,JTextField zone) {
			super();
			this.max = max;
      //this.zone = zone;
		}


		public void insertString(int offset, String text, AttributeSet attr) throws BadLocationException {
			if (text == null)
				return;
			if ((getLength() + text.length()) <= this.max) {
				super.insertString(offset, text, attr);
			}
			

		}
	}
}
