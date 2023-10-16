#include<unistd.h>
#include<stdio.h>
#include<stdlib.h>
#include<signal.h>
#include<stdint.h>
#include<assert.h>
#include "helpers.h"

int x=2,y=3;
int swap(int *x,int *y){
	int tmp=*x;
	*x=*y;
	*y=tmp;
}

void sig_handler(int signo){
	switch(signo){
		case SIGQUIT : 
			printf("x=%d y=%d\n",x,y);
			break;
	}
}

int main(int argc,char * argv[]){
    sigset_t nouveauset;
    sigaddset(&nouveauset,SIGQUIT);
    sigprocmask(SIG_SETMASK,&nouveauset,NULL);
	assert(set_signal_handler(SIGQUIT,sig_handler)==0);
	while(1){
		swap(&x,&y);
	}
}
