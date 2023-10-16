#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main (void){
	int tab[10], impl,i;
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
}
