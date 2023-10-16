#include <stdio.h>
#include <time..h>
#include <stdlib.h.h>

int main(void){


 FILE* commande;
 FILE* registre;
 char c[11];
 int i;


    if (commande==NULL){
	    printf("Accès au fichier non possible");
	   return EXIT_SUCCESS;}

commande = fopen("/export/home/an21/bouzon/APL/commande.c","r");
registre = fopen("/export/home/an21/bouzon/APL/registre.c","w");


 for(i=0;i<11;i++){

fread (c,sizeof(char),1,commande);
fwrite (c,sizeof(char),1,registre);

printf ("%d",c)

}

   fclose(commande);
   fclose(registre);
   return EXIT_SUCCESS;
}