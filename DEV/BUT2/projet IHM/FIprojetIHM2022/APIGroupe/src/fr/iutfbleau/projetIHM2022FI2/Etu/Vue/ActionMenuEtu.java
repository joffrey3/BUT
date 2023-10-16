package fr.iutfbleau.projetIHM2022FI2.Etu.Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionMenuEtu implements ActionListener{
    CardLayout layout;
    JButton bouton1;
    JButton bouton2;
    JButton bouton3;
    JButton bouton4;
    JPanel panel;
    PanneauEtu panneau;
    public ActionMenuEtu(CardLayout l,JButton b1, JButton b2, JButton b3, JButton b4, JPanel p,PanneauEtu page){
        this.panneau=page;
        this.layout=l;
        this.bouton1=b1;
        this.bouton2=b2;
        this.bouton3=b3;
        this.bouton4=b4;
        this.panel=p;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==this.bouton1){
            this.panneau.getP(0).getListe1().reafficher();
            this.layout.first(this.panel);
        }
        if(e.getSource()==this.bouton2){
            this.panneau.getP(1).getListe2().reafficher();
            this.layout.first(this.panel);
            this.layout.next(this.panel);
        }
        if(e.getSource()==this.bouton3){
            this.layout.last(this.panel);
            this.layout.previous(this.panel);
            this.layout.previous(this.panel);
        }
        if(e.getSource()==this.bouton4){
            this.layout.last(this.panel);
            this.layout.previous(this.panel);
        }
    }
}