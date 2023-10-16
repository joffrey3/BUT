#include <stdio.h>
#include <stdlib.h>

int main (void){
	char tab[40],tab2[14]={'0','0','0','1','5','8','1','4','2','7',' ','>','_','>'};
	int i,nb=1581427;
	FILE * f1;
	f1=fopen ("top10","r");
	if (f1==NULL){
		printf("Accès impossible");
		return EXIT_FAILURE;
	}
	for (i=0;i<10;i++){
		fread(tab,sizeof(char),14,f1);
		printf("%s",tab);
	}
	fclose(f1);
	FILE * f2;
	f2=fopen ("top10_2","w");
	if (f2==NULL){
		printf("Accès impossible");
		return EXIT_FAILURE;
	}
	for (i=0;i<10;i++){
			printf("%s",tab);
			fwrite(tab,sizeof(char),14,f2);
			fwrite(tab2,sizeof(char),14,f2);
	}
	fclose(f2);
	return EXIT_SUCCESS;
}