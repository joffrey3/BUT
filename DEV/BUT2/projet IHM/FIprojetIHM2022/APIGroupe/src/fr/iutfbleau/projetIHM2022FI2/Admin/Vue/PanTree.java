package fr.iutfbleau.projetIHM2022FI2.Admin.Vue;

import java.util.Set;

import javax.swing.*;
import javax.swing.event.*;

import javax.swing.tree.DefaultMutableTreeNode;



import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MP.*;
import fr.iutfbleau.projetIHM2022FI2.MNP.*;

public class PanTree implements TreeSelectionListener {

    private JPanel affgroup;
    private Groupe pere;
    private String nompere;
    private String nomfils;
    private Set<Groupe> allgroupe;
    AbstractGroupeFactory agf;
    String sousgroupe;
    /**
     * Cree pan tree qui recupere
     * le gestionnaire de groupe et le panneau qui va le contenir
     * @param affgroup
     * @param agf
     */
    public PanTree(JPanel affgroup,AbstractGroupeFactory agf){
        this.affgroup = affgroup;
        this.agf = agf;
    }

    /**
     * Initialise le jtree
     * @return
     */
    public JTree baseJTree(){
        pere = agf.getPromotion();
        nompere = pere.getName();
        DefaultMutableTreeNode racine = new DefaultMutableTreeNode(nompere);
        JTree arbre = new JTree(racine);
        this.addJtree(pere,racine);
        return arbre;

    }

    /**
     * cree toute les branches du jtree
     * @param pere
     * @param racine
     */
    public void addJtree(Groupe pere,DefaultMutableTreeNode racine){
        allgroupe = pere.getSousGroupes();
        for(Groupe fils : allgroupe){
            nomfils = fils.getName();
            DefaultMutableTreeNode branche = new DefaultMutableTreeNode(nomfils);
            racine.add(branche);
            if(fils.getSousGroupes() != null){
                racine = branche;
                pere=fils;
                this.addJtree(pere, racine);
            }
        }
    }

    /**
     * ajoute le jtree au panneau et l'initialise
     * @param affgroup
     */
    public void AffJTree(JPanel affgroup){
        JTree a =this.baseJTree();
        affgroup.add(a);
    }
    /**
     * met à jour le jtree
     * @param a
     */
    public void refreshTree(JTree a){
        a.updateUI();
        affgroup.add(a);
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {


        
    }

}
