#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <fcntl.h>
#include <unistd.h>


const unsigned int SEQUENCE=1;

static inline double tstamp(void) 
{                                                                                    
	struct timespec tv;
	clock_gettime(CLOCK_REALTIME, &tv);
	return tv.tv_sec + tv.tv_nsec * 1.0e-9;
}

int main(int argc, char ** argv){
  double t1,t2;
  t1=tstamp();
  int fr;
  int fw;
  int nb,nb2;
  char* buf[4];
  if(argc<3 || argc>3){
    perror("argc elements error");
    exit(1);
  }
  fr=open(argv[1],O_RDONLY);
  fw=open(argv[2],O_WRONLY);
  if(fr == -1){
    perror("open fileread error()");
    exit(2);
  }
  if(fw == -1){
    perror("open filewrite error()");
    exit(3);
  }
  nb=read(fr,buf,SEQUENCE);
  while(nb>0){
    nb2=write(fw,buf,SEQUENCE);
    if(nb2==-1){
      perror("write error()");
    }
    nb=read(fr,buf,SEQUENCE);
  }
  if(nb==-1){
        perror("read error()");
  }
  close(fr);
  close(fw);
  t2=tstamp();
  printf("time = %lf\n",t2-t1);
}
