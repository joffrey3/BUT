#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void) {
	int impl;
	double real;
	char car,vide;
  printf("Saisir un réel : ");
  scanf("%lf",&real);
	printf("%.10e\n",real);
 	printf("Saisir un caractere : ",car);
	scanf("%c",&vide);
	scanf("%c",&car);
	for (impl=0;impl<5;impl++){
		printf("%c",car);
	}
	printf("\n");
  return EXIT_SUCCESS;
}
