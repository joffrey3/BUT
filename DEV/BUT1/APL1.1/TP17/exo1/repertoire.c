/* TP 19 Exercice 1 : fichier repertoire.c */

#include<stdlib.h>
#include<stdio.h>
#include "repertoire.h"
#include "lire.h"

repertoire construire_repertoire() {
	repertoire r = (repertoire) malloc(sizeof(struct s_repertoire));
	r->taille = 0;
	return r;
}

void afficher_repertoire(repertoire r) {
	int i = 0;
	printf("\n%-30s %-20s\n", "Nom", "Telephone");
	for(; i<r->taille; i++)
		afficher_personne((r->personnes)[i]);
}

int ajouter_personne(repertoire r, personne p) {
	if (r->taille<CAPACITE) {
		(r->personnes)[r->taille] = p;
		(r->taille)++;
		return 0;
	} else
		return 1;
}

void detruire_repertoire(repertoire r) {
	int i = r->taille;
	while(i-->0) {
		free((r->personnes)[i]);
	}
	free(r);
}

