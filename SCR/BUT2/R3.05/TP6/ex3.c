#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <assert.h>
#include <unistd.h>

static inline double tstamp(void)
{
    struct timespec tv;
    clock_gettime(CLOCK_REALTIME, &tv);
    return tv.tv_sec + tv.tv_nsec * 1.0e-9;
}


typedef struct{
    int deb;
    int fin;
    int inc;
    long int res;
}arg_th;
void *sum(void *arg) {
    arg_th* a = ((arg_th *) arg);
    long int S=0;
    for(long int i=a->deb; i<=a->fin;i=i+a->inc){
        S=S+i;
    }
    a->res= S;
}

int main(int argc, char *argv[]) {
    double t1 =tstamp();
    assert(argc==3);
    int N,M;
    long int res=0;
    arg_th * args =NULL;
    pthread_t * th=NULL;
    N=strtol(argv[1],NULL,0);
    M=strtol(argv[2],NULL,0);
    args=(arg_th *) calloc (M,sizeof(arg_th));
    th=(pthread_t *) calloc (M,sizeof(pthread_t));
    for (int i=0;i<M;i++){
        args[i].deb=i+1;
        args[i].fin=N;
        args[i].inc=M;
        args[i].res=0;
        assert(pthread_create(&th[i], NULL, sum,(void *) &args[i])==0);
    }
    for (int i=0;i<M;i++){
        pthread_join(th[i],NULL);
        res=res+args[i].res;
    }
    double t2 =tstamp();
    printf("Le résultat est : %ld\n",res);
    printf("Le temps écoulé est : %g secondes \n",t2-t1);
    return EXIT_SUCCESS;
}
