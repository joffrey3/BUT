#include <stdio.h>
#include <stdlib.h>

void exemple(unsigned n) ;

int main(void){
  exemple(3);
  return EXIT_SUCCESS;
}

void exemple(unsigned n) {
  if (n != 0) {
    putchar('>');
    exemple(n-1);
    putchar('<');
  } else
    putchar('O');
}