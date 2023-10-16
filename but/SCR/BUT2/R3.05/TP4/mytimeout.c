#include <stdio.h>
#include <signal.h>
#include <stdint.h>
#include <stddef.h>
#include <stdbool.h>
#include <unistd.h>
#include <stdlib.h>
#include <time.h>
#include <sys/wait.h>

int res=1;
double t1, t2;

static inline double tstamp(void) 
{                             
	struct timespec tv;
	clock_gettime(CLOCK_REALTIME, &tv);
	return tv.tv_sec + tv.tv_nsec * 1.0e-9;
}


void handler(void){
    //sigset_t nouveauset;
    //sigaddset(&nouveauset,SIGINT);
    //sigaddset(&nouveauset,SIGQUIT);
    //sigprocmask(SIG_SETMASK,&nouveauset,NULL);
    exit(124);
}


int main(int argc, char **argv)
{
    if(argc<2){
        exit(0);
    }
    int status;
    int p=fork();
    if(p==0){
        sigset_t set;
        sigemptyset(&set);
        struct sigaction act = {0};
        act.sa_handler = (void (*)(int))*handler;
        act.sa_mask = set;
        act.sa_flags=0;
        int alarme=1,entier=1,quitter=1;
        //int i=0;
        alarme=sigaction(SIGTERM,&act,NULL);
        //entier=sigaction(SIGINT,&act2,NULL);
        //quitter=sigaction(SIGQUIT,&act3,NULL);
        //alarm(5);
        t1=tstamp();

        int p2=fork();
        if(p2==0){
            res=execvp(argv[2],argv+2);
        }
        if(p2>0){
            while(1){
                //printf("%d",res);
                if(res==0){
                    //printf("%d\n",res);
                    kill(p2,SIGTERM);
                    //printf("oui");
                    exit(0);
                }
            //sigsuspend(&act.sa_mask);
            }
        }
    }

    //printf("oui");
    int p3=fork();
    if(p3==0){
        int nb;
        sleep(strtol(argv[1],NULL,0));
        int pere=getppid();
        //kill(pere,SIGTERM);
        kill(p,SIGTERM);
        wait(&status);
        if(WIFEXITED(status)){
            nb=WEXITSTATUS(status);
            //printf("%d\n",nb);
        }
        exit(nb);
    }
    wait(&status);
    kill(p3,SIGTERM);
    if(WIFEXITED(status)){
        int nb=WEXITSTATUS(status);
        printf("%d\n",nb);
    }
}