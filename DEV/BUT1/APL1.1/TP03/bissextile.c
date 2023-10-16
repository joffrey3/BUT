#include <stdio.h>
#include <stdlib.h>
int main (void){
	int ANNEE = 2104;
	int BIS = 0;
	if(ANNEE%4==0){
	    BIS = BIS+1;
		if (ANNEE%100==0){
			BIS = BIS-1;
		}
	} 
	if (ANNEE%400==0){
		BIS = BIS+1;
	}
	if (BIS==0){
		printf("L'année %d n'est pas bissextile\n",ANNEE);
		} else {
		printf("L'année %d est bissextile\n",ANNEE);
	}
}

