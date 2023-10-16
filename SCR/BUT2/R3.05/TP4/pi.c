#include <stdio.h>
#include <signal.h>
#include <stdint.h>
#include <stddef.h>
#include <stdbool.h>
#include <unistd.h>
#include <stdlib.h>
#include <time.h>

uint64_t shots_in=0,shots=0;
double x,y,t1,t2;

static inline double tstamp(void) 
{                             
	struct timespec tv;
	clock_gettime(CLOCK_REALTIME, &tv);
	return tv.tv_sec + tv.tv_nsec * 1.0e-9;
}


void handler(void){
    sigset_t nouveauset;
    sigaddset(&nouveauset,SIGINT);
    sigaddset(&nouveauset,SIGQUIT);
    sigprocmask(SIG_SETMASK,&nouveauset,NULL);
    double res = (double)shots_in/(double)shots;
    printf("res = %lf\n",res*4);
    alarm(5);
}
void handler2(void){
    sigset_t nouveauset;
    sigaddset(&nouveauset,SIGALRM);
    sigaddset(&nouveauset,SIGQUIT);
    sigprocmask(SIG_SETMASK,&nouveauset,NULL);
    char reponse;
    printf("\n");
    printf("Etes vous sur ?(1 oui 0 non)\n");
    //scanf("%d",&reponse);
    reponse=getchar();
    if(reponse=='1'){
        t2=tstamp();
        printf("time = %lf\n",t2-t1);
        exit(0);
    }
}
void handler3(void){
    sigset_t nouveauset;
    sigaddset(&nouveauset,SIGALRM);
    sigaddset(&nouveauset,SIGINT);
    sigprocmask(SIG_SETMASK,&nouveauset,NULL);
    shots_in=0;
    shots=0;
}


int main(int argc, char **argv)
{
    sigset_t set;
    sigemptyset(&set);
    struct sigaction act = {0};
    act.sa_handler = (void (*)(int))*handler;
    act.sa_mask = set;
    act.sa_flags=0;

    sigset_t set2;
    sigemptyset(&set2);
    struct sigaction act2 = {0};
    act2.sa_handler = (void (*)(int))*handler2;
    act2.sa_mask = set2;
    act2.sa_flags=0;

    sigset_t set3;
    sigemptyset(&set3);
    struct sigaction act3 = {0};
    act3.sa_handler = (void (*)(int))*handler3;
    act3.sa_mask = set3;
    act3.sa_flags=0;
    int alarme=1,entier=1,quitter=1;
    int i=0;
    alarme=sigaction(SIGALRM,&act,NULL);
    entier=sigaction(SIGINT,&act2,NULL);
    quitter=sigaction(SIGQUIT,&act3,NULL);
    alarm(5);
    t1=tstamp();
	for (;i!=1;){
		x = rand()/(RAND_MAX*1.0);
		y = rand()/(RAND_MAX*1.0);
		shots ++;
		if ((x*x+y*y)<=1){
			shots_in ++;
		} 
        sigsuspend(&act.sa_mask);
	}
}   