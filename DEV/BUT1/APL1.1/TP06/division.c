#include <stdio.h>                                                              
#include <stdlib.h>    
int main(void){        
  int ent1, ent2, reste, quotient;     
  printf("Ecrivez un entier >=0.\n");
  scanf("%d",&ent1);                                                           printf("Ecrivez un entier >0.\n");
  scanf("%d",&ent2);
	quotient = 0;	
  reste = ent1;         
  for (reste;reste >= ent2;reste =reste -ent2){
      quotient = quotient+1;  
  }

  printf("%d = %d * %d + %d",ent1,ent2,quotient,reste);        
  return EXIT_SUCCESS; 
}                  
