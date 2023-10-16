#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(int argc,char** argv){
  int i=0,j=0,nombre=0;
  char car[1000],chaine[1000];
  for(i=0;argv[i]!=NULL;i++){
    printf("%c\n",car[0]);
    for(j=0;argv[i][j]!='\0';j++){
      chaine[nombre]=argv[i][j];
      nombre=nombre+1;
    }
    chaine[nombre]=' ';
    nombre=nombre+1;
  }
  for(i=0;i<nombre;i++){
    printf("%c",chaine[nombre-2-i]);
    }
  printf("\n");
  return EXIT_SUCCESS;
}
