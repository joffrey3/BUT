package fr.iutfbleau.projetIHM2022FI2.Etu.Vue;

import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MNP.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ValidationEtu {
    PageEtu page;
    JPanel panel;
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    int longueurFixe;
    int hauteurFixe;
    public ValidationEtu(PageEtu p,int l,int h){
        this.longueurFixe=l;
        this.hauteurFixe=h;
        this.page=p;
        this.panel=this.page.getPanel();
        this.layout=this.page.getLayout();
        this.gbc=this.page.getGbc();

        JLabel titre= new JLabel("Changement effectué");
        StaticMethodeEtu.absoluteSize(titre,this.longueurFixe*3/2,this.hauteurFixe);
        this.page.layoutOptions(4, 1, 4, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0,new Insets(0, 0, 0, 0));
        this.panel.add(titre,this.gbc);

        JLabel phrase= new JLabel("Vous avez fait une demande de changement");
        StaticMethodeEtu.absoluteSize(phrase,this.longueurFixe*8,this.hauteurFixe);
        phrase.setFont(new Font(Font.SERIF, Font.PLAIN, 40));
        this.page.layoutOptions(2, 4, 8, 2, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0,new Insets(0, 0, 0, 0));
        this.panel.add(phrase,this.gbc);

        JButton valider = new JButton("Ok");
        StaticMethodeEtu.absoluteSize(valider,this.longueurFixe,this.hauteurFixe);
        this.page.layoutOptions(5, 9, 2, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0,new Insets(0, 0, 0, 0));
        this.panel.add(valider,this.gbc);


        for(int i=0;i<=10;i++){
            for(int j=0;j<=10;j++){
                if(i==0 || j==0){
                    this.page.creerVide(i,j);
                }
            }
        }
        this.detection(valider);
    }
    
    public void detection(JButton valider){
        valider.addActionListener(new ActionDemandeEtu(this.page.getPremierPanneau().getLayout(),this.page.getPremierPanneau().getPanneau(),this.page.getDif(),valider));
    }

    public JPanel getPanel(){
        return this.panel;
    }
}