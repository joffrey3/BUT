#include <stdlib.h>
#include <stdio.h>
 
int somme(int n, int m) {
  return n+m;
}
 
int main(void) {
  int valeur;
  int* p = &valeur;
  printf("Entrez un entier : ");
  scanf("%d", p);
 
  printf("Le double vaut %d\n", somme(*p, *p));
  return EXIT_SUCCESS;
}