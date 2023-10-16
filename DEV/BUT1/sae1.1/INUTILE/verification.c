#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#include "fonction.h"
#define L 200
#define H 200
int verification(int pos_x,int pos_y,int tab){
	int flag=1,e,f,g,temp,tab2[64]=tab[8][8],zero_x=pos_x,zero_y=pos_y,parite_zero,nb_mouv=0;
	for (;flag!=0;){
		if (zero_x==0 &&zero_y==0){
			parite_zero=nb_mouv%2;
			flag2=0;
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
	nb_mouv=0;
	for (e=0;e<x*y;e++){
		if (tab2[e]!=e){
			for (f=0;f<x*y;f++){
				if (tab2[f]==e){
					g=f;
				}
			}
			temp=tab2[e];
			tab2[e]=tab2[g];
			tab2[g]=temp;
			nb_mouv=nb_mouv+1;
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