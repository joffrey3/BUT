#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(int argc,char** argv){
  int i=1,j=0, esp;
  char car[1000];
  for(;argv[i]!=NULL;i++){
    strcpy(car,argv[i]);
    printf("%c\n",car[0]);
  }
   return EXIT_SUCCESS;
}
