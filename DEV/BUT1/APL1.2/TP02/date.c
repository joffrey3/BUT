#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int main(void) {
  struct date {
  int annee;
  int mois;
  int jour;
  };
  printf("La date du jour est : ");
  struct date tm ;
  struct tm *localtime(const long int* time_t );
  printf("%d ",tm.annee);
  printf("%d ",tm.mois);
  printf("%d ",tm.jour);
  printf("\n");
}