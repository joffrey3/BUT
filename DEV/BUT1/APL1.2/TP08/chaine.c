#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

struct maillon_s{
		char valeur;
		struct maillon_s* suivant;
	};
typedef struct maillon_s maillon;
typedef maillon* liste;

void inserer(liste* pl,char caractere);

void creerchaine(liste* pl,char* chaine);

void afficher (liste l);

char* detruirechaine(liste* pl,char* chaine);

char supprimer(liste* pl, int i);

int main (void){
	srand(time(NULL));
	int i;
	liste l=NULL;
	char chaine[200];
	char* chaine2;
	printf("Ecrivez une chaine de charactères : ");
	fgets(chaine,200,stdin);
	creerchaine(&l,chaine);
	afficher(l);
	printf("\n");
	chaine2=detruirechaine(&l,chaine);
	puts(chaine2);
}

void inserer(liste* pl,char caractere){
	maillon* p=(maillon*) malloc(sizeof(maillon));
	p->valeur=caractere;
	p->suivant=*pl;
	*pl=p;
}

void creerchaine(liste* pl,char* chaine){
	int t=strlen(chaine), i;
	for(i=t-1;i>=0;i--){
		inserer(pl,chaine[i]);
	}
}
void afficher (liste l){
	maillon* p;
	for(p=l;p!=NULL;p=p->suivant){
		printf("%c",p->valeur);
	}
}
char* detruirechaine(liste* pl,char* chaine){
	int t=strlen(chaine), i;
	char val;
	for(i=0;i<t;i++){
		val=supprimer(pl,i);
		chaine[i]=val;
	}
	return chaine;
}

char supprimer(liste* pl,int i){
	liste l=*pl;
	char val;
	if(i==0){
		val=l->valeur;
	}else{
		maillon* p=l->suivant;
		l->suivant=l->suivant->suivant;
		val=p->valeur;
		free(p);
	}
	return val;
}