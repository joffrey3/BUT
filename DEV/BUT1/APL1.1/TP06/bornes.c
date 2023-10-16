
#include <stdio.h> 
#include <stdlib.h>
int main(void){
  int ent1, impl, max=0, min=0, base ;
	while (base!=-1){
  	printf("Ecrivez un entier.\n");
  	scanf("%d",&ent1);
		base=ent1;
		if (ent1==-1){
			printf("Le maximum est : %d\n",max);
  		printf("Le minimum est : %d\n",min);
  		return EXIT_SUCCESS;
		}
		if (max == 0 && min == 0){
			min=ent1;
			max=ent1;
		}
		if (ent1>max){
			max=ent1;
		}
		if (ent1<min){
			min=ent1;
		}
	}
}
