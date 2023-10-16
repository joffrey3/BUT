#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main (void){
	int var1,var2;
	printf("Entrez le premier entier : ");
	scanf("%d",&var1);
	printf("Entrez le deuxieme entier : ");
	scanf("%d",&var2);
	if(var1%2==1 && var2%2==1){
		printf("impair\n");
	}
	else{
		printf("pair\n");
	}
}
