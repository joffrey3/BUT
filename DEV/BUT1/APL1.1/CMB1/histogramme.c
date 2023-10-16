#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define CAPACITE 10
int main (void){
	int tab[CAPACITE],i,var;
		srand(time(NULL));
	for(i=0;i<CAPACITE;i++){
		tab[i]=rand()%21;
	}
	for(i=0;i<CAPACITE;i=i+1){
		var=tab[i];
		for(;var>0;var=var-1){
			printf("a");
		}
		printf("\n");
	}
}
