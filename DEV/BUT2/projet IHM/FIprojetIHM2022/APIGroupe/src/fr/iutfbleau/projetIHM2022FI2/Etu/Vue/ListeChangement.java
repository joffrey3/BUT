package fr.iutfbleau.projetIHM2022FI2.Etu.Vue;

import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MNP.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ListeChangement{
    private JPanel panel2;
    private PageEtu page;
    private int longueurFixe;
    private int hauteurFixe;
    private final int limite=10;
    private int seuil;
    private ArrayList<JButton> listeBouton;
    public void ajouter(PageEtu fenetre,int l,int h){
        this.listeBouton = new ArrayList<JButton>();
        this.page=fenetre;
        this.longueurFixe=l;
        this.hauteurFixe=h;
        this.panel2=this.page.getPanel();
        this.ajoutTitre();
        this.ajoutCorps();
        this.ajoutLien();
        this.ajoutEntete();
        this.page.setPanel(this.panel2);
        this.ajoutListener();
    }
    public void ajoutEntete(){
        final int longueurEntete = 9;
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1,longueurEntete));
        for (int j=0;j<longueurEntete;j++){
            String matricule="";
            switch(j){
                case 0:
                matricule = "Id :";
                break;
                case 1:
                matricule = "NomEtu :";
                break;
                case 2:
                matricule = "PrenomEtu :";
                break;
                case 3:
                matricule = "NomGroupeA :";
                break;
                case 4:
                matricule = "NomGroupeB :";
                break;
                case 5:
                matricule = "Explication :";
                break;
                case 6:
                matricule = "Lien Etudiant:";
                break;
                case 7:
                matricule = "Lien GroupeA:";
                break;
                case 8:
                matricule = "Lien GroupeB:";
                break;
            }
            JLabel champ = new JLabel (matricule);
            champ.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
            champ.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            p.add(champ);
        }
        StaticMethodeEtu.absoluteSize(p,this.longueurFixe*longueurEntete,this.hauteurFixe);
        this.page.layoutOptions(0, 1, longueurEntete, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, 0.0, 0.0, new Insets(0, 0, 0, 0));
        this.panel2.add(p,this.page.getGbc());
    }
    public void ajoutCorps(){
        final int longueurCorps = 6;
        ArrayDeque<Changement> liste = StaticMethodeEtu.recupTableau2(StaticMethodeEtu.getFactory());
        this.seuil=liste.size();
        int max=0;
        if(this.limite>this.seuil){
            max=this.limite;
        }else{
            max=this.seuil;
        }
        for(int i=1;i<=max;i++){
            if(!liste.isEmpty()){
                JLabel champ;
                JTextArea zone;
                JScrollPane scroll;
                Changement changement0 = liste.remove();
                JPanel p = new JPanel();
                p.setLayout(new GridLayout(1,longueurCorps));
                for (int j=0;j<longueurCorps;j++){
                    String matricule="";
                    switch(j){
                        case 0:
                        matricule = Integer.toString(changement0.getId());
                        break;
                        case 1:
                        matricule = changement0.getEtu().getNom();
                        break;
                        case 2:
                        matricule = changement0.getEtu().getPrenom();
                        break;
                        case 3:
                        matricule = changement0.getA().getName();
                        break;
                        case 4:
                        matricule = changement0.getB().getName();
                        break;
                        case 5:
                        matricule = changement0.getExplication();
                        break;
                    }
                    if(j==5){
                        zone = new JTextArea(matricule);
                        zone.setEnabled(false);
                        scroll = new JScrollPane(zone);
                        scroll.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
                        scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        p.add(scroll);
                    }else{
                        champ = new JLabel (matricule);
                        champ.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
                        champ.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        p.add(champ);
                    }
                }
                StaticMethodeEtu.absoluteSize(p,longueurFixe*longueurCorps,hauteurFixe);
                this.page.layoutOptions(0, i+1, longueurCorps, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0, new Insets(0, 0, 0, 0));
                this.panel2.add(p,this.page.getGbc());
            }else{
                this.page.creerVide(0,i);
            }
        }
    }
    public void ajoutTitre(){
        String texte="Voir les demandes de changements de groupes";
        JLabel titre = new JLabel(texte);
        titre.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        titre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.page.layoutOptions(0, 0, 8, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0, new Insets(0, 0, 0, 0));
        this.panel2.add(titre,this.page.getGbc());
    } 
    public void ajoutLien(){
        ArrayDeque<Changement> liste = StaticMethodeEtu.recupTableau2(StaticMethodeEtu.getFactory());
        ArrayList<Changement> tab = new ArrayList<Changement>();
        for(int i=1;i<=this.seuil;i++){
            int retour=0;
            Changement ch=null;
                for(int j=0;j<3;j++){
                String texte=" ";
                if(j==0 && !liste.isEmpty()){
                    ch=liste.remove(); 
                    texte=ch.getEtu().getNom();
                    retour=1;
                }if(j==1 && retour==1){
                    texte=ch.getA().getName();
                }if(j==2 && retour ==1){
                    texte=ch.getB().getName();
                }
                JButton lien = new JButton(texte);
                lien.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
                lien.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                StaticMethodeEtu.absoluteSize(lien,this.longueurFixe,this.hauteurFixe);
                this.page.layoutOptions(j+6, i+1, 1, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0, new Insets(0, 0, 0, 0));
                this.panel2.add(lien,this.page.getGbc());
                this.listeBouton.add(lien);
            }
        }
    }
    public void ajoutListener(){
        for(int i=0;i<this.listeBouton.size();i++){
            this.listeBouton.get(i).addActionListener(new ActionListeEtu(this.page,this.page.getPremierPanneau().getLayout(),this.page.getPremierPanneau().getPanneau(),this.page.getDif(),this.listeBouton,i));
        }
    }
    public void reafficher(){
        this.panel2.removeAll();
        this.ajoutTitre();
        this.ajoutCorps();
        this.ajoutLien();
        this.ajoutEntete();
        this.panel2.revalidate();
        this.page.setPanel(this.panel2);
        this.ajoutListener();
    }
}