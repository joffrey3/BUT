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
	int f,l,n,x;
	long int i,offset;
	char buf[BUFSZE];
	if(argc<3){
		fprintf(stderr,"usage: %s <file><offset>\n",argv[0]);
		exit(1);
	}
	f=open(argv[1],O_RDONLY);
	if (f==-1){
		perror("Opening Source file fail !");
		exit(2);
	}
	i=strtol(argv[2],NULL,0);
	offset=i*sizeof(int);
	l=lseek(f,offset,SEEK_SET);
	if (l==-1)
	{
		perror("lseek fail!");
		exit(3);
	}
	n=read(f,&x,sizeof(int));
	if (n==0)
	{
		printf("Offset is out of range !\n");
	}else{
		printf("The number at offset %ld is 0x%08x-->%d\n",i,x,x);
	}
	close(f);
	exit(0);
}