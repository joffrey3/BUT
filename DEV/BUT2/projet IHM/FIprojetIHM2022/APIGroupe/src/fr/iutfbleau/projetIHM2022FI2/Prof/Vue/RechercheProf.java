package fr.iutfbleau.projetIHM2022FI2.Prof.Vue;

import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MNP.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class RechercheProf{
    private JPanel panel2;
    private PageProf page;
    private int longueurFixe;
    private int hauteurFixe;
    private final int limite=10;
    private int seuil;
    private ArrayList<JButton> listeBouton;
    public void ajouter(PageProf fenetre,int l,int h){
        this.listeBouton = new ArrayList<JButton>();
        this.page=fenetre;
        this.longueurFixe=l;
        this.hauteurFixe=h;
        this.panel2=this.page.getPanel();
        this.ajoutTitre();
        for(int i=2;i<=10;i++){
            this.page.creerVide(0,i);
        }
        this.page.creerVide(0,10);
        this.page.creerVide(1,10);
        this.page.creerVide(2,10);
        this.page.creerVide(3,10);
        this.page.setPanel(this.panel2);
        /*this.ajoutCorps();
        this.ajoutLien();
        this.ajoutEntete();
        this.page.setPanel(this.panel2);
        this.ajoutListener();*/
    }
    public void ajoutEntete(){
        final int longueurEntete = 4;
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1,longueurEntete));
        for (int j=0;j<longueurEntete;j++){
            String matricule="";
            switch(j){
                case 0:
                matricule = "Id :";
                break;
                case 1:
                matricule = "Nom :";
                break;
                case 2:
                matricule = "Prenom :";
                break;
                case 3:
                matricule = "Lien :";
                break;
            }
            JLabel champ = new JLabel (matricule);
            champ.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
            champ.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            p.add(champ);
        }
        StaticMethodeProf.absoluteSize(p,this.longueurFixe*longueurEntete,this.hauteurFixe);
        this.page.layoutOptions(0, 2, longueurEntete, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, 0.0, 0.0, new Insets(0, 0, 0, 0));
        this.panel2.add(p,this.page.getGbc());
    }
    /*public void ajoutCorps(){
        final int longueurCorps = 3;
        ArrayDeque<Etudiant> liste = StaticMethodeProf.recupTableau1(StaticMethodeProf.getFactory());
        this.seuil=liste.size();
        int max=0;
        if(this.limite>this.seuil){
            max=this.limite;
        }else{
            max=this.seuil;
        }
        for(int i=1;i<=max;i++){
            if(!liste.isEmpty()){
                Etudiant etudiant0 = liste.remove();
                JPanel p = new JPanel();
                p.setLayout(new GridLayout(1,longueurCorps));
                for (int j=0;j<longueurCorps;j++){
                    String matricule="";
                    switch(j){
                        case 0:
                        matricule = Integer.toString(etudiant0.getId());
                        break;
                        case 1:
                        matricule = etudiant0.getNom();
                        break;
                        case 2:
                        matricule = etudiant0.getPrenom();
                        break;
                    }
                    JLabel champ = new JLabel (matricule);
                    champ.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
                    champ.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    p.add(champ);
                }
                StaticMethodeProf.absoluteSize(p,longueurFixe*longueurCorps,hauteurFixe);
                this.page.layoutOptions(0, i+2, longueurCorps, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0, new Insets(0, 0, 0, 0));
                this.panel2.add(p,this.page.getGbc());
            }else{
                this.page.creerVide(0,i);
            }
        }
    }*/

    public void ajoutCorps(String nomEtu){
        final int longueurCorps = 3;
        ArrayDeque<Etudiant> liste = StaticMethodeProf.recupTableau2(StaticMethodeProf.getFactory(),nomEtu);
        this.seuil=liste.size();
        int max=0;
        if(this.limite>this.seuil){
            max=this.limite;
        }else{
            max=this.seuil;
        }
        for(int i=1;i<=max;i++){
            if(!liste.isEmpty()){
                Etudiant etudiant0 = liste.remove();
                JPanel p = new JPanel();
                p.setLayout(new GridLayout(1,longueurCorps));
                for (int j=0;j<longueurCorps;j++){
                    String matricule="";
                    switch(j){
                        case 0:
                        matricule = Integer.toString(etudiant0.getId());
                        break;
                        case 1:
                        matricule = etudiant0.getNom();
                        break;
                        case 2:
                        matricule = etudiant0.getPrenom();
                        break;
                    }
                    JLabel champ = new JLabel (matricule);
                    champ.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
                    champ.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    p.add(champ);
                }
                StaticMethodeProf.absoluteSize(p,longueurFixe*longueurCorps,hauteurFixe);
                this.page.layoutOptions(0, i+2, longueurCorps, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0, new Insets(0, 0, 0, 0));
                this.panel2.add(p,this.page.getGbc());
            }else{
                this.page.creerVide(0,i+2);
            }
        }
    }

    public void ajoutTitre(){
        String texte="Affichage des etudiants dans un groupe :";
        JLabel titre = new JLabel(texte);
        titre.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        titre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.page.layoutOptions(0, 0, 6, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0, new Insets(0, 0, 0, 0));
        this.panel2.add(titre,this.page.getGbc());

        JTextField recherche = new JTextField();
        StaticMethodeProf.absoluteSize(recherche,this.longueurFixe*4,this.hauteurFixe);
        recherche.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        recherche.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.page.layoutOptions(0, 1, 4, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0, new Insets(0, 0, 0, 0));
        this.panel2.add(recherche,this.page.getGbc());
        recherche.addActionListener(new ActionListeProf(this.page,this.page.getPremierPanneau().getLayout(),this.page.getPremierPanneau().getPanneau(),this.page.getDif(),recherche));
        
    } 
    public void ajoutLien(String nomEtu){
        ArrayDeque<Etudiant> liste = StaticMethodeProf.recupTableau2(StaticMethodeProf.getFactory(),nomEtu);
        for(int i=1;i<=this.seuil;i++){
            String texte=liste.remove().getNom();
            JButton lien = new JButton(texte);
            lien.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
            lien.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            StaticMethodeProf.absoluteSize(lien,this.longueurFixe,this.hauteurFixe);
            this.page.layoutOptions(3, i+2, 1, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0, new Insets(0, 0, 0, 0));
            this.panel2.add(lien,this.page.getGbc());
            this.listeBouton.add(lien);
        }
    }
    public void ajoutListener(){
        for(int i=0;i<this.listeBouton.size();i++){
            this.listeBouton.get(i).addActionListener(new ActionListeProf(this.page,this.page.getPremierPanneau().getLayout(),this.page.getPremierPanneau().getPanneau(),this.page.getDif(),this.listeBouton,i));
        }
    }

    /*public void reafficher(){
        this.panel2.removeAll();
        this.ajoutTitre();
        this.ajoutCorps();
        this.ajoutLien();
        this.ajoutEntete();
        this.panel2.revalidate();
        this.page.setPanel(this.panel2);
        this.ajoutListener();
    }*/

    public void reafficher(String nomEtu){
        this.panel2.removeAll();
        this.ajoutTitre();
        this.ajoutCorps(nomEtu);
        this.ajoutLien(nomEtu);
        this.ajoutEntete();
        this.panel2.revalidate();
        this.page.setPanel(this.panel2);
        this.ajoutListener();
    }
}