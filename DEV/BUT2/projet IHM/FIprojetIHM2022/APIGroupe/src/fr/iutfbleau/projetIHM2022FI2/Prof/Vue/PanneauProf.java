package fr.iutfbleau.projetIHM2022FI2.Prof.Vue;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class PanneauProf{
    private JPanel panneau;
    private CardLayout layout;
    private int longueur;
    private int hauteur; 
    private ArrayList<PageProf> p;
    public PanneauProf(int l, int h){
        this.p=new ArrayList<PageProf>();
        this.longueur=l;
        this.hauteur=h;
        this.panneau = new JPanel();
        //this.panneau.setPreferredSize(new Dimension(1200,900));
        this.layout = new CardLayout();
        this.panneau.setLayout(this.layout);

        createPanel(0);
        createPanel(1);
        createPanel(2);
    }
    public void createPanel(int dif) {
        PageProf page = new PageProf(this,this.panneau,dif,this.longueur,this.hauteur);
        this.p.add(page);
        this.panneau.add(p.get(dif).getScroll());
    }
    public JPanel getPanneau(){
        return this.panneau;
    }
    public CardLayout getLayout(){
        return this.layout;
    }
    public PageProf getP(int dif){
        return this.p.get(dif);
    }
}
