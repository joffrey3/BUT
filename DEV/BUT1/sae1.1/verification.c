#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#include "fonction.h"
#define L 200
#define H 200
int verification(int pos_x,int pos_y,int tab){
	int indentation1,indentation2,indentation3,indentation4,temp,tab2[8][8],zero_x=pos_x,zero_y=pos_y,parite_zero,parite,nb_mouv=0;
	flag=1;
	for (indentation1=0;indentation1<x;indentation1++){
		for (indentation2=0;indentation2<x;indentation2++){
			tab2[indentation1][indentation2]=tab[indentation1][indentation2];
		}
	}
	for (;flag!=0;){
		if (zero_x==0 &&zero_y==0){
			parite_zero=nb_mouv%2;
			flag=0;
		}
		else{
			if(zero_x!=0){
				zero_x=zero_x-1;
				nb_mouv=nb_mouv+1;
			}
			if(zero_y!=0){
				zero_y=zero_y-1;
				nb_mouv=nb_mouv+1;
			}
		}
	}
	flag=1;
	nb_mouv=0;
	for (indentation1=0;indentation1<x;indentation1++){
		for (indentation2=0;indentation2<x;indentation2++){
			if (tab2[indentation1][indentation2]!=indentation1*y+indentation2){
				for (indentation3=0;indentation3<x;indentation3++){
					for (indentation4=0;indentation4<x;indentation4++){
						if (indentation1*y+indentation2==tab2[indentation3][indentation4]){
							temp=tab2[indentation1][indentation2];
							tab2[indentation1][indentation2]=tab2[indentation3][indentation4];
							tab2[indentation3][indentation4]=temp;
							nb_mouv=nb_mouv+1;
						}
					}
				}
			}
    	}
	}
    parite=nb_mouv%2;
    if (parite_zero==parite){
    	return 0;
    }
    else{
    	printf("taquin impossible");
    	return 1;
    }
}