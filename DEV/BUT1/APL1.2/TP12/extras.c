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
char pop(liste* l){
	if (empty(l)){
		maillon* p=*l;
		maillon* m;
		for (;p->suivant!=NULL;)
	{
		p=p->suivant;
	}
	m=p;
	p=NULL;
	char val=m->valeur;
	free(m);
	return val;
	}else{
		printf("La pile est vide !\n");
	}
}
void top(liste* pl){
	char val=pop(pl);
	printf("%c\n",val);
	if (empty(pl)){
	push(val,pl);
	}
}
void clear(liste* pl){
	for(;empty(pl);){
		pop(pl);
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
			if (touche[1]=='+'){
				top(&l);
			}else{
				push(touche[1],&l);
			}
		}
		if (touche[0]=='-')
		{
			if (touche[1]=='-'){
				clear(&l);
			}else{
			char val=pop(&l);
			printf("%c\n",val);
			}
		}
	}
}
