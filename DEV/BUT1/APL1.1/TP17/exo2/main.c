#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "structure.h"
#include "saisie.h"
#include "file.h"

#define TAILLE_MIN 30
#define TAILLE_INC 10

int main(void) {
	int choix = 0;
	char *s;
	file f = {NULL, NULL};

	while (choix != '3') {
		printf("\nFaites votre choix :\n");
		printf("\t1. nouveau client\n");
		printf("\t2. client suivant\n");
		printf("\t3. fermer boutique\n");
		printf("? ");
		choix = getchar();
		while(getchar() != '\n');
		switch (choix) {
		case '1':
			s = saisie("Nom du client : ");
			file_push(f, s);
			break;
		case '2':
			if (file_empty(f)) {
				printf("\nAucun Client a l'horizon...\n");
			} else {
				s = file_pop(f);
				printf("\nClient suivant : %s\n", s);
				free(s);
			}
			break;
		case '3':
			printf("\nOn ferme !\n\n");
			break;
		default:
			printf("Ne tapez pas n'importe quoi !\n");
		}
	}
	file_clear(f);
	return EXIT_SUCCESS;
}
