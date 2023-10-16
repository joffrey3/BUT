#include <stdio.h>
#include <stdlib.h>
int main(void){
	int i;
	char un_char;
	printf("Ecrivez un mot de passe de moins de 26 caractères ");
	while (i<=26){
		un_char=getchar();
		if (un_char=='\n'){
			printf("l'autentification a réussie\n");
			return EXIT_SUCCESS;
		}
		i=i+1;
	}
	printf("l'autentification a echouée\n");
	return EXIT_FAILURE;
}
