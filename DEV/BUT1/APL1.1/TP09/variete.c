#include <stdio.h>                                                              
#include <stdlib.h>
#define VALEUR 77 
int main(void){
  int repet;
	double valeur;
  printf("Ecrivez le nombre de repetitions.\n");
  scanf("%d",&repet);
  for (repet;repet>0 ;repet =repet-1){
		if (repet%13==0){
      printf("%d\n",VALEUR);
    }
		if (repet%13==1){
      printf("%u\n",VALEUR);
    }
		if (repet%13==2){
      printf("%hd\n",VALEUR);
    }
		if (repet%13==3){
      printf("%hu\n",VALEUR);
    }
		if (repet%13==4){
      printf("%hhd\n",VALEUR);
    }
		if (repet%13==5){
      printf("%hhu\n",VALEUR);
    }
		if (repet%13==6){
      printf("%ld\n",VALEUR);
    }
		if (repet%13==7){
      printf("%lu\n",VALEUR);
    }
		if (repet%13==8){
      printf("%lld\n",VALEUR);
    }
		if (repet%13==9){
      printf("%llu\n",VALEUR);
    }
		if (repet%13==10){
      printf("%e\n",valeur);
    }
		if (repet%13==11){
      printf("%le\n",valeur);
    }
		if (repet%13==12){
      printf("%Le\n",valeur);
    }
  }
  return EXIT_SUCCESS;
}   
