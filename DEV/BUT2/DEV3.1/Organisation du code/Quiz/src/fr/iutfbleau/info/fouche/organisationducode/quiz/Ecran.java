package fr.iutfbleau.info.fouche.organisationducode.quiz;

import java.awt.*;
import javax.swing.*;

public class Ecran{
    private JPanel panneau;
    private BoiteQuestion tirage;
    public Ecran(){
        this.tirage= new BoiteQuestion();
        this.panneau = new JPanel();
        this.panneau.setSize(100,100);
        this.panneau.setLocation(0,0);
    }
    public void changement(int n){
        JLabel texte = new JLabel("La question numero "+Integer.toString(n)+" est : ");
        this.tirage.creationQuestion();
        String operation =this.tirage.getQuestion();
        JLabel algebre = new JLabel(operation);
        this.panneau.add(texte);
        this.panneau.add(algebre);
    }
    public JPanel getPanneau(){
        return this.panneau;
    }
}