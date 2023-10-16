#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <assert.h>
#include <unistd.h>

#define NUM_THREADS 8
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
int var[NUM_THREADS];
void *thread(void *thread_id) {
    int* id = ((int *) thread_id);
    int id1 =  id[0];
    int id2 =  id[1];
    int inc =  id[2];
    //int var = *(int *) malloc(sizeof(int)); 
    write(STDOUT_FILENO,&inc,sizeof(int));
    if(id1>=id2){
        printf("Le vainqueur du duel n %d  n1=%d et n2=%d est : n1=%d\n",inc,id1,id2,id1);
        var[inc]=id1;
        //printf("%d\n",inc);
        return NULL;
    }
    if(id2>id1){
        printf("Le vainqueur du duel n %d n1=%d et n2=%d est : n2=%d\n",inc,id1,id2,id2);
        var[inc]=id2;
        //printf("%d\n",inc);
        return NULL;
    }
}

int main(int argc, char *argv[]) {
    if(argc!=9){
        exit(1);
    }
    int j=0;
    int triple[8][3];
    int tab[NUM_THREADS];
    int tab_quart[NUM_THREADS/2];
    int tab_demi[NUM_THREADS/4];
    int tab_fin[NUM_THREADS/8];
    pthread_t threads[NUM_THREADS];
    for (int i = 0; i < NUM_THREADS; i++){
        tab[i]=strtol(argv[i+1],(char **)NULL,10);
    }
    for (int i = 0; i < NUM_THREADS/2; i++){
        triple[j][0]=tab[j*2];
        triple[j][1]=tab[j*2+1];
        triple[j][2]=j;
        //write(STDOUT_FILENO,&j,sizeof(int));
        assert(pthread_create(&threads[j], NULL, thread,triple[j])==0);
        //printf("%d\n",j);
        j++;
    }
    for (int i = 0; i <j; i++){
        pthread_join(threads[i], NULL);
        //printf("%d\n",var[i]);
        tab_quart[i]= var[i];
        //printf("%d\n",tab_quart[i]);
    }
    int k=j;

    for (int i = 0; i < NUM_THREADS/4; i++){
        triple[j][0]=tab_quart[(j-k)*2];
        triple[j][1]=tab_quart[(j-k)*2+1];
        triple[j][2]=j;
        assert(pthread_create(&threads[j], NULL, thread, triple[j])==0);
        j++;
    }
    for (int i=k;i < j; i++){
        pthread_join(threads[i], NULL);
        //printf("%d\n",var[i]);
        tab_demi[i-k]= var[i];
    }
    int l=j;

    for (int i = 0; i < NUM_THREADS/8; i++){
        triple[j][0]=tab_demi[(j-l)*2];
        triple[j][1]=tab_demi[(j-l)*2+1];
        triple[j][2]=j;
        assert(pthread_create(&threads[j], NULL, thread,triple[j])==0);
        j++;
    }
    for (int i=l; i < j; i++){
        pthread_join(threads[i], NULL);
        //printf("%d\n",var[i]);
        tab_fin[i-l]= var[i];
    }

    pthread_mutex_destroy(&mutex);
    return EXIT_SUCCESS;
}
