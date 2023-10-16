/* accès mémoire */
#include<stdio.h>
#include<time.h>
#include <stdlib.h>
#define N 8192 

int t[N][N];

static inline double tstamp(void) 
{                             
	struct timespec tv;
	clock_gettime(CLOCK_REALTIME, &tv);
	return tv.tv_sec + tv.tv_nsec * 1.0e-9;
}

int main()
{
	int i,j;
	double t1,t2;
	t1=tstamp();
	/* version 1 */ //    for(i=0;i<N;i++) for(j=0;j<N;j++) t[i][j] = 1;  
	/* version 2 */   for(i=0;i<N;i++) for(j=0;j<N;j++) t[j][i] = 1;  
	t2=tstamp();
	printf("time = %lf\n",t2-t1);
	return 0;
}
