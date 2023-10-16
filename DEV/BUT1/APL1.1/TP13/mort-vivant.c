#include <stdlib.h>
#include <stdio.h>
#include <time.h>
 
int main(void) {
  int* p;
 
  if(time(NULL)%2) {
    int x = 59;
    p = &x;
  } else {
    int y = 31;
    p = &y;
  }
  /*fragment inactif
  printf("x=%d\n", x);
  printf("y=%d\n", y);
  */
  printf("%d\n", *p);
  return EXIT_SUCCESS;
}
