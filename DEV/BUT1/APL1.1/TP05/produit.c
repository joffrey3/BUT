#include <stdio.h>
#include <stdlib.h>
int main (void) {
	int ent_r1, ent_r2;
	printf("Ecrivez un entier relatif. \n");
	scanf("%d",&ent_r1);
	printf("Ecrivez un autre entier relatif. \n");
	scanf("%d",&ent_r2);
	if((ent_r1>0 && ent_r2>0) || (ent_r1<0 && ent_r2<0)){
		printf("Le signe de leur produit est le +\n");
	}
	if((ent_r1>0 && ent_r2<0) || (ent_r1<0 && ent_r2>0)){
		printf("Le signe de leur produit est le -\n");
	}
	return EXIT_SUCCESS;
}
