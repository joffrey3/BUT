#include <stdio.h>                                                                                                                                
#include <stdlib.h>
#define TAILLE 5
int main(void){
  int nb0=0,nb1=1,nb2=1, impl;
 
 
  for (impl=0;impl<TAILLE;impl=impl+1){
    if (TAILLE==0){
    	printf("0");
    	return EXIT_SUCCESS;
    }
    if (TAILLE==1 || TAILLE==2){
    	printf("1");
    	return EXIT_SUCCESS;
    }else{
    	nb0=nb1;
    	nb1=nb2;
    	nb2=nb0+nb1;
    }
  }
	printf("%d\n",nb0);
  return EXIT_SUCCESS;
}         
