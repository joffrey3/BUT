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
        close(p[1]);
        dup2(p[0],STDIN_FILENO);
        close(p[0]);
        wait(NULL);
        int increment=0;
        while(1){
            int nb_read;
            char prime;
            nb_read=read(STDIN_FILENO,&prime,sizeof(char));
            increment=increment+1;
            if(nb_read==0){
                printf("La taille du tampon est de %d\n",increment);
                break;
            }
        }
    }
    if(pid==0){
        close(p[0]);
        dup2(p[1],STDOUT_FILENO);
        close(p[1]);
        while(1){
            char prime2='4';
            int nb_write;
            fcntl(STDOUT_FILENO, F_SETFL, fcntl(STDOUT_FILENO, F_GETFL) | O_NONBLOCK);
            nb_write=write(STDOUT_FILENO,&prime2,sizeof(char));
            if(nb_write<=0){
                exit(0);
            }
        }
    }
}