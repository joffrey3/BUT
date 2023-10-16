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
		if (ent2>=ent3){
			printf("%d<=%d<=%d\n",ent3,ent2,ent1);
		}
		else{
			if (ent1>=ent3){
				printf("%d<=%d<=%d\n",ent2,ent3,ent1);
			}
			else{
				printf("%d<=%d<=%d\n",ent2,ent1,ent3);
			}
		}
	}
	else {
		if (ent1>=ent3){
			printf("%d<=%d<=%d\n",ent3,ent1,ent2);
		}
		else{
			if (ent2>=ent3){
				printf("%d<=%d<=%d\n",ent1,ent3,ent2);
			}
			else{
				printf("%d<=%d<=%d\n",ent1,ent2,ent3);
			}
		}
	}
	return EXIT_SUCCESS;
}
