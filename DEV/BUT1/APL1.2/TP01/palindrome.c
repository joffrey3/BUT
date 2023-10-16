#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char* inverse(const char* s);

int main(void) {
  char* liste1 = NULL,* liste2 = NULL ;
  char chaine[30];
  int i, j, flag=0;
  printf("Ecrivez un mot : ");
  fgets(chaine,30, stdin);
  size_t taille=strlen(chaine);
  liste1 = (char*) malloc((taille-1)*sizeof(char));
  liste2 = (char*) malloc((taille-1)*sizeof(char));
  for (i=0;i<taille-1;i++){
    liste1[0]=chaine[taille-i-2];
    liste2[0]=chaine[i];
    if (strcmp(liste1,liste2)){
      flag=1;
    }
  }
  if (flag==0){
    printf(" %s est un palindrome",chaine);
  }else{
    printf(" %s n'est pas un palindrome",chaine);
  }
  printf("\n");
  free(liste1);
  free(liste2);
  return EXIT_SUCCESS;
}