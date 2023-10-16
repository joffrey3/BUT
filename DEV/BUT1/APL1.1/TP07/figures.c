#include <stdio.h>                                                              
#include <stdlib.h>
int main(void){
  int nb_choisi, impl, impl2, base,base2,base3,base4, produit2=0,produit3=0,produit4=0,resultat, impl3 , carre, ent1,ent2,ent3,ent4;
  printf("Ecrivez un entier positif.\n");
  scanf("%d",&nb_choisi);
  base=nb_choisi;
  carre=0;
  for(;base>=carre*carre;){
    nb_choisi=nb_choisi-carre*carre;
    ent1=carre*carre;
    base2=nb_choisi;
    for(;base2>=produit2*produit2;){
      nb_choisi=nb_choisi-produit2*produit2;
      ent2=produit2*produit2;
      base3=nb_choisi;
      for(;base3>=produit3*produit3;){
	nb_choisi=nb_choisi-produit3*produit3;
	ent3=produit3*produit3;
	base4=nb_choisi;
	for(;base4>=produit4*produit4;){
	  nb_choisi=nb_choisi-produit4*produit4;
	  ent4=produit4*produit4;
	  if (nb_choisi==0 && ent1>=ent2 && ent2>=ent3 && ent3>=ent4){
	    printf("%d = %d+%d+%d+%d",base,ent1,ent2,ent3,ent4);
	    printf("\n");
	  }
	  produit4=produit4+1;
	  nb_choisi=base4;
	}
	produit4=0;
	produit3=produit3+1;
	nb_choisi=base3;
      }
      produit3=0;
      produit2=produit2+1;
      nb_choisi=base2;
    }
    produit2=0;
    carre=carre+1;
    nb_choisi=base;
  }
  return EXIT_SUCCESS;
}   

