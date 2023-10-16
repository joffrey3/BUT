#include <stdio.h>
#include <stdlib.h>

void quitter(void){
	printf("Au revoir...\n");
}

void triangle (int hauteur){
	int i,j;
	for (i=0;i<hauteur;i++){
		for (j=i+1;j>0;j--){
			printf("*");
		}
		printf("\n");
	}
}

void carre (int hauteur){
	int i,j;
	for (i=0;i<hauteur;i++){
		for (j=0;j<hauteur;j++){
			if (i==0 || i==hauteur-1 || j==0 || j==hauteur-1){
				printf("*");
			} else {
				printf(" ");
			}
		}
	printf("\n");
	}
}

int main (void){
	int hauteur, i, j;
	char choix;
	printf("t) Triangle\n");
	printf("c) Carré\n");
	printf("q) Quitter\n");
	printf("Votre choix ? ");
	scanf("%c",&choix);
	if (choix=='t' || choix=='c'){
		printf("Hauteur ? ");
		scanf("%d",&hauteur);
	}

	if (choix=='q'){
		quitter();
	}
	if (choix=='t'){
		triangle(hauteur);
	}
	if (choix=='c'){
		carre(hauteur);
	}
}