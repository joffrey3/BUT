/* TP 19 Exercice 1 : fichier repertoire.h */

#ifndef REPERTOIRE_H
#define REPERTOIRE_H

#include "personne.h"

#define CAPACITE 100

typedef struct s_repertoire {
	int taille;
	personne personnes[CAPACITE];
} * repertoire;

repertoire construire_repertoire();
void afficher_repertoire(repertoire);
int ajouter_personne(repertoire, personne);
void detruire_repertoire(repertoire);

#endif /* REPERTOIRE_H */
