#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <assert.h>
#include <sys/wait.h>

long int boucle(long int n,long int premier)
{
    //printf("n = %d\n",n);
    //printf("premier = %d\n",n);
    if(n<=1)
    {
        return 0;
    }
    if(premier==1)
    {
        return n;
    }
    if(n%premier!=0)
    {
        return n;
    }
    else
    {
        return 0;
    }
}

long int * eratosthene (long int n,long int i, long int * tabretour)
{
    if(i==n){
        //long int tabretour[1];
        //tab[0]=0;
        return tabretour;
    }
    if (n==0){
      return NULL;
    }
    if (n==1){
      return NULL;
    }
    long int res;
    int p[2];
    //long int **tabretour;
    //long int * tabretour2=*tabretour;
    //long int tabretour2[n];
    //tabretour[i]=i+1;
    //printf("%ld\n",tabretour[i]);
    assert(pipe(p)==0);
    pid_t pid=fork();
    assert(pid>=0);

    if(pid>0){
            close(p[1]);
            //long int **tab;
            //tab=eratosthene(n,i+1);
            long int *tab2;
            //tab2=*tab;
            read(p[0],&res,sizeof(long int));
            close(p[0]);
            tabretour[i] =res;
            tabretour=eratosthene(n,i+1,tabretour);
            
    }
    
    if(pid==0){
        close(p[0]);
        res=i+2;
        if(res<n){
            for(int j=0;j<i-1;j++){
                if(tabretour[j]!=0){
                    res=boucle(res,tabretour[j]);
                }
            }
        }else{
            res=0;
        }
        //printf("i= %ld\n",i);
        //printf("res = %ld\n",res);
        write(p[1],&res,sizeof(long int));
        close(p[1]);
        exit(1);
    }
    //tabretour=&tabretour2;
    return tabretour;
}

int main(int argc, char *argv[])
{
	long int n;
    long int * res;
    int taille,k=0;
	assert(argc > 1);
	n=strtol(argv[1],NULL,0);
    long int * tab = calloc(n,sizeof(long int));
	printf("fibo(%ld) =\n",n);
    res=eratosthene(n,0,tab);
    for (long int i=0;i<n;i++){
        //printf("%ld\n",res[i]);
    }
    for(int j=0;j<n;j++){
        if(tab[j]!=0)
        {
            taille=taille+1;
            //printf("tab %d = %d\n",k,tab[j]);
        }
        //printf("tab= %d\n",tabretour[j]);
    }
    long int *tabretour = tab;
    printf("[");
    for(int j=0;j<n;j++){
        if(tabretour[j]!=0)
        {
            //printf("tab %d = %d\n",k,tab[k]);
            tab[k]=tabretour[j];
            //printf("tab %d = %d\n",k,tabretour[j]);
            if(k==0){
                printf(" %d",tab[k]);
            }else{
                printf(", %d",tab[k]);
            }
            k=k+1;
        }
    }
    printf("]\n");
    free(tab);
	return 0;
}
