package fr.iutfbleau.projetIHM2022FI2.Test;
import fr.iutfbleau.projetIHM2022FI2.MP.*;
import fr.iutfbleau.projetIHM2022FI2.API.*;

import java.util.*;

public class Testtkt {
    public static void main(String[] args) {

        Set<Etudiant> listeEtu=new LinkedHashSet<Etudiant>();

        EtudiantMP.InitEtu(listeEtu);

        Etudiant e51=new EtudiantMP("prosper","marzio");
        listeEtu.add(e51);
        Etudiant e52=new EtudiantMP("mirabelle","massimiliano");
        listeEtu.add(e52);
        Etudiant e53=new EtudiantMP("carine","matteo");
        listeEtu.add(e53);
        Etudiant e54=new EtudiantMP("jeannine","melchiorre");
        listeEtu.add(e54);
        Etudiant e55=new EtudiantMP("dianne","micaela");
        listeEtu.add(e55);
        Etudiant e56=new EtudiantMP("evette","michela");
        listeEtu.add(e56);
        Etudiant e57=new EtudiantMP("gisselle","michelangela");
        listeEtu.add(e57);

        Groupe g1 = new GroupeMP("test", 0, 25);
        g1.addEtudiant(e57);
        g1.addEtudiant(e55);
        Groupe g2 = new GroupeMP(g1);

        System.err.println("-----");
        for (Etudiant etudiant : listeEtu) {
            System.err.println(etudiant.getNom());
        }
    }
}
