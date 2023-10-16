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

void inserer_debut(liste* pl,int val);

void inserer_fin(liste* pl,int val);

void creerliste(liste* pl,int t);

void afficher (liste l);

void detruireliste(liste* pl,int t);

void supprimer(liste* pl);

int supprimer_debut(liste* pl);

int supprimer_fin(liste* pl);

void circulation_arriere(liste* pl,int tour);

void circulation_avant(liste* pl,int tour);

int main (void){
	srand(time(NULL));
	int i;
	liste l;
	l=NULL;
	creerliste(&l,10);
	afficher(l);
	int tour=1;
	for(;tour!=0;){
		printf("Que souhaitez vous faire (0 pour quitter) : ");
		scanf("%d",&tour);
		if(tour<0){
			circulation_arriere(&l,tour);
		}
		if(tour>0){
			circulation_avant(&l,tour);
		}
	afficher(l);
	}
	detruireliste(&l,10);
}
void inserer(liste* pl){
	maillon* p=(maillon*) malloc(sizeof(maillon));
	int alea=rand()%888+111;
	p->valeur=alea;
	p->suivant=*pl;
	*pl=p;
}

void inserer_debut(liste* pl,int val){
	maillon* p=(maillon*) malloc(sizeof(maillon));
	p->valeur=val;
	p->suivant=*pl;
	*pl=p;
}
void inserer_fin(liste* pl,int val){
	liste l=*pl;
	maillon* p=l;
	for (;p->suivant!=NULL;)
	{
		p=p->suivant;
	}
	maillon* m=(maillon*) malloc(sizeof(maillon));
	p->suivant=m;
	m->valeur=val;
	m->suivant=NULL;
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

int supprimer_debut(liste* pl){
	liste l=*pl;
	maillon* p=l->suivant;
	int val=l->valeur;
	*pl=p;
	free(l);
	return val;
}

int supprimer_fin(liste* pl){
	liste l=*pl;
	maillon* p=l;
	maillon* m;
	for (;p->suivant->suivant!=NULL;)
	{
		p=p->suivant;
	}
	m=p->suivant;
	p->suivant=NULL;
	int val=m->valeur;
	free(m);
	return val;
}
void circulation_arriere(liste* pl,int tour){
	int i;
	for(i=0;i>tour;i--){
		int val=supprimer_debut(pl);
		inserer_fin(pl,val);
	}
}
void circulation_avant(liste* pl,int tour){
	int i;
	for(i=0;i<tour;i++){
		int val=supprimer_fin(pl);
		inserer_debut(pl,val);
	}
}