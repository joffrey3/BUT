#include <stdio.h>
#include <stdlib.h>

void affichage(double* tab, int taille);

int main(void){
  double tab[4]={12.3,0,0,0};
  affichage(tab,4);
  printf("\n");
  return EXIT_SUCCESS;
}

void affichage(double* tab, int taille){
  if (taille!=0) {
    printf("%f, ",tab[0]);
    affichage(tab+1,taille-1);
  }
}