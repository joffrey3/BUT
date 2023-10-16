#include <stdio.h>                                                              
#include <stdlib.h>
int main (void) {
  int moyenne;
  printf("Ecrivez votre moyenne. \n");
  scanf("%d",&moyenne);
  while(moyenne<10){
    printf("Ce n'est pas une note correcte.\n");
    scanf("%d",&moyenne);
  }
  if(moyenne>=10 && moyenne<12){
    printf("Vous avez eu votre bac mais pas de mention\n");
  }
  if(moyenne>=12 && moyenne<14){
    printf("Vous avez eu votre bac avec une mention assez bien\n");
  }
  if(moyenne>=14 && moyenne<16){
    printf("Vous avez eu votre bac avec une mention bien\n");
  }
  if(moyenne>=16){
    printf("Vous avez eu votre bac avec une mention tres bien\n");
  }
  return EXIT_SUCCESS;
} 
                              
