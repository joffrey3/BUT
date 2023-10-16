#include <stdio.h>
#include <stdlib.h>
#include <math.h>

unsigned long int  factorielle(int n){
  if(n!=0){
    unsigned long int m;
    m=n*factorielle(n-1);
    if (m*(n+1)<pow(2,63)*1.8){
      return m;
    }else{
      return 0;
    }
  }else{
    return 1;
  }
}

int main(int argc, char *argv[]) {
  unsigned long int l,temp;
  int n = 0,i=1;
  for(;i!=0;){
  temp=factorielle(i);
  if (temp!=0){
    l=temp;
    i=i+1;
  }else{
    n=i-1;
    i=0;
    }
  }
  printf("valeur de n = %d, valeur de %d! = %lu\n", n, n, l);
  return EXIT_SUCCESS;
}