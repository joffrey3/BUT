#include <stdio.h>
#include <stdlib.h>
#include<time.h>

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
  FILE *fr;
  FILE *fw;
  int nb,nb2;
  char* buf[4];
  if(argc<3 || argc>3){
    perror("argc elements error");
    exit(1);
  }
  fr=fopen(argv[1],"r");
  fw=fopen(argv[2],"w");
  if(fr == NULL){
    perror("open fileread error()");
    exit(2);
  }
  
  if(fw == NULL){
    perror("open filewrite error()");
    exit(3);
  }
  nb=fread(buf,SEQUENCE,SEQUENCE,fr);
  while(nb>0){
    nb2=fwrite(buf,SEQUENCE,SEQUENCE,fw);
    if(nb2==-1){
      perror("write error()");
    }
    nb=fread(buf,SEQUENCE,SEQUENCE,fr);
    if(nb==-1){
        perror("read error()");
        exit(4);
    }
  }
  fclose(fr);
  fclose(fw);
  t2=tstamp();
  printf("time = %lf\n",t2-t1);
}
