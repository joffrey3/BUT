#include <stdio.h>
#include <stdlib.h>
int main (void){
	int VAR = 0;
	int NB = 10;
	printf("Le résultat de %d = %d est %d\n",VAR,NB,VAR==NB);
	printf("Le résultat de %d < %d est %d\n",VAR,NB,VAR<NB);
	printf("Le résultat de %d <= %d est %d\n",VAR,NB,VAR<=NB);
	printf("Le résultat de %d > %d est %d\n",VAR,NB,VAR>NB);
	printf("Le résultat de %d >= %d est %d\n",VAR,NB,VAR>=NB);
	printf("Le résultat de %d != %d est %d\n",VAR,NB,VAR!=NB);
}
