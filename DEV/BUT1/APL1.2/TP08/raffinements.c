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

void changer (liste l);

int taille (liste l);

void concatene (liste* pl,liste* pl2);

int compare (liste* pl,liste* pl2);

char* detruirechaine(liste* pl,char* chaine);

char supprimer(liste* pl, int i);

void copie (liste* pl,liste* pl2);

int main (void){
	srand(time(NULL));
	int i;
	liste l=NULL,l2=NULL;
	char chaine[200];
	char* chaine2;
	int taille2;
	printf("Ecrivez une chaine de charactères : ");
	fgets(chaine,200,stdin);
	creerchaine(&l,chaine);
	creerchaine(&l2,chaine);
	afficher(l);
	taille2=compare(&l,&l2);
	printf("%d\n",taille2);
	copie(&l,&l2);
	afficher(l);
	detruirechaine(&l,chaine);
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
void changer (liste l){
	maillon* p;
	char chaine[200];
	int i=0;
	scanf("%s",chaine);
	for(p=l;p!=NULL;p=p->suivant){
		p->valeur=chaine[i];
		i=i+1;
	}
}
int taille (liste l){
	maillon* p;
	int i=0;
	for(p=l;p!=NULL;p=p->suivant){
		i=i+1;
	}
	return i-1;
}
void concatene (liste* pl,liste* pl2){
	liste l=*pl,l2=*pl2;
	maillon* p, *p2;
	for(p=l->suivant;p->suivant!=NULL;p=p->suivant){
		p=p->suivant;
	}
	p2=l2;
	p->suivant=p2;
}

void copie (liste* pl,liste* pl2){
	liste l=*pl,l2=*pl2;
	maillon* p, *p2;
	for(p=l->suivant;p->suivant!=NULL;p=p->suivant){
		p=p->suivant;
	}
	maillon* p3=(maillon*) malloc(sizeof(maillon));
	p3=l2;
	p->suivant=p3;
	for(p2=l2->suivant;p2->suivant!=NULL;p2=p2->suivant){
		maillon* p3=(maillon*) malloc(sizeof(maillon));
		p3=p2;
		p2=p2->suivant;
		p->suivant=p3;
		p=p->suivant;
	}
}

int compare (liste* pl,liste* pl2){
	liste l=*pl,l2=*pl2;
	maillon* p, *p2;
	int flag=0;
	p=l->suivant;
	p2=l2->suivant;
	for(;p->suivant!=NULL || p2->suivant!=NULL;){
		if(p->valeur!=p2->valeur){
			flag=1;
			return flag;
		}
		p=p->suivant;
		p2=p2->suivant;
	}
	return flag;
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