#include <stdio.h>
#include <stdlib.h>
int main(int argc, char const *argv[])
{
	int i=0;
	unsigned char tab[4], tab2[100];
	FILE* f,* tab3;
	if (argc != 2) {
		fprintf (stderr, "Nombre d'argument incorrect pour %s \n",argv [0]);
		return EXIT_FAILURE;
	}
	
 	f=fopen(argv[1], "r");
 	if(f==NULL){
 		printf("Accès impossible\n");
 		return EXIT_FAILURE;
 	}
 	for(;!feof(f);){
	fread(tab,sizeof(char),1,f);
	i=i+1;
	if (i>157 && i<257){
		tab2[i]=tab[0];
		printf("%2hhx ",tab2[i]);
	}
	}
	printf("\n");
 	fclose(f);
}