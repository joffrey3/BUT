/* accès mémoire */
#include<stdio.h>
#include<time.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>

int main()
{
	int x,x1,x2;
    x=fork();
    x1=fork();
    if (x==0){
        x2=fork();
    }
    sleep(150);

}
