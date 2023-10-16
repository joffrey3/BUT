#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#define L 200
#define H 200

void DessinerRectangle(int x,int y,int l,int h);

void RemplirRectangle(int x,int y,int l,int h);

void ChoisirCouleurDessin(couleur c);

void EffacerEcran(couleur c);

void EcrireTexte(int x,int y,char *texte,int taille);

void SourisPosition();

int SourisCliquee();

couleur CouleurParComposante(unsigned char r, unsigned char v, unsigned char b);

void ChargerImageFond(char *file);

int main(void)
{
   InitialiserGraphique();
   CreerFenetre(10,10,1000,1000);
   unsigned long int b=CouleurParComposante(255,255,255),N=CouleurParComposante(0,0,0),R=CouleurParComposante(255,0,0),V=CouleurParComposante(0,255,0),B=CouleurParComposante(0,0,255),Y=CouleurParComposante(255,255,0),v=CouleurParComposante(255,0,255),Bl=CouleurParComposante(0,255,255),G=CouleurParComposante(128,128,128);
   EffacerEcran(b);
   ChargerImageFond("image2.jpg");
   int flag=1,i ,j ,x ,y ,t[2];
   char taille[6]={'3','4','5','6','7','8'};
   ChoisirCouleurDessin(B);
   RemplirRectangle(400,100,200,50);
   ChoisirCouleurDessin(N);
   DessinerRectangle(400,100,200,50);
   EcrireTexte(500,125,"Choisir la taille",2);
   ChoisirCouleurDessin(B);
   RemplirRectangle(150,200,100,50);
   ChoisirCouleurDessin(N);
   DessinerRectangle(150,200,100,50);
   EcrireTexte(200,225,"Lignes",2);
   ChoisirCouleurDessin(B);
   RemplirRectangle(650,200,100,50);
   ChoisirCouleurDessin(N);
   DessinerRectangle(650,200,100,50);
   EcrireTexte(700,225,"Colonnes",2);
   ChoisirCouleurDessin(B);
   RemplirRectangle(50,50,50,50);
   ChoisirCouleurDessin(N);
   DessinerRectangle(50,50,50,50);
   EcrireTexte(75,75,"Retour",2);
   ChoisirCouleurDessin(B);
   RemplirRectangle(400,900,200,50);
   ChoisirCouleurDessin(N);
   DessinerRectangle(400,900,200,50);
   EcrireTexte(500,925,"Lancer",2);
   for(i=0;i<=1;i++){
      for(j=3;j<=8;j++){
         ChoisirCouleurDessin(B);
         RemplirRectangle(175+i*500,j*100,50,50);
         ChoisirCouleurDessin(N);
         DessinerRectangle(175+i*500,j*100,50,50);
         EcrireTexte(175+i*500+25,j*100+25,"1",2);
      }
   }
   for(;flag!=0;){
      if (SourisCliquee()==1){
         SourisPosition();
         if (_X>=175 && _X<=225 && _Y>=300 && _Y<=350){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            x=3;
            i=0;
            j=3;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);

         }
         if (_X>=175 && _X<=225 && _Y>=400 && _Y<=450){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            x=4;
            i=0;
            j=4;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=175 && _X<=225 && _Y>=500 && _Y<=550){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            x=5;
            i=0;
            j=5;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=175 && _X<=225 && _Y>=600 && _Y<=650){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            x=6;
            i=0;
            j=6;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=175 && _X<=225 && _Y>=700 && _Y<=750){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            x=7;
            i=0;
            j=7;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=175 && _X<=225 && _Y>=800 && _Y<=850){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            x=8;
            i=0;
            j=8;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=675 && _X<=725 && _Y>=300 && _Y<=350){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            y=3;
            i=1;
            j=3;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=675 && _X<=725 && _Y>=400 && _Y<=450){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            y=4;
            i=1;
            j=4;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=675 && _X<=725 && _Y>=500 && _Y<=550){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            y=5;
            i=1;
            j=5;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=675 && _X<=725 && _Y>=600 && _Y<=650){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            y=6;
            i=1;
            j=6;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=675 && _X<=725 && _Y>=700 && _Y<=750){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            y=7;
            i=1;
            j=7;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=675 && _X<=725 && _Y>=800 && _Y<=850){
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
            y=8;
            i=1;
            j=8;
            ChoisirCouleurDessin(B);
            RemplirRectangle(175+i*500,j*100,50,50);
            ChoisirCouleurDessin(N);
            DessinerRectangle(175+i*500,j*100,50,50);
            EcrireTexte(175+i*500+25,j*100+25,"1",2);
         }
         if (_X>=400 && _X<=600 && _Y>=900 && _Y<=950){
            t[0]=x;
            t[1]=y;
            return 4;
         }
         if (_X>=50 && _X<=100 && _Y>=50 && _Y<=100){
            return 1;
         }
      }
   }
   FermerGraphique();
}