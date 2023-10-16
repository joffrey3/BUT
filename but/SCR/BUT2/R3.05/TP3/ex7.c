#include <time.h>
#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>


#define SIZE 1000
int n;

int search(int n)
{
  //v3
  int alea,nb=-1,status;
  pid_t x=fork(),x2=0;
  //int milieu = (end-start+1)/n;
  //decalage=0;
  for(int i=0;i<n-2;i++){
    if(x2==0 && x==0){
      x2=fork();
    }
    /*if(x==0){
        x2=fork();
        if(x2==0){
        aléa=random()%128;
        exit(aléa);
        }
    }*/if(x2>0){
      wait(&status);
      if(WIFEXITED(status)){
        nb=WEXITSTATUS(status);
      }
    }
  }
  RAND_MAX=128;
  alea=rand();
  printf("%d\n",nb);
  printf("%d\n",alea);
  if(x==0){
    if(nb>=alea){
      exit(nb);
    }
    if(nb<alea){
      exit(alea);
    }
  }
  if(nb>=alea){
      return nb;
  }
  if(nb<alea){
    return alea;
  }
}

int main(int argc , char * argv[])
{
  if (argc<2){
      printf("argc error\n");
      exit(0);
  };
  n=strtol(argv[1],NULL,0);
	int nombre=search(n);
	printf("Le nombre est %d\n",nombre);
}