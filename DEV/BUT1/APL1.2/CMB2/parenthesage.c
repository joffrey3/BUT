#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int main(int argc, char *argv[]) {
  int i,par_gauche=0,par_droite=0,valide=1;
  char * n=argv[1];
  /*size_t t=strlen(n);
  printf("%d",t);*/
  for(i=0;i<=10;i++){
  if (n[i]=='('){
    printf("%c",n[i]);
    par_gauche=par_gauche+1;
  }if (n[i]==')'){
    printf("%c",n[i]);
    par_droite=par_droite+1;
  }
  if(par_gauche<par_droite){
    valide=0;
  }
  }
  if (par_gauche==par_droite){
    printf(" OK ");
    if (valide==1){
    printf(" valide ");
  }else{
    printf(" pas_valide ");
  }
  }else{
    printf(" NOTOK ");
  }
  printf("\n");
  return EXIT_SUCCESS;
}