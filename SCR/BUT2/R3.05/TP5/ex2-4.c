#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <unistd.h>
#include <sys/wait.h>
#include <fcntl.h>

void handler(int n){
        char prime='!';
        write(STDOUT_FILENO,&prime,sizeof(char));
}
void handler2(int b){
        alarm(1);
        int nb_read=1;
        while(nb_read){
        char prime;
            nb_read=read(STDIN_FILENO,&prime,sizeof(char));
            write(STDOUT_FILENO,&prime,sizeof(char));
        }
}

int main(void){

    int p[2];
    pid_t pid;
    pid_t pid2;
    assert(pipe(p)==0);
    pid=fork();
    assert(pid>=0);
    pid2=fork();
    assert(pid2>=0);
    if(pid>0){
        if(pid2>0){
            close(p[0]);
            close(p[1]);
            pause();
        }
        if(pid2==0){
            close(p[0]);
            while(1){
                    pid_t pp = getpid();
                    
                    write(p[1],&pp,sizeof(pid_t));
                    printf("%d sent %d\n",getpid(),pp);
                    sleep(3);

            }
            
            close(p[1]);
            exit(0);
        }
    }
    if(pid==0){
        if(pid2>0){
            close(p[0]);
            while(1){
                    pid_t pp = getpid();
                    
                    write(p[1],&pp,sizeof(pid_t));
                    printf("%d sent %d\n",getpid(),pp);
                    sleep(3);

            }
            close(p[1]);
            exit(2);
        }
        if(pid2==0){
            close(p[1]);
            while(1){
                pid_t p2;
                read(p[0],&p2,sizeof(pid_t));
                printf("%d received %d\n",getpid(),p2);
                
                sleep(1);
            }
            close(p[0]);
            exit(1);
        }
    }
}