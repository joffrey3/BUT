#include <stdio.h>                                                              
#include <stdlib.h>
int main(void){
	int base, impl2=0, impl=0, premier=0;
	printf("Ecrivez un entier positif : \n");
  scanf("%d",&base);
	printf("%d = ",base);
	for (impl=base;impl>1;impl=impl/premier){
		for (impl2=impl;impl2>1;impl2=impl2-1){
			if (impl%impl2==0){
				premier=impl2;
			}
		}
		printf("%d",premier);
		if (impl2!=1 || impl !=premier){
			printf("*");
		}
	}
	printf("\n");
  return EXIT_SUCCESS;
}   
