#include <stdio.h>
#include <stdlib.h>
int main (void){
	int ANNEE = 2100;
	if(ANNEE%4==0 && ANNEE%100!=0 || ANNEE%400==0){
		printf("L'année %d est bissextile\n",ANNEE);
		} else {
		printf("L'année %d n'est pas bissextile\n",ANNEE);
	}
}
