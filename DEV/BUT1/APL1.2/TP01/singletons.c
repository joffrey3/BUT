#include<stdio.h>
#include<stdlib.h>

int main(void) {
  double* tab = NULL;
  int i, j, flag=0, t;
  double ent;
  printf("Combien voulez-vous d'entier : ");
  scanf("%d", &t);
  tab = (double*) malloc(t*sizeof(int));
  for (i=0;i<t;i++){
    printf("Entrez un réel : ");
    scanf("%lf", &ent);
    tab[i]=ent;
  }
  for (i=0;i<t;i++){
    for (j=0;j<i;j++) {
      if (tab[i]==tab[j]){
        flag=1;
      }
    }
    if (flag==0){
    printf(" %f ",tab[i]);
    }
    flag=0;
  }
  printf("\n");
  free(tab);
  return EXIT_SUCCESS;
}