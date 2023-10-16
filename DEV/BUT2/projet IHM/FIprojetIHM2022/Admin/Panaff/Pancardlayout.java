package FIprojetIHM2022.Admin.Panaff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pancardlayout {
    
    CardLayout card;
    JPanel c,addetu,creegroup,supgroup,rengroup,depetu;
<<<<<<< HEAD
=======
<<<<<<< HEAD
    JLabel nometudiant,sousgroupe;
    JTextField etud,groupe;
    GridLayout j,g,h;
    JButton valider;
    GridLayout aff;
=======
>>>>>>> master
    JLabel nometudiant,sousgroupe,newgroupe;
    JTextField etud,groupe,ngroupe;
    GridLayout j,g,h;
    JButton valider;
<<<<<<< HEAD
=======
>>>>>>> nevejans
>>>>>>> master

    public Pancardlayout(JPanel a){
        this.c = a;
        
        addetu = new JPanel();
        creegroup = new JPanel();
        supgroup = new JPanel();
        rengroup = new JPanel();
        depetu = new JPanel();
        card = new CardLayout();
        c.setLayout(card);
<<<<<<< HEAD
=======
<<<<<<< HEAD




        
    }

=======
>>>>>>> master
        j = new GridLayout(2,1);
        addetu.setLayout(j);
        nometudiant = new JLabel("Nom d'etudiant : ");
        addetu.add(nometudiant);
        etud = new JTextField(10);
        addetu.add(etud);
        sousgroupe = new JLabel("numero du groupe :");
        addetu.add(sousgroupe);
        groupe = new JTextField(10);
        addetu.add(groupe);
        c.add("addetu",addetu);
        g = new GridLayout(1,1);
        creegroup.setLayout(g);
        creegroup.add(sousgroupe);
        creegroup.add(groupe);
        c.add("creegroup",creegroup);
        supgroup.setLayout(1,1);
        supgroup.add(sousgroupe);
        supgroup.add(groupe);
        c.add("supgroup",supgroup);
        rengroup.setLayout(j);
        rengroup.add(sousgroupe);
        rengroup.add(groupe);
        newgroupe = new JLabel("numero du nouveau groupe :");
        ngroupe = new JTextField(10);
        rengroup.add(newgroupe);
        rengroup.add(ngroupe);
        c.add("rengroup",rengroup);
        h =  new GridLayout(3,1);
        depetu.setLayout(h);
        sousgroupe = new JLabel("numero du groupe actuel");
        depetu.add(sousgroupe);
        depetu.add(groupe);
        depetu.add(nometudiant);
        depetu.add(etud);
        depetu.add(newgroupe);
        depetu.add(ngroupe);
        c.add("depetu",depetu);
        
    }

    public JPanel getPanel(){
        return this.c;
    }

    public CardLayout

<<<<<<< HEAD
=======
>>>>>>> nevejans
>>>>>>> master
}
