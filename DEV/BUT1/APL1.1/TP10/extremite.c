#include <stdio.h>
#include <stdlib.h>

int main(void) {
  printf("%f\n", +1.0/0.0);
  printf("%f\n", -1.0/0.0);
  printf("%f\n", -0.0/0.0);
  return EXIT_SUCCESS;
}
