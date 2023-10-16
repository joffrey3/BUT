#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main (void){
	char slash='|',guillemets[2]={'"'};
	printf("{o,o}\n");
	printf("(__(%c\n",slash);
	printf("-%c",'"');
	printf("-%c",'"');
	printf("-\n");
}
