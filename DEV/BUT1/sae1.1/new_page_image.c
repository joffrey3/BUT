#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#include "fonction.h"
#define L 200
#define H 200

int  new_page_image()
{
    EffacerEcran(CouleurParNom("black"));
    ChargerImageFond("image2.jpg");
    int flag=1, i=0;
    int chaine;
    bouton(400,200,200,50,"black","white","      Choisir image");
    bouton(50,50,50,50,"black","white","Retour");
    bouton(800,200,200,50,"black","white","             Lancer");
    ChargerImage("image3.png",50,400,200,200,600,600);
    ChargerImage("image4.jpg",650,400,200,200,600,600);
    ChargerImage("image5.jpg",1250,400,200,200,600,600);

    /* Les blocks ci-dessous entoure l'image sélectionné par l'utilisateur lorsqu'il  clique dessus par le biais d'un contour vert */
    
    for(;flag!=0;){
        if (SourisCliquee()==1){
            SourisPosition();
            if (_X>=50 && _X<=650 && _Y>=400 && _Y<=1000){
                ChoisirCouleurDessin(CouleurParNom("black"));
                DessinerRectangle(50+i*600,400,600,600);
		chaine=3;
                i=0;
                ChoisirCouleurDessin(CouleurParNom("green"));
                DessinerRectangle(50+i*600,400,600,600);
            }
            if (_X>=650 && _X<=1250 && _Y>=400 && _Y<=1000){
                ChoisirCouleurDessin(CouleurParNom("black"));
                DessinerRectangle(50+i*600,400,600,600);
                chaine=4;
                i=1;
                ChoisirCouleurDessin(CouleurParNom("green"));
                DessinerRectangle(50+i*600,400,600,600);
            }
            if (_X>=1250 && _X<=1850 && _Y>=400 && _Y<=1000){
               ChoisirCouleurDessin(CouleurParNom("black"));
                DessinerRectangle(50+i*600,400,600,600);
		chaine=5;
                i=2;
                ChoisirCouleurDessin(CouleurParNom("green"));
                DessinerRectangle(50+i*600,400,600,600);
            }
	    
	    /* Celui-ci à sortir du programme vers les autres pages  */
	    
            if (_X>=800 && _X<=1000 && _Y>=200 && _Y<=250){
                return chaine;
            }
            if (_X>=50 && _X<=100 && _Y>=50 && _Y<=100){
                return 1;
            }
        }
    }
}
