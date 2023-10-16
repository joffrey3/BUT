#include <stdio.h>
#include <stdlib.h>
int main (void){
	int hauteur, rayon, croix, espace, largeur,i;
	printf("Rayon ? ");
	scanf("%d",&rayon);
	i=rayon/2-1;
	for (hauteur=rayon*2-1;hauteur>0;hauteur = hauteur-1){
		if (i >=0 && hauteur<rayon/2+1){
			i=i-1;
		}
		for (espace=rayon-i;espace>0;espace = espace-1){
			printf("  ");
		}
		for (croix=0;croix<i;croix = croix+1){
			printf("* ");
		}
		printf("*");
		for (croix=0;croix<i;croix = croix+1){
			printf(" *");
		}
		for (espace=rayon-i;espace>0;espace = espace-1){
			printf("  ");
		}
		printf("\n");
		if (i <rayon-1 && hauteur>rayon+(rayon/2-1)){
			i=i+1;
		}
	}
}
