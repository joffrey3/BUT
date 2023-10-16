package fr.iutfbleau.projetIHM2022FI2.Etu.Vue;

import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MNP.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DemandeEtu {
    PageEtu page;
    JPanel panel;
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    int longueurFixe;
    int hauteurFixe;
    ListeChangement liste;

    public DemandeEtu(PageEtu p,int l,int h,ListeChangement t){
        this.liste=t;
        this.longueurFixe=l;
        this.hauteurFixe=h;
        this.page=p;
        this.panel=this.page.getPanel();
        this.layout=this.page.getLayout();
        this.gbc=this.page.getGbc();

        JLabel titre= new JLabel("Faire un changement");
        StaticMethodeEtu.absoluteSize(titre,this.longueurFixe*3/2,this.hauteurFixe);
        this.page.layoutOptions(4, 1, 4, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0,new Insets(0, 0, 0, 0));
        this.panel.add(titre,this.gbc);

        JButton valider = new JButton("Valider");
        StaticMethodeEtu.absoluteSize(valider,this.longueurFixe,this.hauteurFixe);
        this.page.layoutOptions(5, 9, 2, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0,new Insets(0, 0, 0, 0));
        this.panel.add(valider,this.gbc);


        JLabel nomPrenomEcrit= new JLabel("Nom Prenom :");
        StaticMethodeEtu.absoluteSize(nomPrenomEcrit,this.longueurFixe*2,this.hauteurFixe/2);
        this.page.layoutOptions(3, 3, 2, 1, GridBagConstraints.NONE, GridBagConstraints.SOUTH, 0.0, 0.0,new Insets(0, 0, 0, 0));
        this.panel.add(nomPrenomEcrit,this.gbc);

        JComboBox <String> nomPrenom= new JComboBox <String>(this.transformTabEtudiantNom());
        StaticMethodeEtu.absoluteSize(nomPrenom,this.longueurFixe*2,this.hauteurFixe/2);
        this.page.layoutOptions(3, 4, 2, 1, GridBagConstraints.NONE, GridBagConstraints.NORTH, 0.0, 0.0,new Insets(0, 0, 0, 0));
        this.panel.add(nomPrenom,this.gbc);
        
        JLabel explicationEcrit= new JLabel("Explication :");
        StaticMethodeEtu.absoluteSize(explicationEcrit,this.longueurFixe*2,this.hauteurFixe/2);
        this.page.layoutOptions(3, 5, 2, 1, GridBagConstraints.NONE, GridBagConstraints.SOUTH, 0.0, 0.0,new Insets(0, 0, 0, 0));
        this.panel.add(explicationEcrit,this.gbc);

        JTextArea explication= new JTextArea();
        JScrollPane scroll= new JScrollPane(explication);
        StaticMethodeEtu.absoluteSize(scroll,this.longueurFixe*2,this.hauteurFixe*2);
        this.page.layoutOptions(3, 6, 2, 2, GridBagConstraints.NONE, GridBagConstraints.NORTH, 0.0, 0.0,new Insets(0, 0, 0, 0));
        this.panel.add(scroll,this.gbc);

        JLabel AEcrit= new JLabel("Groupe de depart :");
        StaticMethodeEtu.absoluteSize(AEcrit,this.longueurFixe*2,this.hauteurFixe/2);
        this.page.layoutOptions(7, 3, 2, 1, GridBagConstraints.NONE, GridBagConstraints.SOUTH, 0.0, 0.0,new Insets(0, 0, 0, 0));
        this.panel.add(AEcrit,this.gbc);

        JComboBox <String> A= new JComboBox <String>(this.transformTabGroupe());
        StaticMethodeEtu.absoluteSize(A,this.longueurFixe*2,this.hauteurFixe/2);
        this.page.layoutOptions(7, 4, 2, 1, GridBagConstraints.NONE, GridBagConstraints.NORTH, 0.0, 0.0,new Insets(0, 0, 0, 0));
        this.panel.add(A,this.gbc);


        JLabel BEcrit= new JLabel("Groupe de d'arrive :");
        StaticMethodeEtu.absoluteSize(BEcrit,this.longueurFixe*2,this.hauteurFixe/2);
        this.page.layoutOptions(7, 6, 2, 1, GridBagConstraints.NONE, GridBagConstraints.SOUTH, 0.0, 0.0,new Insets(0, 0, 0, 0));
        this.panel.add(BEcrit,this.gbc);

        JComboBox <String> B= new JComboBox <String>(this.transformTabGroupe());
        StaticMethodeEtu.absoluteSize(B,this.longueurFixe*2,this.hauteurFixe/2);
        this.page.layoutOptions(7, 7, 2, 1, GridBagConstraints.NONE, GridBagConstraints.NORTH, 0.0, 0.0,new Insets(0, 0, 0, 0));
        this.panel.add(B,this.gbc);


        for(int i=0;i<=10;i++){
            for(int j=0;j<=10;j++){
                if(i==0 || j==0){
                    this.page.creerVide(i,j);
                }
            }
        }
        ActionDemandeEtu choix = new ActionDemandeEtu(this.page.getPremierPanneau().getLayout(),this.page.getPremierPanneau().getPanneau(),this.page.getDif(),valider,nomPrenom,A,B,explication,this.liste);
        nomPrenom.addActionListener(choix);
        A.addActionListener(choix);
        B.addActionListener(choix);
        valider.addActionListener(choix);
}

    public String[] transformTabGroupe(){
        ArrayDeque<Groupe> file = StaticMethodeEtu.recupTableau0(StaticMethodeEtu.getFactory());
        String[] tab = new String[file.size()+1];
        tab[0]=null;
        for(int i=0;!file.isEmpty();i++){
            tab[i+1]=file.remove().getName();
        }
        return tab;
    }

    public String[] transformTabEtudiantNom(){
        ArrayDeque<Etudiant> file = StaticMethodeEtu.recupTableau1(StaticMethodeEtu.getFactory());
        String[] tab = new String[file.size()+1];
        tab[0]=null;
        for(int i=0;!file.isEmpty();i++){
            Etudiant etu=file.remove();
            tab[i+1]=etu.getPrenom()+" "+etu.getNom();
        }
        return tab;
    }
    

    public JPanel getPanel(){
        return this.panel;
    }
}