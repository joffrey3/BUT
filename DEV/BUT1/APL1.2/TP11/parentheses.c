#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

struct parent {
  char par;
  struct parent* suivant;
};
typedef struct parent parenthese;
typedef struct parent* liste;

int empty(liste* p){
  if(*p==NULL){
    return 0;
  }else{
    return 1;
  }
}

void ajout(char val,liste* p){
  parenthese* m = (parenthese*)malloc(sizeof(parenthese));
  m->par=val;
  m->suivant=*p;
  *p=m;
}
char retire(liste* p){
  if (empty(p)){
    char val;
    parenthese* m;
    m=*p;
    val=m->par;
    *p=m->suivant;
    free(m);
    return val;
  }else{
    printf("La pile est vide !\n");
  }
}
int main(int argc, char *argv[]) {
  int i;
  char * n=argv[1];
  liste p=NULL;
  for(i=0;i<strlen(argv[1]);i++){
  if (n[i]=='(' || n[i]==')' || n[i]=='[' || n[i]==']' || n[i]=='{' || n[i]=='}'){
    ajout(n[i],&p);
    if(p->suivant!=NULL){
      if(p->par==')' && p->suivant->par=='(' || p->par==']' && p->suivant->par=='[' || p->par=='}' && p->suivant->par=='{'){
        retire(&p);
        retire(&p);
      }
    }
  }
}
  if (p->suivant=NULL){
    printf("Bienjoué");
  }else{
    printf("Perdu");
  }
  printf("\n");
  return EXIT_SUCCESS;
}