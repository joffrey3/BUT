package fr.iutfbleau.projetIHM2022FI2.Etu.Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ActionListeEtu implements ActionListener{
    private CardLayout layout;
    private JPanel panneau;
    private int dif;
    private PageEtu page;
    private ArrayList<JButton> listeBouton;
    private int pos;
    public ActionListeEtu(PageEtu page,CardLayout l,JPanel p,int d, ArrayList<JButton> b,int i){
        this.layout=l;
        this.panneau=p;
        this.page=page;
        this.dif=d;
        this.listeBouton=b;
        this.pos=i;
    }
    public void actionPerformed(ActionEvent e){
        if(this.dif==0){
            this.cas0(e);
        }
        if(this.dif==1){
            this.cas1(e);
        }
        if(this.dif==2){
            this.cas2(e);
        }
    }
    public void cas0(ActionEvent e){
        this.page.getPremierPanneau().getP(1).getListe2().reafficher(this.listeBouton.get(this.pos).getText());
        this.layout.first(this.panneau);
        this.layout.next(this.panneau);
    }
    public void cas1(ActionEvent e){
        this.page.getPremierPanneau().getP(0).getListe1().reafficher(this.listeBouton.get(this.pos).getText());
        this.layout.first(this.panneau);
    }
    public void cas2(ActionEvent e){
        this.layout.first(this.panneau);
        for(int i=this.listeBouton.size()/3;i<this.listeBouton.size();i++){
            if(e.getSource()==this.listeBouton.get(i)){
                this.layout.next(this.panneau);
                this.page.getPremierPanneau().getP(1).getListe2().reafficher(this.listeBouton.get(this.pos).getText());
            }
        }
        for(int i=0;i<this.listeBouton.size()/3;i++){
            if(e.getSource()==this.listeBouton.get(i)){
                this.page.getPremierPanneau().getP(0).getListe1().reafficher(this.listeBouton.get(this.pos).getText());
            }
        }
    }
}