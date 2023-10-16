#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#include <unistd.h>
#include <fcntl.h>
#define BUFSZ 256

int main (int argc,char**argv){
	int f,n;
	char buf[BUFSZ];
	if(argc!=2){
		fprintf(stderr,"usage: %s <message>\n",argv[0]);
		exit(1);
	}
	f=open(argv[1],O_RDONLY);
	if (f==-1){
		perror("Opening file fail !");
		exit(2);
	}
	while ((n=read(f,buf,BUFSZ))!=0){
		write(1,buf,n);
	}
	close(f);
	exit(0);
}