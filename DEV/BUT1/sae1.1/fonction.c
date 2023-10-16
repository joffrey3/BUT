#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#include "fonction.h"
#define L 200
#define H 200

/* Crée une zone de texte cliquable */

void bouton(int ariv_l,int ariv_h,int l,int h,char* C_txt,char* C_img,char* txt){
	ChoisirCouleurDessin(CouleurParNom(C_img));
    RemplirRectangle(ariv_l,ariv_h,l,h);
    ChoisirCouleurDessin(CouleurParNom(C_txt));
    DessinerRectangle(ariv_l,ariv_h,l,h);
    EcrireTexte(ariv_l+10,ariv_h+h/2,txt,2);
}

