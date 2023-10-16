/* TP 19 Exercice 1 : fichier personne.c */

#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include "personne.h"
#include "lire.h"

personne construire_personne(const char *nom, const char *tel) {
	personne p = (personne) malloc(sizeof(struct s_personne));
	strcpy(p->nom, nom);
	strcpy(p->tel, tel);
	return p;
}

personne saisir_personne() {
	personne p = (personne) malloc(sizeof(struct s_personne));
	printf("\nEntrez le nom de la personne   : ");
	fflush(stdout);
	lire(p->nom, 30);
	printf("Entrez son numero de telephone : ");
	fflush(stdout);
	lire(p->tel, 20);
	return p;
}

void afficher_personne(personne p) {
	printf("%-30s %-20s\n", p->nom, p->tel);
}

void detruire_personne(personne p) {
	free(p);
}
