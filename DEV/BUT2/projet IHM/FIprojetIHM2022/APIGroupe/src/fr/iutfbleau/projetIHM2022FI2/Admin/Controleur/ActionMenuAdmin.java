package fr.iutfbleau.projetIHM2022FI2.Admin.Controleur;

import java.awt.event.*;
import javax.swing.*;

import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MNP.*;
import fr.iutfbleau.projetIHM2022FI2.MP.*;


import fr.iutfbleau.projetIHM2022FI2.Admin.Vue.*;

public class ActionMenuAdmin implements ActionListener {

    JButton AddEtu,CreeGroup,SupGroup,RenGroup,DepEtu;
    Pancardlayout a;


    public ActionMenuAdmin(JButton AddEtu,JButton CreeGroup,JButton SupGroup,JButton RenGroup,JButton DepEtu,Pancardlayout a,AbstractGroupeFactory agf){
        this.AddEtu = AddEtu;
        this.CreeGroup = CreeGroup;
        this.SupGroup = SupGroup;
        this.RenGroup = RenGroup;
        this.DepEtu = DepEtu;
        this.a = a;
    }

    public void actionPerformed(ActionEvent e){
        /**
         * lance le panneau addetu
         */
        if(e.getSource() == AddEtu){
            a.getaddetu();
        }
        /**
         * lance le panneau cree groupe
         */
        if(e.getSource() == CreeGroup){
            a.getcreegroup();
        }
        /**
         * lance le panneau supgroupe
         */
        if(e.getSource() == SupGroup){
            a.getsupgroup();
        }
        /**
         * lance le panneau rennomer groupe
         */
        if(e.getSource() == RenGroup){
            a.getrengroup();
        }
        /**
         * lance le panneau deplacer etudiant
         */
        if(e.getSource() == DepEtu){
            a.getdepetu();
        }

    }

    
}
