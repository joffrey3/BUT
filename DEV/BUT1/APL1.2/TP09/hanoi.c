#include <stdio.h>
#include <stdlib.h>
#include <graph.h>

void faireplateau(int taille);

void Hanoi(int taille);

int main(void){
  double tab[2]={1,2};
  Hanoi(4);
  printf("\n");
  return EXIT_SUCCESS;
}

void Hanoi(int taille){
  DessinerRectangle(taille*50,taille*50,taille*50,taille*50);
  if (taille!=0) {
    faireplateau(taille);
    taille=taille-1;
  }
}
void faireplateau(int taille){
  DessinerRectangle(taille*50,taille*50,taille*50,taille*50);
}