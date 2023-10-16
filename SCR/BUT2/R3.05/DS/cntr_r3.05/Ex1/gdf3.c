/* accès mémoire */
#include<stdio.h>
#include<time.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>

int main()
{
    int p[2];
	int x,x1,x2;
    x=fork();
    if(x>0){
        close(p[0]);
        close(p[1]);
    }
    x1=fork();
    if(x>0 && x1==0){
        int pid=getpid();
        close(p[0]);
        write(p[1],&pid,sizeof(int));
        close(p[1]);
        exit(0);
    }
    if (x==0){
        x2=fork();
        if(x1>0 && x2==0){
        close(p[0]);
        close(p[1]);
        exit(0);
    }
    if(x1==0 && x2>0){
        close(p[1]);
        close(p[0]);
        exit(0);
    }
    if(x1==0 && x2==0){
        int pid=0;
        close(p[1]);
        read(p[0],&pid,sizeof(int));
        close(p[0]);
        write(STDOUT_FILENO,&pid,sizeof(int));
        exit(pid);
    }
    }
    if(x==0 && x1>0 && x2>0){
        close(p[0]);
        close(p[1]);
        exit(0);
    }
    int nb=0,status;
    while(nb==0){
        wait(&status);
        if(WIFEXITED(status)){
            nb=WEXITSTATUS(status);
            printf("%d\n",nb);
        }
    }
    printf("%d\n",nb);
    //sleep(150);

}
