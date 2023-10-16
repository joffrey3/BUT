#include<stdio.h>                                                                                                      
         
int main(){
	int CONSTANTE = 32;
    unsigned char t[CONSTANTE][CONSTANTE];
    int k,n;
    for(n=0;n<CONSTANTE;n++){
        for(k=0;k<=n;k++){
            if (k==0||k==n) t[n][k] = 1;
            else t[n][k] = (t[n-1][k] + t[n-1][k-1])%2;
            putchar(t[n][k] ? '*':' ');
        }  
        putchar('\n');
    }    
}      
