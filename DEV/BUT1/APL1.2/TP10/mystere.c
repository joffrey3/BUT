#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <math.h>

unsigned int mystere(unsigned int a,unsigned int b);

int main(void){
  int a=mystere(3,4);
  printf("%d\n",a);
}

unsigned int mystere(unsigned int a,unsigned int b) { 
  if (b==0)
    return 0;
  else
    return a*(b%2)+mystere(2*a,b/2);
}