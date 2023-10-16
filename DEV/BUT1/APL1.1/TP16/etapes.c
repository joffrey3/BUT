#include<stdio.h>
#include<stdlib.h>

int main(void) {
  int a = 1, b = 2, c = 3;
  int *p, *q;
 
  p=&a;
  q=&c;
  *p=(*q)++;
  p=q;
  q=&b;
  *p-=*q;
  ++*q;
  *p*=*q;
  a=++*q**p;
  p=&a;
  *q=*p/(*q);
  return EXIT_SUCCESS;
}