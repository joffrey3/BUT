#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <assert.h>
#include <sys/wait.h>
long int fibo (long int n)
{
    if(n<=2){
        return 1L;
    }
    int p[2],p2[2];
    long int retour1,retour2;
    assert(pipe(p)==0);
    assert(pipe(p2)==0);
    pid_t pid=fork();
    assert(pid>=0);

    if(pid>0){
        pid_t pid2=fork();
        assert(pid2>=0);

        if(pid2==0){
            close(p[0]);
            close(p[1]);
            close(p2[0]);
            long int res;
            res=fibo(n-2);
            write(p2[1],&res,sizeof(long int));
            close(p2[1]);
            exit(2);
        }

    }
    
    if(pid==0){
        close(p2[0]);
        close(p2[1]);
        close(p[0]);
        long int res;
        res=fibo(n-1);
        write(p[1],&res,sizeof(long int));
        close(p[1]);
        exit(1);
	    //return (n<=1)?n:fibo(n-1)+fibo(n-2);
    }
    close(p[1]);
    close(p2[1]);
    read(p[0],&retour1,sizeof(long int));
    read(p2[0],&retour2,sizeof(long int));
    close(p[0]);
    close(p2[0]);
    return retour1+retour2;
}



int main(int argc, char *argv[])
{
	long int n;
	assert(argc > 1);
	n=strtol(argv[1],NULL,0);
	printf("fibo(%ld) = %ld\n",n,fibo(n));
	return 0;
}
