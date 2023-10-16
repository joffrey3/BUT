#ifndef STRUCTURE_H
#define STRUCTURE_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TAILLE_MIN 30
#define TAILLE_INC 10

struct maillon {
	char *nom;
	struct maillon *suivant;
};

typedef struct maillon *liste;

enum indice {DEBUT, FIN, TAILLE_FILE};

typedef liste file[TAILLE_FILE];

#endif
