#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define ENT1 0.5
#define ENT2 6
#define ENT3 13
#define ENT4 4
#define ENT5 -3
#define ENT6 2

int main(void) {
	double real;
	char car;
  printf("Le résultat de la formule 1 est : %f\n",sqrt(fabs(log(ENT1))));
  printf("Le résultat de la formule 2 est : %f\n",sin(M_PI/ENT2));
  printf("Le résultat de la formule 3 est : %f\n",atan(pow(ENT3,2)));
  printf("Le résultat de la formule 4 est : %f\n",pow(exp(-1),ENT4));
  printf("Le résultat de la formule 5 est : %f\n",log(ENT5));
  printf("Le résultat de la formule 6 est : %f\n",pow(sqrt(ENT6),2));
  return EXIT_SUCCESS;
}
