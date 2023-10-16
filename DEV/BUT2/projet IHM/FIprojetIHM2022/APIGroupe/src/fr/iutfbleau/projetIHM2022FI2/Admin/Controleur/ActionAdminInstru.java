package fr.iutfbleau.projetIHM2022FI2.Admin.Controleur;

import java.awt.event.*;
import java.util.Set;

import javax.swing.*;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MNP.*;
import fr.iutfbleau.projetIHM2022FI2.MP.*;


public class ActionAdminInstru implements ActionListener {


   boolean c;
   Etudiant b;
   AbstractGroupeFactory gestiongroupe;
   String nometudiant, sousgroupe, newgroupe,nummintext,nummaxtext,nbrpartitiontext;
   JButton valaddetu,valcreegroup,valsupgroup,valrengroup,valdepetu;

   /**
    * Re cupere tous les parametres de panlayout même si ils ne sont pas utilisé à chaque fois
    * @param nummin
    * @param nummax
    * @param nbrpartition
    * @param partition
    * @param nom
    * @param sous
    * @param newg
    * @param valaddetu
    * @param valcreegroup
    * @param valsupgroup
    * @param valrengroup
    * @param valdepetu
    * @param gestiongroupe
    */
   public ActionAdminInstru(JTextField nummin,JTextField nummax,JTextField nbrpartition,JCheckBox partition,JLabel nom,JLabel sous,JLabel newg,JButton valaddetu,JButton valcreegroup,JButton valsupgroup,JButton valrengroup,JButton valdepetu,AbstractGroupeFactory gestiongroupe){
    this.nometudiant = nom.getText();
    this.sousgroupe = sous.getText();
    this.newgroupe = newg.getText();
    this.nummintext = nummin.getText();
    this.nummaxtext = nummax.getText();
    this.nbrpartitiontext = nbrpartition.getText();
    this.c = partition.isSelected();
    this.valaddetu = valaddetu;
    this.valcreegroup = valcreegroup;
    this.valsupgroup = valsupgroup;
    this.valrengroup = valrengroup;
    this.valdepetu = valdepetu;
    this.gestiongroupe = gestiongroupe;
   }
    

   public void actionPerformed(ActionEvent e){
      
      /**
       * ajoute un etudiant à un groupe
       */
      if(e.getSource() == valaddetu){
         Set<Etudiant> listeetu = gestiongroupe.getEtudiants(nometudiant);
         for (Etudiant a : listeetu) {
            if (a.getNom() == nometudiant) {
               b=a;
            }
         }
         Groupe pere = gestiongroupe.getGroupeByName(sousgroupe);
         gestiongroupe.addToGroupe(pere,b);
      }
      /**
       * cree un nouveau groupe ou une partition
       */
      if(e.getSource() == valcreegroup){
         if(c== true){
            int nbrpartition = Integer.parseInt(nbrpartitiontext);
            Groupe pere = gestiongroupe.getGroupeByName(sousgroupe);
            gestiongroupe.createPartition(pere,newgroupe,nbrpartition);
         } else {
         Groupe pere = gestiongroupe.getGroupeByName(sousgroupe);
         int nbrmin = Integer.parseInt(nummintext);
         int nbrmax = Integer.parseInt(nummaxtext);
         gestiongroupe.createGroupe(pere,newgroupe,15,60);
         }
      }
      /**
       * renomme un groupe
       */
      if(e.getSource() == valrengroup){
         Groupe pere = gestiongroupe.getGroupeByName(sousgroupe);
         pere.setName(newgroupe);
      }
      /**
       * supprime un groupe
       */
      if(e.getSource() == valsupgroup){
         Groupe pere = gestiongroupe.getGroupeByName(sousgroupe);
         gestiongroupe.deleteGroupe(pere);
      }
      /**
       * deplace un étudiant
       */
      if(e.getSource() == valdepetu){
         Groupe pere = gestiongroupe.getGroupeByName(sousgroupe);
         Groupe fils = gestiongroupe.getGroupeByName(newgroupe);
         Set<Etudiant> listeetu = gestiongroupe.getEtudiants(nometudiant);
         for (Etudiant a : listeetu) {
            if (a.getNom() == nometudiant) {
               b=a;
               break;
            }
         }
         gestiongroupe.dropFromGroupe(pere,b);
         gestiongroupe.addToGroupe(fils,b);
      }

}
}
