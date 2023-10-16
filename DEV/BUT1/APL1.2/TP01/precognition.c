#include<stdio.h>
#include<stdlib.h>

int main(void) {
  int* tab = NULL;
  int i=0, j, flag=0, t[100], taille;
  double ent;
  char k, chiffres[10]="0123456789";
  for (k='0';k!='q';){
    printf("Entrez un réel : ");
    scanf("%c", &k);
    printf("\n");
    for (j=0;j<10;j++) {
      if(k==chiffres[j])
      {
        ent=j;
        t[i]=ent;
        i=i+1;
        taille=i;
      }
    }
  }
  tab = (int*) malloc(taille*sizeof(int));
  for (i=0;i<taille;i++){
    tab[i]=t[i];
    for (j=0;j<i;j++) {
      if (tab[i]==tab[j]){
        flag=1;
      }
    }
    if (flag==0){
    printf(" %d ",tab[i]);
    }
    flag=0;
  }
  printf("\n");
  free(tab);
  return EXIT_SUCCESS;
}