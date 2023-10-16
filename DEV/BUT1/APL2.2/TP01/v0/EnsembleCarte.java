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
 * classe abstraite pour gérer les opérations sur les ensembles de carte qu'on trouve au memory
 * 
 */
public abstract class EnsembleCarte {
    /**
     * La structure de donnée utilisée pour stocker les cartes dans la partie Collection de java.util.
     * En gros, c'est un ensemble (répétition interdite) qui liste les éléments dans un ordre stable.
     * La doc de java.util a propos de AbstractSet (ancêtre de LinkedHashSet)
     * (...) all of the methods and constructors in subclasses of this class must obey the additional
     * constraints imposed by the Set interface (for instance, the add method must not permit addition 
     * of multiple instances of an object to a set). 
     */
   	private LinkedHashSet<Carte> contenu = new LinkedHashSet<Carte>();
    
    /**
     * nbre de Cartes de l'ensemble.
     * 
     */
    private int nbreCarte;

    /**
    * Constructeur d'Ensemble vide.
    */
    public EnsembleCarte(){
        this.nbreCarte=0;
    }

    /**
     * Ajoute une carte à l'ensemble.
     * @param  c une carte
     * @return true si la carte est ajoutée à l'ensemble
     * @throws NullPointerException si la carte est null
     * @throws IllegalStateException si la carte ne peut pas être ajoutée car elle est déjà présente dans l'ensemble  
     */
    protected boolean add(Carte c){
        this.nbreCarte++;
        return contenu.add(c); 
    }

    /**
     * Enlève une carte à l'ensemble.
     * @param  c une carte
     * @return true si la carte est retirée à l'ensemble
     * @throws NullPointerException si la carte est null
     * @throws IllegalStateException si la carte ne peut pas être enlevéé car elle n'est pas présente dans l'ensemble  
     */
    private boolean remove(Carte c){
        this.nbreCarte++;
        return contenu.remove(c); 
    }

    /**
     * Permet de transférer une paire de carte (par exemple depuis la table vers un joueur)
     * Si ces cartes sont toutes les deux visibles
     * @param  target destination du transfert
     * @param  c1     première carte
     * @param  c2     seconde carte
     * @return        true en cas de succès, false sinon
     * @throws NullPointerException si un élément passé en paramètre est null.
     * @throws IllegalArgumentException si les cartes ne sont pas toutes les deux visibles
     * @throws IllegalStateException si this ne contient pas les deux cartes.
     */
    public boolean transfer(EnsembleCarte target, Carte c1, Carte c2){
    	return this.contenu.contains(c1) && this.contenu.remove(c1) && target.add(c1) && this.contenu.contains(c2) && this.contenu.remove(c2) && target.add(c2);
    }	


    public String toString(){
        // Stringbuilder is the most efficient method of building a String like datastructure incrementally. 
        StringBuilder sb = new StringBuilder(" de taille " + this.contenu.size() + ", contenant : \n");
        for (Carte c : this.contenu){
            sb.append(" _ " + c.toString() +"\n");
        }
        return sb.toString();
    }


    // tests obsolètes [serait OK si classe n'était pas abstraite]
    
    // public static void main(String[] args) {
        
    //     Carte un = new Carte(1);
    //     Carte deux = new Carte (2);
    //     deux.toggleVisible();
    //     Carte unBis = new Carte(1);

    //     Carte deuxBis = new Carte(2);

    //     EnsembleCarte e1 = new EnsembleCarte();
    //     System.out.println(e1.add(un) && e1.add(deux));
    //     System.out.println(e1.toString());

    //     EnsembleCarte e2 = new EnsembleCarte();
    //     System.out.println(e2.add(un) && e2.add(unBis));
    //     System.out.println(e2.toString());
        
    //     e1.transfer(e2,un,deuxBis);
    //     System.out.println(e1.toString());
    //     System.out.println(e2.toString());   
        
    // }
}


