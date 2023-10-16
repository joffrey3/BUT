#include <stdio.h>
#include <stdlib.h>
#define MAX 999999999

int main(void) {
  int nb ;
  for(nb=0;nb*nb*nb<=MAX;nb++){
    printf("%d\n",nb*nb*nb); /* on regarde le cube de chaque nombre et on l'écrit tant qu'il ne depasse pas le max */
  }
  return EXIT_SUCCESS;
}