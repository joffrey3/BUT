#include <stdio.h> 
#include <stdlib.h>
int main(void){
  int ent1, base,multi ;
	while (base!=-1){
  	printf("Ecrivez un entier.\n");
  	scanf("%d",&ent1);
		base=ent1;
  	multi = 1; 
  	for (ent1;ent1 <= base*10;ent1 =ent1 +base){
	 		printf("%d * %2d = %6d \n",base,multi,ent1);
 			multi =multi+1; 
 		}	 
  	printf("\n");
	}
  return EXIT_SUCCESS;
}

