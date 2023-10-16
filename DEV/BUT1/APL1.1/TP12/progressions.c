#include <stdio.h>
#include <stdlib.h>

int main (void){
	int i, j,k=0, inv,t1[2][5],t2[3][5],t3[5][5];
	for (i=0;i<5;i=i+1){
		for (j=0;j<5;j=j+1){
			k=k+1;
			if (i<2){
				t1[i][j]=j+1;
			}
			if (i<3){
				t2[i][j]=k;
			}
			if (i>j){
				t3[i][j]=j+1;
			}
			else{
				t3[i][j]=0;
			}
		}
	}
	for (i=0;i<5;i=i+1){
		for (j=0;j<5;j=j+1){
			if (i%2==1){
				printf("| %2d ",t1[(i-1)/2][j]);
			}
			else{
				printf("-----");
			}
		}
		if (i%2==1){
			printf("|");
		}
		printf("\n");
	}
	printf("\n");
	for (i=0;i<7;i=i+1){
		for (j=0;j<5;j=j+1){
			if (i%2==1){
				printf("| %2d ",t2[(i-1)/2][j]);
			}
			else{
				printf("-----");
			}
		}
		if (i%2==1){
			printf("|");
		}
		printf("\n");
	}
	printf("\n");
	for (i=0;i<11;i=i+1){
		for (j=0;j<5;j=j+1){
			if (i%2==1){
				printf("| %2d ",t3[(i-1)/2][j]);
			}
			else{
				printf("-----");
			}
		}
		if (i%2==1){
			printf("|");
		}
		printf("\n");
	}
	printf("\n");
	for (i=0;i<11;i=i+1){
		for (j=0;j<2;j=j+1){
			if (i%2==1){
				printf("| %2d ",t1[j][(i-1)/2]);
			}
			else{
				printf("-----");
			}
		}
		if (i%2==1){
			printf("|");
		}
		printf("\n");
	}
	printf("\n");
	for (i=0;i<11;i=i+1){
		for (j=0;j<3;j=j+1){
			if (i%2==1){
				printf("| %2d ",t2[j][(i-1)/2]);
			}
			else{
				printf("-----");
			}
		}
		if (i%2==1){
			printf("|");
		}
		printf("\n");
	}
	printf("\n");
	for (i=0;i<11;i=i+1){
		for (j=0;j<5;j=j+1){
			if (i%2==1){
				printf("| %2d ",t3[j][(i-1)/2]);
			}
			else{
				printf("-----");
			}
		}
		if (i%2==1){
			printf("|");
		}
		printf("\n");
	}
	printf("\n");
}

