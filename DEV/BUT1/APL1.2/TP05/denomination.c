#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
	int i=0;
	char tab[100], chaine1[3][5],* l[5]={"noir","blanc","rouge","vert","bleu"};
	FILE* f,* f1;
	if (argc != 4) {
		fprintf (stderr, "Nombre d'argument incorrect pour %s \n",argv [0]);
		return EXIT_FAILURE;
	}
	
 	f=fopen("rgb.txt", "r");
 	if(f==NULL){
 		printf("Accès impossible\n");
 		return EXIT_FAILURE;
 	}
	for(;!feof(f);){
		fread(chaine1[0],sizeof(char),3,f);
		fread(tab,sizeof(char),1,f);
		fread(chaine1[1],sizeof(char),3,f);
		fread(tab,sizeof(char),1,f);
		fread(chaine1[2],sizeof(char),3,f);
		fread(tab,sizeof(char),1,f);
   		if (!strcmp(chaine1[0],argv[1]) && !strcmp(chaine1[1],argv[2]) && !strcmp(chaine1[2],argv[3])){
   			fwrite(chaine1[0],sizeof(char),4,stdout);
   			printf(" ");
   			fwrite(chaine1[1],sizeof(char),4,stdout);
   			printf(" ");
   			fwrite(chaine1[2],sizeof(char),4,stdout);
   			printf(" %s",l[i]);

   		}
   		i=i+1;
 	}
 	printf("\n");
 	fclose(f);
}
