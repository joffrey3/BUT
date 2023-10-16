# include <stdio.h>
# include <stdlib.h>
# include <time.h>
# include <graph.h>
# include <math.h>
# include <string.h>

struct maillon_s {
	char valeur;
	struct maillon_s* suivant;
};
typedef struct maillon_s maillon;
typedef maillon* liste;

int empty(liste* l){
	if(*l==NULL){
		return 0;
	}else{
		return 1;
	}	
}
void push(char val,liste* l){
	maillon* m=(maillon*) malloc(sizeof(maillon));
	m->valeur=val;
	m->suivant=*l;
	*l=m;
}
void pop(liste* l){
	if (empty(l)){
		char val;
		maillon* m;
		m=*l;
		val=m->valeur;
		printf("%c\n",val);
		*l=m->suivant;
		free(m);
	}else{
		printf("La pile est vide !\n");
	}
}