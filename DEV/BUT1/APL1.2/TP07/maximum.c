#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct maillon_s{
		unsigned short int valeur;
		struct maillon_s* suivant;
	};
typedef struct maillon_s maillon;
typedef maillon* liste;

void inserer(liste* pl);

void creerliste(liste* pl,int t);

void afficher (liste l);

void detruireliste(liste* pl,int t);

void supprimer(liste* pl);

int maximum(int max,liste l);

int main (void){
	srand(time(NULL));
	int i;
	liste l;
	l->suivant=NULL;
	creerliste(&l,10);
	afficher(l);
	printf("\n");
	int max =maximum(0,l);
	printf("%d\n",max);
	detruireliste(&l,10);
}

void inserer(liste* pl){
	maillon* p=(maillon*) malloc(sizeof(maillon));
	int alea=rand()%888+111;
	p->valeur=alea;
	p->suivant=*pl;
	*pl=p;
}

void creerliste(liste* pl,int t){
	for(;t>0;t=t-1){
		inserer(pl);
	}
}
void afficher (liste l){
	maillon* p;
	for(p=l;p!=NULL;p=p->suivant){
		printf("%d ",p->valeur);
	}
}
void detruireliste(liste* pl,int t){
	for(;t>0;t=t-1){
		supprimer(pl);
	}
}
void supprimer(liste* pl){
	liste l=*pl;
	maillon* p=l->suivant;
	*pl=p;
	free(l);
}
int maximum(int max,liste l){
	maillon* p;
	for(p=l;p!=NULL;p=p->suivant){
		if (p->valeur>max){
			max=p->valeur;
		}
	}
	return max;
}