#include <stdlib.h>
#include <stdio.h>
#include <time.h>

int main(void) {
  long long int n = 4614256656552045848LL;
  double* p = (double*) &n;
	double m=*p*2;
	long long int* r = (long long int*) &m ;
  printf("π = %lld\n", n);
  printf("π = %f\n", *p);
  printf("π = %f\n", m);
  printf("π = %lld\n", *r);
  return EXIT_SUCCESS;
}
