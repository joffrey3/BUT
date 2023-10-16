#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#include <unistd.h>

int main (int argc,char**argv){
	if(argc!=2){
		fprintf(stderr,"usage: %s <message>\n",argv[0]);
		return EXIT_FAILURE;
	}
	while (1) {
		printf("%s",argv[1]);
		fflush(stdout);
		sleep(1);
		exit();
	}
}