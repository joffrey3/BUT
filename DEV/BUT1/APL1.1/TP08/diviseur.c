#include <stdio.h>                                                              
#include <stdlib.h>
int main(void){
  int nb_choisi, nb_choisi2, impl, min, pgcd;
  printf("Ecrivez un entier positif.\n");
  scanf("%d",&nb_choisi);
  printf("Ecrivez un autre entier positif.\n");
  scanf("%d",&nb_choisi2);
	if (nb_choisi>nb_choisi2){
		min=nb_choisi2;
	}
	if (nb_choisi2>nb_choisi){
		min=nb_choisi;
	}

  for (impl=1;impl<= min;impl =impl +1){
		if(nb_choisi%impl==0 && nb_choisi2%impl==0){
      pgcd = impl;
    }
  }
  printf("Le pgcd de ces deux nombres est : %d\n",pgcd);
  return EXIT_SUCCESS;
}   
