import java.util.Objects;

// Copyright Florent Madelaine, (3 juin 2020) 

// florent.madelaine@u-pec.fr

// Ce logiciel est un programme informatique simulant une petite partie du jeu de Memory

// Ce logiciel est régi par la licence CeCILL soumise au droit français et
// respectant les principes de diffusion des logiciels libres. Vous pouvez
// utiliser, modifier et/ou redistribuer ce programme sous les conditions
// de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA 
// sur le site "http://www.cecill.info".

// En contrepartie de l'accessibilité au code source et des droits de copie,
// de modification et de redistribution accordés par cette licence, il n'est
// offert aux utilisateurs qu'une garantie limitée.  Pour les mêmes raisons,
// seule une responsabilité restreinte pèse sur l'auteur du programme,  le
// titulaire des droits patrimoniaux et les concédants successifs.

// A cet égard  l'attention de l'utilisateur est attirée sur les risques
// associés au chargement,  à l'utilisation,  à la modification et/ou au
// développement et à la reproduction du logiciel par l'utilisateur étant 
// donné sa spécificité de logiciel libre, qui peut le rendre complexe à 
// manipuler et qui le réserve donc à des développeurs et des professionnels
// avertis possédant  des  connaissances  informatiques approfondies.  Les
// utilisateurs sont donc invités à charger  et  tester  l'adéquation  du
// logiciel à leurs besoins dans des conditions permettant d'assurer la
// sécurité de leurs systèmes et ou de leurs données et, plus généralement, 
// à l'utiliser et l'exploiter dans les mêmes conditions de sécurité. 

// Le fait que vous puissiez accéder à cet en-tête signifie que vous avez 
// pris connaissance de la licence CeCILL, et que vous en avez accepté les
// termes.

/**
 * Classe représentant une carte de Memory
 */
public class Carte {
    
    /**
     * Permet de savoir combien on a de cartes en tout.
     * Pas vraiment clair qu'on veuille s'en servir ici. 
     * C'est purement pour des raisons pédagogiques de rappel de ce que veut dire un attribut de classe.
     * 
     * Je ne rentre pas dans les détails de la destruction d'objets.
     * Il faut lire la doc à propos de Objects.finalize()
    */
    static int nbreCarte;

    /**
     * False ssi caché
     */
    private boolean visible; 
    
    /**
     * pour pouvoir apparier des cartes.
     */
    private int valeur;    

    /** Constructeur de carte.
    */
    public Carte(int valeur){
        this.nbreCarte ++;
        this.visible=false; // caché par défaut
        this.valeur=valeur;
    }

    // NB. Moralement, les cartes ne devraient pas être cachées.
    // dans cette version on ne fait rien mais on voudrait idéalement que ce ne soit pas possible
    /**
     *  Prédicat permettant de tester le fait que deux cartes ont la même valeur
     * @param Carte la carte à comparer à this. 
     * @return true si elles ont la même valeur. 
     * @throws NullPointerException si la carte passée en paramètre ou this est null.
     * @throws IllegalArgumentException si l'argument n'est pas visible
     * @throws IllegalStateExeption si this n'est pas visible
     */
    public boolean egale(Carte c){
        Objects.requireNonNull(c, "la carte à tester passée en paramètre ne peut pas être null");
        Objects.requireNonNull(this, "la carte qu'on veut comparer (this) ne peut pas être null");
        return c.valeur == this.valeur;
    }

    public boolean getVisible(){
        return visible;
    }

    /**
     * Méthode inversant la visibilité d'une carte.
     */
    public void toggleVisible(){
        this.visible = ! this.visible;
    }

  /**
    * @return String representant la carte (version longue)
    * @see toString
    */ 
    public String toStringLong(){
        return  this.toString() + " parmi " + this.nbreCarte;
    }

    /**
    * @return String representant la carte.
    */ 
    public String toString(){
        return "une carte " + (this.visible ? "visible" + " de valeur " + this.valeur: "cachée");
    }

    /**
     * C'est un peu moche mais on peut pour simplifier mettre des tests manuels dans un main dans chaque classe.
     * C'est plutôt mieux que de mettre des print dans chaque méthode car vous êtes plus sûr de la stabilité de vos tests 
     * (vous pouvez rejouer les tests plus tard).
     *
     * Idéalement on utilise un outil dédié comme JUnit qui favorise au maximum cette automatisation.
     * @param args pas de paramètre en ligne de commande prévu.
     */
    public static void main(String[] args) {
        Carte un = new Carte(1);
        System.out.println(un.toString());
        Carte deux = new Carte (2);
        System.out.println(deux.toString());
        Carte unBis = new Carte(1);
        System.out.println(unBis.toString());

        un.toggleVisible();
        System.out.println(un.toString());
        unBis.toggleVisible();
        System.out.println(unBis.toString());
        System.out.println(un.egale(unBis));
        unBis.toggleVisible();//true
        System.out.println(unBis.toString());

        System.out.println(un.toString());
        deux.toggleVisible();
        System.out.println(deux.toString());
        System.out.println(!un.egale(deux));//not false

        Carte bad = null;
        un.egale(bad);
    }
}


