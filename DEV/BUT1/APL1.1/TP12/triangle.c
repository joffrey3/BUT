#include <stdio.h>
#include <stdlib.h>
#define BASE 30

int main (void){
	int i, j,t1[BASE][BASE];
	for (i=0;i<BASE;i=i+1){
		for (j=0;j<BASE;j=j+1){
			if (j>=1){
				if (j<i){
				t1[i][j]=t1[i-1][j-1]+t1[i-1][j];
				}else{
					t1[i][j]=0;
				}
			}
			if (i>=1){
				t1[i][j]=t1[i-1][j-1]+t1[i-1][j];
			}
			if (i<1 && j<1){
				t1[i][j]=1;
			}
		}
	}
	for (i=0;i<BASE;i=i+1){
		for (j=0;j<BASE;j=j+1){
		  if (t1[i][j]!=0){
			printf(" %d",t1[i][j]);
		  }
		}
		printf("\n");
	}
}
