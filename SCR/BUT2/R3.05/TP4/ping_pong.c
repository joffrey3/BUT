#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <stdlib.h>
#include <sys/types.h>
#include <errno.h>
#include <assert.h>

#define N 100
void sig_hand(int sig) {}

sigset_t saveMask, blockMask ;

void player_wait(){
	sigsuspend(&saveMask);
}
void child_process()
{
	int x = 0;
	while(x < N)
	{
		player_wait();
		printf("\tPong %d!\n", ++x);
		kill(getppid(), SIGUSR1);
	}
	return ;
}

void parent_process(pid_t pid)
{
	int y = 0;
	while (y < N)
	{
		printf("Ping %d!\n", ++y);
		kill(pid, SIGUSR1);
		player_wait();
	}
	return ;
}

int main(int argc, char* argv[])
{
	//set up signal handler for parent & child
	struct sigaction sa;
	sigemptyset(&sa.sa_mask);
	sa.sa_flags = 0;
	sa.sa_handler = sig_hand;

    sigaddset(&blockMask,SIGUSR1);
    sigprocmask(SIG_SETMASK,&blockMask,&saveMask);

	assert (sigaction(SIGUSR1, &sa, NULL) != -1);

	pid_t pid = fork();

	if (pid == 0)
		child_process();
	else
		parent_process(pid);
	return 0;
}
