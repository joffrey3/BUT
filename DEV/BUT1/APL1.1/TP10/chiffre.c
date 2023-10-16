#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void) {
	double ent;
  printf("Ecrivez un réel : ");
	scanf("%lf",&ent);
  printf("Le chiffre des unités est : %.0f\n",trunc((ent/10-trunc(ent/10))*10));
  printf("Le chiffre des diziemes est : %.0f\n",round((ent-trunc(ent))*10));

  return EXIT_SUCCESS;
}
