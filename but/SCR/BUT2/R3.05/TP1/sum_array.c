#include<stdio.h>
#include<time.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
static inline double tstamp(void) 
{                                                                                    
	struct timespec tv;
	clock_gettime(CLOCK_REALTIME, &tv);
	return tv.tv_sec + tv.tv_nsec * 1.0e-9;
}
void shuffle(int *array, size_t n)
{
	if (n > 1)
	{
		size_t i;
		for (i = 0; i < n - 1; i++)
		  //for (i = 0; i < n ; i++)
		{
		  //size_t j = i + rand() / (RAND_MAX / (n - i) + 1);
			size_t j = rand()%n;
			int t = array[j];
			array[j] = array[i];
			array[i] = t;
		}
	}
}
void init_access_c(int access[],size_t size)
{
	int i;
	for(i=0;i<size;i++) access[i] = i;
}
void init_access_d(int access[],size_t size)
{
	int i;
	for(i=0;i<size;i++) access[i] = size-i-1;
}
void init_access_a(int access[],size_t size)
{
  init_access_c(access,size);
  shuffle(access,size);
}
void init_array(int t[],int N)
{
	int i;
	for(i=0;i<N;i++) t[i] = i ;
}
long int sum_array(int t[],int access[],size_t size)
{
	long int S=0;
	int i;
	for(i=0;i<size;i++) S += t[access[i]];
	return S;
}
int main(int argc,char * argv[])
{
	double t1,t2;
	int * array; // tableau à sommer (contient les tous les entiers [0,SIZE-1]
	int * access;
	int i,size;
	long	int  S=0;
	if (argc !=3) {
		printf("%s -c|-d|-a SIZE\n",argv[0]);
		return 1;
	}
	size=strtol(argv[2],NULL,0);
	array=(int *)malloc(sizeof(int)*size);
	assert(array != NULL);
	access=(int *)malloc(sizeof(int)*size);
	assert(access != NULL);
	init_array(array,size);
	if (strcmp(argv[1],"-c") == 0)
		init_access_c(access,size);
	if (strcmp(argv[1],"-d") == 0)
		init_access_d(access,size);
	if (strcmp(argv[1],"-a") == 0){
		init_access_a(access,size);
	}
	/* On somme les elements en accedant au tableau 
	 * sequentiellement (croissant/décroissant), ou 
	 * de manière aléatoire
	 * */
	t1=tstamp();
	S= sum_array(array,access,size);
	t2=tstamp();
	printf("S=%ld %lf\n",S,(t2-t1));
}
