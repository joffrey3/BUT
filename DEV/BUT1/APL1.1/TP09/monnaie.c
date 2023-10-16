#include <stdio.h>                                                              
#include <stdlib.h>
int main(void){
  double produit=5.49, client, rendu, repet, argent=0;
	int g_pieces=0, pieces=0, p_pieces=0;
  printf("Combien le client a payé.\n");
  scanf("%lf",&client);
	rendu = client -produit;
	printf("%lf\n",rendu);
	for (rendu;rendu>=2;rendu=rendu-2){
		g_pieces =g_pieces+1;
	}	
	for (rendu;rendu>=0.2;rendu=rendu-0.2){
		pieces =pieces+1;
	}
	for (rendu;rendu>=0.005;rendu=rendu-0.01){
		p_pieces =p_pieces+1;
	}
	printf("Le rendu en piece de 2 est de : %d\n",g_pieces);
	printf("Le rendu en piece de 20 est de : %d\n",pieces);
	printf("Le rendu en piece de 1 est de : %d\n",p_pieces);
  return EXIT_SUCCESS;
}
