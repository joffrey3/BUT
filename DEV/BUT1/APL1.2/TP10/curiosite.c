#include <stdio.h>
#include <stdlib.h>

int f(int n) ; 

int main(void){
  f(0);
}
int f(int n) { 
  printf("%d\n",n);
  if (n>100)
    return n-10;
  else
    return f(f(n+11));
}