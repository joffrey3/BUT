#include <stdio.h>
#include <stdlib.h>
#define BASE 3
#define TOTAL 15

int main (void){
  int i, j,t1[BASE*BASE]={0,0,0,0,0,0,0,0,0},t2[BASE][BASE], entier,flag1=0,flag2=0,flag3=0;
  for (i=0;i<BASE;i=i+1){
    for (j=0;j<BASE;j=j+1){
      printf("Entrez un entier compris entre 1 et 9 pour compléter un carré magique : ");
      scanf("%d",&entier);
      if (entier>=1 && entier<=9){
	if (t1[entier-1]!=0){
	  printf("Entier déja utilisé \n");
	  j=j-1;
	}else{
	  t2[i][j]=entier;
	  t1[entier-1]=entier;
	}
      }else{
        printf("Entier non compris entre 1 et 9\n");
      }
    }
  }
  for (i=0;i<BASE;i=i+1){
    for (j=0;j<BASE;j=j+1){
      if (t2[i][j]!=0){
        printf(" %d",t2[i][j]);
      }
    }
    printf("\n");
  }
  for (i=0;i<BASE;i=i+1){
    if(t2[i][0]+t2[i][1]+t2[i][2]!=TOTAL){
      flag1=1;
    }
  }
  if(flag1==1){
    printf("Les sommes des lignes ne sont pas identiques\n");
  }
  for (i=0;i<BASE;i=i+1){
    if(t2[0][i]+t2[1][i]+t2[2][i]!=TOTAL){
      flag2=1;
    }
  }
  if(flag2==1){
    printf("Les sommes des colonnes ne sont pas identiques\n");
  }
  for (i=0;i<BASE;i=i+2){
    if(t2[0][i]+t2[1][1]+t2[2][2-i]!=TOTAL){
      flag3=1;
    }
  }
  if(flag3==1){
    printf("Les sommes des diagonales ne sont pas identiques\n");
  }
  if(flag1==1 || flag2==1 || flag3==1){
    printf("Le carré n'est pas magique\n");
  }else{
    printf("Le carré est magique\n");
  }
}
