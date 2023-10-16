/* adresses virtuelles d'un processus */

#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>
#include<stdlib.h>

int t[1000] = {[0 ... 999] = 2};

int main(int argc, char * argv[])
{
	int i=3;
	static int j = 3;
	char * m = (char*)malloc(1);
	printf("je suis le pid %d\n\n",getpid());
	/* ------- Affichage des adresses --------*/
	printf("main\t=\t%p\n",main);
	printf("&argc\t=\t%p\n",&argc);
	printf("&i\t=\t%p\n",&i);
	printf("&j\t=\t%p\n",&j);
	printf("t\t=\t%p\n",t);
	printf("m\t=\t%p\n",m);

	getchar();
}  
