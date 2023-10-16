package fr.iutfbleau.projetIHM2022FI2.Etu.Vue;

import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MNP.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PageEtu{
    //JPanel panneau;
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    private JScrollPane scroll;
    private JPanel panel;
    private int dif;
    private int longueurFixe;
    private int hauteurFixe;
    private PanneauEtu premierPanneau;
    ListeGroupe liste1;
    ListeEtudiant liste2;
    ListeChangement liste3;
    public PageEtu(PanneauEtu panel,JPanel panneau,int d,int l,int h){
        this.premierPanneau=panel;
        this.longueurFixe=l;
        this.hauteurFixe=h;
        this.dif = d;
        this.layout = new GridBagLayout();
        this.gbc = new GridBagConstraints();
        this.panel = new JPanel();
        this.panel.setBackground(Color.GRAY);
        this.panel.setLayout(layout);
        this.scroll = new JScrollPane(this.panel);
        this.panel.setLocation(0,0);
        this.panel.setSize(this.scroll.getX(),this.scroll.getY());

        if(this.dif==0){
            this.listeGroupe();
        }
        if(this.dif==1){
            this.listeEtudiant();
        }
        if(this.dif==2){
            this.listeChangement();
        }
        if(this.dif==3){
            this.changement();
        }
        if(this.dif==4){
            this.validation();
        }
    }


    public void layoutOptions(int x, int y, int width, int height, int fill, int anchor, double weightx, double weighty,Insets insets) {
        this.gbc.gridx = x;
        this.gbc.gridy = y;
        this.gbc.gridwidth = width;
        this.gbc.gridheight = height;
        this.gbc.fill = fill;
        this.gbc.anchor = anchor;
        this.gbc.weightx = weightx;
        this.gbc.weighty = weighty;
        this.gbc.insets = insets;
    }

    public void creerVide(int x, int y) {
        JPanel espace = new JPanel();
        espace.setPreferredSize(new Dimension(this.longueurFixe/11,this.hauteurFixe/11));
        espace.setBackground(Color.GRAY);
        this.layoutOptions(x, y, 1, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0,new Insets(0, 0, 0, 0));
        this.panel.add(espace, this.gbc);
    }

    public JScrollPane getScroll(){
        return this.scroll;
    }
    public void listeGroupe(){
        this.liste1 = new ListeGroupe();
        this.liste1.ajouter(this,this.longueurFixe/8,this.hauteurFixe/11);
    }  
    public void listeEtudiant(){
        this.liste2 = new ListeEtudiant();
        this.liste2.ajouter(this,this.longueurFixe/4,this.hauteurFixe/11);
    }
    public void listeChangement(){
        this.liste3 = new ListeChangement();
        this.liste3.ajouter(this,this.longueurFixe/9,this.hauteurFixe/11);
    }
    public void changement(){
        DemandeEtu demande = new DemandeEtu(this,this.longueurFixe/11,this.hauteurFixe/11,this.getPremierPanneau().getP(2).getListe3());
        this.panel=demande.getPanel();
    }
    public void validation(){
       ValidationEtu valider = new ValidationEtu(this,this.longueurFixe/11,this.hauteurFixe/11);
       this.panel=valider.getPanel();
    } 
    public GridBagConstraints getGbc(){
        return this.gbc;
    }
    public GridBagLayout getLayout(){
        return this.layout;
    }
    public JPanel getPanel(){
        return this.panel;
    }
    public void setPanel(JPanel p){
        this.panel=p;
    }
    public int getDif(){
        return this.dif;
    }
    public ListeGroupe getListe1(){
        return this.liste1;
    }
    public ListeEtudiant getListe2(){
        return this.liste2;
    }
    public ListeChangement getListe3(){
        return this.liste3;
    }
    public PanneauEtu getPremierPanneau(){
        return this.premierPanneau;
    }
}
