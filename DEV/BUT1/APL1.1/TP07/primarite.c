#include <stdio.h>                                                              
#include <stdlib.h>
int main(void){
  int nb_choisi, impl;
  printf("Ecrivez un entier positif.\n");
  scanf("%d",&nb_choisi);


  for (impl=2;impl< nb_choisi;impl =impl +1){
		if(nb_choisi%impl==0){
      printf("c'est un nombre qui n'est pas premier.\n");
      return EXIT_SUCCESS;
    }
  }
  printf("C'est un nombre premier.\n");
  return EXIT_FAILURE;
}   

