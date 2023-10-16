#include <stdio.h>
#include <stdlib.h>

int main(void) {
  int a = 1, b = 2, c = 3;
  int *p, *q;
 
  p=&a;
  printf("%d %d %d %d %d\n",a,b,c,*p,*q);
  q=&c;
  printf("%d %d %d %d %d\n",a,b,c,*p,*q);
  *p=(*q)++;
  printf("%d %d %d %d %d\n",a,b,c,*p,*q);
  p=q;
  printf("%d %d %d %d %d\n",a,b,c,*p,*q);
  q=&b;
  printf("%d %d %d %d %d\n",a,b,c,*p,*q);
  *p-=*q;
  printf("%d %d %d %d %d\n",a,b,c,*p,*q);
  ++*q;
  printf("%d %d %d %d %d\n",a,b,c,*p,*q);
  *p*=*q;
  printf("%d %d %d %d %d\n",a,b,c,*p,*q);
  a=++*q**p;
  printf("%d %d %d %d %d\n",a,b,c,*p,*q);
  p=&a;
  printf("%d %d %d %d %d\n",a,b,c,*p,*q);
  *q=*p/(*q);
  printf("%d %d %d %d %d\n",a,b,c,*p,*q);
  return EXIT_SUCCESS;
}
