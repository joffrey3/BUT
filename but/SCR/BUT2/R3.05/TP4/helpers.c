#include "helpers.h"
#include <signal.h>
#include <time.h>
int set_signal_handler(int signo, void (*handler)(int)) {
    struct sigaction sa;
    sa.sa_handler = handler;    // call `handler` on signal
    sigemptyset(&sa.sa_mask);   // don't block other signals in handler
    sa.sa_flags = SA_RESTART;            //  restart system calls
    return sigaction(signo, &sa, NULL);
}
double tstamp(void) {                                                                                    
	struct timespec tv;
	clock_gettime(CLOCK_REALTIME, &tv);
	return tv.tv_sec + tv.tv_nsec * 1.0e-9;
}

