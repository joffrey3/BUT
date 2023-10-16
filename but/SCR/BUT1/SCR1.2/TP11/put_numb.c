#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <graph.h>
#include <time.h>
#include <unistd.h>
#include <fcntl.h>
#include <limits.h>
#include <errno.h>

#define BUFSZE 256

int main (int argc,char**argv){
	int f,n;
	unsigned long int i,offset,l;
	unsigned int x;
	char buf[BUFSZE];
	if(argc<4){
		fprintf(stderr,"usage: %s <file><32 bit install><offset in Hex>\n",argv[0]);
		exit(1);
	}
	f=open(argv[1],O_WRONLY);
	if (f==-1){
		perror("Opening Source file fail !");
		exit(2);
	}
	x=(unsigned int)strtol(argv[2],NULL,16);
	i=(unsigned long int)strtol(argv[3],NULL,16);
	offset=i*sizeof(int);
	l=lseek(f,0,SEEK_END);
	if (offset>l){
		offset=l;
	}
	l=lseek(f,offset,SEEK_SET);
	if (l==-1)
	{
		perror("lseek fail!");
		exit(3);
	}
	n=write(f,&x,sizeof(int));
	if (n==-1){
		perror("Writing fail!");
		exit(4);
	}
	close(f);
	exit(0);
}