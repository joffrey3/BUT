#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main (void){
	int tab[10], impl,i,neg;
	srand(time(NULL));
	for(i = 0; i < 10; i++) {
  	tab[i]=rand()%100-50;
	}
	for(neg=0;neg<2;neg++){
		for(impl=0;impl<10;impl=impl+1){
			printf("+-----",tab[impl]);
		}
		printf("+\n");
		for(impl=0;impl<10;impl=impl+1){
			if (neg ==1 && tab[impl]<0){
				printf("|     ");
			}
			else{
				printf("| %3d ",tab[impl]);
			}
		}
		printf("|\n");
		for(impl=0;impl<10;impl=impl+1){
			printf("+-----",tab[impl]);
		}
		printf("+\n");
	}
}
