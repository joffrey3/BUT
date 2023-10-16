# include <stdio.h>
# include <stdlib.h>
# include <string.h>

int main(int argc, char const *argv[])
{
	int i,j;
	char chaine[50];
	for(i=0;i<strlen(argv[1]);i++){
		chaine[i]=argv[1][i];
	}
	char nombre[11]={'0','1','2','3','4','5','6','7','8','9','.'};
	double val;
	for(i=0;i<strlen(chaine);i++){
		printf("oui %c\n",chaine[i]);
		for(j;j<11;j++){
			if(chaine[i]==nombre[j]){
				printf("cool %c\n",chaine[i]);
				val=10*val+j;
			}
		}
	}
	printf("%f\n",val);
	if(strcmp(argv[2],"in")){
		val=val*2.54;
		printf("%f\n",val);
	}
	if(strcmp(argv[2],"cm")){
		val=val/2.54;
		printf("%f\n",val);
	}
}