#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#include <unistd.h>
#include <fcntl.h>
#define BUFSZE 256

int main (int argc,char**argv){
	int f,n,r;
	char buf[BUFSZE];
	if(argc<2){
		fprintf(stderr,"usage: %s <input><output>\n",argv[0]);
		exit(1);
	}
	f=open(argv[1],O_WRONLY|O_CREAT|O_TRUNC,0600);
	if (f==-1){
		perror("Opening Source file fail !");
		exit(2);
	}
	write(1,"Numb --> ",9);
	while ((n=read(0,buf,BUFSZE))!=0){
		r=write(f,buf,n);
		if(r==-1){
			perror("Writing fail!");
			exit(3);
		}
		write(1,"Numb --> ",9);
	}
	close(f);
	exit(0);
}