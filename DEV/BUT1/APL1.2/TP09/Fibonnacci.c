#include <stdio.h>
#include <stdlib.h>

int Fibonnaci(unsigned n);

int main(void){
  int n;
  n=Fibonnaci(10);
  printf("%d\n",n);
  return EXIT_SUCCESS;
}

int Fibonnaci(unsigned n) {
  if (n > 1) {
    n=Fibonnaci(n-2)+Fibonnaci(n-1);
    return n;
  } else{
    return n;
  }
}