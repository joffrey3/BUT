package fr.iutfbleau.projetIHM2022FI2.Etu.Vue;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class PanneauEtu{
    private JPanel panneau;
    private CardLayout layout;
    private int longueur;
    private int hauteur; 
    private ArrayList<PageEtu> p;
    public PanneauEtu(int l, int h){
        this.p=new ArrayList<PageEtu>();
        this.longueur=l;
        this.hauteur=h;
        this.panneau = new JPanel();
        //this.panneau.setPreferredSize(new Dimension(1200,900));
        this.layout = new CardLayout();
        this.panneau.setLayout(this.layout);

        createPanel(0);
        createPanel(1);
        createPanel(2);
        createPanel(3);
        createPanel(4);
    }
    public void createPanel(int dif) {
        PageEtu page = new PageEtu(this,this.panneau,dif,this.longueur,this.hauteur);
        this.p.add(page);
        this.panneau.add(p.get(dif).getScroll());
    }
    public JPanel getPanneau(){
        return this.panneau;
    }
    public CardLayout getLayout(){
        return this.layout;
    }
    public PageEtu getP(int dif){
        return this.p.get(dif);
    }
}
