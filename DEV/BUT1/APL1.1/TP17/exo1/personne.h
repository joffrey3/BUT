/* TP 19 Exercice 1 : fichier personne.h */

#ifndef PERSONNE_H
#define PERSONNE_H

typedef struct s_personne {
	char nom[30];
	char tel[20];
} * personne;

personne construire_personne(const char*, const char*);
personne saisir_personne();
void afficher_personne(personne);
void detruire_personne(personne);

#endif /* PERSONNE_H */
