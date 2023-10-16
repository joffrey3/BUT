#include <stdio.h>
#include <stdlib.h>
int main (void) {
int resultat,entier=1234;
int resultat2, entier2=0;
printf("Entrez un entier : ");
resultat=scanf("%d", &entier);
printf("Entrez un autre entier : ");
resultat2=scanf("%d", &entier2);
if (resultat==0){
	printf("Erreur vous n'avez pas rentrer de premier entier");
} else{
	printf("Le premier entier tapé est : %d\n", entier);
}
if (resultat2==0){
	printf("Erreur vous n'avez pas rentrer de second entier");
} else{
printf("Le second entier tapé est : %d\n", entier2);
}
}
