#include <stdio.h>                                                              
#include <stdlib.h>
int main(void){
  int nb_cache=29 , nb_choisi, impl;


  for (impl = 0;impl < 5;impl =impl +1){
  	printf("Ecrivez un entier entre 0 et 100 qui représente le nombre caché.\n");
  	scanf("%d",&nb_choisi);
    if(nb_choisi<nb_cache){
      printf("+\n");
    }
    if(nb_choisi>nb_cache){
      printf("-\n");
    }   
    if(nb_choisi==nb_cache){
      printf("c'est le bon nombre vous avez réussi.\n");
      return EXIT_SUCCESS;
    }
  }
  printf("Vous n'avez pas trouvez le nombre caché.\n");
  return EXIT_FAILURE;
}   

