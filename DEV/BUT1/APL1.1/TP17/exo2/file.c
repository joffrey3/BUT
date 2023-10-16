#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "structure.h"

#define TAILLE_MIN 30
#define TAILLE_INC 10

int file_empty(file f) {
	return (f[DEBUT] == NULL);
}

void file_push(file f, char *s) {
	liste l = (liste) malloc(sizeof(struct maillon));
	l->nom = s;
	l->suivant = NULL;
	if (f[FIN] == NULL)
		f[DEBUT] = l;
	else
		f[FIN]->suivant = l;
	f[FIN] = l;
}

char *file_top(file f) {
	return f[DEBUT]->nom;
}

char *file_pop(file f) {
	struct maillon m = *(f[DEBUT]);
	free(f[DEBUT]);
	f[DEBUT]=m.suivant;
	if (f[DEBUT] == NULL)
		f[FIN] = NULL;
	return m.nom;
}

void file_clear(file f) {
	liste tmp,l = f[DEBUT];

	while(l != NULL) {
		tmp = l->suivant;
		free(l->nom);
		free(l);
		l = tmp;
	}
	f[DEBUT] = f[FIN] = NULL;
}
