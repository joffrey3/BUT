#include <stdio.h>
#include <stdlib.h>
int main (void){
	int x = 3;
	if (x=2){
		printf("x vaut 2\n");
	} else {
		printf("x est different de 2\n");
		}
		printf("la valeur de x est en fait %d\n",x);
		if (x=0) {
			printf("x vaut 0\n");
		} else {
			printf("%s","x est different de 0\n");
		}
		printf("la valeur de x est en fait %d\n", x);
		return EXIT_SUCCESS;
}
