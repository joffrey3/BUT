#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/mman.h>

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
  off_t offset=0;
  char* buf[4];
  char* tab[10000];
  void* adresse;
  if(argc<3 || argc>3){
    perror("argc elements error");
    exit(1);
  }
  fr=open(argv[1],O_RDONLY);
  fw=open(argv[2],O_WRONLY | O_CREAT | O_TRUNC, S_IRWXU | S_IRWXG | S_IRWXO);
  if(fr == -1){
    perror("open fileread error()");
    exit(2);
  }
  if(fw == -1){
    perror("open filewrite error()");
    exit(3);
  }
adresse=mmap(NULL,1000, PROT_WRITE,MAP_SHARED,fr,offset);
if (adresse == MAP_FAILED){
    perror("mmap");
}
    char* adresse2 = (char*) adresse;
    printf("%d : %c\n",offset,adresse2[0]);
    printf("%d : %c\n",offset,adresse2[1]);
    adresse=mmap(NULL,1000, PROT_READ,MAP_SHARED,fw,offset);
    if (adresse == MAP_FAILED){
      perror("mmap");
    }
    write(fw,adresse2,1000);
    printf("%d : %p\n",offset,adresse);
     //printf("%d : %c\n",offset,tab[offset]);
  close(fr);
  close(fw);
  t2=tstamp();
  printf("time = %lf\n",t2-t1);
}
