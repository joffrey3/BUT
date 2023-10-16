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

void EffacerEcran(couleur c);

void ChargerImageFond(char *file);

int main()
{
    InitialiserGraphique();
    CreerFenetre(10,10,1000,1000);
	unsigned long int b=CouleurParComposante(255,255,255),N=CouleurParComposante(0,0,0),R=CouleurParComposante(255,0,0),V=CouleurParComposante(0,255,0),B=CouleurParComposante(0,0,255),Y=CouleurParComposante(255,255,0),v=CouleurParComposante(255,0,255),Bl=CouleurParComposante(0,255,255),G=CouleurParComposante(128,128,128);
	EffacerEcran(b);
	ChargerImageFond("image2.jpg");
	int flag=1;
    ChoisirCouleurDessin(B);
    RemplirRectangle(400,200,200,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(400,200,200,50);
    EcrireTexte(500,225,"Jouer",2);
    ChoisirCouleurDessin(B);
    RemplirRectangle(50,50,50,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(50,50,50,50);
    EcrireTexte(75,75,"Quitter",2);
    for(;flag!=0;){
    	if (SourisCliquee()==1){
    		SourisPosition();
    		if (_X>=400 && _X<=600 && _Y>=200 && _Y<=250){
    			return 2;
    		}
    		if (_X>=900 && _X<=950 && _Y>=50 && _Y<=100){
    			return 6;
    		}
    		if (_X>=50 && _X<=100 && _Y>=50 && _Y<=100){
    			return 0;
    		}
    	}
    }
    FermerGraphique();
}