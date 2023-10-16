#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <assert.h>

#define NUM_THREADS 16
void *thread(void *thread_id) {
    int id = *((int *) thread_id);
    printf("Hello from thread %d\n", id);
    return NULL;
}

int main() {
    
    int tab[NUM_THREADS];
    pthread_t threads[NUM_THREADS];
    for (int i = 0; i < NUM_THREADS; i++){
        tab[i]=i;
        assert( pthread_create(&threads[i], NULL, thread, &tab[i]) == 0);
    }

    for (int i = 0; i < NUM_THREADS; i++){
        assert( pthread_join(threads[i], NULL) == 0);
    }
    return EXIT_SUCCESS;
}
