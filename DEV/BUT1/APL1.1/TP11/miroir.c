#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main (void){
	int tab[10], impl,i,inv;
	srand(time(NULL));
	for(i = 0; i < 10; i++) {
  	tab[i]=rand()%100-50;
	}
	for(inv=0;inv<2;inv++){
		for(impl=0;impl<10;impl=impl+1){
			printf("+-----",tab[impl]);
		}
		printf("+\n");
		for(impl=0;impl<10;impl=impl+1){
			if (inv ==0){
				printf("| %3d ",tab[impl]);
			}
			if (inv ==1){
				printf("| %3d ",tab[9-impl]);
			}
		}
		printf("|\n");
		for(impl=0;impl<10;impl=impl+1){
			printf("+-----",tab[impl]);
		}
		printf("+\n");
	}
}
