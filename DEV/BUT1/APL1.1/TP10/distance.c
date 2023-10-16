#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void) {
	double x1, y1, x2, y2;
  printf("Ecrivez un point du plan de coordonnées x = ");
	scanf("%lf",&x1);
  printf("et  y = ");
	scanf("%lf",&y1);
  printf("Ecrivez un autre point du plan de coordonnées x = ");
	scanf("%lf",&x2);
  printf("et  y = ");
	scanf("%lf",&y2);
	printf("La distance entre ces deux point est de : %f\n,",sqrt(pow(x1-x2,2)+pow(y1-y2,2)));
  return EXIT_SUCCESS;
}
