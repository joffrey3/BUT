# include <stdio.h>
# include <stdlib.h>

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

int main(void)
{
	char touche[100];
	liste l=NULL;
	for(;touche[0]!='q';){
		printf("La pile attends vos ordres : ");
		fgets(touche,10,stdin);
		if (touche[0]=='+')
		{
			push(touche[1],&l);
		}
		if (touche[0]=='-')
		{
			pop(&l);
		}
	}
}
