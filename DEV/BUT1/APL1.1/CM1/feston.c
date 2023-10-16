#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define LIGNE 10
#define COLONNE 20
#define NB_ALEATOIRE 20

int main(void) {
  int matrice[LIGNE][COLONNE], liste[NB_ALEATOIRE], i, j, k, alea;
  srand(time(NULL));
  for(i = 0; i < 20; i++) {
   liste[i]=rand()%200;
   printf("%d ",liste[i]); /* on obtient des elements aléatoires*/
  }
  printf("\n");
  for(i=0;i<LIGNE;i++){
    for(j=0;j<COLONNE;j++){
      alea=0;
      for(k=0;k<NB_ALEATOIRE && alea==0;k++){
        if (20*i+j==liste[k]){
          printf("%d",0); /* si c'est un element aleatoire on met 0 */
          alea=1;
        }
      }
      if(alea==0){
        printf("%d",1); /* sinon on met un 1 */
      }
    }
    printf("\n");
  }
  return EXIT_SUCCESS;
}