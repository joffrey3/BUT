/* TP19 Exercice 1 : fichier main.c */

#include <stdlib.h>
#include <stdio.h>
#include "personne.h"
#include "repertoire.h"
#include "options.h"

int main(void) {
	options opt;
	repertoire r = construire_repertoire();
	while ((opt=saisir_option())!=SORTIR)
		switch(opt) {
		case AJOUTER :
			ajouter_personne(r, saisir_personne());
			break;
		case AFFICHER :
			afficher_repertoire(r);
			break;
		default :
		  ; /* rien a faire */
		}
	detruire_repertoire(r);
	return EXIT_SUCCESS;
}
