package fr.iutfbleau.projetIHM2022FI2.Prof.Vue;

import javax.swing.*;
import java.awt.*;

public class VueProf {
        public void Vue2() {
                final int menuHorizontal = 300;
                final int menuVertical = 800;
                final int fenetreHorizontal = 1500;
                final int fenetreVertical = 1000;
                JFrame WindowsAdmin = new JFrame();
                WindowsAdmin.setSize(fenetreHorizontal, fenetreVertical);
                PanneauProf p = new PanneauProf(fenetreHorizontal - 300, fenetreVertical - 100);
                /* */ GridBagConstraints c = new GridBagConstraints();
                c.fill = GridBagConstraints.VERTICAL;
                JButton AffGroup = new JButton("Afficher groupes");
                JButton AffEtu = new JButton("afficher etudiant");
                JButton Recherche = new JButton("afficher recherche");
                JPanel Titre = new JPanel();
                // Titre.setLayout(new BorderLayout());
                JLabel titre = new JLabel("Etudiant");
                // JLabel aff = new JLabel("affichage");
                Titre.add(titre, BorderLayout.CENTER);
                JPanel Menu = new JPanel();
                StaticMethodeProf.absoluteSize(Menu, menuHorizontal, menuVertical);
                StaticMethodeProf.absoluteSize(AffGroup, menuHorizontal, menuVertical / 3);
                StaticMethodeProf.absoluteSize(AffEtu, menuHorizontal, menuVertical / 3);
                StaticMethodeProf.absoluteSize(Recherche, menuHorizontal, menuVertical / 3);
                Menu.setLayout(new GridLayout(3, 1));
                // System.out.println(Menu);
                JPanel affichage = p.getPanneau();
                StaticMethodeProf.absoluteSize(affichage, fenetreHorizontal - 300, fenetreVertical - 100);
                StaticMethodeProf.absoluteSize(Titre, 1000, 100);
                WindowsAdmin.setLayout(new GridBagLayout());
                Titre.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                c.gridx = 0;
                c.gridy = 0;
                c.gridwidth = 2;
                c.ipadx = 0;
                c.ipady = 0;
                WindowsAdmin.add(Titre, c);
                Menu.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                c.gridx = 0;
                c.gridy = 1;
                c.gridwidth = 1;
                c.ipadx = 0;
                c.ipady = 0;
                WindowsAdmin.add(Menu, c);
                affichage.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                c.gridx = 1;
                c.gridy = 1;
                c.ipadx = 0;
                c.ipady = 0;
                WindowsAdmin.add(affichage, c);
                Menu.add(AffGroup);
                Menu.add(AffEtu);
                Menu.add(Recherche);
                ActionMenuProf act = new ActionMenuProf(p.getLayout(), AffGroup, AffEtu, Recherche, affichage,p);
                WindowsAdmin.setVisible(true);
                WindowsAdmin.setResizable(false);
                WindowsAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                AffGroup.addActionListener(act);
                AffEtu.addActionListener(act);
                Recherche.addActionListener(act);
        }
}