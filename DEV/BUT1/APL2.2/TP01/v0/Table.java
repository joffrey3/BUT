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
 * Classe gérant la table de jeu du Memory dans le modèle
 * Pour l'instant ne gère pas le tour des joueurs.
 * Devrait probablement le faire un jour.
 */
public class Table extends EnsembleCarte {
       
    /**
     * Constructeur de Table vide (seul constructeur pour l'instant)
     */
    public Table(){
    }

    /**
     * Nécessaire de la rendre publique car on a un parti pris que on commence avec une table vide à laquelle on ajoute des cartes.
     * On pourrait alternativement faire un constructeur qui fabrique les cartes ou bien qui prend une collection de cartes.
     * Ça n'aurait pas la vertu pédagogique de montrer qu'on peut surcharger une méthode en élevant les droits en java.
     * 
     * Par délégation mais en rendant publique la méthode (pour l'initialisation en fait).
     * @param  c Carte à ajou
     * @return true si la carte est ajoutée à l'ensemble
     * @throws NullPointerException si la carte est null
     * @throws IllegalStateException si la carte ne peut pas être ajoutée car elle est déjà présente dans l'ensemble  
     */
    @Override
    public boolean add(Carte c){
        return super.add(c);
    }

    /**
     * révèle une carte.
     * @param c une carte à révèler
     * @throws NullPointerException si la carte est null
     * @throws IllegalArgumentException si la carte n'est pas sur la table
     * @throws IllegalStateException si la carte est déjà révélée 
     */
    public void reveler(Carte c){
        c.toggleVisible(); 
    }

	/**
     * cache une carte.
     * @param c une carte à cacher
     * @throws NullPointerException si la carte est null
     * @throws IllegalArgumentException si la carte n'est pas sur la table
     * @throws IllegalStateException si la carte est déjà cachée 
     */
    public void cacher(Carte c){
        c.toggleVisible(); 
    }


    public String toString(){
        return "Table " + super.toString();
    }


    public static void main(String[] args) {
        // c'est un peu moche mais on peut pour simplifier mettre des tests manuels dans un main dans chaque classe.
        // C'est plutôt mieux que de mettre des print dans chaque méthode car vous êtes plus sûr de la stabilité de vos tests (vous pouvez rejouer les tests plus tard).

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

        t.reveler(un);
        t.reveler(unBis);
        
        System.out.println(t);
                
    }
}


