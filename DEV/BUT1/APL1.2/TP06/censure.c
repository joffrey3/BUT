#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
	int i=0;
	char tab[1],tab2[3]="XXX",tab4[1];
	FILE* f,* tab3;
	if (argc != 2) {
		fprintf (stderr, "Nombre d'argument incorrect pour %s \n",argv [0]);
		return EXIT_FAILURE;
	}
	
 	f=fopen(argv[1], "r+");fwrite(tab2,sizeof(char),3,stdout);
 	tab3=fopen("tampon", "r+");
 	if(f==NULL){
 		printf("Accès impossible\n");
 		return EXIT_FAILURE;
 	}
	for(;!feof(f);){
		fread(tab,sizeof(char),1,f);
   		if (tab[0]=='e'){
			fwrite(tab2,sizeof(char),3,tab3);
			fwrite(tab2,sizeof(char),3,stdout);
   		}else{
   			fwrite(tab,sizeof(char),1,tab3);
   			fwrite(tab,sizeof(char),1,stdout);
   		}
   		i=i+1;
 	}
 	for(;!feof(f);){
 		fread(tab4,sizeof(char),1,tab3);
 		fwrite(tab4,sizeof(char),1,f);
	}
 	printf("\n");
 	fclose(f);
 	fclose(tab3);
}
