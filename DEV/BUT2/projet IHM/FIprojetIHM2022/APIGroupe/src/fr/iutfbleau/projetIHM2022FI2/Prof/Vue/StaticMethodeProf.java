package fr.iutfbleau.projetIHM2022FI2.Prof.Vue;

import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MNP.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class StaticMethodeProf{
    public static int retour=0;
    public static AbstractChangementFactoryNP factory=null;
    public static void absoluteSize(Component comp, int x, int y) {
        comp.setSize(new Dimension(x, y));
        comp.setMinimumSize(new Dimension(x, y));
        comp.setPreferredSize(new Dimension(x, y));
        comp.setMaximumSize(new Dimension(x, y));
    }
    public static AbstractChangementFactoryNP getFactory(){
        if(retour==0){
            factory=MainTest.main();
            retour++;
        }
        return factory;
    }
    public static ArrayDeque<Groupe> recupTableau0(AbstractChangementFactoryNP factory){
            LinkedList<Groupe> pile = new LinkedList<Groupe>();
            ArrayDeque<Groupe> arbre = new ArrayDeque<Groupe>();
            AbstractGroupeFactory factory2=factory.getGroupeFactory();
            Groupe g=factory2.getPromotion();
            pile.addFirst(g);
            for(;!pile.isEmpty();){
                Groupe promotion = pile.remove();
                arbre.add(promotion);
                Iterator<Groupe> tab = promotion.getSousGroupes().iterator();
                for(;tab.hasNext();){
                    pile.add(tab.next());
                }
            }
        return arbre;
    }
    public static ArrayDeque<Groupe> recupTableau0(AbstractChangementFactoryNP factory,String nomEtu){
        ArrayDeque<Groupe> arbre = new ArrayDeque<Groupe>();
        AbstractGroupeFactory factory2=factory.getGroupeFactory();
        Set<Etudiant> set = StaticMethodeProf.getFactory().getGroupeFactory().getEtudiants(nomEtu);
        Iterator<Etudiant> iterator = set.iterator();
        Etudiant etu=null;
        if(iterator.hasNext()){
            etu=iterator.next();
        }
        Set<Groupe> setter =StaticMethodeProf.getFactory().getGroupeFactory().getGroupesOfEtudiant(etu);
        Iterator<Groupe> ite = setter.iterator();
        for(;ite.hasNext();){
            arbre.add(ite.next());
        }
        return arbre;
    }
    public static ArrayDeque<Etudiant> recupTableau1(AbstractChangementFactoryNP factory){
        ArrayDeque<Etudiant> arbre = new ArrayDeque<Etudiant>();
        AbstractGroupeFactory factory2=factory.getGroupeFactory();
        Groupe g=factory2.getPromotion();
        Iterator<Etudiant> tab = g.getEtudiants().iterator();
        for(;tab.hasNext();){
                arbre.add(tab.next());
        }
        return arbre;
    }

    public static ArrayDeque<Etudiant> recupTableau1(AbstractChangementFactoryNP factory,String nomGrp){
        ArrayDeque<Etudiant> arbre = new ArrayDeque<Etudiant>();
        LinkedList<Groupe> pile = new LinkedList<Groupe>();
        ArrayDeque<Groupe> tab2 = new ArrayDeque<Groupe>();
        AbstractGroupeFactory factory2=factory.getGroupeFactory();
        Groupe g=factory2.getPromotion();
        pile.addFirst(g);
        for(;!pile.isEmpty();){
            Groupe promotion = pile.remove();
            if(promotion.getName()==nomGrp){
                tab2.add(promotion);
            }
            Iterator<Groupe> tab = promotion.getSousGroupes().iterator();
            for(;tab.hasNext();){
                pile.add(tab.next());
            }
        }
        Iterator<Groupe> iterator = tab2.iterator();
        Groupe grp=null;
        if(iterator.hasNext()){
            grp=iterator.next();
        }
        Set<Etudiant> setter =grp.getEtudiants();
        Iterator<Etudiant> ite = setter.iterator();
        for(;ite.hasNext();){
            arbre.add(ite.next());
        }
        return arbre;
    }

    public static ArrayDeque<Etudiant> recupTableau2(AbstractChangementFactoryNP factory,String nomEtu){
        System.out.println(nomEtu);
        ArrayDeque<Etudiant> arbre = new ArrayDeque<Etudiant>();
        AbstractGroupeFactory factory2=factory.getGroupeFactory();
        Set<Etudiant> setter =factory2.getEtudiants(nomEtu);
        Iterator<Etudiant> ite = setter.iterator();
        for(;ite.hasNext();){
            arbre.add(ite.next());
        }
        return arbre;
    }

    
}