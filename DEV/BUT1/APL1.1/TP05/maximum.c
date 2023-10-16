#include <stdio.h>
#include <stdlib.h>
int main (void) {
	int ent1, ent2, ent3;
	printf("Ecrivez un entier. \n");
	scanf("%d",&ent1);
	printf("Ecrivez un autre entier. \n");
	scanf("%d",&ent2);
	printf("Ecrivez encore un autre entier. \n");
	scanf("%d",&ent3);
	if(ent1>=ent2){
		if (ent1>=ent3){
			printf("%d\n",ent1);
		}
		if (ent3>=ent1){
			printf("%d\n",ent3);
		}
	}
	if(ent2>=ent1){
		if (ent2>=ent3){
			printf("%d\n",ent2);
		}
		if (ent3>=ent2){
			printf("%d\n",ent3);
		}
	}
	return EXIT_SUCCESS;
}
