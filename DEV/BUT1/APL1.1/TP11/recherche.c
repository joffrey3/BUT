#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main (void){
	int tab[10], impl,i,valeur;
	srand(time(NULL));
	for(i = 0; i < 10; i++) {
  	tab[i]=rand()%100-50;
	}
	for(impl=0;impl<10;impl=impl+1){
		printf("+-----",tab[impl]);
	}
	printf("+\n");
	for(impl=0;impl<10;impl=impl+1){
		printf("| %3d ",tab[impl]);
	}
	printf("|\n");
	for(impl=0;impl<10;impl=impl+1){
		printf("+-----",tab[impl]);
	}
	printf("+\n");
	printf("Quelle valeur voulez vous chercher : ");
	scanf("%d",&valeur);
	for(impl=0;impl<10;impl=impl+1){
		if (valeur == tab[impl]){
			printf("La position de la valeur la plus a gauche est : %d\n",impl);
			return EXIT_SUCCESS;
		}
	}
	printf("La position de la valeur la plus a gauche est : %d\n",-1);
	return EXIT_FAILURE;
}
