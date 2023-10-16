import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Boutons implements WindowListener{
    JFrame fenetre;
    public Boutons(){
	this.fenetre = new JFrame();
	this.fenetre.setSize(300,300);
	this.fenetre.setLocation(0,0);
	
	GridBagLayout gestionnaire =new GridBagLayout();
	GridBagConstraints cont = new GridBagConstraints();
	this.fenetre.setLayout(gestionnaire);
	
	JButton bouton1 = new JButton("1");
	cont.gridx = 0;
	cont.gridy = 0;
	cont.gridwidth = 2;
	cont.gridheight = 1;
	cont.fill = GridBagConstraints.BOTH;
	cont.anchor = GridBagConstraints.CENTER;
	cont.insets = new Insets(0, 0, 0, 0);
	cont.weightx = 2.0;
	cont.weighty = 1.0;
	this.fenetre.add(bouton1, cont);
	
	JButton bouton2 = new JButton("2");
	cont.gridx = 2;
	cont.gridy = 0;
	cont.gridwidth = 1;
	cont.gridheight = 2;
	cont.fill = GridBagConstraints.BOTH;
	cont.anchor = GridBagConstraints.CENTER;
	cont.insets = new Insets(0, 0, 0, 0);
	cont.weightx = 1.0;
	cont.weighty = 2.0;
	this.fenetre.add(bouton2, cont);
	
	
	JButton bouton3 = new JButton("3");
	cont.gridx = 1;
	cont.gridy = 2;
	cont.gridwidth = 2;
	cont.gridheight = 1;
	cont.fill = GridBagConstraints.BOTH;
	cont.anchor = GridBagConstraints.CENTER;
	cont.insets = new Insets(0, 0, 0, 0);
	cont.weightx = 2.0;
	cont.weighty = 1.0;
	this.fenetre.add(bouton3, cont);
	
	JButton bouton4 = new JButton("4");
	cont.gridx = 0;
	cont.gridy = 1;
	cont.gridwidth = 1;
	cont.gridheight = 2;
	cont.fill = GridBagConstraints.BOTH;
	cont.anchor = GridBagConstraints.CENTER;
	cont.insets = new Insets(0, 0, 0, 0);
	cont.weightx = 1.0;
	cont.weighty = 2.0;
	this.fenetre.add(bouton4, cont);
	
	JButton bouton5 = new JButton("5");
	cont.gridx = 1;
	cont.gridy = 1;
	cont.gridwidth = 1;
	cont.gridheight = 1;
	cont.fill = GridBagConstraints.BOTH;
	cont.anchor = GridBagConstraints.CENTER;
	cont.insets = new Insets(0, 0, 0, 0);
	cont.weightx = 1.0;
	cont.weighty = 1.0;
	this.fenetre.add(bouton5, cont);
	this.fenetre.setVisible(true);
	this.fenetre.addWindowListener(this);
    }
    public void windowDeactivated(WindowEvent w1){
	
    }
    public void windowActivated(WindowEvent w2){
	
    }
    public void windowDeiconified(WindowEvent w3){
	
    }
    public void windowIconified(WindowEvent w4){
	
    }
    public void windowClosed(WindowEvent w5){
	this.fenetre.setVisible(true);
    }
    public void windowClosing(WindowEvent w6){
	String chaine = new String("Voulez-vous vraiment fermer cette fenêtre ?");
	String texte = new String ("Attention");
        int object=JOptionPane.showConfirmDialog(this.fenetre,chaine,texte,JOptionPane.YES_NO_OPTION);
	if(object==0){
	this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	if(object==1){
	this.fenetre.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
    }
    public void windowOpened(WindowEvent w7){
	
    } 
}
