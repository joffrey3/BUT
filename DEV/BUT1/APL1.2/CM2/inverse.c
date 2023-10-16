#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct maillon_s{
		unsigned short int valeur;
		struct maillon_s* suivant;
	};
typedef struct maillon_s maillon;
typedef maillon* liste;

void inserer(liste* pl,int val);

void afficher (liste l);

void supprimer(liste* pl);

int main (void){
	srand(time(NULL));
	int i=0;
	liste l;
	l=NULL;
	int tour=1;
	int val;
		printf("Combien d'entiers voulez vous utilisez : ");
		scanf("%d",&tour);
		int temp=tour;
		for(;tour>0;tour=tour-1){
			i=i+1;
			printf("Entrez entier n %d : ",i);
			scanf("%d",&val);
			inserer(&l,val);
		}
	afficher(l);
	for(;temp>0;temp=temp-1){
		supprimer(&l);
	}
	
}
void inserer(liste* pl,int val){
	maillon* p=(maillon*) malloc(sizeof(maillon));
	p->valeur=val;
	p->suivant=*pl;
	*pl=p;
}

void afficher (liste l){
	maillon* p;
	for(p=l;p!=NULL;p=p->suivant){
		printf("%d ",p->valeur);
	}int val=l->valeur;
	printf("\n");
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