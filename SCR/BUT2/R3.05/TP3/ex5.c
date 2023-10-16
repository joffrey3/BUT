#include <time.h>
#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>


#define SIZE 1000
int n;

int search(const unsigned char * t,int start,int end)
{
	/* renvoie 1 s'il y a un 0 dans la tranche du tableau, 
	 * 0 sinon */

  //v1
  /*pid_t x=fork();
  int status;
  int milieu = (end-start)%2;
  switch(x){
  case 0 :
    for(int i=start;i<milieu;i++){
      if(t[i]==0){
	exit(1);
      }
    }
    exit(0);
  default :
    for(int i=milieu;i<end;i++){
      if(t[i]==0){
	return 1;
      }
    }
    x=wait(&status);
    if(status==1){
      return 1;
    }
    return 0;
    }*/
    /* renvoie 1 s'il y a un 0 dans la tranche du tableau, 
	 * 0 sinon */

  //v2
  /*int status=0,nb,constante=0,decalage;
  pid_t x=fork();
  int milieu = (end-start+1)/n;
  decalage=0;
  for(int i=0;i<n-1;i++){
    switch(x){
      case 0 :
        for(int i=decalage;i<decalage+milieu;i++){
          if(t[i]==0){
	          exit(1);
          }
        }
        exit(0);
      default : 
        decalage=decalage+milieu;
        x=fork();
    }
  }
  if(x==0){
    for(int i=decalage;i<decalage+milieu;i++){
      if(t[i]==0){
        exit(1);
      }
    }
    exit(0);
  }
    for(int i=0;i<n;i++){
      wait(&status);
      if(WIFEXITED(status)){
        nb=WEXITSTATUS(status);
        if(nb==1){
        constante=nb;
      }
      }
    }
    return constante;*/


  //v3
  int status=0,nb,constante=0,decalage;
  pid_t x=fork();
  int milieu = (end-start+1)/n;
  decalage=0;
  for(int i=0;i<n-1;i++){
    switch(x){
      case 0 :
        for(int i=decalage;i<decalage+milieu;i++){
          if(t[i]==0){
	          exit(1);
          }
        }
        exit(0);
      default : 
        decalage=decalage+milieu;
        x=fork();
    }
  }
  if(x==0){
    for(int i=decalage;i<decalage+milieu;i++){
      if(t[i]==0){
        exit(1);
      }
    }
    exit(0);
  }
    for(int i=0;i<n;i++){
      wait(&status);
      if(WIFEXITED(status)){
        nb=WEXITSTATUS(status);
        if(nb==1){
        constante=nb;
        kill(-status,SIGTERM);
      }
      }
    }
    return constante;
}

int main(int argc , char * argv[])
{
	unsigned char arr[SIZE];
	int i;
	srandom(time(NULL));
	
	for (i = 0; i < SIZE; i++)
		arr[i] = (unsigned char) (random() % 255) + 1;

	printf("Enter a number between 0 and %d: ", SIZE);
	scanf(" %d", &i);
  n = strtol(argv[1],NULL,0);
	if (i >= 0 && i < SIZE) arr[i] = 0;

	if (search(arr,0,SIZE-1)) 
		printf("Found !\n");
	else 
		printf("Not Found !\n");
}