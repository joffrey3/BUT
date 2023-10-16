#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(int argc,char** argv){
  int i=0,j=0,k=0,ent1=0,nombre[1000],resultat=1,flag1=0,flag2=0;
  char car[1000],chaine[1000],liste[10]="0123456789";
  if(argc<3){
    printf("Il manque des arguments\n");
  }else{
    for(k=1;argv[k]!=NULL;k++){
      strcpy(car,argv[k]);
      if(strtol(car,argv,10)!=0){
	for(i=0;argv[k][i]!='\0';i++){
	  for(j=0;j<10;j++){
	    if(car[i]==liste[j]){
	      ent1=ent1*10+j;
	      flag1=1;
	    }
	  }
	}
      }else{
	ent1=1;
      }
      nombre[k-1]=ent1;
      ent1=0;
    }
    for(i=0;i<k-1;i++){
      resultat=resultat*nombre[i];
    }
    if(flag1==0){
      printf("L'un des deux arguments n'est pas un entier\n");
    }else{
      printf("%d\n",resultat);
    }
  }
  return EXIT_SUCCESS;
}
