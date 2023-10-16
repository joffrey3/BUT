#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <assert.h>
#include <unistd.h>

typedef struct{
    int max;
    int pos;
    int tab[];
} stack_t;

stack_t * stack_create(int max_size);

int stack_destroy(stack_t *s);

int stack_push(stack_t *s, int val);

int stack_pop(stack_t *s,int *val);


int main(int argc, char *argv[]) {
    stack_t* tableau= NULL;
    int val;
    int cont[1];
    assert(stack_push(tableau,val)==1);
    assert(stack_pop(tableau,cont)==1);
    tableau = stack_create(10);
    printf("%d\n",tableau->max);
    assert(stack_pop(tableau,cont)==1);
    for(int i=0;i<tableau->max;i++){
        val=i*10;
        assert(stack_push(tableau,val)==0);
        printf("%d\n",tableau->pos);
        printf("%d\n",tableau->tab[i]);
        printf("\n");
    }
    assert(stack_push(tableau,val)==1);
    for(int i=0;i<tableau->max;i++){
        //val=i*10;
        assert(stack_pop(tableau,cont)==0);
        printf("%d\n",tableau->pos);
        printf("%d\n",cont[0]);
        printf("\n");
    }
    assert(stack_pop(tableau,cont)==1);
    if(stack_destroy(tableau)==0){
        tableau=NULL;
    }
    assert(stack_push(tableau,val)==1);
    assert(stack_pop(tableau,cont)==1);
}


stack_t * stack_create(int max_size){
    stack_t* s= malloc(sizeof(int)+sizeof(int)*max_size);
    s->max=max_size;
    s->pos=0;
    int t[max_size];
    for(int i=0;i<max_size;i++){
        s->tab[i]=0;
    }
    return s;
}

int stack_push(stack_t *s, int val){
    if(s==NULL){
        return 1;
    }
    if(s->pos==10){
        return 1;
    }
    s->tab[s->pos]=val;
    s->pos++;
    return 0;
}

int stack_pop(stack_t *s, int *val){
    if(s==NULL){
        return 1;
    }
    if(s->pos==0){
        return 1;
    }
    val[0]=s->tab[s->pos-1];
    s->tab[s->pos-1]=0;
    s->pos--;
    return 0;
}

int stack_destroy(stack_t *s){
    free(s);
    return 0;
}