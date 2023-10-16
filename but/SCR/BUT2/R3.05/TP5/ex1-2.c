#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <unistd.h>
#include <sys/wait.h>
#include <fcntl.h>

int main(void){
    int p[2];
    pid_t pid;
    assert(pipe(p)==0);
    pid=fork();
    assert(pid>=0);
    if(pid>0){
        int fd=open("log",O_WRONLY | O_CREAT, S_IRWXU | S_IRWXG | S_IRWXO);
        close(p[1]);
        dup2(p[0],STDIN_FILENO);
        close(p[0]);
        wait(NULL);
        while(1){
            int nb_read;
            char prime;
            nb_read=read(STDIN_FILENO,&prime,sizeof(char));
            write(fd,&prime,sizeof(char));
            if(nb_read==0){
                break;
            }
        }
        close(fd);
    }
    if(pid==0){
        close(p[0]);
        dup2(p[1],STDOUT_FILENO);
        close(p[1]);
        execl("/usr/bin/ls","ls","-i","-l","/tmp",NULL);
    }
}