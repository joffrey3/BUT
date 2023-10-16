#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main (void){
	int tab[10], impl,max=-51, numero = 0;
	srand(time(NULL));
	for(impl = 0; impl < 10; impl++) {
  	tab[impl]=rand()%100-50;
		if (tab[impl]>max) {
			max = tab[impl];
			numero = impl;
		}
	}
	for(impl=0;impl<10;impl=impl+1){
		if (impl!=numero){
		printf("      ");
		}
		else{
			printf("   |  ");
		}
	}
	printf("\n");
	for(impl=0;impl<10;impl=impl+1){
		if (impl!=numero){
		printf("      ");
		}
		else{
			printf("   V  ");
		}
	}
	printf("\n");
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
}
