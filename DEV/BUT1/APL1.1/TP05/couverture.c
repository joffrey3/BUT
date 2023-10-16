#include <stdio.h>
#include <stdlib.h>
int main (void) {
	int reparations, part_assurance, part_assure;
	printf("Combien vont couter les réparations ? \n");
	scanf("%d",&reparations);
	if (reparations<=200){
		printf("La franchise est de : %d euros\n",part_assure=reparations);
		printf("La part de l'assurance est de : %d euros\n",part_assurance=0);
	}
if (reparations>200 && reparations<=2000){
		printf("La franchise est de : %d euros\n",part_assure=200);
		printf("La part de l'assurance est de : %d euros\n",part_assurance=reparations-200);
	}
if (reparations>2000 && reparations<=8000){
		printf("La franchise est de : %d euros et %d centimes.\n",part_assure=reparations/10, reparations%10*10);
		printf("La part de l'assurance est de : %d euros et %d centimes\n",part_assurance=reparations*9/10, reparations*9%10*10);
	}
if (reparations>8000){
		printf("La franchise est de : %d euros\n",part_assure=800);
		printf("La part de l'assurance est de : %d euros\n",part_assurance=reparations-800);
	}
	return EXIT_SUCCESS;
}
