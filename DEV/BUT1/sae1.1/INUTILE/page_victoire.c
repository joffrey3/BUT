#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#define L 200
#define H 200
int ChargerImage(char *f,int x,int y,int xx,int yy,int l,int h);

void ChargerImageFond(char *file);

void ChoisirEcran(int n);

void CopierZone(int src,int dst,int ox,int oy,int lar,int hau, int dx,int dy);

couleur CouleurParComposante(unsigned char r, unsigned char v, unsigned char b);
 
int page_victoire()
{
   int x, y, i=0 , j,k,l,flag=1;
   unsigned long int b=CouleurParComposante(255,255,255),N=CouleurParComposante(0,0,0),R=CouleurParComposante(255,0,0),V=CouleurParComposante(0,255,0),B=CouleurParComposante(0,0,255),Y=CouleurParComposante(255,255,0),v=CouleurParComposante(255,0,255),Bl=CouleurParComposante(0,255,255),G=CouleurParComposante(128,128,128);
   EffacerEcran(b);
   ChargerImageFond("image2.jpg");
   ChoisirCouleurDessin(B);
    RemplirRectangle(400,900,200,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(400,900,200,50);
    EcrireTexte(410,75,"Recommencer",2);
   ChoisirCouleurDessin(B);
   RemplirRectangle(50,50,50,50);
   ChoisirCouleurDessin(N);
   DessinerRectangle(50,50,50,50);
   EcrireTexte(75,75,"retour aux tailles",2);
   ChoisirCouleurDessin(B);
   RemplirRectangle(150,50,50,50);
   ChoisirCouleurDessin(N);
   DessinerRectangle(150,50,50,50);
   EcrireTexte(175,75,"retour aux  images",2);
   ChoisirCouleurDessin(B);
   RemplirRectangle(250,50,50,50);
   ChoisirCouleurDessin(N);
   DessinerRectangle(250,50,50,50);
   EcrireTexte(275,75,"retour a l'accueil",2);
   ChargerImage("image.jpg",200,200,0,0,L,H);
   for(;flag!=0;){
      if (SourisCliquee()==1){
         SourisPosition();
         if (_X>=400 && _X<=600 && _Y>=900 && _Y<=950){
            return 4;
         }
         if (_X>=50 && _X<=100 && _Y>=50 && _Y<=100){
            return 3;
         }
         if (_X>=150 && _X<=200 && _Y>=50 && _Y<=100){
            return 2;
         }
         if (_X>=250 && _X<=300 && _Y>=50 && _Y<=100){
            return 1;
         }
      }
    }
}