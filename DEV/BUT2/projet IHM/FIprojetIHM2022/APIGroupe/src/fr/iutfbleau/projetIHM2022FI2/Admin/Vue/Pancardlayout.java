package fr.iutfbleau.projetIHM2022FI2.Admin.Vue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.Admin.Controleur.ActionAdminInstru;
import fr.iutfbleau.projetIHM2022FI2.MP.*;
import fr.iutfbleau.projetIHM2022FI2.MNP.*;


public class Pancardlayout extends JPanel {
    
    CardLayout card;
    JPanel instru,addetu,creegroup,supgroup,rengroup,depetu;
    String textaddetu,textcreegroup,textsupgroup,textrengroup,textdepetu;
    JLabel nometudiant,sousgroupe,newgroupe;
    JTextField etud,groupe,ngroupe;
    GridLayout j,g,h;
    JButton valaddetu,valcreegroup,valsupgroup,valrengroup,valdepetu;
    AbstractGroupeFactory agf;


/**
 * @param panel TODO
 * @param affichage
 * recupere la gestion du groupe et le panneau qui va integerer le cardlayout
 */
public Pancardlayout(JPanel instru,AbstractGroupeFactory agf){
    this.instru = instru;
    this.agf = agf;
}

    public void adPanel(){

        /**
         * initialistion des objets
         */
        valaddetu = new JButton("valider");
        valcreegroup = new JButton("valider");
        valsupgroup = new JButton("valider");
        valrengroup = new JButton("valider");
        valdepetu = new JButton("valider");
        addetu = new JPanel();
        creegroup = new JPanel();
        supgroup = new JPanel();
        rengroup = new JPanel();
        depetu = new JPanel();
        card = new CardLayout();
        instru.setLayout(card);

        /**
         * mise en place du panneau addetu
         */
        
        j = new GridLayout(5,1);
        addetu.setLayout(j);
        nometudiant = new JLabel("Nom d'etudiant : ");
        addetu.add(nometudiant);
        etud = new JTextField();
        addetu.add(etud);
        sousgroupe = new JLabel("nom du groupe :");
        addetu.add(sousgroupe);
        groupe = new JTextField();
        addetu.add(groupe);
        addetu.add(valaddetu);
        instru.add(addetu,"texaddetu");

        /**
         * Mise en place dupanneau sous groupe
         */

        g = new GridLayout(8,1);
        creegroup.setLayout(g);
        sousgroupe = new JLabel("nom du groupe :");
        creegroup.add(sousgroupe);
        groupe = new JTextField();
        creegroup.add(groupe);
        JLabel nummintext = new JLabel("nombre minimum d'etudiant :");
        creegroup.add(nummintext);
        JTextField nummin = new JTextField();
        creegroup.add(nummin);
        JLabel nummaxtext = new JLabel("nombre maximum d'etudiant :");
        creegroup.add(nummaxtext);
        JTextField nummax = new JTextField();
        creegroup.add(nummax);
        JCheckBox partition = new JCheckBox("partition");
        creegroup.add(partition);
        JTextField nbrpartition = new JTextField();
        creegroup.add(nbrpartition);
        creegroup.add(valcreegroup);
        instru.add(creegroup, "textcreegroup");

        //Mise en place supgroup

        supgroup.setLayout(g);
        sousgroupe = new JLabel("nom du groupe :");
        supgroup.add(sousgroupe);
        groupe = new JTextField();
        supgroup.add(groupe);
        supgroup.add(valsupgroup);
        instru.add(supgroup,"textsupgroup");

        //Mise en place rennomer groupe

        rengroup.setLayout(j);
        sousgroupe = new JLabel("nom du groupe :");
        rengroup.add(sousgroupe);
        groupe = new JTextField();
        rengroup.add(groupe);
        newgroupe = new JLabel("nom du nouveau groupe :");
        rengroup.add(newgroupe);
        ngroupe = new JTextField();
        rengroup.add(ngroupe);
        rengroup.add(valrengroup);
        instru.add(rengroup,"textrengroup");

        //Deplacer etudiant 


        h =  new GridLayout(7,1);
        depetu.setLayout(h);
        sousgroupe = new JLabel("nom du groupe actuel");
        depetu.add(sousgroupe);
        groupe = new JTextField();
        depetu.add(groupe);
        nometudiant = new JLabel("Nom d'etudiant : ");
        depetu.add(nometudiant);
        etud = new JTextField();
        depetu.add(etud);
        newgroupe = new JLabel("nom du nouveau groupe :");
        depetu.add(newgroupe);
        ngroupe = new JTextField();
        depetu.add(ngroupe);
        depetu.add(valdepetu);
        instru.add(depetu, "textdepetu");
        ActionAdminInstru j = new ActionAdminInstru(nummin, nummax, nbrpartition, partition, nummaxtext, nummintext, nummaxtext, valaddetu, valcreegroup, valsupgroup, valrengroup, valdepetu, agf);
        valcreegroup.addActionListener(j);
        valdepetu.addActionListener(j);
        valrengroup.addActionListener(j);
        valsupgroup.addActionListener(j);
        
    }

    /**
     * retourne le panneau
     * @return
     */
    public JPanel getPanel(){
        return this.instru;
    }


    /**
     * retourne le panneau pour addetu
     */
    public void getaddetu(){
        card.show(instru,"texaddetu");

    }

    /**
     * retourne le panneau pour cree un group
     */
    public void getcreegroup(){
        card.show(instru,"textcreegroup");

    }


    /**
     * retourne le panneau de suppression de groupe
     */
    public void getsupgroup(){
        card.show(instru,"textsupgroup");

    }

    /**
     * retourne le panneau pour renommer le groupe
     */
    public void getrengroup(){
        card.show(instru,"textrengroup");

    }

    /**
     * retourne
     */
    public void getdepetu(){
        card.show(instru,"textdepetu");
    }

    /**
     * retourne le pancardlayout
     * @return
     */
    public Pancardlayout getPancardlayout(){
        return this;
    }
}
