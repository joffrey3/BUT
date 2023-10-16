#include <stdio.h>                                                              
#include <stdlib.h>
int main(void){
  int visit, total=0,moyenne, repet;
	 for (repet=0;repet<5 ;repet=repet+1){
  	printf("Ecrivez le nombre de visiteurs.\n");
  	scanf("%d",&visit);
		total = total +visit;
  }
	moyenne=total/repet;
	printf("La moyenne de la semaine est de : %d\n",moyenne);
  return EXIT_SUCCESS;
}
