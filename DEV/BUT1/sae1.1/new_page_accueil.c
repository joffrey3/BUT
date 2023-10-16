#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#include "fonction.h"
#define L 200
#define H 200

int new_page_accueil()
{
	EffacerEcran(CouleurParNom("white"));
	ChargerImageFond("image2.jpg");
	int flag=1;
    bouton(750,200,200,50,"black","white","           Jouer");
    bouton(60,60,50,50,"black","white","Quitter");

    /* Le code qui suit sert à naviguer sur les différentes pages */  
    for(;flag!=0;){
    	if (SourisCliquee()==1){
    		SourisPosition();
    		if (_X>=750 && _X<=950 && _Y>=200 && _Y<=250){
    			return 2;
    		}
    		if (_X>=50 && _X<=100 && _Y>=50 && _Y<=100){
    			return 0;
    		}
    	}
    }
}
