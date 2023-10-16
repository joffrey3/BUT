#include <stdio.h>
#include <stdlib.h>
int main(void){
	int i=0,j=0, var_e, char_dif=0, dif;
	char un_char[200];
	printf("Ecrivez une chaine d'au plus 200 caracteres ");
	fgets(un_char,200,stdin);
	while(un_char[i]!='\n' && i<=200){
		dif=1;
		if (un_char[i]=='e'){
			var_e=var_e+1;
		}
		j=i;
		while(j>0){
			j=j-1;
			if (un_char[i]==un_char[j]){
				dif=0;
			}
		}
		i=i+1;
		if (dif==1){
			char_dif=char_dif+1;
		}
	}
	printf("le nombre de e est : %d \n",var_e);
	printf("le nombre de caractères différent est : %d \n",char_dif);
	return EXIT_FAILURE;
}
