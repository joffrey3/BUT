package fr.iutfbleau.projetIHM2022FI2.Admin.Vue;


import javax.swing.*;
import java.awt.*;
import fr.iutfbleau.projetIHM2022FI2.Admin.Controleur.*;

import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MNP.*;
import fr.iutfbleau.projetIHM2022FI2.MP.*;

public class VueAdmin {

    /**
     * Initialise l'interface d'admin en créant tous les panneaux et les placant
     * Et lance panlayout qui gère le panneau actif d'admin
     * Et lance Panjtree qui doit ajoute le jtree mais qui ne fonctionne pas
     * contient tous les boutons qui vont gérer panlayout
     * @param agf
     */
    public VueAdmin(AbstractGroupeFactory agf) {
        final int menuHorizontal = 300;
        final int menuVertical = 800;
        final int fenetreHorizontal = 1000;
        final int fenetreVertical = 1000;
        JFrame WindowsAdmin = new JFrame();
        this.absoluteSize(WindowsAdmin, fenetreHorizontal, fenetreVertical);
        GridLayout h = new GridLayout(5,1);
        GridLayout j = new GridLayout(2,1);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;
        JButton AddEtu = new JButton("Ajout d'etudiant");
        JButton CreeGroup = new JButton("Cree Groupe");
        JButton SupGroup = new JButton("Supprime groupe");
        JButton RenGroup = new JButton("renplacer groupe");
        JButton DepEtu = new JButton("deplacer etudiant");
        JPanel Titre = new JPanel();
        JLabel titre = new JLabel("Admnistrateur");
        Titre.add(titre,BorderLayout.CENTER);
        this.absoluteSize(Titre, 1000, 200);
        WindowsAdmin.setLayout(new GridBagLayout());
        Titre.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 0;
        c.ipady =0;
        c.gridwidth = 2;
        WindowsAdmin.add(Titre, c);
        JPanel Menu = new JPanel();
        this.absoluteSize(Menu,menuHorizontal,menuVertical);
        this.absoluteSize(AddEtu,menuHorizontal-50,menuVertical/5 - 50);
        this.absoluteSize(CreeGroup, menuHorizontal-50, menuVertical/5-50);
        this.absoluteSize(SupGroup, menuHorizontal-50, menuVertical/5 -50);
        this.absoluteSize(RenGroup, menuHorizontal-50, fenetreVertical/5-50);
        this.absoluteSize(DepEtu, menuHorizontal-50, menuVertical/5-50);
        Menu.setLayout(h);
        Menu.add(AddEtu);
        Menu.add(CreeGroup);
        Menu.add(SupGroup);
        Menu.add(RenGroup);
        Menu.add(DepEtu);
        JPanel affichage = new JPanel();
        this.absoluteSize(affichage, fenetreHorizontal - 300,fenetreVertical -300);
        Menu.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 0;
        c.ipady =0;
        c.gridwidth = 1;
        WindowsAdmin.add(Menu, c);

        affichage.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        c.gridx = 1;
        c.gridy = 1;
        c.ipadx = 0;
        c.ipady =0;

        affichage.setLayout(j);
        JPanel affgroup = new JPanel();
        affgroup.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        PanTree a = new PanTree(affgroup, agf);
        a.AffJTree(affgroup);
        affichage.add(affgroup);
        WindowsAdmin.add(affichage, c);
        JPanel instru = new JPanel();
        Pancardlayout l = new Pancardlayout(instru,agf);
        l.adPanel();
        instru.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        affichage.add(instru);


        ActionMenuAdmin i = new ActionMenuAdmin(AddEtu,CreeGroup,SupGroup,RenGroup,DepEtu,l,agf);
        AddEtu.addActionListener(i);
        CreeGroup.addActionListener(i);
        SupGroup.addActionListener(i);
        RenGroup.addActionListener(i);
        DepEtu.addActionListener(i);

        WindowsAdmin.setResizable(false);

        WindowsAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WindowsAdmin.setVisible(true);


    }

    public void absoluteSize(Component comp,int x,int y){
        comp.setSize(new Dimension(x,y));
        comp.setMinimumSize(new Dimension(x,y));
        comp.setPreferredSize(new Dimension(x,y));
        comp.setMaximumSize(new Dimension(x,y));
    }
}