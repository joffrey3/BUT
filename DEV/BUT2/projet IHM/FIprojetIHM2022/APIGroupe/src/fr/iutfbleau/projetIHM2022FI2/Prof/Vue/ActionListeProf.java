package fr.iutfbleau.projetIHM2022FI2.Prof.Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ActionListeProf implements ActionListener{
    private CardLayout layout;
    private JPanel panneau;
    private int dif;
    private PageProf page;
    private ArrayList<JButton> listeBouton;
    private int pos;
    private JTextField recherche;
    public ActionListeProf(PageProf page,CardLayout l,JPanel p,int d, ArrayList<JButton> b,int i){
        this.layout=l;
        this.panneau=p;
        this.page=page;
        this.dif=d;
        this.listeBouton=b;
        this.pos=i;
        this.recherche=null;
    }
    public ActionListeProf(PageProf page,CardLayout l,JPanel p,int d, JTextField r){
        this.layout=l;
        this.panneau=p;
        this.page=page;
        this.dif=d;
        this.listeBouton=null;
        this.pos=0;
        this.recherche=r;
    }
    public void actionPerformed(ActionEvent e){
        if(this.dif==0){
            this.cas0(e);
        }
        if(this.dif==1){
            this.cas1(e);
        }
        if(this.dif==2){
            if(e.getSource()==this.recherche){
                this.cas3(e);
            }else{
                this.cas2(e);
            }
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
    public void cas3(ActionEvent e){
        this.page.getPremierPanneau().getP(2).getListe3().reafficher(this.recherche.getText());
    }
}