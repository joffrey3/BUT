#include<stdio.h>
#include<stdlib.h>
int main(void) {
  struct charactere {
  char champ1;
  int champ2;
  char champ3;
  };
  printf("La taille des champs est : ");
  struct charactere taille={'a','b','c'};
  printf("%d ",sizeof(taille.champ1));
  printf("%d ",sizeof(taille.champ2));
  printf("%d ",sizeof(taille.champ3));
  printf("\n");
  printf("%d ",sizeof(taille));
  printf("\n");
}