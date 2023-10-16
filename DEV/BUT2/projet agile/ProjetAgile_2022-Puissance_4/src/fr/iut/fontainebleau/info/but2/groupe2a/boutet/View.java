package src.fr.iut.fontainebleau.info.but2.groupe2a.boutet;

import java.awt.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;

public class View implements MouseListener {
    protected JFrame fenetre;
    protected JPanel p;
    private Grille grille;
    private Model a;

    private int numerojoueur = 1; // tour du joueur jaune turn=false | tour du joueur rouge turn=true

    public View(int x, int y) {

        /* la fenetre */
        this.fenetre = new JFrame("Puissance 4");
        this.fenetre.setSize(x, y);
        this.fenetre.setLocation((1920 - x) / 2, (1080 - y) / 2);
        this.fenetre.setDefaultCloseOperation(3);

        /* la grille */
        this.grille = new Grille(485,400);
        grille.PrintGrille();
        this.a = new Model(grille, fenetre);

        /* Faire en sorte que le plateau reste toujours au centre de la fenetre */
        // Box box = new Box(BoxLayout.Y_AXIS);

        // box.add(Box.createVerticalGlue());
        // box.add(p);
        // box.add(Box.createVerticalGlue()); // causes a deformation

        this.p = new JPanel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        for (int i = 0; i < grille.getNombreColonne(); i++) {
            for (int j = 0; j < grille.getNombreLigne(); j++) {
                Jeton jeton = this.grille.getJeton(i, j);
                // System.out.println("x = " + jeton.getLigne() + " y = " + jeton.getColonne() +
                // " Value = " + jeton.getValue());
                jeton.addMouseListener(this);
                gbc.gridx = this.grille.getNombreLigne() - i;
                gbc.gridy = this.grille.getNombreColonne() - j;
                gbc.ipadx = 50;
                gbc.ipady = 50;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.fill = GridBagConstraints.BOTH;
                p.add(jeton, gbc);
            }
        }

        this.p.setBackground(Color.BLUE);
        this.p.setPreferredSize(new Dimension(485, 400));
        this.p.setMinimumSize(new Dimension(485, 400));
        this.p.setMaximumSize(new Dimension(485, 400));
        this.p.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        this.fenetre.add(p);
        // this.fenetre.add(box);
        /* le texte */

        /* le bouton */
    }

    public void affichage() {
        this.fenetre.setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {

        System.out.println(e.getComponent());
        Component j = e.getComponent();// Récupere le jeton ayant recu le clique
        Jeton jeton = (Jeton) j;
        int ligneNouveauJeton = this.grille.getLowestJeton(jeton);
        switch (numerojoueur) {

            case 1:
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setValue('r');
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].repaint();
                a.CoupVictorieux(jeton.getColonne(), ligneNouveauJeton, numerojoueur);
                this.numerojoueur = 2;
                this.fenetre.setTitle("Puissance 4 : Tour du joueur Jaune");
                break;

            case 2:
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setValue('j');
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].repaint();
                a.CoupVictorieux(jeton.getColonne(), ligneNouveauJeton, numerojoueur);
                this.numerojoueur = 3;
                this.fenetre.setTitle("Puissance 4 : Tour du joueur Vert");
                break;

            case 3:
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setValue('v');
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].repaint();
                a.CoupVictorieux(jeton.getColonne(), ligneNouveauJeton, numerojoueur);
                this.numerojoueur = 1;
                this.fenetre.setTitle("Puissance 4 : Tour du joueur Rouge");
                break;
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        if (e.getComponent().getForeground() == Color.BLACK) {
            if (numerojoueur == 2) {// Tour du joueur Jaune
                Component j = e.getComponent();// Récupere le jeton ayant recu le clique
                Jeton jeton = (Jeton) j;
                int ligneNouveauJeton = this.grille.getLowestJeton(jeton);
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setForeground(Color.GRAY);
            } else if (numerojoueur == 1) {// tour du joueur Rouge
                Component j = e.getComponent();// Récupere le jeton ayant recu le clique
                Jeton jeton = (Jeton) j;
                int ligneNouveauJeton = this.grille.getLowestJeton(jeton);
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setForeground(Color.GRAY);
            } else if (numerojoueur == 3) {
                Component j = e.getComponent();// Récupere le jeton ayant recu le clique
                Jeton jeton = (Jeton) j;
                int ligneNouveauJeton = this.grille.getLowestJeton(jeton);
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setForeground(Color.GRAY);
            }
        }
    }

    public void mouseExited(MouseEvent e) {
        if (e.getComponent().getForeground() == Color.gray) {
            e.getComponent().setForeground(Color.BLACK);
            System.out.print(" -> Couleur changée \n");
        }
    }

    public void mouseReleased(MouseEvent e) {
    }
}
