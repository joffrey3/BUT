import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import java.util.*;


public class Securite implements  ActionListener{
    JDialog protection;
    JLabel question;
    JButton oui;
    JButton non;
    public Securite(JFrame f){
	this.protection= new JDialog(f,true);
	this.protection.setSize(400,200);
	this.protection.setLocation(500,450);
	this.protection.setLayout(null);

	this.question = new JLabel("Voulez-vous vraiment fermer cette fenêtre ?");
	this.question.setLocation(50,10);
	this.question.setSize(1000,10);
	this.oui = new JButton("oui");
	this.oui.setLocation(100,50);
	this.oui.setSize(70,30);
	this.non = new JButton("non");
	this.non.setLocation(220,50);
	this.non.setSize(70,30);
	this.protection.add(this.question);
	this.protection.add(this.oui);
	this.protection.add(this.non);
	this.oui.addActionListener(this);
	this.non.addActionListener(this);
	this.protection.setVisible(true);
    }
    public void actionPerformed(ActionEvent e1){
	if(e1.getSource()==non){
	    Confirmation livre = new Confirmation();
	}
	this.protection.dispose();
    } 
}
