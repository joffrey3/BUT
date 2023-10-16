#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#define L 200
#define H 200

int main()
{
	InitialiserGraphique();
	CreerFenetre(10,10,1920,1080);
	int p=1,adresse,x,y,nb;
	int* t={0,0,0};
	int chaine;

	/* Chaque page dans cette boucle sera noté d'un numéro par lequel elle pourra être appeler, les pages renvoie différents nombres pour appeler d'autres pages.
	   Si la variable est à 0, le programme est terminé. */ 
	for (;p!=0;){
		if(p==1){
		p=new_page_accueil();
		}
		if(p==2){
			chaine=new_page_image();
			if(chaine==1){
				p=1;
			}else{
				p=3;
			}
		}
		if(p==3){
			nb=new_page_taille();
			if (nb>10){
				p=4;
				x=nb/10;
				y=nb%10;
			} else{
				p=2;
			}
		}
		if(p==4){
		p=new_page_taquin(x,y,chaine);
		}
		if(p==5){
		p=new_page_victoire(chaine);
		}
	}
	FermerGraphique();
	return EXIT_SUCCESS;
}
