# include <stdio.h>
# include <stdlib.h>

struct maillon_s {
	char valeur;
	struct maillon_s* suivant;
};
typedef struct maillon_s maillon;
typedef maillon* liste;

int empty(char* l){
	if(l[0]==' '){
		return 0;
	}else{
		return 1;
	}	
}
void push(char val,char* l){
	int i=0;
	for(;l[i]!=' ';){
		i=i+1;
	}
	l[i]=val;
}
char pop(char* l){
	int i=0;
	if (empty(l)){
		for(;l[i]!=' ';){
		i=i+1;
	}
	i=i-1;
	char val=l[i];
	l[i]=' ';
	return val;
	}else{
		printf("La pile est vide !\n");
	}
}
void top(char* pl){
	char val=pop(pl);
	printf("%c\n",val);
	if (empty(pl)){
	push(val,pl);
	}
}
void clear(char* pl){
	for(;empty(pl);){
		pop(pl);
	}
}
int main(void)
{
	char touche[100];
	char* l=(char*)malloc(sizeof(char));
	for(;touche[0]!='q';){
		printf("La pile attends vos ordres : ");
		fgets(touche,10,stdin);
		if (touche[0]=='+')
		{
			if (touche[1]=='+'){
				top(l);
			}else{
				push(touche[1],l);
			}
		}
		if (touche[0]=='-')
		{
			if (touche[1]=='-'){
				clear(l);
			}else{
			char val=pop(l);
			printf("%c\n",val);
			}
		}
	}
}
