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

char *saisie(const char* invite) {
	char *temp = (char *) malloc(TAILLE_MIN);
	int c, i=0, taille = TAILLE_MIN;

	printf("\n%s", invite);
	while(((c=getchar())!=EOF)&&(c!='\n')) {
		if (i>=taille) {
			taille += TAILLE_INC;
			temp = (char *) realloc(temp, taille);
		}
		temp[i++] = c;
	}
	temp = (char *) realloc(temp, i+1);
	temp[i] = '\0';
	return temp;
}

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
