#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
int main(void){
	int x=fork();
	int status;
	pid_t y=getpid();
	pid_t z=getppid();
	printf("pid du fils ou 0 : %d\n",x);
	printf("pid du père ou du fils : %d\n",y);
	printf("pid inconnu ou du père : %d\n",z);
	switch (x){
		case 0:
			sleep(4);
			exit(2);
		default :
		  x = wait(&status);
		  printf("état du status de la sortie du fils : %d\n",WIFEXITED(status));
		  if(WIFEXITED(status)){
		    printf("code de reour du fils : %d\n",WEXITSTATUS(status));
		  }
		  execl("/usr/bin/ps","ps","-ef",NULL);
	}
}
