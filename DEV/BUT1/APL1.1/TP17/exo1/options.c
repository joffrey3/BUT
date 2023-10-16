#include <stdio.h>
#include <stdlib.h>

typedef enum {AJOUTER, AFFICHER, SORTIR} options;

options saisir_option() {
	short o;
	printf("\nChoisissez une option :\n");
	printf("1] Ajouter une personne.\n");
	printf("2] Afficher le repertoire.\n");
	printf("3] Sortir\n");
	printf("? ");
	scanf("%hd", &o);
	switch(o) {
	case 1 : return AJOUTER;
	case 2 : return AFFICHER;
	case 3 : return SORTIR;
	default : return AFFICHER;
	}
}
