#include <stdlib.h>
#include <stdio.h>
#include <time.h>
 
int main(void) {
	float fl;
	double db;
	long double l_db;
	char ch;
	short int s_i;
	int i;
	long long unsigned int l_l_u_i;
  printf("%p\n", &fl);
  printf("%p\n", &db);
  printf("%p\n", &l_db);
  printf("%p\n", &ch);
  printf("%p\n", &s_i);
  printf("%p\n", &i);
  printf("%p\n", &l_l_u_i);
  return EXIT_SUCCESS;
}
