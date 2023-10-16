#include <stdlib.h>
#include <stdio.h>
#include <string.h>
 
void envers(const char texte[]) {
  int position ;
  for(position = strlen(texte)-1; position >= 0; position--) {
    printf("%c", texte[position]);
  }
  printf("\n");
}
 
int main(int argc, char** argv) {
  if (argc < 2) {
    printf("usage : %s <texte>\n", argv[0]);
    return EXIT_FAILURE;
  }
  envers(argv[1]);
  return EXIT_SUCCESS;
}