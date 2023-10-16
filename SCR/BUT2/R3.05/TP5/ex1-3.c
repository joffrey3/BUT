#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <unistd.h>
#include <sys/wait.h>
#include <fcntl.h>

int main(void){
    int p[2],p2[2];
    pid_t pid;
    assert(pipe(p)==0);
    assert(pipe(p2)==0);
    pid=fork();
    assert(pid>=0);
    if(pid>0){
        pid_t pid2;
        pid2=fork();
        assert(pid2>=0);
        if(pid2>0){
            close(p[0]);
            close(p[1]);
            close(p2[1]);
            dup2(p2[0],STDIN_FILENO);
            close(p2[0]);
            wait(NULL);
            wait(NULL);
            while(1){
                int nb_read;
                char prime;
                nb_read=read(STDIN_FILENO,&prime,sizeof(char));
                write(STDOUT_FILENO,&prime,sizeof(char));
                if(nb_read==0){
                    break;
                }
            }
        }
        if(pid2==0){
            wait(NULL);
            close(p[1]);
            dup2(p[0],STDIN_FILENO);
            close(p[0]);
            close(p2[0]);
            dup2(p2[1],STDOUT_FILENO);
            close(p2[1]);
            execl("/usr/bin/wc","wc","-l",NULL);
        }
    }
    if(pid==0){
        close(p2[0]);
        close(p2[1]);
        close(p[0]);
        dup2(p[1],STDOUT_FILENO);
        close(p[1]);
        execl("/usr/bin/ls","ls",".",NULL);
    }
}