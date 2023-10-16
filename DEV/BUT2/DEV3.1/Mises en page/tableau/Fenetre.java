import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.*;

public class Fenetre{
    public Fenetre(String[] tab1,int max,String[][] tab3){
	JFrame fenetre = new JFrame();
	fenetre.setSize(300,300);
	fenetre.setLocation(0,0);
	System.out.println(max);
	System.out.println(tab1.length);
	GridBagLayout gestionnaire =new GridBagLayout();
	GridBagConstraints cont = new GridBagConstraints();
	fenetre.setLayout(gestionnaire);
	Border contour = BorderFactory.createLineBorder(Color.BLACK);
	
	for(int i=0;i<tab1.length;i++){
	    int temp=0;
	    for(int j=0;j<max;j++){
		System.out.println(tab3[i][j]);
		if(tab3[i][j]!=null){
		    temp=temp+1;
		    JLabel texte = new JLabel(tab3[i][j]);
		    cont.gridx = 1;
		    cont.gridy = i*max+j;
		    cont.gridwidth = 1;
		    cont.gridheight = 1;
		    cont.fill = GridBagConstraints.NONE;
		    cont.anchor = GridBagConstraints.CENTER;
		    cont.insets = contour.getBorderInsets(texte);
		    cont.weightx = 1.0;
		    cont.weighty = 1.0;
			texte.setBorder(contour);
		    fenetre.add(texte, cont);
		}
	    }
	    JLabel texte2 = new JLabel(tab1[i]);
	    cont.gridx = 0;
	    cont.gridy = i*max;
	    cont.gridwidth = 1;
	    cont.gridheight = temp;
	    cont.fill = GridBagConstraints.NONE;
	    cont.anchor = GridBagConstraints.CENTER;
	    cont.insets =  new Insets(10,10,10,10);
	    cont.weightx = 1.0;
	    cont.weighty = 1.0;
		texte2.setBorder(contour);
	    fenetre.add(texte2, cont);
	    }
	cont.gridx = 1;
	cont.gridy = 1;
	cont.gridwidth = 1;
	cont.gridheight = 1;
	cont.fill = GridBagConstraints.NONE;
	cont.anchor = GridBagConstraints.CENTER;
	cont.insets =  new Insets(10,10,10,10);
	cont.weightx = 1.0;
	cont.weighty = 1.0;
	fenetre.setVisible(true);
    }
}
