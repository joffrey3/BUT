#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#include "fonction.h"
#define L 200
#define H 200

int new_page_taille()
{
   EffacerEcran(CouleurParNom("black"));
   ChargerImageFond("image2.jpg");
   int flag=1,i ,j ,x ,y ,x_i=0,y_i=1,x_j=3,y_j=3,nb;
   char taille[6]={'3','4','5','6','7','8'};
   bouton(750,100,200,50,"black","white","        Choisir taille");
   bouton(600,200,100,50,"black","white","   Lignes");
   bouton(1000,200,100,50,"black","white","  Colonnes");
   bouton(50,50,50,50,"black","white","Retour");
   bouton(750,900,200,50,"black","white","         Lancer");
   for(i=0;i<=1;i++){
      for(j=3;j<=8;j++){
         bouton(625+i*400,j*100,50,50,"black","white","1");
      }
   }
   /* Le reste du programme "highlight" la case en adéquation avec le choix de l'utilisateur ( 1 case ou moins pour la colonne des lignes et idem pour la colonne des colonnes ) */ 
   for(;flag!=0;){
      if (SourisCliquee()==1){
         SourisPosition();

         if (_X>=625 && _X<=1025 && _Y>=300 && _Y<=350){
            bouton(625+x_i*400,x_j*100,50,50,"black","white","");
            x_j=3;
            i=0;
            j=3;
            x=3;
            bouton(625+i*400,j*100,50,50,"black","green","3");
         }

         if (_X>=625 && _X<=675 && _Y>=400 && _Y<=450){
            bouton(625+x_i*400,x_j*100,50,50,"black","white","");
            x_j=4;
            i=0;
            j=4;
            x=4;
            bouton(625+i*400,j*100,50,50,"black","green","4");
         }

         if (_X>=625 && _X<=675 && _Y>=500 && _Y<=550){
            bouton(625+x_i*400,x_j*100,50,50,"black","white","");
            x_j=5;
            i=0;
            j=5;
            x=5;
            bouton(625+i*400,j*100,50,50,"black","green","5");
         }

         if (_X>=625 && _X<=675 && _Y>=600 && _Y<=650){
            bouton(625+x_i*400,x_j*100,50,50,"black","white","");
            x_j=6;
            i=0;
            j=6;
            x=6;
            bouton(625+i*400,j*100,50,50,"black","green","6");
         }

         if (_X>=625 && _X<=675 && _Y>=700 && _Y<=750){
            bouton(625+x_i*400,x_j*100,50,50,"black","white","");
            x_j=7;
            i=0;
            j=7;
            x=7;
            bouton(625+i*400,j*100,50,50,"black","green","7");
         }

         if (_X>=625 && _X<=675 && _Y>=800 && _Y<=850){
            bouton(625+x_i*400,x_j*100,50,50,"black","white","");
            x_j=8;
            i=0;
            j=8;
            x=8;
            bouton(625+i*400,j*100,50,50,"black","green","8");
         }

         if (_X>=1025 && _X<=1075 && _Y>=300 && _Y<=350){
            bouton(625+y_i*400,y_j*100,50,50,"black","white","");
            y_j=3;
            i=1;
            j=3;
            y=3;
            bouton(625+i*400,j*100,50,50,"black","green","3");
         }

         if (_X>=1025 && _X<=1075 && _Y>=400 && _Y<=450){
            bouton(625+y_i*400,y_j*100,50,50,"black","white","");
            y_j=4;
            i=1;
            j=4;
            y=4;
            bouton(625+i*400,j*100,50,50,"black","green","4");
         }

         if (_X>=1025 && _X<=1075 && _Y>=500 && _Y<=550){
            bouton(625+y_i*400,y_j*100,50,50,"black","white","");
            y_j=5;
            i=1;
            j=5;
            y=5;
            bouton(625+i*400,j*100,50,50,"black","green","5");
         }

         if (_X>=1025 && _X<=1075 && _Y>=600 && _Y<=650){
            bouton(625+y_i*400,y_j*100,50,50,"black","white","");
            y_j=6;
            i=1;
            j=6;
            y=6;
            bouton(625+i*400,j*100,50,50,"black","green","6");
         }

         if (_X>=1025 && _X<=1075 && _Y>=700 && _Y<=750){
            bouton(625+y_i*400,y_j*100,50,50,"black","white","");
            y_j=7;
            i=1;
            j=7;
            y=7;
            bouton(625+i*400,j*100,50,50,"black","green","7");
         }

         if (_X>=1025 && _X<=1075 && _Y>=800 && _Y<=850){
            bouton(625+y_i*400,y_j*100,50,50,"black","white","");
            y_j=8;
            i=1;
            j=8;
            y=8;
            bouton(625+i*400,j*100,50,50,"black","green","8");
         }
	 /* Le code renvoie soit les valeurs choisies en dizaine et en unités, soit 0 */
	 
         if (_X>=750 && _X<=950 && _Y>=900 && _Y<=950){
            nb=x*10+y;
            return nb;
         }

         if (_X>=50 && _X<=100 && _Y>=50 && _Y<=100){
            nb=0;
            return nb;
         }
      }
   }
}
