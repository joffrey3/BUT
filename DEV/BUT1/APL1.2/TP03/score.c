#include <stdio.h>
#include <stdlib.h>

int main (void){
	char tab[40];
	int i;
	FILE * f;
	f=fopen ("top10","r");
	if (f==NULL){
		printf("Accès impossible");
		return EXIT_FAILURE;
	}
	for (i=0;i<10;i++){
		fread(tab,sizeof(char),14,f);
		printf("%s",tab);
	}
	fclose(f);
	return EXIT_SUCCESS;
}