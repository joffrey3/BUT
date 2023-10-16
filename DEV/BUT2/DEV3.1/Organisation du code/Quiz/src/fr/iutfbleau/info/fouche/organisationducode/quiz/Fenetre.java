package fr.iutfbleau.info.fouche.organisationducode.quiz;

import java.awt.*;
import javax.swing.*;

public class Fenetre {
    public Fenetre(){
        JFrame fenetre= new JFrame();
        fenetre.setSize(100,100);
        fenetre.setLocation(0,0);
        CardLayout gestionnaire = new CardLayout();
        fenetre.setLayout(gestionnaire);
        for(int i=0;i<10;i++){
            Ecran q = new Ecran();
            q.changement(i);
            String chaine = "q"+ Integer.toString(i);
            fenetre.add(q.getPanneau(),chaine);
        }
        fenetre.setVisible(true);
    }
}