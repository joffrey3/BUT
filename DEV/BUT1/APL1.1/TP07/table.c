#include <stdio.h>                                                              
#include <stdlib.h>
#define TAILLE 20
int main(void){
  int longueur=0, largeur=0;


	for (longueur=0; longueur <= TAILLE+2 ;longueur = longueur+1){
    for (largeur=0; largeur <= TAILLE+1 ;largeur = largeur+1){
  		if(longueur==0){
      	if(largeur==0){
          printf(" X  | ");
        } else {
        	printf(" %3d ",largeur-1);
        }
    	}

			if (longueur==1){
				if(largeur==0){
					printf("----+");
				}else{
					printf("-----");
				}
			}

      if(largeur==0){
        if(longueur>1) {
          printf(" %2d | ",longueur-2);
        }
      }

      if (longueur >1 && largeur>0){
        printf(" %3d ",((longueur-2)*(largeur-1)));
      }
    }
		printf("\n");
  }
	return EXIT_SUCCESS;
}   

