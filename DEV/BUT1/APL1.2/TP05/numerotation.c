#include <stdio.h>
#include <stdlib.h>

int main(const char* nom)
{
	int i;
	char tab[100];
	FILE* f,* f1;
 	f=fopen("exemple", "r");
 	if(f==NULL){
 		printf("Accès impossible\n");
 		return EXIT_FAILURE;
 	}
	for(;!feof(f);){
   		fgets(tab,100,f);
   		printf("%d ",i);
   		fputs(tab,stdout);
   		i=i+1;
 	}
 	printf("\n");
 	fclose(f);
}
