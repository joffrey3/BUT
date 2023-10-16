#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define CLOU 10
#define BILLE 10
int main (void){
	int tab[BILLE][CLOU],i,j,k,tab2[BILLE],pos;
		srand(time(NULL));
	for(i=0;i<BILLE;i++){
		for(j=0;j<CLOU;j++){
		tab[i][j]=rand()%2;
		}
	}
	for(i=0;i<BILLE;i++){
		pos=0;
		for(j=0;j<CLOU;j++){
			if (tab[i][j]==0){
				pos=pos-1;
			}
			if (tab[i][j]==1){
				pos=pos+1;
			}
		}
		tab2[i]=pos;
		printf("%d ",pos);
	}

/*	for(i=0;i<BILLE;i++){
		printf("Bille %d\n",i);
		for(j=0;j<CLOU;j++){
			for(k=CLOU-j;k>0;k=k-1){
				printf(" ");
			}
			for(k=j;k>0;k=k-1){
				printf("^ ");
			}
			printf("\n");
		}
		for(j=0;j<CLOU-1;j++){
			if (tab2[i]==j-4){
				printf("|o");
			}
			else{
				printf("|_");
			}
		}
		printf("|\n");
	}*/
}
