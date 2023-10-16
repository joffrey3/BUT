#include <stdio.h>
#include <stdlib.h>
#define BOUCLE 192
 
int main(void) {
  int metres,tour=0;
  printf("Entrez une distance en mètres : ", 65);
  scanf("%d",&metres);
  for(metres=metres;metres>BOUCLE;metres=metres-BOUCLE){
    tour = tour+1; /* a chaque fois que la personne fait un tour on lui retire 192 metres */
  }
  printf("%d tour", tour);
  if (metres>BOUCLE/2){
    printf(" et demi \n"); /*si il reste plus de la moitie des metres d'un tour a la fin on le compte en un demi tour */
  } else {
    printf("\n");
  }
  return EXIT_SUCCESS;
}