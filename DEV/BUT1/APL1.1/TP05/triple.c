#include <stdio.h>
#include <stdlib.h>
int main (void) {
	int ent_nat;
	printf("Ecrivez un entier naturel. \n");
	scanf("%d",&ent_nat);
	if(ent_nat%3==0){
		printf("%d\n",ent_nat);
	}
	if(ent_nat%3==1){
		printf("%d\n",ent_nat-1);
	}
	if(ent_nat%3==2){
		printf("%d\n",ent_nat+1);
	}
	return EXIT_SUCCESS;
}
