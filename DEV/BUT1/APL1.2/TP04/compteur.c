#include <stdio.h>
#include <stdlib.h>

int main (void){
	int x=0,y=0,i;
	FILE * f, * f1, * f2, * f3;
	f3=fopen ("compteur","a");
	if (f3==NULL){
		printf("Accès impossible\n");
		return EXIT_FAILURE;
	}
	fwrite(&x,sizeof(int),1,f3);
	fclose(f3);
	f1=fopen ("compteur","r");
	if (f1==NULL){
		printf("Accès impossible\n");
		return EXIT_FAILURE;
	}
	fread(&x,sizeof(int),1,f1);
	fclose(f1);
	f=fopen ("compteur","w");
	if (f==NULL){
		printf("Accès impossible\n");
		return EXIT_FAILURE;
	}
	y=x;
	x=x+1;
	fwrite(&x,sizeof(int),1,f);
	fclose(f);
	f2=fopen ("compteur","r");
	if (f2==NULL){
		printf("Accès impossible\n");
		return EXIT_FAILURE;
	}
	fread(&x,sizeof(int),1,f2);
	printf("%d\n",x);
	fclose(f2);
	return EXIT_SUCCESS;
}