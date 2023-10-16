import java.util.LinkedHashSet;

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
 * Classe servant à représenter le joueur dans le modèle.
 * Pour l'instant juste un nom et un ensemble de cartes
 */
public class Joueur extends EnsembleCarte {
    /**
    * Nom du joueur
    */
    private String nom;
    
    /**
     * Constructeur
     * @param  nom Futur nom du joueur, ne doit pas être null
     * @throws nullPointerException si nom est null.
     */
    public Joueur(String nom){
        this.nom=nom;
    }

    public String toString(){
        return "Joueur " + this.nom + " " + super.toString();
    }


    public static void main(String[] args) {
        // c'est un peu moche mais on peut pour simplifier mettre des tests manuels dans un main dans chaque classe.
        // C'est plutôt mieux que de mettre des print dans chaque méthode car vous êtes plus sûr de la stabilité de vos tests (vous pouvez rejouer les tests plus tard).

        // Les Joueurs
        Joueur toto = new Joueur("Toto");
        Joueur titi = new Joueur("Titi");
        Joueur tata = new Joueur("Tata");
        
        // Les cartes
        Carte un = new Carte(1);
        Carte deux = new Carte (2);
        Carte unBis = new Carte(1);
        Carte deuxBis = new Carte(2);

        // la Table
        Table t = new Table();
        t.add(un);
        t.add(deux);
        t.add(unBis);
        t.add(deuxBis);

        System.out.println(t);
        System.out.println(toto);

        t.reveler(un);
        t.reveler(unBis);

        t.transfer(toto,un,unBis);
        
        System.out.println(t);
        System.out.println(toto);	
    }
}


