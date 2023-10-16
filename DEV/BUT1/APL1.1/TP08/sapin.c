#include <stdio.h>
#include <stdlib.h>
int main (void){
	int hauteur, base, croix, espace;
	printf("Hauteur ? ");
	scanf("%d",&hauteur);
	base = hauteur;
	for (hauteur;hauteur>0;hauteur = hauteur-1){
		for (espace=hauteur;espace>0;espace = espace-1){
			printf(" ");
		}
		for (croix=hauteur;croix<base;croix = croix+1){
			printf("*");
		}
		printf("*");
		for (croix=hauteur;croix<base;croix = croix+1){
			printf("*");
		}
		for (espace=hauteur;espace>0;espace = espace-1){
			printf(" ");
		}
		printf("\n");
	}
}
