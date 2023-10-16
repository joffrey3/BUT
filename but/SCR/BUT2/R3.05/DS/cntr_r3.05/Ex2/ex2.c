/* accès mémoire */
#include<stdio.h>
#include<time.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <unistd.h>


static inline double tstamp(void) 
{                             
	struct timespec tv;
	clock_gettime(CLOCK_REALTIME, &tv);
	return tv.tv_sec + tv.tv_nsec * 1.0e-9;
}

int main(int argc, char *argv[])
{
    if(argc<3 || argc>3){
    perror("argc elements error");
    exit(1);
  }
  int n=strtol(argv[1],NULL,0),lecture=0,i=0;
  char *chaine="part";
  char indent='1';
  char lettre[5];
  char* buf[1];
  int fr=open(argv[2],O_RDONLY);
  int fw,nb,nb2;
  for(int j;j<4;j++){
    lettre[j]=chaine[j];
  }
    lettre[4]=indent;
    printf(lettre);
    fw=open(lettre,O_WRONLY | O_CREAT | O_TRUNC, S_IRWXU | S_IRWXG | S_IRWXO);
  //int fw=open(,O_WRONLY);
  if(fr == -1){
    perror("open fileread error()");
    exit(2);
  }
  if(fw == -1){
    perror("open filewrite error()");
    exit(3);
  }
  nb=read(fr,buf,sizeof(char));
    while(i){
        while(nb>0 && lecture==512*n){
            nb2=write(fw,buf,sizeof(char));
            if(nb2==-1){
              perror("write error()");
            }
            nb=read(fr,buf,sizeof(char));
            lecture=lecture+1;
            }
        if (lecture!=512*n){
            i=1;
        }else{
            close(fw);
            lettre[4]=indent;
            printf(lettre);
            fw=open(lettre,O_WRONLY);
        }
    }
  /*if(nb==-1){
        perror("read error()");
  }*/
  close(fr);
  close(fw);
}
