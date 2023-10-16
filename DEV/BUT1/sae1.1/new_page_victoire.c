#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#include "fonction.h"
 
int new_page_victoire(char* image)
{
   int flag=1;;
   EffacerEcran(CouleurParNom("black"));
   ChargerImageFond("image2.jpg");
   bouton(400,900,200,50,"black","white","Recommencer");
   bouton(50,50,350,50,"black","white","Retour aux tailles");
   bouton(450,50,350,50,"black","white","Retour aux images");
   bouton(850,50,350,50,"black","white","Retour a l'accueil");
   bouton(400,400,200,50,"black","white","Victoire");

   /* Le code ci-dessous sert à changer de page lorsque l'on clique sur l'un des boutons*/
   
   for(;flag!=0;){
      if (SourisCliquee()==1){
         SourisPosition();
         if (_X>=400 && _X<=600 && _Y>=900 && _Y<=950){
            return 4;
         }
         if (_X>=50 && _X<=400 && _Y>=50 && _Y<=100){
            return 3;
         }
         if (_X>=450 && _X<=800 && _Y>=50 && _Y<=100){
            return 2;
         }
         if (_X>=850 && _X<=1200 && _Y>=50 && _Y<=100){
            return 1;
         }
      }
   }
}
