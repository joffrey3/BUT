#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(int argc,char** argv){
  int i=0,j=0, ent1=0,ent2=0,resultat=0,flag1=0,flag2=0;
  char car[1000],chaine[1000],liste[10]="0123456789";
  if(argc<3){
    printf("Il manque des arguments\n");
  }else{
  strcpy(car,argv[1]);
  strcpy(chaine,argv[2]);
  for(i=0;argv[1][i]!='\0';i++){
    for(j=0;j<10;j++){
      if(car[i]==liste[j]){
	ent1=ent1*10+j;
	flag1=1;
      }
    }
  }
  for(i=0;argv[2][i]!='\0';i++){
    for(j=0;j<10;j++){
      if(chaine[i]==liste[j]){
	ent2=ent2*10+j;
	flag2=1;
      }
    }
  }
  if(flag1==0 || flag2==0){
    printf("L'un des deux arguments n'est pas un entier\n");
  }else{
    resultat=ent1*ent2;
    printf("%d\n",resultat);
  }
  }
  return EXIT_SUCCESS;
}
