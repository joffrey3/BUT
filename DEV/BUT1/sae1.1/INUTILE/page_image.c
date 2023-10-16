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

couleur CouleurParComposante(unsigned char r, unsigned char v, unsigned char b);



int main()
{
	InitialiserGraphique();
    CreerFenetre(10,10,1000,1000);
    int flag=1, i=0;
    unsigned long int b=CouleurParComposante(255,255,255),N=CouleurParComposante(0,0,0),R=CouleurParComposante(255,0,0),V=CouleurParComposante(0,255,0),B=CouleurParComposante(0,0,255),Y=CouleurParComposante(255,255,0),v=CouleurParComposante(255,0,255),Bl=CouleurParComposante(0,255,255),G=CouleurParComposante(128,128,128);
    EffacerEcran(b);
    ChargerImageFond("image2.jpg");
    ChoisirCouleurDessin(B);
    RemplirRectangle(50,50,50,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(50,50,50,50);
    EcrireTexte(50,50,"Retour",2);
    ChoisirCouleurDessin(B);
    RemplirRectangle(400,200,200,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(400,200,200,50);
    EcrireTexte(400,225,"Choisir une image",2);
    ChoisirCouleurDessin(B);
    RemplirRectangle(400,900,200,50);
    ChoisirCouleurDessin(N);
    DessinerRectangle(400,900,200,50);
    EcrireTexte(500,925,"Lancer",2);
    ChargerImage("image3.png",200,400,0,0,200,100);
    ChargerImage("image4.jpg",400,400,0,0,200,100);
    ChargerImage("image5.jpg",600,400,0,0,200,100);
    Touche();
    for(;flag!=0;){
        if (SourisCliquee()==1){
            SourisPosition();
            if (_X>=200 && _X<=400 && _Y>=400 && _Y<=500){
                ChoisirCouleurDessin(N);
                DessinerRectangle(200+i*200,400,200,50);
                char chaine[20]="image3.png";
                i=0;
                ChoisirCouleurDessin(V);
                DessinerRectangle(200+i*200,400,200,50);
            }
            if (_X>=400 && _X<=600 && _Y>=400 && _Y<=500){
                ChoisirCouleurDessin(N);
                DessinerRectangle(200+i*200,400,200,50);
                char chaine[20]="image4.jpg";
                i=1;
                ChoisirCouleurDessin(V);
                DessinerRectangle(200+i*200,400,200,50);
            }
            if (_X>=600 && _X<=800 && _Y>=400 && _Y<=500){
               ChoisirCouleurDessin(N);
                DessinerRectangle(200+i*200,400,200,50);
                char chaine[20]="image5.jpg";
                i=2;
                ChoisirCouleurDessin(V);
                DessinerRectangle(200+i*200,400,200,50);
            }
            if (_X>=400 && _X<=600 && _Y>=900 && _Y<=950){
                return chaine;
            }
            if (_X>=50 && _X<=100 && _Y>=50 && _Y<=100){
                return NULL;
            }
        }
    }

    FermerGraphique();
    return EXIT_SUCCESS;
}