#include <stdio.h>
#include <stdlib.h>
#include <time.h>
void echange(int* x,int* y){
  int temp=*x;
  *x=*y;
  *y=temp;
}
void affiche(int* tab, int t){
	int impl;
	for(impl=0;impl<t;impl=impl+1){
		printf("+-----",tab[impl]);
	}
	printf("+\n");
	for(impl=0;impl<t;impl=impl+1){
		printf("|     ",tab[impl]);
	}
	printf("|\n");
	for(impl=0;impl<t;impl=impl+1){
		printf("+-----",tab[impl]);
	}
	printf("+\n");
}
int* remplir(int* tab,int t ){
	int impl;
	srand(time(NULL));
	for(impl = 0; impl < t; impl++) {
  	tab[impl]=rand()%100-50;
	}
	for(impl=0;impl<t;impl=impl+1){
		printf("+-----");
	}
	printf("+\n");
	for(impl=0;impl<t;impl=impl+1){
		printf("| %3d ",tab[impl]);
	}
	printf("|\n");
	for(impl=0;impl<t;impl=impl+1){
		printf("+-----");
	}
	printf("+\n");
	return tab;
}

void inverse(int* tab,int t ){
	int impl;
	for(impl=0;impl<t;impl=impl+1){
		printf("+-----");
	}
	printf("+\n");
	for(impl=0;impl<t/2;impl=impl+1){
	  echange(tab+impl,tab+t-1-impl);
	}
	for(impl=0;impl<t;impl=impl+1){
		printf("| %3d ",tab[impl]);
	}
	printf("|\n");
	for(impl=0;impl<t;impl=impl+1){
		printf("+-----");
	}
	printf("+\n");

}

int main (void){
	int tab[10];
	affiche(tab,10);
	inverse(remplir(tab,10),10);
}
