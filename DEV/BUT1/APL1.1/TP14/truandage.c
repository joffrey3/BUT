#include<stdio.h>
#include<stdlib.h>

int main(void) {
  long long int n = 32217268732456802LL;
  long long int o = 114LL;
  long long int p = 105LL;
  long long int q = 111LL;
  long long int r = 115LL;
  long long int s = 110LL;
  long long int t = 111LL;
  long long int u = 98LL;
  long long int m =(((((o*256+p)*256+q)*256+r)*256+s)*256+t)*256+u;
  printf("%d\n",n/256/256/256/256/256/256);
  printf("%s\n",&o);
  printf("%d\n",n/256/256/256/256/256%256);
  printf("%s\n",&p);
  printf("%d\n",n/256/256/256/256%256);
  printf("%s\n",&q);
  printf("%d\n",n/256/256/256%256);
  printf("%s\n",&r);
  printf("%d\n",n/256/256%256);
  printf("%s\n",&s);
  printf("%d\n",n/256%256);
  printf("%s\n",&t);
  printf("%d\n",n%256);
  printf("%s\n",&u);
  printf("%d\n",&m);
  printf("%s\n",&m);
  return EXIT_SUCCESS;
}
