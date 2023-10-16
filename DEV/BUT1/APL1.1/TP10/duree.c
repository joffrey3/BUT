#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void) {
	double vit, vent, distance, duree;
  printf("Quelle est la vitesse de l'avion ? ");
	scanf("%lf",&vit);
  printf("Quelle est la vitesse du vent ? ");
	scanf("%lf",&vent);
  printf("Quelle est la distance a parcourir ? ");
	scanf("%lf",&distance);
  duree = distance/(vit+vent);
  printf("Il reste %.0f heures,",trunc(duree));
  printf(" %.0f minutes,",(duree - trunc(duree))*60);
  printf(" %.0f secondes \n",(duree-trunc(duree))*60-trunc((duree-trunc(duree))*60));
  return EXIT_SUCCESS;
}
