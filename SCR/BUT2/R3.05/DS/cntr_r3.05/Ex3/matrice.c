/* accès mémoire */
#include<stdio.h>
#include<time.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>

int tab[1][1];
void * matrice(int n)
{
    int x=1,x2=1;
    int buf;
    int p[2];
    tab[n][n+2];
    int vecteur [n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n+2;j++){
            tab[i][j]=random()%20-10;
        }
        vecteur[i]=i;
    }
    pipe(p);
    for(int i=0;i<=n-1;i++){
        if(x>0 && x2>0){
            x2=fork();
            if(x2==0){
                close(p[0]);
                for(int j=0;j<n;j++){
                tab[j][i]=tab[j][i]+vecteur[i];
                buf=tab[j][i];
                write(p[1],&buf,sizeof(int));
                }
                close(p[1]);
                exit(0);
                //printf("%d",tab[0][i]);
            }
        }
        //printf("%d",x2);
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<n+2;j++){
            close(p[1]);
            read(p[0],&buf,sizeof(int));
            tab[i][j]=buf;
            printf(" %d ",tab[i][j]);
        }
        printf("\n");
    }
    close(p[0]);
    //printf("oui");
    return &tab;
}
int main(int argc, char *argv[]){
    if(argc!=2){
        printf("argc error\n");
        exit(0);
    }
    int n=strtol(argv[1],NULL,0);
    int mat**=(int**)matrice(n);
    for(int i=0;i<n;i++){
        for(int j=0;j<n+2;j++){
            printf(" %d ",mat[i][j]);
        }
        printf("\n");
    }
    //printf("%c",mat[i]);
}
